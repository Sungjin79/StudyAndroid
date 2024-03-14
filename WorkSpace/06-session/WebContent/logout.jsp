<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	session.setMaxInactiveInterval(30*60);
	String mySession = (String) session.getAttribute("mysession");
%>

<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>My JSP Page</title>
	<!-- Twitter Bootstrap3 & jQuery -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css" />
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<%
			if(mySession !=null){
				out.println("<h1>mysession="+mySession+"</h1>");
			}else{
				out.println("<h1>mysession=세션값없음</h1>");
			}
		%>
		<form name="myform" method="post" action="session_save.jsp" role="form" class='form-inline'>
			<fieldset>
			 	<div class='form-group'>
			 		<lable for="user_input">세션저장하기</lable>
			 		<input type="text" name="user_input" id="user_input" class="form-control" />		 		
			 	</div>
			 	<button type="submit" class="btn btn-primary">세션저장</button>
		 	</fieldset>
 		</form>
	</div>
	
	
</body>
</html>