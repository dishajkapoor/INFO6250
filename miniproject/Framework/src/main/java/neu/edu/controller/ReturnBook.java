package neu.edu.controller;

import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

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
import neu.edu.data.MyBook;
import neu.edu.data.UserSession;
import neu.edu.data.convertor.DataConvertors;

/**
 * Servlet implementation class ReturnBook
 */
@WebServlet("/returnbook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*
		 * 
		 * UserSession userSession = (UserSession) session.getAttribute("userSession");
		 */
		
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		
		Book myselectedBook = (Book) session.getAttribute("myselectedbook");
		
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = currentDate.format(formatter);
		
		/* LocalDate twoWeeksFromToday = currentDate.plusWeeks(2); */
		/* String twoWeeksFromTodayString = twoWeeksFromToday.format(formatter); */
		
		/*
		 * MyBook myBook = new MyBook(); myBook.setReturn_date(dateString);
		 */
		
		ServletContext application = request.getServletContext();
		application = request.getServletContext(); 
		MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
		 MongoCollection<Document> mongoCollectionBooks = mongoClient.getDatabase("webdev").getCollection("mybooks");
				  
			/* Bson filter = Filters.eq("isbn", myselectedBook.getIsbn()) ;*/
			/*
			 * Bson update = Updates.set("return_date", dateString);
			 * mongoCollectionBooks.updateOne(filter, update);
			 */
		
		 
	        Document filter1 = new Document("isbn", myselectedBook.getIsbn());
	        Document filter2 = new Document("username", userSession.getUsername());

	        Document update = new Document("$set", new Document("return_date", dateString));

	        // Update documents that match both filters
	        Document query = new Document("$and", Arrays.asList(filter1, filter2));
	        mongoCollectionBooks.updateMany(query, update);
		 
		 
		/*
		 * Document bookDoc = DataConvertors.toMyBookDoc(myBook); ServletContext
		 * application = request.getServletContext(); MongoClient mongoClient =
		 * (MongoClient) application.getAttribute("mongodbClient");
		 * MongoCollection<Document> mongoCollectionMyBooks =
		 * mongoClient.getDatabase("webdev").getCollection("mybooks");
		 * mongoCollectionMyBooks.insertOne(bookDoc);
		 * 
		 * */
	        
		 MongoCollection<Document> mongoCollection = mongoClient.getDatabase("webdev").getCollection("books");
		 
		  Bson filter = Filters.eq("isbn", myselectedBook.getIsbn()); 
		  Bson update_count = Updates.set("count", myselectedBook.getCount()+1);
		  mongoCollection.updateOne(filter, update_count);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
