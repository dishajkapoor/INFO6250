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
 * Servlet implementation class ViewMyBooks
 */
@WebServlet("/viewmybooks")
public class ViewMyBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMyBooks() {
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
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		
		String username = userSession.getUsername();
		ServletContext application = request.getServletContext();
        MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
        MongoCollection<Document> mongoCollectionUsers = mongoClient.getDatabase("webdev").getCollection("mybooks");
        MongoCursor<Document> cursor = mongoCollectionUsers.find().iterator();
        ArrayList<MyBook> mybooks = new ArrayList<MyBook>();
        ArrayList<MyBook> mybooks2 = new ArrayList<MyBook>();
            try {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
                    MyBook mybook = DataConvertors.toMyBook(doc);
                    //check for username 
                    
                    mybooks.add(mybook);
                }
                for(MyBook mybook:mybooks) {
                	if(mybook.getUsername().equals(userSession.getUsername())){
                		System.out.println(mybook.getDue_date());
                		mybooks2.add(mybook);
                	}
                }
//                HttpSession session = request.getSession();
                session.setAttribute("mybooks", mybooks2);
//                BookSession bookSession = new BookSession(book.get);
            } finally {
                cursor.close();
            }
		request.getRequestDispatcher("/WEB-INF/viewmybooks.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
