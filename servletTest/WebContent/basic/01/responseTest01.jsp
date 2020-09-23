<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>페이지 이동 연습</title>
	</head>
	<body>
		<h2>sendRedirect와 forward 연습</h2>
		<hr>
		<form action="/servletTest/ResponseTest01.do" method="post">
			sendRedirect : <input type="text" name="username">
			<input type="submit" value="확인">
		</form>	
		<form action="/servletTest/ResponseTest02.do" method="post">
			forward : <input type="text" name="username">
			<input type="submit" value="확인">
		</form>	
	</body>
</html>