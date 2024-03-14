<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	session.setMaxInactiveInterval(30*60);
	String sessionUserId = (String) session.getAttribute("user_id");
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
	
		<% 
		if(sessionUserId ==null){
		%>
		<div class="container">
			<h1>로그인</h1>
			<form name="myform" method="post" action="login_ok.jsp" role="form" class='form-inline'>
				<fieldset>
				 	<div class='form-group'>
				 		<lable for="user_input">아이디</lable>
				 		<input type="text" name="user_id" id="user_id" class="form-control" placeholder="user id" />		 		
				 	</div>
				 	<div class='form-group'>
				 		<lable for="user_input">패스워드</lable>
				 		<input type="password" name="user_pw" id="user_pw" class="form-control" placeholder="password" />		 		
				 	</div>
				 	<button type="submit" class="btn btn-primary">로그인</button>
			 	</fieldset>
	 		</form>
	 	</div>
 		<% }else{%>
 		
 		<div class="container">
			<h1>로그아웃</h1>
		 	<div class='form-group'>
		 		<p>안녕하세요.<%=sessionUserId %>님</p>
		 		<a href='logout.jsp' class='btn btn-primary'>로그아웃</a>		 		
		 	</div>				
	 	</div>
	 	<%} %>
	
</body>
</html>