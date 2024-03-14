<%@page import="sun.font.Script"%>
<%@page import="study.jsp.helper.WebHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%  WebHelper web = WebHelper.getInstance(request,out);
	String is_popup = web.getCookie("is_popup","N");
	
%>

<html>
<head>
	<meta charset="utf-8" />
	<title>CookiePopup</title>
	<!-- Twitter Bootstrap3 & jQuery -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css" />
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<% 
		if(!is_popup.equals("Y")){ %>
			<script type='text/javascript'>
				window.open('ex2Child.jsp','child-win','width=350,height=300,scrollbars=no,toolbar=no,resizable=no');
			</script>
	<%
	}
	%>
	
</head>
<body>
	<div class="container">
		<div class="page-header">			
		<h1>팝업창 열기</h1>
		</div>
		<div>
			<p>이 페이지는 저장된 쿠키값이 있을 경우 팝업을 열지 않습니다.</p>
		</div>
	</div>
</body>
</html>