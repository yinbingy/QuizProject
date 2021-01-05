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
<h3> This is your result </h3>
<h1><%= session.getAttribute("sessionName") %> Your score is <%= request.getAttribute("correctNum") %> / <%= request.getAttribute("numOfQuestions") %></h1>
<h2> <%= request.getAttribute("pass") %> </h2>

<h3> start at <%= session.getAttribute("startTime") %> </h3>
<h3> end at <%= session.getAttribute("endTime") %></h3>

<c:forEach items="${requestScope.qqwcList}" var="qqwcList" >
	
			
	 <div class="card" style="width: 18rem;">
	  <div class="card-body">
	    <h5 class="card-title"><c:out value = "${qqwcList.qContent}"></c:out></h5>
	    <p>Your answer is: </p>
	     <h5 class="card-title"><c:out value = "${qqwcList.cContent}"></c:out></h5>
	     <p> which is: </p>
	      <h5 class="card-title"><c:out value = "${qqwcList.ifCorrect}"></c:out></h5>
	    
	  </div>
	  </div>
	 
</c:forEach>


 <a class="nav-item nav-link" href="ResultServlet">Home</a>



</body>
</html>