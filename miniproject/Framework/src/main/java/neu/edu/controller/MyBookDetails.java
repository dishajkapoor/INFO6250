package neu.edu.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class MyBookDetails
 */
@WebServlet("/mybookdetails")
public class MyBookDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBookDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<MyBook> mybooks = (ArrayList<MyBook>) session.getAttribute("mybooks");
		
		String isbn = (String) request.getAttribute("isbn");
		/* session.setAttribute(, isbn) */
		System.out.println("sjdfhbjhdsbjhbdsjbnds:::::::::::::::::::::::::" + isbn);
		for (MyBook mybook : mybooks) {
			if(mybook.getIsbn() == Integer.parseInt(isbn)){
				session.setAttribute("selectedBook", mybook);
				System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooo" + session.getAttribute("selectedBook"));
			}
		}
		
		ServletContext application = request.getServletContext();
        MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
        MongoCollection<Document> mongoCollectionUsers = mongoClient.getDatabase("webdev").getCollection("books");
        MongoCursor<Document> cursor = mongoCollectionUsers.find().iterator();
        
            try {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
                    Book book = DataConvertors.toBook(doc);
                    if(book.getIsbn() == Integer.parseInt(isbn)) {
                    	session.setAttribute("myselectedbook", book);
                    	System.out.println("ooooooooooooooooooooooooo.....................ooooooooooooooooooooooo" + session.getAttribute("myselectedbook"));
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
