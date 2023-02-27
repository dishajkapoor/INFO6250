<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
<%@page import="java.util.ArrayList"%>
<%@page import="neu.edu.data.Book"%>
<%@ page import = "neu.edu.data.UserSession" %>
<!DOCTYPE html>
<html>
<head>
<title>TurnThePage | Books</title>
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
<li><a href="controller?action=profile">Profile</a></li>
<li><a href="controller?action=viewmybooks">View My Books</a></li>
<li><a href="controller?action=dashboard">Dashboard</a></li>
	</ul>

	<!-- Add your content below -->
	<div style="padding:50px">
      <h1>Hey <%
      UserSession userSession = (UserSession)session.getAttribute("userSession");
      if(userSession != null){
      	out.append(userSession.getUsername());
      }
      %> </h1>
      <p>You can view all the books here.</p>
    </div>
    
    <div style="padding: 50px">
		<h1>Books</h1>
		<table>
			<tr>
			<th>ISBN</th>
				<th>Name</th>
				<th>Availability</th>
				
				<th>Action</th>

			</tr>
			<%
			ArrayList<Book> books = (ArrayList<Book>) session.getAttribute("books");
			for (Book book : books) {
			%>
			<!-- Add more rows of data as needed -->
			<tr>
			<td><%=book.getIsbn() %></td>
			<td style="text-transform: uppercase;"><%=book.getName() %></td>
				<td><%=book.getCount() %></td>
				
				

				<td><button onclick="viewRow(this)">View</button></td>


			</tr>

			<%
			}
			%>
		</table>
	</div>

	<script type="text/javascript">
		function viewRow(button) {
			var row = button.parentNode.parentNode;
			var cells = row.getElementsByTagName("td");
			
			
			var xhr = new XMLHttpRequest();
			  xhr.open("POST", "controller?action=bookdetails", true);
			  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			  xhr.onreadystatechange = function() {
			    if (xhr.readyState === 4 && xhr.status === 200) {
			    	window.location.href = "controller?action=bdetails" 
			    }
			  };
			 var isbn = cells[0].innerHTML;
			  xhr.send("data=" + isbn);	
			
			}
	</script>
	
</body>
</html>
