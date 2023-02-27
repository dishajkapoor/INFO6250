<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
    <%@page import="neu.edu.data.MyBook"%>
    <%@page import="neu.edu.data.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TurnThePage | My Book Details</title>
<link rel="stylesheet" href="css/styles.css" >
 <link rel="icon" href="book2.png" type="image/png">
<style>
    body {
      font-family: Arial, sans-serif;
      background-color: #F5F5F5;
    }
    h1 {
      color: #333333;
      text-align: center;
    }
    .container {
      margin: 0 auto;
      max-width: 600px;
      background-color: #FFFFFF;
      border-radius: 10px;
      padding: 20px;
      box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
    }
    .book-cover {
      display: block;
      margin: 0 auto;
      max-width: 300px;
      height: auto;
    }
    .book-title {
      font-size: 28px;
      margin-top: 20px;
      margin-bottom: 10px;
      text-align: center;
    }
    .book-author {
      font-size: 18px;
      font-style: italic;
      margin-bottom: 20px;
      text-align: center;
    }
    .book-description {
      font-size: 16px;
      line-height: 1.5;
      margin-bottom: 20px;
      text-align: justify;
    }
    .book-details {
      font-size: 16px;
      margin-bottom: 20px;
    }
    .book-details li {
      margin-bottom: 5px;
    }
    #returnBtn{
    background-color: #4CAF50; /* Green background */
			color: white; /* White text */
			padding: 12px 20px; /* Padding */
			border: none; /* No border */
			border-radius: 4px; /* Rounded corners */
			cursor: pointer;
    }
    #returnBtn:hover{
    background-color: #3e8e41; 
    }
    #returnTxt{
    background-color: #4CAF50;
    font-size: 18px;
      font-style: italic;
      text-align: center;
    }
    .inline {
  display: inline;
 	margin: 0;		
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
  </style>
</head>
<body>
<ul>
		<li class="logo"><img src="book.png" alt="Logo"></li>
      <li class="center">TurnThePage</li>
		
<li><a href="controller?action=viewmybooks">Back</a></li>
	</ul>


<div class="container">
<%
HttpSession session2 = request.getSession();
			MyBook selectedbook = (MyBook)(session2.getAttribute("selectedBook"));	
			System.out.println("sdhbfdjhkadnklsandkjandkjsakjbcajchbabshasbjd" + session.getAttribute("selectedBook"));
			Book myselectedbook = (Book)(session2.getAttribute("myselectedbook"));
			System.out.println("sdhbfdjhkadnklsandkjandkjsakjbcajchbabshasbjd" + session.getAttribute("myselectedbook"));
			%>
    <!-- <img class="book-cover" src="https://via.placeholder.com/300x450.png?text=Book+Cover" alt="Book Cover"> -->
    <h1 class="book-title">Purchase Date: <%=selectedbook.getPurchase_date() %></h1>
    <p class="book-author">Due Date: <%=selectedbook.getDue_date() %></p>
    <p class="book-author">Return Date: </p><p id = "returnDate"><%=selectedbook.getReturn_date() %></p>
    <!-- conole.log("return daeee"+ selectedbook.getReturn_date); -->
    <%-- <p class="book-description">About the book: <%=selectedbook.get() %></p> --%>
   	
    <p class="inline" > Number of available books: </p><p class= "inline" id = "count"><%=myselectedbook.getCount() %> </p>
    <p class="book-description"> Your Ratings: <%=selectedbook.getRatings() %> </p>
    <p> Average Ratings: <%=myselectedbook.getRatings() %></p>
    
    <button id = "returnBtn" onclick="returnThis(this)"> Return </button>
     <p id = "returnTxt"></p>
  </div>
  
  <script type="text/javascript">
<%--   <%
  if(session2.getAttribute("returned")=="true"){
	  %>
	  const myButton = document.getElementById("returnBtn");
	  
	  myButton.style.display = "none";
	  document.getElementById("returnTxt").innerHTML = "You have returned this book."
	  <%
  }
  %> --%>
  
		function returnThis(button) {
			const myButton = document.getElementById("returnBtn");
			  
			  myButton.style.display = "none";
				document.getElementById("returnTxt").innerHTML = "Thank You for returning!";
		
				  var element = document.getElementById("count");
				  var value = parseInt(element.innerHTML);
				  value++;
				  element.textContent = value.toString();
				  
				  var currentDate = new Date();
					
					// Format the date as yyyy-mm-dd
					var year = currentDate.getFullYear();
					var month = ('0' + (currentDate.getMonth() + 1)).slice(-2);
					var day = ('0' + currentDate.getDate()).slice(-2);
					var formattedDate = year + '-' + month + '-' + day;
					
					// Get the span element by ID
					var currentDateSpan = document.getElementById("returnDate");
					currentDateSpan.innerHTML = formattedDate;
				
				var xhr = new XMLHttpRequest();
			  xhr.open("POST", "controller?action=returnbook", true);
			  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			  xhr.send();
			}
		
		<%--  document.getElementById("returnDate").innerHTML = <%selectedbook.getReturn_date(); %> --%>
		<%-- console.log("return date" + <% selectedbook.getReturn_date(); %>); --%>
		<%-- <% System.out.println("return date............"+selectedbook.getReturn_date()); %> --%>
		
		/* aaj ka date set */
		/* db update count */
		<% if (!selectedbook.getReturn_date().equals("Not returned")){
			System.out.println("return date"+selectedbook.getReturn_date());
			
			%>
			
			const myButton = document.getElementById("returnBtn");
			 myButton.style.display = "none";
			 document.getElementById("returnTxt").innerHTML = "You have returned this book."
	<%
		}
		%>
</script>

</body>
</html>