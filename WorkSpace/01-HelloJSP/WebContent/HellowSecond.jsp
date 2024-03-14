<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String myname = "Ko Sungjin 개발자";
    int count = 8;
    
    for(int i=0;i<count;i++){
    	String output = String.format("'%s'는 '%d'번째 개발중입니다.</br>", myname, i);
    	out.println(output);
    }

%>