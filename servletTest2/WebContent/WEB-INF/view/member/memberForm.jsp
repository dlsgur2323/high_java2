<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="<%=request.getContextPath()%>/js/jquery-3.5.1.js"></script>
		<script>
			$(function(){
				
				var btnList = document.getElementById("btnList");
				btnList.onclick = function(){
					location.href = "<%=request.getContextPath()%>/member/memberList.do";
				}
				
				var chkMemId = ""; // 중복확인 된 아이디를 저장할 변수
				
				$("#idCheck").on("click", function(){
					var memId = $("#mem_id").val();
					if(memId == ""){
						alert("회원 아이디를 입력하세요");
						$("#mem_id").focus();
					} 					
					$.ajax({
						url : "<%=request.getContextPath()%>/member/memberIdCheck.do",
						data : {"mem_id" : memId},
						type : "post",
						dataType : "json", 
						success : function(res){
							if(res == "OK"){
								$("#idChkResult").html("사용가능ID");
								chkMemId = memId;
							} else {
								$("#idChkResult").html("ID중복");
								chkMEmId = "";
							}
						},
						error : function(req){
							alert(req.status);
						},
					})
				})
				
				$("form").on("submit",function(){
					var memId = $("#mem_id").val();
					var idchk = $("#idChkResult").html().trim();
					if(idchk!="사용가능ID" || chkMemId!=memId){
						alert("ID가 중복됩니다. 새로운 ID를 입력하세요");
						return false; // 서버로의 전송을 취소한다.
					}
					return true;	// 서버로 전송작업을 수행한다.
				})
				
			})
				
		</script>
	</head>
	<body>
		<h2>회원 정보 입력 폼</h2>
		<form action="<%=request.getContextPath()%>/member/memberJoin.do" method="post">
			<table border="1">
				<tr>
					<td>회원ID</td>
					<td>
						<input type="text" name="mem_id" id="mem_id">
						<input type="button" id="idCheck" value="중복확인"><br>
						<span id="idChkResult"></span>
					</td>
					
				</tr>
				<tr>
					<td>회원이름</td>
					<td><input type="text" name="mem_name"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="tel" name="mem_tel"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" name="mem_addr" size="50"></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" id="btnSave" value="저장">
					<input type="reset" id="btnCancel" value="취소">
					<input type="button" id="btnList" value="회원목록">
					</td>
				</tr>			
			</table>
		</form>
	</body>
</html>