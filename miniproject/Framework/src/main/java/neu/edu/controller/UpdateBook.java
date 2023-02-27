package neu.edu.controller;

import java.io.IOException;
//import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import neu.edu.data.Book;
import neu.edu.data.convertor.DataConvertors;

//import neu.edu.data.UserSession;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/updatebook")
public class UpdateBook extends HttpServlet {
//	private Connection connection;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
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
		Book selectedBook = (Book) session.getAttribute("selectedBook");
//		UserSession userSession = (UserSession) session.getAttribute("userSession");
//		String action = (String) request.getAttribute("action2");
//		System.out.println("selectednook" + selectedBook);
		
		ServletContext application = request.getServletContext();
        MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
        MongoCollection<Document> mongoCollectionBooks = mongoClient.getDatabase("webdev").getCollection("books");
		
        System.out.println(request.getParameter("page") + "----------------------------------------------------------");
		
		if(request.getParameter("page").equals("editBook")) {
			String name = request.getParameter("name");
			String isbn = request.getParameter("isbn");
			String desc = request.getParameter("desc");
			String count = request.getParameter("count");
			String author = request.getParameter("author");
			String ratings = request.getParameter("ratings");

			Bson filter = Filters.eq("isbn", selectedBook.getIsbn());
			Bson update = Updates.combine(
				    Updates.set("name", name),
				    Updates.set("isbn", Integer.parseInt(isbn)),
				    Updates.set("desc", desc),
				    Updates.set("count", Integer.parseInt(count)),
				    Updates.set("author", author),
				    Updates.set("ratings", Integer.parseInt(ratings))
				);
	        mongoCollectionBooks.updateOne(filter, update);
	        System.out.println("updated...........................................");
		}
		

		else if(request.getParameter("page").equals("addBook")) {
	 Book book = new Book();
	 book.setName(request.getParameter("name"));
	 book.setIsbn(Integer.parseInt(request.getParameter("isbn")));
	 book.setCount(Integer.parseInt(request.getParameter("count")));
	 book.setRatings(Integer.parseInt(request.getParameter("ratings")));
	 book.setAuthor(request.getParameter("author"));
	 book.setDesc(request.getParameter("desc"));
	 
	 Document bookDoc = DataConvertors.toBookDoc(book);
	 
	 mongoCollectionBooks.insertOne(bookDoc);
	 
	 }

		else {
		     Document filter = new Document("isbn", selectedBook.getIsbn());

		      // Delete one document
		     mongoCollectionBooks.deleteOne(filter);
//		        System.out.println("herererer" + request.getParameter("page_redirect"));
//		        System.out.println("skjdhfjdfsjbdsbfhsbfdsbfjsdjdsbg" + request.getAttribute("page_redirect"));
		        
		}
 request.setAttribute("page_redirect", "view_books");
 request.getRequestDispatcher("/WEB-INF/updateSuccess.jsp").forward(request,response);
//		String action2
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
