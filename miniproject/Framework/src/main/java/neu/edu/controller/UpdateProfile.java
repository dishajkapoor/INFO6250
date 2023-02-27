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

import neu.edu.data.UserSession;
import neu.edu.database.DBConnector;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/updateprofile")
public class UpdateProfile extends HttpServlet {
	private Connection connection;

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
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
		String action = (String) request.getAttribute("action");
			if(action.equals("updatePassword")){	
				String password1 = request.getParameter("password");
				String password2 = request.getParameter("confirm_password");
				
				if(!password1.equals(password2)) {
					request.setAttribute("error", "Passwords do not match");
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/profile.jsp");
					rd.forward(request, response);
				}
				else {
					PreparedStatement pst = null;
			        boolean isValid = true;
			        try {
			            connection = DBConnector.getInstance().getConnection();
			            pst = connection.prepareStatement("UPDATE USER SET PASSWORD = MD5(?) WHERE USERNAME = ?");
			            pst.setString(1, password1);
			            pst.setString(2, userSession.getUsername());
			            pst.executeUpdate();     
			            session.invalidate();
			            request.setAttribute("page_redirect", "login");
			            request.getRequestDispatcher("/WEB-INF/updateSuccess.jsp").forward(request, response);
			        } catch (SQLException e) {
			            isValid = false;
			        } finally {
			            try {
			                pst.close();
			            } catch (SQLException e) {
			                // TODO Auto-generated catch block                e.printStackTrace();
			            }
			        }
				}
		}
			if (action.equals("updateUsername")){	
				System.out.println("changing username");
				String email = (String) request.getParameter("email");
				
				PreparedStatement pst = null;
		        boolean isValid = true;
		        try {
		            connection = DBConnector.getInstance().getConnection();
		            pst = connection.prepareStatement("UPDATE USER SET EMAIL = ? WHERE USERNAME = ?");
		            pst.setString(1, email);
		            pst.setString(2, userSession.getUsername());
		            pst.executeUpdate();     
					
					  session.invalidate();
					  request.setAttribute("page_redirect", "login");
					  request.getRequestDispatcher("/WEB-INF/updateSuccess.jsp").forward(request,response);
					 
		        } catch (SQLException e) {
		            isValid = false;
		        } finally {
		            try {
		                pst.close();
		            } catch (SQLException e) {
		                // TODO Auto-generated catch block                e.printStackTrace();
		            }
		        }
		
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
