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
import neu.edu.data.UserSession;
import neu.edu.data.convertor.DataConvertors;

/**
 * Servlet implementation class ViewBooks
 */
@WebServlet("/viewbooks")
public class ViewBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		ServletContext application = request.getServletContext();
        MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
        MongoCollection<Document> mongoCollectionUsers = mongoClient.getDatabase("webdev").getCollection("books");
       
        MongoCursor<Document> cursor = mongoCollectionUsers.find().iterator();
        ArrayList<Book> books = new ArrayList<Book>();
            try {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
                    Book book = DataConvertors.toBook(doc);
              
                    books.add(book);
                }
                HttpSession session = request.getSession();
                session.setAttribute("books", books);
            } finally {
                cursor.close();
            }
		request.getRequestDispatcher("/WEB-INF/viewbooks.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
