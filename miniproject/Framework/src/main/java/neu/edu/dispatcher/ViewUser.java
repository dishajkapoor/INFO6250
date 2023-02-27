//package neu.edu.dispatcher;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.mongodb.MongoClient;
//
//import neu.edu.dao.UserDao;
//import neu.edu.data.Address;
//import neu.edu.data.Name;
//import neu.edu.data.User;
//
///**
// * Servlet implementation class ViewUser
// */
//@WebServlet("/ViewUser")
//public class ViewUser extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ViewUser() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//
//		ServletContext application = request.getServletContext();
//		MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
//	    UserDao userDao = new UserDao(mongoClient);
//	    List<User> users = userDao.getList();
//	    request.setAttribute("users", users);
//	    
//	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/viewUsers.jsp");
//	    rd.forward(request, response);
//
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		String age = request.getParameter("age");
//		String street1 = request.getParameter("street1");
//		String city = request.getParameter("city");
//		String state = request.getParameter("state");
//		String zip = request.getParameter("zip");
//
//
//		MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("mongodbClient");
//	    UserDao userDao = new UserDao(mongoClient);
//	    
//	    User user = new User();
//	    
//	    Name name = new Name();
//	    name.setFirstName(firstName);
//	    name.setLastName(lastName);
//	    user.setName(name);
//	    
//	    user.setAge(Integer.valueOf(age));
//	    
//	    Address address = new Address();
//	    address.setCity(city);
//	    address.setLine1(street1);
//	    address.setState(state);
//	    address.setZip(zip);
//	    
//	    user.setAddress(address);
//	    
//	    userDao.create(user);
//
//	    PrintWriter pw = response.getWriter();
//	    pw.append("Success");
//	}
//
//}
