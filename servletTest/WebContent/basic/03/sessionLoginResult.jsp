<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<!-- 
		로그인이 성공하면
			~~님 반갑습니다.
			로그아웃 ==> 이것을 누르면 로그아웃을 처리하고 main페이지로 이동
		로그인이 실패하면
			alert("로그인 실패");
			이전 페이지로 이동
	 -->
	 <% 
	 	session = request.getSession();
	 	String id = (String)session.getAttribute("id");
	 	if(id == null){
	 %>
	 	<script>
			alert("로그인 실패");
			history.go(-1);
		</script>
	<%
	 	} else {
	 %>
		<%= id %>님 반갑습니다.<br>
		<a href="<%=request.getContextPath() %>/SessionLogout.do">로그아웃	 
	 <%		
	 	}
	 %>
	 	
	</body>
</html>