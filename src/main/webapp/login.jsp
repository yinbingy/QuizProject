<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

</head>


<body>


<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<div class ="modal-dialog">
	<div class="modal-content">
		<div class = "modal-header">
			<h1 class="text-center text-primary">login</h1>
		</div>
	
		<div class="modal-body">
		
		<% 
			String name = (String) request.getAttribute("loginMsg");
		
			
			if(name != null) {
				out.print(name);
			}
			
		%>
			
			<form action="LoginServlet" method="post">
			
			
				<div class="form-group-lg">
					<label>NAME:</label>
					<input class = "form-control" type="text" name="name"/ placeholder="NAME:">
				</div>
					
					
				
				<div class="form-group-lg">
					<label>Password:</label>
					<input class = "form-control" type="password" name="password"/ placeholder="PASSWARD">
				</div>
				
				<div class = "form-group">
					<button class="btn btn-default btn-lg col-md-3" id="btn_register" type="submit">Login</button>
				</div>
			</form>
			
			<a href="registration.jsp">Don't have an account?</a> 
		
		</div>
		
	</div>
</div>
<p>LOGIN PAGE</p>
</body>
</html>

