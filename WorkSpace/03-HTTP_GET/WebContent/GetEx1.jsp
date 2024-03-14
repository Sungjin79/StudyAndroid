<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<h1>GET 예제</h1>
		<h2>Q. 100 + 200 = ? </h2>
	</div>
	<div class="container">
		<div>
			<a href='GetEx2.jsp?ans=100' class='btn btn-default'>100</a>
			<a href='GetEx2.jsp?ans=200' class='btn btn-primary'>200</a>
			<a href='GetEx2.jsp?ans=300' class='btn btn-info'>300</a>
			<a href='GetEx2.jsp?ans=400' class='btn btn-warning'>400</a>
			<a href='GetEx2.jsp?ans=500' class='btn btn-danger'>500</a>
		</div>
	</div>
	
	
</body>
</html>