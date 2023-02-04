package neu.edu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FormSubServlet
 */
@WebServlet("/FormSubServlet")
public class FormSubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormSubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("Form.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String first_name = request.getParameter("first-name");
		String middle_name = request.getParameter("middle-initial");
		String last_name = request.getParameter("last-name");
		
		String address_line_1 = request.getParameter("address-line-1");
		String address_line_2 = request.getParameter("address-line-2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postal_code = request.getParameter("postal-code");
		String country = request.getParameter("country");
		
		String mobile = request.getParameter("mobile");
		String work = request.getParameter("work");
		
		String email = request.getParameter("email");
		
		String contact_pref = request.getParameter("contact-preference");
		
		String gender = request.getParameter("gender");
		String occupation = request.getParameter("occupation");
		
		String birthdate = request.getParameter("birthdaytime");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		String password2 = request.getParameter("password2");
		/*
		 * System.out.println("Response - " + first_name + " - " + middle_name + " - " +
		 * last_name + contact_pref +mobile+"''"+work);
		 */
		
		HttpSession session = request.getSession();
		
		RegistrationForm rfm = new RegistrationForm();
		rfm.setFirstName(first_name);
		rfm.setMiddleName(middle_name);
		rfm.setLastName(last_name);
		rfm.setAddressLine1(address_line_1);
		rfm.setAddressLine2(address_line_2);
		rfm.setCity(city);
		rfm.setState(state);
		rfm.setPostalCode(postal_code);
		rfm.setCountry(country);
		rfm.setMobile(mobile);
		rfm.setWork(work);
		rfm.setEmail(email);
		rfm.setGender(gender);
		rfm.setContactPref(contact_pref);
		rfm.setBirthdate(birthdate);
		rfm.setOccupation(occupation);
		rfm.setUsername(username);
		rfm.setPassword(password);
//		rfm.setPassword2(password2);
		
		session.setAttribute("registrationData", rfm);
		
		response.sendRedirect("FormRedirectServlet");
		
	}

}
