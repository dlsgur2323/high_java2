<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%@ include file="header.jsp"%>
	<%
		BoardVo vo = (BoardVo)request.getAttribute("vo");
	%>
	<style>
		#board_table{
			font-size : 1.1em;
			width : 100%;
			border-top: 1px solid #444444;
  			border-collapse: collapse;
  			margin-bottom : 10px;
		}
		#board_table a{
			text-decoration: none;
		}
		#board_table span{
			width : 445px;
		}
		#board_table tr:nth-child(odd) {
			border-bottom : 1px solid #444444;
			text-align: center;
		}
		#board_table tr:nth-child(1),tr:nth-child(2) {
			height:35px;
		}
		#board_table tr:nth-child(3) td{
			padding : 20px;
			padding-left : 50px;
			padding-right : 50px;
			text-align : left;
		}
		#div_table{
			width : 800px;
			margin : auto;
		}
		#board_table tr:nth-child(1) td:nth-child(2){
			padding-left : 10px;
			text-align: left;
		}
		#div_table_bottom{
			margin : auto;
			width : 200px;
			text-align : center;
		}
		#board_update_table{
			width : 440px;
			margin-left : 50px;
		}
		#board_update_table td{
			padding-top : 10px;
		}
		#board_update_table td:nth-child(2){
			padding-left : 10px;
		}
	</style>
	<script>
		$(function(){
			$("#board_page_go_list").on("click", function(){
				location.href="<%=request.getContextPath()%>/BoardList.do";
			})
			$("#board_page_update_btn").on("click", function(){
				cont = "<%=vo.getBoard_content().replaceAll("\n", "<br>").replaceAll("\r", "")%>";
				$("#board_update_title").val("<%=vo.getBoard_title()%>");
				$("#board_update_writer").val("<%=vo.getBoard_writer()%>");
				$("#board_update_content").val(cont.replace(/<br>/g, "\n"));
				$("#board_update_modal").modal("show");
			})
			
		})
	</script>
		<div id="wrapper">
			<div id="div_table">
				<table id="board_table">
					<tr>
						<td style="width:10%; text-align:left;">No : <%= vo.getBoard_no()%></td>
						<td colspan="2">제목 : <%= vo.getBoard_title()%></td>
						<td style="width:15%; text-align:right;">조회수 : <%= vo.getBoard_cnt()%></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:left;">작성자 : <%= vo.getBoard_writer()%></td>
						<td colspan="2" style="text-align:right;"><%= vo.getBoard_date()%></td>
					</tr>
					<tr>
						<td colspan="4"><%= vo.getBoard_content().replaceAll("\n", "<br>")%></td>
					</tr>
				</table>
				<div id="div_table_bottom">
					<input type="button" id="board_page_update_btn" value="수정">
					<input type="button" id="board_page_delete_btn" onclick="location.href='<%=request.getContextPath()%>/BoardDelete.do?board_no=<%= vo.getBoard_no() %>'" value="삭제">
					<input type="button" id="board_page_go_list" value="목록">
				</div>
			</div>
			<%@ include file="footer.jsp"%>
		</div>
		
		<!-- --------------------- 수정 모달창 ----------------------- -->
		<div id="board_update_modal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">글 수정</h4>
					</div>
					<form id="board_update_form" action="<%=request.getContextPath()%>/BoardUpdate.do" method="post">
						<div class="modal-body">
								<input type="hidden" name="no" value="<%=vo.getBoard_no() %>">
								<table id="board_update_table">
									<tr>
										<td>제목</td>
										<td><input type="text" id="board_update_title" name="title" size="50"></td>
									</tr>
									<tr>
										<td>작성자</td>
										<td><input type="text" id="board_update_writer" name="writer" size="50"></td>
									</tr>
									<tr>
										<td>내용</td>
										<td><textarea id="board_update_content" name="content" cols="52" rows="10"></textarea></td>
									</tr>
								</table>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-default" id="board_update_btn">저장</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
	</body>
</html>















