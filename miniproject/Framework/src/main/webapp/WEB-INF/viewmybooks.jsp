<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="neu.edu.data.MyBook"%>
<%@ page import = "neu.edu.data.UserSession" %>
<!DOCTYPE html>
<html>
<head>
<title>TurnThePage | MyBooks</title>
<link rel="stylesheet" href="css/styles.css" >
 <link rel="icon" href="book2.png" type="image/png">
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
Button{
    background-color: #4CAF50; /* Green background */
			color: white; /* White text */
			padding: 12px 20px; /* Padding */
			border: none; /* No border */
			border-radius: 4px; /* Rounded corners */
			cursor: pointer;
    }
    Button:hover{
    background-color: #3e8e41; 
    }
    /* body {
  background-image: url("books.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center center;
   background-color: rgba(255, 255, 255, 0.1);
  color: #FFFFFF;  
  
} */
</style>
</head>
<body>

	<ul>
		<li class="logo"><img src="book.png" alt="Logo"></li>
      <li class="center">TurnThePage</li>
      
<li><a href="logout">Logout</a></li>
<li><a href="controller?action=profile">Profile</a></li>
<li><a href="controller?action=dashboard">Dashboard</a></li>
<li><a href="controller?action=viewbooks">View Books</a></li>

	</ul>

	<div style="padding:50px">
      <h1>Hey <%
      UserSession userSession = (UserSession)session.getAttribute("userSession");
      if(userSession != null){
      	out.append(userSession.getUsername());
      }
      %> </h1>
      <p>You can view your purchased books here.</p>
    </div>
    
    <div style="padding: 50px">
		<h1>My Books</h1>
		<table>
			<tr>
			<th>ISBN</th>
				<th>Purchase Date</th>
				<th>Due Date</th>
				
				<th>Return Date</th>
				<th> Action </th>

			</tr>
			
			<%
			ArrayList<MyBook> mybooks = (ArrayList<MyBook>) session.getAttribute("mybooks");
			for (MyBook book : mybooks) {
			%>
			
			<tr>
				<td><%=book.getIsbn() %></td>
				<td><%=book.getPurchase_date() %></td>
				<td><%=book.getDue_date() %></td>
				<td><%=book.getReturn_date() %></td>	
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
			  xhr.open("POST", "controller?action=mybookdetails", true);
			  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			  xhr.onreadystatechange = function() {
			    if (xhr.readyState === 4 && xhr.status === 200) {
			    	window.location.href = "controller?action=mybdetails" 
			    }
			  };
			 var isbn = cells[0].innerHTML;
			 console.log("isbn in jsp" + isbn);
			 xhr.send("data=" + isbn);
		 }
		
	</script>
</body>
</html>
