<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>test입니다</title>
	</head>
	<body>
		<table border="1">
			<thead>
				<tr>
					<th>ID</th><th>이름</th><th>전화</th><th>주소</th>
				</tr>
			</thead>
			<tbody>
			<%
				List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
				for(MemberVO vo : list){
				%>
					<tr>
						<td><%= vo.getMem_id() %></td><td><%= vo.getMem_name() %></td>
						<td><%= vo.getMem_tel() %></td><td><%= vo.getMem_addr() %></td>
					<tr>	
				<%
				}
			%>
			</tbody>
		</table>
	</body>
</html>