package neu.edu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.data.User;
import neu.edu.database.DBConnector;

/**
 * Servlet implementation class AdminUserDetails
 */
@WebServlet("/adminuserdetails")
public class AdminUserDetails extends HttpServlet {
	Connection connection;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String username = ;
		System.out.println("username" + request.getAttribute("username"));
		PreparedStatement pst = null;
		connection = DBConnector.getInstance().getConnection();
		HttpSession session = request.getSession();
        try {
			pst = connection.prepareStatement("select * from user");
			ResultSet rs = pst.executeQuery();
//	        System.out.println("rsfjkbhb" + rs);
//	        ArrayList<User> users = new ArrayList<User>();
			User user = new User();
	        while(rs.next()) {
	        	if(request.getAttribute("username").equals(rs.getString("username"))) {
	        		
	        		user.setEmail(rs.getString("email"));
	        		user.setFirstName(rs.getString("firstName"));
	        		user.setLastName(rs.getString("lastName"));
	        		user.setUsername(rs.getString("username"));
	        		user.setRole(rs.getString("role"));
	        		
	        	}
	        }
	        session.setAttribute("selectedUser", user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
