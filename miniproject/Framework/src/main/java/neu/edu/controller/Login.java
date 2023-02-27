package neu.edu.controller;
import neu.edu.dao.RegistrationDAO;
import neu.edu.data.UserRegistration;
import neu.edu.data.UserSession;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet(
		urlPatterns =  {"/Login","/login"},
		initParams = {@WebInitParam(name = "user1@gmail.com",value = "pass1")}
)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		if (userSession == null){
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
		requestDispatcher.forward(request, response);
	}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/dashboard.jsp");
			rd.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");

		if (userSession == null) {
			RegistrationDAO reg = new RegistrationDAO();
			
			 UserSession userSession2 = reg.user_exists(username, password);
			 
			 
			if (userSession2!=null) {
				session.setAttribute("userSession", userSession2);
				String role =  userSession2.getRole();
				if(role.equals("user")) {
				
				response.sendRedirect("controller");
				}
				else {
					response.sendRedirect("controller?action=admindashboard");
				}
				
			}
			else {
				request.setAttribute("error", "Invalid username or password");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
				rd.forward(request, response);
			}
		}
		else {
			String role = userSession.getRole();
			if(role.equals("user")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/dashboard.jsp");
			rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admindashboard.jsp");
				rd.forward(request, response);
			}
		}
			
	}

}
