<%@page import="kr.or.ddit.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>webBoard</title>
		<script src="<%=request.getContextPath()%>/js/jquery-3.5.1.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		<style>
			html {
				height: 100%;
			}
			body {
				height: 100%;
			}
			#header {
				width : 100%;
				height : 200px;
				margin : 0px;
				background : black;
			}
			#header h1 {
				color : white;
				margin : 0px;
				text-align: center;
 				font-size : 4em;
 				font-family: inherit;
			    font-weight: bold;
				line-height : 200px;
			}
			#nav {
				height : 50px;
				border-bottom : 1px solid #444444;
				margin-bottom : 20px;
			}
			#wrapper {
			min-height:90%;
			position : relative;
 			padding-bottom : 150px; 
			}
		</style>
		
	</head>
	<body>
		<header>
			<div id="header">
				<h1 style="cursor:pointer;" onclick="location.href='<%=request.getContextPath()%>/BoardList.do'">webBoard</h1>
			</div>
		</header>
		<nav>
			<div id="nav">
			</div>
		</nav>
</html>