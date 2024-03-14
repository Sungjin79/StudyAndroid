<%@page import="java.net.URLEncoder"%>
<%@page import="study.jsp.helper.WebHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<% 
	session.setMaxInactiveInterval(30*60);

	WebHelper web = WebHelper.getInstance(request,out);
	String input = web.getString("user_input");
	String msg="";
	
	if(input != null){
		/* 전송된 값이 있는 경우 저장 (혹은 덮어쓰기)*/
		session.setAttribute("mysession", input);
		msg="세션 저장 완료";
	}else{
 		//세션삭제		
 
 		session.removeAttribute("mysession");
 		msg="세션삭제완료";
		
	}
	web.redirect("session.jsp",msg);
%>
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
	</div>
</body>
</html>