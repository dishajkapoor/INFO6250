package neu.edu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.dao.RegistrationDAO;
import neu.edu.data.UserRegistration;

/**
 * Servlet implementation class Register
 */
@WebServlet(urlPatterns = {"/Registration","/registration"})
public class Registration extends HttpServlet {
	private Connection connection;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/registration.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		
		if (!password.equals(password2)) {
			request.setAttribute("error", "Passwords donot match bro");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/registration.jsp");
			rd.forward(request, response);
		}
		else {
			ServletContext application = request.getServletContext();
			ArrayList<UserRegistration> userRegistration = (ArrayList<UserRegistration>) request.getAttribute("userRegistration");
			if(userRegistration == null) {
				userRegistration = new ArrayList<>();
			}
			userRegistration.add(new UserRegistration(username, password, email));
			application.setAttribute("userRegistration", userRegistration);
	//		response.sendRedirect("/WEB-INF/registrationstatus.jsp");
			RegistrationDAO reg = new RegistrationDAO();
			reg.register(username, password, firstName, lastName, email, "user");
			String emailMessage = "Congratulations! You are registered with TurnThePage. Thank you, Enjoy!";
	        String subject = "Successful registration";
	        request.setAttribute("message", emailMessage);
	        request.setAttribute("subject", subject);
	        request.setAttribute("email", email);
//	        request.setAttribute("email", appt.getEmail());
	        RequestDispatcher emailDispatcher = request.getRequestDispatcher("sendEmail");      
	        response.setBufferSize(10 * 1024);
	        response.resetBuffer();
	        emailDispatcher.include(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/rstatus.jsp");
			rd.forward(request, response);
		
		}
	}

}
