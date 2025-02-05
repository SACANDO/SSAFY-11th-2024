<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<%
		if(session.getAttribute("id") == null){
			response.sendRedirect("07_LoginForm.jsp");
		}else{
			%>
			<%-- <%=request.getParameter("password") %> 위험해! --%>
			<%=session.getAttribute("id") %>
			<%
		}
	%>
	<!-- 로그아웃 -->
	<a href="07_Logout.jsp">로그아웃</a>
	<form action="07_Logout.jsp" method="POST">
		<input type="submit">
		<button>로그아웃</button>
	</form>
	
	<hr>
	<h2>메인페이지</h2>
	


</body>
</html>