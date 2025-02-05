<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 화면을 보여줄게 아니기 때문에 다 지워버렸다. 로그인 처리 용도만 할 친구!! --%>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	//실제로는 id / pw 를 이용하여 DB 저장되어있는 유저가 맞는지를 쳌 
	//아니면 적어도 Manager라도 있어야 했음.. 하지만 우리는 지금 없어요 ㅠ 
	//if("ssafy".equals(id) && "1234".equals(pw)){
	if(id.equals("ssafy") && pw.equals("1234")){
		//로그인 성공
		//세션에 정보를 저장할꺼에요!
		//request.getCookies() 반복문 돌면서  JSESSIONID 쿠키를 찾아서 값을 이용해서 메모리에 접근을 해야하는가!
		
		/* HttpSession mySession = request.getSession();
		//저거 이름 session 이라고 하면 X?
		mySession.setAttribute("id", id); */
		
		session.setAttribute("id", id); //JSP가 session 영역을 기본으로 접근할 수 있으니까... 
		response.sendRedirect("08_Main.jsp"); 
		//request.getRequestDispatcher("08_Main.jsp").forward(request, response);
		//살짝 위험 ㅠ
		
	}else{
		//로그인 실패
		response.sendRedirect("07_LoginForm.jsp");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
%>