<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠퍼스</title>
</head>
<body>
	<%
	String[] dramaList = { "파리의 연인", "고려거란전쟁", "대조영", "내남편과 결혼해줘" };
	%>


	<h3>c:forToken</h3>
	<c:forTokens var="campus" items="<%=Arrays.toString(dramaList)%>" delims=",">
		${campus}<br>
	</c:forTokens>

	<h3>c:forToken</h3>
	<c:forTokens var="campus" items="서울,대전,구미.광주.부울경" delims=",.">
		${campus}<br>
	</c:forTokens>

</body>
</html>