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
			<h1 class="text-center text-primary">Add Question</h1>
		</div>
	
		<div class="modal-body">
		
			
			<form action="AddQuestionServlet" method="post">
			
			
				<div class="form-group-lg">
					<label>Content:</label>
					<input class = "form-control" type="text" name="content">
				</div>
				
				<div class="form-group-lg">
					<label>Right Choice</label>
					<input class = "form-control" type="text" name="choice1">
				</div>
				
				<div class="form-group-lg">
					<label>Wrong Choice</label>
					<input class = "form-control" type="text" name="choice2">
				</div>
				
				<div class="form-group-lg">
					<label>Wrong Choice</label>
					<input class = "form-control" type="text" name="choice3">
				</div>
					
				
				<div class = "form-group">
					<button class="btn btn-default btn-lg col-md-3" id="btn_register" type="submit">submit</button>
				</div>
			</form>
		
		</div>
		
	</div>
</div>
</body>
</html>