<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	/* 저장된 쿠키 목록을 가져온다. */
	Cookie[] cookies = request.getCookies();
	
	String mycookie = null;
	
	if(cookies != null){
		for(int i=0; i<cookies.length; i++){
			String cookieName = cookies[i].getName();
			
			if(cookieName.equals("mycookie")){
				mycookie = cookies[i].getValue();
			}
		}
	}
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
			if(mycookie ==null){
				out.println("<h1>mycookies값 없다</h1>");
			}else{
				String value = URLDecoder.decode(mycookie, "UTF-8");
				out.println("<h1>mycookies="+value+"</h1>");
			}
		%>
		<form name="myform" method="post" action="cookie_save.jsp" role="form" class='form-inline'>
			<fieldset>
			 	<div class='form-group'>
			 		<lable for="user_input">쿠키저장하기</lable>
			 		<input type="text" name="user_input" id="user_input" class="form-control" />		 		
			 	</div>
			 	<button type="submit" class="btn btn-primary">쿠키저장</button>
		 	</fieldset>
 		</form>
	</div>
	
	
</body>
</html>