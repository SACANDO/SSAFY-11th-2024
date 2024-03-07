<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
String id = request.getParameter("id");
String pw = request.getParameter("password");

//실제로는 id 와 pw를 이용하여 DB에 저장되어있는 유저가 맞는지를 체크
if(id.equals("ssafy")&&pw.equals("1234")) {
	out.print("로그인성공");
	//로그인 성공
	//세션에 정보를 저장할꺼에요!
	
/* 	HttpSession mySession = request.getSession();
	mySession.setAttribute("id", id); */
	
	session.setAttribute("id", id); // JSP가 session영역을 기본으로 접근 가능
	
	response.sendRedirect("08_Main.jsp");
	/* request.getRequestDispatcher("08_Main.jsp").forward(request,response); 위험*/
	
	
	
}else {
	//로그인 실패
	out.print("로그인실패");
	response.sendRedirect("07_LoginForm.jsp");
}
%>