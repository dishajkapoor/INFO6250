<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
    <%@page import="neu.edu.data.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TurnThePage | Book Details</title>
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
      text-align: left;
    }
    .book-details {
      font-size: 16px;
      margin-bottom: 20px;
       text-align: center;
    }
    .book-details li {
      margin-bottom: 5px;
      text-align: center;
    }
    #purchaseBtn{
    background-color: #4CAF50; /* Green background */
			color: white; /* White text */
			padding: 12px 20px; /* Padding */
			border: none; /* No border */
			border-radius: 4px; /* Rounded corners */
			cursor: pointer;
    }
    #purchaseBtn:hover{
    background-color: #3e8e41; 
    }
    #purchaseTxt{
    background-color: #4CAF50;
    font-size: 18px;
      font-style: italic;
      text-align: center;
    }
    .inline {
  display: inline;
 	margin: 0;		
 	
}
  </style>
</head>
<body>
<ul>
		<li class="logo"><img src="book.png" alt="Logo"></li>
      <li class="center">TurnThePage</li>
		
<li><a href="controller?action=viewbooks">Back</a></li>
	</ul>

<br>
<br>
<div class="container">
<%
HttpSession session2 = request.getSession();
			Book selectedbook = (Book)(session2.getAttribute("selectedBook"));	
			
			%>
    <!-- <img class="book-cover" src="https://via.placeholder.com/300x450.png?text=Book+Cover" alt="Book Cover"> -->
    <h1 class="book-title" style="text-transform: uppercase;"><%=selectedbook.getName() %></h1>
    <p class="book-author">by <b><%=selectedbook.getAuthor() %></b></p>
    <p class="book-author">ISBN: <b><%=selectedbook.getIsbn() %></b></p>
    <p class="book-description">About the book: <b><%=selectedbook.getDesc() %></b></p>

    <p class="inline book-description" > Number of available books: </p><p class= "inline" id = "count"><b><%=selectedbook.getCount() %> </b></p>
    <p class="book-description"> Average Ratings: <b><%=selectedbook.getRatings() %> </b></p>
    
    <button id = "purchaseBtn" onclick="purchaseThis(this)"> Purchase </button>
     <p id = "purchaseTxt"></p>
  </div>
  
  <script type="text/javascript">
    

    var count = document.getElementById("count").innerHTML;
    
    if(count == 0){
    	const myButton = document.getElementById("purchaseBtn");
		  myButton.style.display = "none";
		  document.getElementById("purchaseTxt").innerHTML = "Sorry, no more books left. But come back later, we'll fix this for you.";
    }
    
    <%--
    
     ServletContext application2 = request.getServletContext();
	application2 = request.getServletContext(); 
	MongoClient mongoClient = (MongoClient) application2.getAttribute("mongodbClient");
	 MongoCollection<Document> mongoCollectionBooks = mongoClient.getDatabase("webdev").getCollection("mybooks");
	 /* UserSession userSession = session.getAttribute("userSession"); */
    --%>
    <% 
    if(session2.getAttribute("owned").equals("true")){
    %>
    
    	const myButton = document.getElementById("purchaseBtn");
		  myButton.style.display = "none";
		  document.getElementById("purchaseTxt").innerHTML = "You have already purchased this book :)";		 
	
		  <%
    } %> 
    
    var xhr = new XMLHttpRequest();
	  xhr.open("POST", "controller?action=checkbook", true);
	  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	  xhr.send();
    
		function purchaseThis(button) {
			const myButton = document.getElementById("purchaseBtn");
			  
			  myButton.style.display = "none";
				document.getElementById("purchaseTxt").innerHTML = "Congratulations! The book is yours.";

				  var element = document.getElementById("count");
				  var value = parseInt(element.innerHTML);
				  value--;
				  element.textContent = value.toString();
				
				var xhr = new XMLHttpRequest();
			  xhr.open("POST", "controller?action=purchasebook", true);
			  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			  /* xhr.onreadystatechange = function() {
			     f (xhr.readyState === 4 && xhr.status === 200) {
			    	window.location.href = "controller?action=purchase" 
			    } 
			    
			  } */
			  xhr.send();
			}
</script>

</body>
</html>