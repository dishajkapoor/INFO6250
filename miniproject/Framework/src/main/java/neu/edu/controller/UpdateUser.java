package neu.edu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.data.User;
import neu.edu.database.DBConnector;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
	
	Connection connection;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PreparedStatement pst = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("selectedUser");
		connection = DBConnector.getInstance().getConnection();
		if(request.getParameter("page").equals("editUser")) {
			/*
			 * String name = request.getParameter("name"); String isbn =
			 * request.getParameter("isbn"); String desc = request.getParameter("desc");
			 * String count = request.getParameter("count"); String author =
			 * request.getParameter("author"); String ratings =
			 * request.getParameter("ratings");
			 */
			
			
			try {
				pst = connection.prepareStatement("UPDATE user SET username = ?, firstName = ?, lastName = ?, email = ? WHERE username = ?");
				pst.setString(1, request.getParameter("username"));
	            pst.setString(2, request.getParameter("name"));
	            pst.setString(3, request.getParameter("lname"));
	            pst.setString(4, request.getParameter("email"));
	            pst.setString(5, user.getUsername());
	            
	            int rowsAffected = pst.executeUpdate();
	            if (rowsAffected > 0) {
	            	request.setAttribute("page_redirect", "view_users");
	            	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateSuccess.jsp");
	       		 rd.forward(request, response);
	            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			String query = "DELETE FROM user WHERE username = ?";

			// Create a PreparedStatement object
			PreparedStatement statement;
			try {
				statement = connection.prepareStatement(query);
				statement.setString(1, user.getUsername());

				// Execute the query
				int rowsAffected = statement.executeUpdate();
				request.setAttribute("page_redirect", "view_users");
            	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateSuccess.jsp");
       		 rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Set the parameter value for the query
			
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
