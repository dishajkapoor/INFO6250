<!DOCTYPE html>
<html>
<head>
<title>TurnThePage | Add User</title>
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
      
      select {
    display: block;
    width: 100%;
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
    font-size: 16px;
    margin-bottom: 15px;
}

select:focus {
    outline: none;
    border-color: #007bff;
    box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
}
</style>
</head>
<body>

	<ul>
		<li class="logo"><img src="book.png" alt="Logo"></li>
      <li class="center">TurnThePage</li>
		

		<li><a href="controller?action=viewusers">Back</a></li>
	</ul>

	<!-- Add your registration form below -->
    <div class="registration-form">
      <h2>Add a new user</h2>
      <%
      if (request.getAttribute("error") != null){
    	  %>
    	  <p class="error">Error: <%= request.getAttribute("error") %></p>
    	  <%
      }
      %>
      <form action="controller?action=adminadduser" method="post">
      
      <label for="name">First Name</label>
        <input type="text" id="name" name="name" class="form-control" required>
        
        <label for="lname">Last Name</label>
        <input type="text" id="lname" name="lname" class="form-control" required>
        
        <label for="email">Email</label>
        <input type="email" id="email" name="email" class="form-control" required>

        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control" required>
        
        <label for="role">Role</label>
        <!-- <input type="text" id="role" name="role" class="form-control" required> -->
        
        <select id="role" name="role" required>
    		<!-- <option value="">Select a Role</option> -->
    		
            	<option value="user">User</option>
            	<option value="admin">Admin</option>
            	
		</select>
        
		<p id = "error">
		</p>
		<input type="hidden" name="page" value="addUser"/>
        <input type="submit" value="Submit" >
      </form>
    </div>
</body>
</html>
