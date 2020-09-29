<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cookie 연습</title>
	</head>
	<body>
	
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie c : cookies){
	%>
		쿠키 변수 : <%=c.getName() %><br>
		쿠키 값    : <%=URLDecoder.decode(c.getValue(),"utf-8") %><hr>
	<%		
			}
		}
	%>
	<br><br>
	
	
	
	<a href="<%=request.getContextPath() %>/CookieAddServlet.do">Cookie정보 저장하기</a><br>
	<a href="<%=request.getContextPath() %>/CookieReadServlet.do">Cookie정보 확인하기</a><br>
	<a href="<%=request.getContextPath() %>/CookieDeleteServlet.do">Cookie정보 삭제하기</a><br>
	</body>
</html>