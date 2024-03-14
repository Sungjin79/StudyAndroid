<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	String ans = request.getParameter("ans");
	
	String result = null;
	
	if(ans==null){
		result ="응답 내용이 없습니다.";		
	}else{
		
		
		int user_select=0;
		try{
			user_select = Integer.parseInt(ans);
		}catch(Exception e){}			
		
		if(user_select == 300){
			result = "정답~~!!";
		}else{
			result = "정답 아님~~!!";
		}
	}
%>
<body>
	<div class="container">
		<h1>GET 예제결과</h1>
	</div>
	<div class="container">
		<div class='page=header'><h1>응답결과</h1></div>
		<div>
			<p><%=result %>
		</div>
	</div>
</body>
</html>