<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	MemberVO vo = (MemberVO)request.getAttribute("memberVo");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script>
			window.onload = function(){
				var btnList = document.getElementById("btnList");
				btnList.onclick = function(){
					location.href = "<%=request.getContextPath()%>/member/memberList.do";
				}
				
				var btnDelete = document.getElementById("btnDelete");
				btnDelete.onclick = function(){
					location.href = "<%=request.getContextPath()%>/member/memberDelete.do?mem_id=<%= vo.getMem_id() %>";
				}
				
				var btnUpdate = document.getElementById("btnUpdate");
				btnUpdate.onclick = function(){
					location.href = "<%=request.getContextPath()%>/member/memberUpdateForm.do?mem_id=<%= vo.getMem_id() %>";
				}
			}
		</script>
	</head>
	<body>
		<h2>회원 정보 상세보기</h2>
		<table border="1">
			<tr>
				<td>회원ID</td>
				<td><%= vo.getMem_id() %></td>
			</tr>
			<tr>
				<td>회원이름</td>
				<td><%= vo.getMem_name() %></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><%= vo.getMem_tel() %></td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td><%= vo.getMem_addr() %></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="btnUpdate" value="수정">
					<input type="button" id="btnDelete" value="삭제">
					<input type="button" id="btnList" value="회원목록">
				</td>
			</tr>
		</table>
	</body>
</html>