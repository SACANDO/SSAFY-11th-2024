<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<% out.print("Hello"); %><!-- 스크립트릿 -->
	<%= "Hello" %><!-- 표현식 -->
	${"Hello"}<!-- EL -->
</body>
</html>