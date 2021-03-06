<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 목록 보기</title>
		<script>
			window.onload = function(){
				var btnAdd = document.getElementById("btnAdd");
				btnAdd.onclick = function(){
					location.href = "<%=request.getContextPath()%>/member/memberForm.do";
				}
			}
		</script>
	</head>
	<body>
		<table border="1">
			<thead>
				<tr>
					<td colspan="4"><input type="button" value="회원추가" id="btnAdd"></td>
				</tr>
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
						<td><a href="<%=request.getContextPath()%>/member/memberView.do?mem_id=<%= vo.getMem_id() %>"><%= vo.getMem_id() %></a></td>
						<td><%= vo.getMem_name() %></td>
						<td><%= vo.getMem_tel() %></td>
						<td><%= vo.getMem_addr() %></td>
					<tr>	
				<%
				}
			%>
			</tbody>
		</table>
	</body>
</html>