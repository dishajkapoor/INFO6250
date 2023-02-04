package neu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FormRedirectServlet
 */
@WebServlet("/FormRedirectServlet")
public class FormRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormRedirectServlet() {
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
		RegistrationForm rfm = (RegistrationForm) session.getAttribute("registrationData");
		
		PrintWriter pr = response.getWriter();
//		pr.append("Status");
		pr.append("<html>"
				+ "<head><title>Redirected Page</title></head>"
				+ "<body><p> Thanks for registering! Here is a copy of the details you entered.</p>"
				+ "<br><br>First Name : "+rfm.getFirstName()
				+ "<br><br>Middle Name : "+rfm.getMiddleName()
				+ "<br><br>Last Name : "+rfm.getLastName()
				+ "<br><br>Address Line 1 : "+rfm.getAddressLine1()
				+ "<br><br>Address Line 2 : "+rfm.getAddressLine2()
				+ "<br><br>City : "+rfm.getCity()
				+ "<br><br>State : "+rfm.getState()
				+ "<br><br>Postal Code : "+rfm.getPostalCode()
				+ "<br><br>Country : "+rfm.getCountry()
				+ "<br><br>Mobile Number : "+rfm.getMobile()
				+ "<br><br>Work number : "+rfm.getWork()
				+ "<br><br>Email : "+rfm.getEmail()
				+ "<br><br>Contact Preference : "+rfm.getContactPref()
				+ "<br><br>Gender : "+rfm.getGender()
				+ "<br><br>Username : "+rfm.getUsername()
				+ "<br><br>Password : "+rfm.getPassword()
				+ "<br><br>Joining Date: "+rfm.getBirthdate()
				+ "<br><br>Job Role : "+rfm.getOccupation()
				+ "<br><br><a href = 'FormSubServlet'> Return to form </a>" 
				+"</body>"
				+ "</html>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
