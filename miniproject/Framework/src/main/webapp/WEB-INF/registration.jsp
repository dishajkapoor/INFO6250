<!DOCTYPE html>
<html>
<head>
<title>TurnThePage | Registration</title>
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
      .error {
        color: red;
        font-weight: bold;
        text-align: center;
        padding: 10px;
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
		

		<li><a href="index.html">Home</a></li>
		<li><a href="login">Login</a></li>
	</ul>

	<!-- Add your registration form below -->
    <div class="registration-form">
      <h2>Register Here</h2>
      <%
      if (request.getAttribute("error") != null){
    	  %>
    	  <p class="error">Error: <%= request.getAttribute("error") %></p>
    	  <%
      }
      %>
      <form action="registration" method="post">
      
      <label for="firstName">First Name</label>
        <input type="text" id="firstName" name="firstName" class="form-control" required>
        
        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" name="lastName" class="form-control" required>
        
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control" required>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" class="form-control" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control" required>
        
        <label for="password2">Confirm Password</label>
        <input type="password" id="password2" name="password2" class="form-control" required>
		<p id = "error">
		</p>
        <input type="submit" value="Submit" >
      </form>
    </div>
</body>
</html>
