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
</div>

<div class = "container mb-3 mt-3">
	<table class = "table table-striped table-bordered" stype="width: 100%" id = myTable>
		<thead>
			<th>
				Taken_Date
			</th>
			
			<th>
				QuizType
			</th>
			<th>
				Name
			</th>
			<th>
				Number of Questions
			</th>
			<th>
				Score
			</th>
		</thead>
		
			
		<tbody>
			
			<c:forEach items = "${requestScope.resultList}"  var  = "result">
				<tr>
					<td>
						${result.startTime}
					</td>
					<td>
						${result.type.type_name}
					</td>
					<td>
						${result.user.user_name}
					</td>
					<td>
						10
					</td>
					<td>
						${result.score}
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