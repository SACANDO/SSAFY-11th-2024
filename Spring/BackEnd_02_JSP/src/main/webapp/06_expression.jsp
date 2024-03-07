<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!int a = 10;
	int b = -20;

	String name = "SAFFY";

	public int add(int a, int b) {
		return a + b;
	}

	public int abs(int a) {
		return a > 0 ? a : -a;
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현식</title>
</head>
<body>

	<%=name	%>
	<br>
	<%=a+b %>
	<br>
	<%=add(a,b) %>
	<br>

	<a href="index.html">홈으로</a>
</body>
</html>