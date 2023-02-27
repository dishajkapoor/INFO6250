package neu.edu.database;

import java.io.IOException;
import org.bson.Document;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

/**
 * Servlet implementation class TestMongoDb
 */
@WebServlet("/TestMongoDb")
public class TestMongoDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestMongoDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int age;
        ServletContext application = request.getServletContext();
        MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
        MongoCollection<Document> mongoCollectionUsers = mongoClient.getDatabase("webdev").getCollection("books");
        MongoCursor<Document> cursor = mongoCollectionUsers.find().iterator();
            try {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
                    age = doc.get("isbn",0);
                    System.out.println(doc.get("isbn",0));
                }
            } finally {
                cursor.close();
            }
            response.getWriter().append("ahe").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
