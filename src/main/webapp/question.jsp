<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
</head>
<body>
<h> Q PAGE </h>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	
	 <div class="card" style="width: 18rem;">
	  <div class="card-body">
	  
	  
	  	<p> Question : <c:out value = "${sessionScope.quizPage+1}"/> </p>
	    <h5 class="card-title"><c:out value = "${sessionScope.QuizeQuestionList.get(sessionScope.quizPage).content}"></c:out></h5>
	  </div>
	  </div>
	  
	  
	  
	  <form action="QuizServlet" method="post">
	  
	  
	  
	  
	  
	  			<c:forEach items = "${requestScope.QuizChoiceList}"  var  = "choice">
						
						<c:choose>
							<c:when test="${requestScope.nextChoiceId == choice.choice_id}">
								<input type = "radio" name = "choiceSelected"  checked value = "${choice.choice_id}" > ${choice.content} </input>
							</c:when>
								
							<c:otherwise>
			
								<input type = "radio" name = "choiceSelected"  value = "${choice.choice_id}" > ${choice.content} </input>
									
							</c:otherwise>
						</c:choose >
						
				
	  			</c:forEach>
	  			
	  			
	  									
	
					
	  
	  			<c:if test="${sessionScope.quizPage > 0}">
	  				<input type="submit" name="act" value="prev"/>
	  				
	  			</c:if>
	  			
	  			
	  			
	  			
				<c:choose>
					<c:when test = "${sessionScope.quizPage < sessionScope.QuizeQuestionList.size()-1}">
						<input type="submit" name="act" value="next"/>
					</c:when>
					
					<c:otherwise>
						<input type="submit" name="act" value="submit"/>
					</c:otherwise>
				</c:choose>
				

				
				
	</form>
	
	


</body>
</html>