package neu.edu.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import neu.edu.data.Book;
import neu.edu.data.MyBook;
import neu.edu.data.UserSession;
import neu.edu.data.convertor.DataConvertors;

/**
 * Servlet implementation class AdminBookDetails
 */
@WebServlet("/adminbookdetails")
public class AdminBookDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBookDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		ArrayList<Book> books = (ArrayList<Book>) session.getAttribute("books");
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		String username = userSession.getUsername();
		String isbn = (String) request.getAttribute("isbn");
		for (Book book : books) {
//			System.out.println("isbn book" + book.getIsbn());
			if(book.getIsbn() == Integer.parseInt(isbn)){
				System.out.println("ratings" + book.getRatings());
				session.setAttribute("selectedBook", book);
			}
		}
		
		ServletContext application = request.getServletContext();
        MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
        MongoCollection<Document> mongoCollectionUsers = mongoClient.getDatabase("webdev").getCollection("mybooks");
        MongoCursor<Document> cursor = mongoCollectionUsers.find().iterator();
        session.setAttribute("owned", "false");

            try {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
                    MyBook mybook = DataConvertors.toMyBook(doc);
				if(mybook.getUsername().equals(username) && mybook.getIsbn() == Integer.parseInt(isbn)) {
                    	session.setAttribute("owned", "true");
                    }
                }
            }
                finally {
                    cursor.close();
                }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
