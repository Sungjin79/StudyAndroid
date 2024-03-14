<%@page import="study.jsp.helper.WebHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	WebHelper web = WebHelper.getInstance(request,out);
	String is_popup = web.getString("is_popup","N");
	if(is_popup.equals("Y")){
		web.setCookie("is_popup", is_popup, 60);
	}
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>CookiePopup</title>
	<!-- Twitter Bootstrap3 & jQuery -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css" />
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		window.close();
	</script>
</head>
<body>
	<div class="container">
		<h1>Hello JSP</h1>
	</div>
</body>
</html>