//package neu.edu.controller;
//
//import java.io.IOException;
//import java.util.Arrays;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.bson.Document;
//
//import com.mongodb.MongoClient;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//
//import neu.edu.data.Book;
//import neu.edu.data.UserSession;
//
///**
// * Servlet implementation class CheckBook
// */
//@WebServlet("/checkbook")
//public class CheckBook extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public CheckBook() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
//		HttpSession session = request.getSession();
//		ServletContext application = request.getServletContext();
//		application = request.getServletContext(); 
//		MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
//		 MongoCollection<Document> mongoCollectionBooks = mongoClient.getDatabase("webdev").getCollection("mybooks");
//		 UserSession userSession = (UserSession) session.getAttribute("userSession"); 
//		 Book selectedbook = (Book)(session.getAttribute("selectedB	ook"));
//		 Document filter1 = new Document("isbn", selectedbook.getIsbn());
//	        Document filter2 = new Document("username", userSession.getUsername());
//
//	        // Find documents that match both filters
//	        Document query = new Document("$and", Arrays.asList(filter1, filter2));
//	        FindIterable<Document> results = mongoCollectionBooks.find(query);
//
//	        System.out.println("reuslyskjdvndjvnsdjfnsdfc" + results);
//	        // Print results
//	        for (Document doc : results) {
//	            System.out.println(doc.toJson());
//	        }
//		 
//		 
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
