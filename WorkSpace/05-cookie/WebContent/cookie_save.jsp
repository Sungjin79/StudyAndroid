<%@page import="java.net.URLEncoder"%>
<%@page import="study.jsp.helper.WebHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<% 
	WebHelper web = WebHelper.getInstance(request,out);
	String input = web.getString("user_input");
	
	String msg="";
	
	if(input != null){
		/* 전송된 값이 있는 경우 저장 */
		//저장할 값에 대한 URLEncodeing
		input = URLEncoder.encode(input, "UTF-8");
		//쿠키생성
		Cookie info = new Cookie("mycookie",input);
		//쿠키유효시간
		info.setMaxAge(60);
		//쿠키경로
		info.setPath("/");
		response.addCookie(info);
	}else{
/* 		쿠키삭제
		동일한 이름으로 만료시간을 0으로 설정하면 삭제
 */
 		Cookie info = new Cookie("mycookie",null);
		info.setMaxAge(60);
		info.setPath("/");
		response.addCookie(info);
		msg="쿠키삭제완료";
		
	}
	web.redirect("cookie.jsp",msg);
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