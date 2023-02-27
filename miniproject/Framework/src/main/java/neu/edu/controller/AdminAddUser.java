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

import neu.edu.data.User;
import neu.edu.database.DBConnector;

/**
 * Servlet implementation class AdminAddUser
 */
@WebServlet("/adminadduser")
public class AdminAddUser extends HttpServlet {
	Connection  connection;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		User user = new User();
		/*user.setEmail());
		System.out.println("sdjknfjsbjb .................................................... s" + user.getEmail());
		user.setFirstName();
		user.setLastName();
		user.setUsername();
		user.setPassword();*/
//		user.setRole(request.getParameter("role"));
//		user.setFirstName(request.getParameter("name"));
		
		HttpSession session = request.getSession();
		PreparedStatement pst = null;
		try {
			connection = DBConnector.getInstance().getConnection();
			pst = connection.prepareStatement("INSERT INTO user (username, password,firstName,lastName,email,role) VALUES (?, MD5(?),?,?,?,?)");
			pst.setString(1, request.getParameter("username"));
            pst.setString(2, request.getParameter("password"));
            pst.setString(3, request.getParameter("name"));
            pst.setString(4, request.getParameter("lname"));
            pst.setString(5, request.getParameter("email"));
            pst.setString(6, request.getParameter("role"));
            int rowsInserted = pst.executeUpdate();
            System.out.println(rowsInserted);
            if (rowsInserted > 0) {
//                status=true;
            	request.setAttribute("page_redirect", "view_users");
            	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateSuccess.jsp");
       		 rd.forward(request, response);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            finally {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
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
