<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.css">
<title>Insert title here</title>
</head>
<body>

<div class = "container">
	<div class="col-sm">
     <a href="HomeServlet">Home <span class="sr-only">Home</span></a>
    </div>
    <div class="col-sm">
     <a class="nav-item nav-link" href="AdmainServlet">Back</a>
    </div>
    
</div>

<div class = "container mb-3 mt-3">
	<table class = "table table-striped table-bordered" stype="width: 100%" id = myTable>
		<thead>
			<th>
				Name
			</th>
			
			<th>
				Enabled
			</th>
			
			<th>
				Operation
			</th>
		</thead>
		
			
		<tbody>
			
			<c:forEach items = "${requestScope.userList}"  var  = "user">
				<tr>
					<td>
						${user.user_name}
					</td>
					<td>
						${user.status}
					</td>
					<td>
					
					<form action="UserProfileServlet" method="post">
						<button type="submit" name="enable" value="${user.user_id}">Enable</button>
						<button type="submit" name="disable" value="${user.user_id}">Disable</button>
					</form>
						
					</td>
				</tr>
			
			</c:forEach>
		
		</tbody>
		
	</table>
</div>

 <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.js"></script>



<script>
	$(document).ready( function () {
	    $('#myTable').DataTable();
	} );
</script>
</body>
</html>