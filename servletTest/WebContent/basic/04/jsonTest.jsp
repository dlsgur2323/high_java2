<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
		<script>
			$(function(){
				// 응답 데이터 문자열
// 				$("button").on("click", function(){
// 					$.ajax({
<%-- 						"url" : "<%= request.getContextPath() %>/JSONTestServlet.do", --%>
// 						"type" : "post",
// 						"success" : function(data){
// 							$("#result").html("ajax 처리 데이터  : " + data)
// 						},
// 						"dataType" : "json"
// 					})
// 				})
//					응답 데이터 배열
// 				$("button").on("click", function(){
// 					$.ajax({
<%-- 						"url" : "<%= request.getContextPath() %>/JSONTestServlet.do", --%>
// 						"type" : "post",
// 						"success" : function(data){
// 							var str = "";
// 							$.each(data, function(i,v){
// 								str += i + "번째 자료 : " + v + "<br>";
// 							});
// 							$("#result").html(str)
// 						},
// 						"dataType" : "json"
// 					})
// 				})
//					응답 데이터 객체
// 				$("button").on("click", function(){
// 					$.ajax({
<%-- 						"url" : "<%= request.getContextPath() %>/JSONTestServlet.do", --%>
// 						"type" : "post",
// 						"success" : function(data){
// 							var str = "";
// 							str += "ID : " + data.id +"<br>";
// 							str += "이름 : " + data.name +"<br>";
							
// 							$("#result").html(str)
// 						},
// 						"dataType" : "json"
// 					})
// 				})
//					응답 데이터 컬렉션(List)
				$("button").on("click", function(){
					$.ajax({
						"url" : "<%= request.getContextPath() %>/JSONTestServlet.do",
						"type" : "post",
						"success" : function(data){
							var str = "";
							$.each(data, function(i,v){
								str += i + "번째 자료<br>"
								str += "ID : " + v.id +"<br>";
								str += "이름 : " + v.name +"<br>";
							});
							$("#result").html(str);
						},
						"dataType" : "json"
					})
				})
				
			})
		</script>
	</head>	
	<body>
		<button>JSON 데이터 가져오기</button>
		<hr>
		<h3>가져온 데이터</h3>
		<div id="result"></div>
	</body>
</html>