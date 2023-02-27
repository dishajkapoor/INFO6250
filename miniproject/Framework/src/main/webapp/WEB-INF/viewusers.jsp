<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
<%@page import="java.util.ArrayList"%>
<%@page import="neu.edu.data.User"%>
<%@ page import = "neu.edu.data.UserSession" %>
<!DOCTYPE html>
<html>
<head>
<title>TurnThePage | Users</title>
 <link rel="icon" href="book2.png" type="image/png">
<link rel="stylesheet" href="css/styles.css" >
<style type="text/css">

/* Add your table styling below */
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
button{
    background-color: #4CAF50; /* Green background */
			color: white; /* White text */
			padding: 12px 20px; /* Padding */
			border: none; /* No border */
			border-radius: 4px; /* Rounded corners */
			cursor: pointer;
    }
    button:hover{
    background-color: #3e8e41; 
    }
</style>
</head>
<body>

	<ul>
		<li class="logo"><img src="book.png" alt="Logo"></li>
      <li class="center">TurnThePage</li>
		<li><a href="logout">Logout</a></li>
<li><a href="controller?action=adminprofile">Profile</a></li>
<li><a href="controller?action=adminviewbooks">View Books</a></li>
<li><a href="controller?action=admindashboard">Dashboard</a></li>
	</ul>

	<!-- Add your content below -->
	<div style="padding:50px">
      <h1>Hey <%
      UserSession userSession = (UserSession)session.getAttribute("userSession");
      if(userSession != null){
      	out.append(userSession.getUsername());
      }
      %> </h1>
      <p>You can view all the users here.</p>
    </div>
    
    <div style="padding: 50px">
		<h1>Users</h1>
		<table>
			<tr>
				<th>First Name</th>
				<th>Username</th>
				
				<th>Email</th>
<th>Role</th>
<th>Action</th>
			</tr>
			<%
			ArrayList<User> users = (ArrayList<User>) session.getAttribute("users");
			for (User user : users) {
			%>
			<!-- Add more rows of data as needed -->
			<tr>
			<td><%=user.getFirstName() %></td>
			<td style="text-transform: uppercase;"><%=user.getUsername() %></td>
				<td><%=user.getEmail() %></td>
				<td><%=user.getRole() %></td>
				<td><button onclick="view(this)">View & edit</button>

			</tr>

			<%
			}
			%>
		</table>
		<br><br>
		<button type="button" onclick="addBook()">Add a new user</button>
	</div>

	<script type="text/javascript">
		function view(button) {
			console.log("clicked");
			var row = button.parentNode.parentNode;
			var cells = row.getElementsByTagName("td");
			
			
			var xhr = new XMLHttpRequest();
			  xhr.open("POST", "controller?action=adminuserdetails", true);
			  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			  xhr.onreadystatechange = function() { 
			    if (xhr.readyState === 4 && xhr.status === 200) {
			    	window.location.href = "controller?action=adminudetails" 
			    }
			  };
			  var username = cells[1].innerHTML;
			  console.log("sent" + username);
			  xhr.send("data=" + username);	
			
			}
		function addBook(button) {			
			    	window.location.href = "controller?action=addUser" 
			}
	</script>
	
</body>
</html>
