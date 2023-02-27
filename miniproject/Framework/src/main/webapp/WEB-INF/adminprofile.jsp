<!DOCTYPE html>
<html>
<head>
<title>TurnThePage | Admin Profile</title>
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
      /* .tab {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
            color: #333;
        } */

	        /* /* Style for selected tab */
	        /* .tab:focus, .tab:active {
	            border: 2px solid #f00;
	            outline: none;
	        }  */
</style>
</head>
<body>
    <ul>
        <li class="logo"><img src="book.png" alt="Logo"></li>
      <li class="center">TurnThePage</li>
        
        <li><a href="logout" >Logout</a></li>
        <!-- <li><a href="controller?action=profile" class="tab">Profile</a></li> -->
<li><a href="controller?action=admindashboard" class="tab">Dashboard</a></li>
<li><a href="controller?action=viewusers" class="tab">View Users</a></li>
<li><a href="controller?action=adminviewbooks" class="tab">View Books</a></li>
    </ul>
    <div class="registration-form">
      <h2>Update Email here</h2>
      <form action="controller?action=updateAdminUsername" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control" value="${requestScope.username}" disabled>
        <label for="email">Email</label>
        <input type="email" id="email" name="email" class="form-control" value ="${requestScope['email']}"required>
        <input type="hidden" name="page" value="editProfile"/>
        <input type="submit" value="Submit">
      </form>
    </div>
    
        <div class="registration-form">
      <h2>Update Password here</h2>
      <form action="controller?action=updateAdminPassword" method="post">
      <p id = "status"></p>
     
      
      <%
      if (request.getAttribute("error") != null){
    	  %>
    	  <p class="error">Error: <%= request.getAttribute("error") %></p>
    	  <%
      }
      %>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control" value="" required>
        <label for="confirm_password">Confirm Password</label>
        <input type="password" id="confirm_password" name="confirm_password" class="form-control" value ="" required>
            <input type="hidden" name="page" value="editProfilePassword"/>
    
        <input type="submit" value="Submit">
      </form>
    </div>
</body>
</html>