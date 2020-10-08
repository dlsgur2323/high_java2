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
				
				var btnDelete = document.getElementById("btnCancel");
				btnDelete.onclick = function(){
					location.href = "<%=request.getContextPath()%>/member/memberView.do?mem_id=<%= vo.getMem_id() %>";
				}
				
			}
		</script>
	</head>
	<body>
		<h2>회원 정보 상세보기</h2>
		<form action="<%=request.getContextPath()%>/member/memberUpdate.do" method="post">
			<table border="1">
				<tr>
					<td>회원ID</td>
					<td><input type="text" name="mem_id" value="<%= vo.getMem_id() %>" readonly></td>
				</tr>
				<tr>
					<td>회원이름</td>
					<td><input type="text" name="mem_name" value="<%= vo.getMem_name() %>"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="mem_tel" value="<%= vo.getMem_tel() %>"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" name="mem_addr" value="<%= vo.getMem_addr() %>"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="저장">
						<input type="button" id="btnCancel" value="취소">
						<input type="button" id="btnList" value="회원목록">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>