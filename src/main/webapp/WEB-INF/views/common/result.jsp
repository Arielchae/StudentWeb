<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 중복 안내</title>
<style>
	h1 {
		color: red;
	}

</style>
<% 
	String message = (String)request.getAttribute("message");
%>
</head>
<body>
	<h1><%= message %></h1>
</body>
</html>