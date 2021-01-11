<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<c:forEach items="${requestScope.qdList}" var="qd" >
	
			
	 <div class="card" style="width: 18rem;">
	  <div class="card-body">
	    <h5 class="card-title"><c:out value = "${qd.quizQuestion.content}"></c:out></h5>
	    <p>Your answer is: </p>
	    
	    
	    	<c:choose>
							<c:when test="${qd.choice == null}">
								<h5 class="card-title"><c:out value = "N/A"></c:out></h5>
	    						 <p> which is: </p>
	      						<h5 class="card-title"><c:out value = "false"></c:out></h5>
							</c:when>
								
							<c:otherwise>
			
								<h5 class="card-title"><c:out value = "${qd.choice.content}"></c:out></h5>
	    						 <p> which is: </p>
	      						<h5 class="card-title"><c:out value = "${qd.choice.if_correct}"></c:out></h5>
							</c:otherwise>
			</c:choose >
	    
	     
	    
	  </div>
	  </div>
	 
</c:forEach>

 <a class="nav-item nav-link" href="AdmainServlet">Back</a>
</body>
</html>