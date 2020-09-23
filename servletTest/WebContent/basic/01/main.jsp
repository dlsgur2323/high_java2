<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
	<%
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
	%>
		<h2>로그인 성공!</h2>
		<%= id %>님 환영합니다!<br>
		(접속정보 : <%=id %>, <%=pass %> ) 
	</body>
</html>