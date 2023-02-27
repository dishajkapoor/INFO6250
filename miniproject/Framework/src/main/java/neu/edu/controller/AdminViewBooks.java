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
import neu.edu.data.convertor.DataConvertors;

/**
 * Servlet implementation class AdminViewBooks
 */
@WebServlet("/adminviewbooks")
public class AdminViewBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext application = request.getServletContext();
//		System.out.println("HERERERERE");
        MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
        MongoCollection<Document> mongoCollectionUsers = mongoClient.getDatabase("webdev").getCollection("books");
        MongoCursor<Document> cursor = mongoCollectionUsers.find().iterator();
        ArrayList<Book> books = new ArrayList<Book>();
//        System.out.println("HERERERERE");
        HttpSession session = request.getSession();
            try {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
//                    System.out.println("HEREREREREdkwoskdjnjidjfdjeidjfdjidkjcfdjwi");
                    Book book = DataConvertors.toBook(doc);
//                    System.out.println("HEREREREREsddaxc");
                    books.add(book);
                }
//                System.out.println("HERERERERE");
                
//                System.out.println("HERERERERckskckkskcE");
                session.setAttribute("books", books);
				/*
				 * System.out.println(".............................");
				 * System.out.println("jdbfdsvhjdsbvhdbv" + session.getAttribute("books"));
				 */
            } finally {
//                System.out.println("HERERERERE");
//                System.out.println("dom" + session.getAttribute("books"));
        		request.getRequestDispatcher("/WEB-INF/adminviewbooks.jsp").forward(request, response);
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
