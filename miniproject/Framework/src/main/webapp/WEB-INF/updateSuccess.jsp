<!DOCTYPE html>
<html>
<head>
	<title>Update Successful</title>
	 <link rel="icon" href="book2.png" type="image/png">
	<style>
		.container {
			margin: 50px auto;
			padding: 20px;
			max-width: 600px;
			text-align: center;
			background-color: #fff;
			border-radius: 10px;
			box-shadow: 0 0 10px rgba(0,0,0,0.3);
		}

		h1 {
			font-size: 36px;
			color: #333;
			margin-bottom: 20px;
		}

		p {
			font-size: 24px;
			color: #555;
			margin-bottom: 40px;
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
	<!-- <script type="text/javascript"> -->
	<%
	String page_redirect = (String)request.getAttribute("page_redirect");
	System.out.println("padesjkdjfdskjfh.............................." + page_redirect);
	if(page_redirect.equals("view_books")){
		%>
		<meta http-equiv="refresh" content="5; url= controller?action=adminviewbooks">
		<%
	}
	else if(page_redirect.equals("view_users")){
		%>
		<meta http-equiv="refresh" content="5; url= controller?action=viewusers">
		<%
	}
	else{
		
		%>
		<meta http-equiv="refresh" content="5; url=./login">
		<%
	}
	%> 
	<!-- </script> -->
	
</head>
<body>
	<div class="container">
		<h1>Update Successful!</h1>
		<H3>You will be redirected in 5 seconds.</H3>
		<p>Thank you.</p>
	</div>
</body>
</html>