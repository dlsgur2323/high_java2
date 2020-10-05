<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>RequestWrapper 연습</h1>
	<hr>
	
	<h2>GET방식 요청 1 ==> 링크 방식</h2>
	<a href="http://localhost/servletTest/WrapperTestServlet.do">Get 방식 요청1</a>
	<hr>
	<form action="http://localhost/servletTest/WrapperTestServlet.do">
		회원ID : <input type="text" name="mem_id"><br><br>
		회원 이름 : <input type="text" name="mem_name"><br><br>
		패스워드 : <input type="password" name="mem_pass"><br><br>
		<input type="submit" value="전송">
		<input type="reset" value="취소">
	</form>
</body>
</html>