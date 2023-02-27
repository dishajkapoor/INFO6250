package neu.edu.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
 * Servlet implementation class PurchaseBook
 */
@WebServlet("/purchasebook")
public class PurchaseBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Book selectedBook = (Book) session.getAttribute("selectedBook");
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = currentDate.format(formatter);
		
	    LocalDate twoWeeksFromToday = currentDate.plusWeeks(2);
	    String twoWeeksFromTodayString = twoWeeksFromToday.format(formatter);
		
		MyBook myBook = new MyBook();
		myBook.setIsbn(selectedBook.getIsbn());
		myBook.setUsername(userSession.getUsername());
		myBook.setPurchase_date(dateString);
		myBook.setReturn_date("Not returned");
		myBook.setDue_date(twoWeeksFromTodayString);
		
		Document bookDoc = DataConvertors.toMyBookDoc(myBook);
		ServletContext application = request.getServletContext();
        MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
        MongoCollection<Document> mongoCollectionMyBooks = mongoClient.getDatabase("webdev").getCollection("mybooks");
        mongoCollectionMyBooks.insertOne(bookDoc);	
        
        MongoCollection<Document> mongoCollectionBooks = mongoClient.getDatabase("webdev").getCollection("books");
        
        Bson filter = Filters.eq("isbn", selectedBook.getIsbn());
        Bson update = Updates.set("count", selectedBook.getCount()-1);
        mongoCollectionBooks.updateOne(filter, update);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
