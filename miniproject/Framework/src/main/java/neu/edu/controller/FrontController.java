package neu.edu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.data.UserSession;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/controller")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("in fornt cntroelsdfkjlnsjkfdshvbdhgsvfghdavfgvsdzfhbdshzfn");
		String action = request.getParameter("action");
//		System.out.println("action!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1" + action);
		HttpSession session = request.getSession();
		 UserSession userSession = (UserSession) session.getAttribute("userSession");
		 
//		 String currentPage = userSession.getCurrent_page();
		 String dispatcher = "";
		 String role = userSession.getRole();
//		System.out.println("role!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + role);
		if(role.equals("user")) { 
			 if(action == null || action.equals("dashboard")) {
//				 userSession.setCurrent_page("dashboard");
				 dispatcher = "dashboard";
			 }
		
			 else if(action.equals("profile")) {
//				 userSession.setCurrent_page("profile");
				 dispatcher = "profile";
			 }
			 else if(action.equals("viewbooks")) {
//				 userSession.setCurrent_page("viewbooks");	
				 dispatcher = "viewbooks";
			 }
	
			 else if(action.equals("viewmybooks")) {
//				 userSession.setCurrent_page("viewmybooks");
				 dispatcher = "viewmybooks";
			 }
			 else if(action.equals("bookdetails")){
//				 userSession.setCurrent_page("bookdetails");
				 String isbn = (String) request.getParameter("data");
				 request.setAttribute("isbn", isbn);
				 dispatcher = "bookdetails";
			 }
			 else if(action.equals("mybookdetails")){
//				 userSession.setCurrent_page("mybookdetails");
				 request.setAttribute("isbn", request.getParameter("data"));
				 dispatcher = "mybookdetails";
			 }
			 else if(action.equals("bdetails")) {
				 dispatcher = "/WEB-INF/bdetails.jsp";
			 }
			 else if(action.equals("mybdetails")) {
				 dispatcher = "/WEB-INF/mybdetails.jsp";
			 }
			 else if(action.equals("purchasebook")) {
				 dispatcher = "purchasebook";
			 }
			 else if(action.equals("returnbook")) {
				 dispatcher = "returnbook";
			 }
			 else if(action.equals("updateUsername")) {
				 request.setAttribute("action", "updateUsername");
				 dispatcher = "updateprofile";
			 }
			 else if(action.equals("updatePassword")) {
				 request.setAttribute("action", "updatePassword");
				 dispatcher = "updateprofile";
			 }
				
		} 
		else {
				 
			 if(action.equals("admindashboard")) {
//				 userSession.setCurrent_page("admindashboard");
				 dispatcher = "admindashboard";
			 }
			 else if(action.equals("adminviewbooks")) {
				 
//			 userSession.setCurrent_page("adminviewbooks");
			 dispatcher = "adminviewbooks";
			 }
			 else if(action.equals("adminbookdetails")) {
				 request.setAttribute("isbn", request.getParameter("data"));
//				 userSession.setCurrent_page("adminbookdetails");
				 dispatcher = "adminbookdetails";
			 }
			 else if(action.equals("adminbdetails")) {
				 dispatcher = "/WEB-INF/adminbdetails.jsp";
			 }
			 else if(action.equals("updateBook")) {
				 userSession.setCurrent_page("updateBook");
				 dispatcher = "updatebook";
			 }
			 else if(action.equals("addBook")) {
				 dispatcher = "/WEB-INF/addbook.jsp";
			 }
			 else if(action.equals("addUser")) {
				 dispatcher = "/WEB-INF/adduser.jsp";
			 }
			 else if(action.equals("viewusers")) {
				 dispatcher = "viewusers";
			 }
			 else if(action.equals("adminadduser")) {
				 dispatcher = "adminadduser";
			 }
			 else if(action.equals("adminuserdetails")) {
				 request.setAttribute("username", request.getParameter("data"));
				 dispatcher = "adminuserdetails";
			 }
			 else if(action.equals("adminudetails")) {
				 dispatcher = "/WEB-INF/adminudetails.jsp";
				 
			 }
			 else if(action.equals("updateUser")) {
//				 userSession.setCurrent_page("updateUser");
				 dispatcher = "updateUser";
			 }
			 else if(action.equals("adminprofile")) {
//				 userSession.setCurrent_page("adminprofile");
				 dispatcher = "adminprofile";
			 }
			 else if(action.equals("updateAdminUsername")) {
				 request.setAttribute("action", "updateAdminUsername");
				 dispatcher = "updateadminprofile";
			 }
			 else if(action.equals("updateAdminPassword")) {
				 request.setAttribute("action", "updateAdminPassword");
				 dispatcher = "updateadminprofile";
			 }
			 
		}
		 
			/*
			 * else if(action.equals("checkbook")) { dispatcher = "checkbook"; }
			 */
		 
		 System.out.println("dispatcher" + dispatcher);
		 
		 RequestDispatcher rd = request.getRequestDispatcher(dispatcher);
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
