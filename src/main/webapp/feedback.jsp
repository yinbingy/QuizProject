<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
    <title>Pattern</title>

</head>
<body>

<script type="text/javascript">
    
$(function () {

	  $("#rateYo").rateYo({
	       fullStar: true,
	       onSet: function (rating, rateYoInstance) {
	       rating = Math.ceil(rating);
	       $('#rating_input').val(rating);//setting up rating value to hidden field
	    }
	  });
	});
    </script>


<form action="FeedbackServlet" method="post">
			
			
			
			<div class="form-group">
			    <label for="exampleFormControlTextarea1">Feedback</label>
			    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name = "feedBack"></textarea>
			  </div>
			  <div style="display:inline-block;" id="rateYo"></div>
                      <input type="hidden" name="rating" id="rating_input"/>
              </div> 
		
              
               
				<div class = "form-group">
					<button class="btn btn-default btn-lg col-md-3" id="btn_register" type="submit">Submit</button>
				</div>
</form>

</body>
</html> 