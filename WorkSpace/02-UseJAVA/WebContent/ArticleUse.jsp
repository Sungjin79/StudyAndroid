<%@ page import="study.jsp.usingjava.model.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    Article article = new Article();
	article.setTextnum(100);
	article.setTexttitle("안뇽하십니까. 기초 jsp 수업중입니다.");
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
		<h1>Hello JSP</h1>
		<h1>글번호 : <%out.println(article.getTextnum()); %></h1>
		<h1>글제목 : <%=article.getTexttitle() %></h1>
		
		
	</div>
</body>
</html>