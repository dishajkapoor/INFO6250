package neu.edu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.data.Book;
import neu.edu.data.User;
import neu.edu.database.DBConnector;

/**
 * Servlet implementation class ViewUsers
 */
@WebServlet("/viewusers")
public class ViewUsers extends HttpServlet {
	private Connection connection;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUsers() {
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
		PreparedStatement pst = null;
		try {
			connection = DBConnector.getInstance().getConnection();
            pst = connection.prepareStatement("select * from user");
            ResultSet rs = pst.executeQuery();
//            System.out.println("rsfjkbhb" + rs);
            ArrayList<User> users = new ArrayList<User>();
            while(rs.next()) {
            	User user = new User();
            	user.setEmail(rs.getString("email"));
            	user.setFirstName(rs.getString("firstName"));
            	user.setLastName(rs.getString("lastName"));
            	user.setRole(rs.getString("role"));
            	user.setUsername(rs.getString("username"));
            	users.add(user);
            	
//            	System.out.println("is-------" + rs.getString("username"));
            }
            session.setAttribute("users", users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/viewusers.jsp");
		 rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
