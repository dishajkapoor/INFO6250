<!DOCTYPE html>
<html>
<head>
<title>TurnThePage | Add Book</title>
<link rel="stylesheet" href="css/styles.css" >
 <link rel="icon" href="book2.png" type="image/png">
<style type="text/css">
 /* Add your registration form styling here */
      .registration-form {
        background-color: #f2f2f2;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0px 0px 10px 0px #ccc;
        margin: 50px auto;
        width: 500px;
      }

      .form-control {
        width: 100%;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
        margin-top: 6px;
        margin-bottom: 16px;
        resize: vertical;
      }

      input[type=submit] {
        background-color: #4CAF50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }

      input[type=submit]:hover {
        background-color: #45a049;
      }
      body {
  background-image: url("books.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center center;
   background-color: rgba(255, 255, 255, 0.1);
   /* color: #FFFFFF;  */
  
}
</style>
</head>
<body>

	<ul>
		<li class="logo"><img src="book.png" alt="Logo"></li>
      <li class="center">TurnThePage</li>
		

		<li><a href="controller?action=adminviewbooks">Back</a></li>
	</ul>

	<!-- Add your registration form below -->
    <div class="registration-form">
      <h2>Add a new book</h2>
      <%
      if (request.getAttribute("error") != null){
    	  %>
    	  <p class="error">Error: <%= request.getAttribute("error") %></p>
    	  <%
      }
      %>
      <form action="controller?action=updateBook" method="post">
      
      <label for="name">Book Name</label>
        <input type="text" id="name" name="name" class="form-control" required>
        
        <label for="isbn">ISBN</label>
        <input type="text" id="isbn" name="isbn" class="form-control" required>
        
        <label for="count">Count</label>
        <input type="text" id="count" name="count" class="form-control" required>

        <label for="desc">Description</label>
        <input type="text" id="desc" name="desc" class="form-control" required>

        <label for="ratings">Ratings</label>
        <input type="text" id="ratings" name="ratings" class="form-control" required>
        
        <label for="author">Author</label>
        <input type="text" id="author" name="author" class="form-control" required>
		<p id = "error">
		</p>
		<input type="hidden" name="page" value="addBook"/>
        <input type="submit" value="Submit" >
      </form>
    </div>
</body>
</html>
