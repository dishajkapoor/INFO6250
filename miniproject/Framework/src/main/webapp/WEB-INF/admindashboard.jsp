<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "neu.edu.data.UserSession" %>
<!DOCTYPE html>
<html>
<head>
<title>TurnThePage | Admin Dashboard</title>
<link rel="stylesheet" href="css/styles.css" >
 <link rel="icon" href="book2.png" type="image/png">
 

<style>
body {
  background-image: url("books.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center center;
   background-color: rgba(255, 255, 255, 0.1);
   color: #FFFFFF; 
  
}
</style>
</head>
<body>

	<ul>
		<li class="logo"><img src="book.png" alt="Logo"></li>
      <li class="center">TurnThePage</li>
		<li><a href="logout">Logout</a></li>
<li><a href="controller?action=adminprofile">Profile</a></li>
<li><a href="controller?action=viewusers">View Users</a></li>
<li><a href="controller?action=adminviewbooks">View Books</a></li>

		
	</ul>

	<!-- Add your content below -->
	<div style="padding:50px">
      <h1>Welcome <%
      UserSession userSession = (UserSession)session.getAttribute("userSession");
      if(userSession != null){
      	out.append(userSession.getUsername());
      }
      %> </h1>
    </div>

</body>
</html>
