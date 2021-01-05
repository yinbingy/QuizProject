<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
   
    <title>Pattern</title>

    <style type="text/css">
        #header {
            background: url(imgs/header.jpeg);
            background-size: cover;
            background-position: center;
        }

    </style>
</head>
<body>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>



<div class="container">
  <div class="row">
    <div class="col-sm">
     <a href="#">Home <span class="sr-only">(current)</span></a>
    </div>
    <div class="col-sm">
     <a  href="LogoutServlet">Logout</a>
    </div>
    <div class="col-sm">
      <a  href="RegistrationServlet">Registration</a>
    </div>
    
    <div class="col-sm">
    	<a  href="feedback.jsp">Feedback</a>
    </div>
  </div>
</div>

  
   


<h>HOME</h>
	

	<c:forEach items="${requestScope.quizTypeList}" var="quizTypeList" >
	
			
	 <div class="card" style="width: 18rem;">
	  <div class="card-body">
	    <h5 class="card-title"><c:out value = "${quizTypeList.type_name}"></c:out></h5>
	    
	   
	    <a href="QuizServlet?quizId=${quizTypeList.type_id}&quizType=${quizTypeList.type_name}" class="btn btn-primary">Start</a>
	  </div>
	  </div>
	 
  	 
  	</c:forEach>
	
  	




</body>
</html>