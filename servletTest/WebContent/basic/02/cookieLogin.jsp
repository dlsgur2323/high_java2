<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>로그인</title>
	</head>
	
	<body>
	<br><br>
		<h2>로그인</h2>
		<form action="/servletTest/LoginCheckServlet.do" method="post">
			<table>
				<tr>
					<td>아이디:</td>
					<td>
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 1){
			for(Cookie c : cookies){
				if(c.getName().equals("id")){
	%>					
						<input type="text" name="id" autocomplete="off" value="<%=c.getValue() %>">
	<%
				}
			}
		} else {
	%>			
						<input type="text" name="id" autocomplete="off">
	<%		
		}
	%>
						<input type="checkbox" name="chkid" value="ok"> id 기억하기
					</td>
				</tr>
				<tr>
					<td>비밀번호:</td>
					<td><input type="password" name="pass" autocomplete="off"></td>
				</tr>
			</table>
			<input type="submit" value="로그인">
			<input type="reset" value="취소">
		</form>
	</body>
</html>