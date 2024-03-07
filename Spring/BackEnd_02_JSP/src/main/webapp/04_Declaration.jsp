<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언부</title>
</head>
<body>
	<%!int a = 10;
	int b = -20;
	
	String name = "SAFFY";
	
	public int add (int a,int b) {
		return a+b;
	}
	
	public int abs(int a ) {
		return a>0? a: -a;
	}
	
	%>
	<% 
	int c = 10; 
	out.print(add(a,b));
	out.print("</br>");
	
	out.print(abs(b));
	out.print(name);
	
	
	%>
	<a href="index.html">홈으로</a>
</body>
</html>