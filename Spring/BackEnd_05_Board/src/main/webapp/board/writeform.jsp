<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>�� ���</h2>
	<form action="board" method="POST">
		<!-- /�ִ°� ���� ����? -->
		<input type="hidden" name="action" value="write">
		<div>
			�� ���� : <input type="text" name="title">
		</div>
		<div>
			�� ���� : <input type="text" name="writer" value="�͸�">
		</div>
		<div>
			�� ���� :
			<textarea rows="10" cols="30" name="content"></textarea>
		</div>
		<div>
			<input type="submit"  value="�Խñ� ���">
		</div>


	</form>
</body>
</html>