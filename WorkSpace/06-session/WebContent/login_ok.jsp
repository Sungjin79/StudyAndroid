<%@page import="java.net.URLEncoder"%>
<%@page import="study.jsp.helper.WebHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<% 
	session.setMaxInactiveInterval(30*60);

	WebHelper web = WebHelper.getInstance(request,out);
	
	String userId = web.getString("user_id","");
	String userPw = web.getString("user_pw","");
	
	
	if(userId.equals("")){
		web.redirect(null, "아이디를 입력하세요.");
		return;
	}
	
	if(userPw.equals("")){
		web.redirect(null, "패스워드를 입력하세요.");
		return;
	}
	
	if(!userId.equals("jspuser")){
		web.redirect(null, "아이디가 맞지않습니다요.");
		return;
	}
	
	if(!userPw.equals("123qwe!@#")){
		web.redirect(null, "패스워드가 맞지않습니다.");
		return;
	}
	
	//로그인 완료시 세션에 정보저장
	session.setAttribute("user_id", userId);
	//메세지 표시후 페이지 리다이렉트
	web.redirect("login.jsp", "안녕하세요"+userId+"님");	
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