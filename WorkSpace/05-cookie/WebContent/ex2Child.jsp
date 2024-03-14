<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>팝업창</h1>
		</div>
		<p>opener.jsp에 의해서 열려진 팝업창 입니다.</p>
		<form name="myform" mehtod="post" action="ex2ChildClose.jsp" role="form" class='form-inline'>
			<fieldset>
				<label>
					<input type="checkbox" name='is_popup' value='Y'>
					1분간 창 열지 않음
				</label>
			</fieldset>
			<button type="submit" class="btn btn-default">닫기 </button>
		</form>	
		</div>
</body>
</html>