<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	\${5+2} : ${5+2} <br>
	\${5/2} : ${5/2} <br>
	<%-- \${5 div 2} : ${5 div 2} <br> --%>
	\${5 gt 2} : ${5 gt 2} <br>
	\${5 < 2} : ${5 < 2} <br>
	<!-- 그 외 나머지 들은 직접 작성을 해보면서 익히자 -->
</body>
</html>