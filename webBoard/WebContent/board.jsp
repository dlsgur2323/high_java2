<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%@ include file="header.jsp"%>
	<%
		List<BoardVo> list = (List<BoardVo>)request.getAttribute("list");
	%>
	<script>
		$(function(){
			$("#board_write_btn").on("click", function(){
				$("#board_write_modal").modal("show");
			})
			$("boad_write_insert_btn").on("click", function(){
				location.href="<%=request.getContextPath()%>/BoardInsert.do";
			})
			$("#board_write_modal").on("hidden.bs.modal", function(){
				$("#board_write_table input").val("");
				$("#board_write_table textarea").val("");
			});
			
		})
	</script>
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
		#board_table th, #board_table td {
			border-bottom : 1px solid #444444;
			text-align: center;
		}
		#div_table{
			width : 800px;
			margin : auto;
		}
		#board_table th:nth-child(2){
			width : 496px;
		}
		#board_table td:nth-child(2){
			padding-left : 40px;
			text-align: left;
		}
		#div_board_bottom #div_board_bottom_search {
			float : left;
			width : 80%;
		}
		#div_board_bottom #div_board_bottom_search select{
			margin-left : 15%;
			font-size : 1.0em;
			vertical-align : middle;
			height : 24px;
		}
		#div_board_bottom #div_board_bottom_search #board_search_bar{
			height : 24px;
			vertical-align : middle;
		}
		#div_board_bottom #div_board_bottom_search #board_search_btn{
			vertical-align : middle;
		}
		#div_board_bottom #div_board_bottom_write {
			float : left;
			width : 20%;
		}
		#div_board_bottom #div_board_bottom_write #board_write_btn{
			margin-left : 40%;
		}
		#board_write_table{
			width : 440px;
			margin-left : 50px;
		}
		#board_write_table td{
			padding-top : 10px;
		}
		#board_write_table td:nth-child(2){
			padding-left : 10px;
		}
		
	</style>
	
		<div id="wrapper">
			<div id="div_table">
				<table id="board_table">
					<tr>
						<th>No</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
					<tr>
					<%
						for(int i=0;i<list.size();i++){
					%>
							<tr>
								<td><%= list.get(i).getBoard_no()%></td>
								<td style="cursor:pointer;" onclick="location.href='<%=request.getContextPath()%>/BoardPage.do?board_no=<%= list.get(i).getBoard_no()%>'"><%= list.get(i).getBoard_title()%></td>
								<td><%= list.get(i).getBoard_writer()%></td>
								<td><%= list.get(i).getBoard_cnt()%></td>
							</tr>
					<%
						}
					%>
				</table>
						<%
							String search_title = (String)request.getAttribute("search_title");
							String title = "";
							if(search_title != null){
								title = search_title;
							}
						%>
				<div id="div_board_bottom">
					<div id="div_board_bottom_search">
						<form id="board_search_form" action="<%=request.getContextPath()%>/BoardList.do">
						<select>
							<option value="title" selected>제목</option>
						</select>
							<input type="text" id="board_search_bar" name="search_title" size="40" value="<%=title %>">
							<input type="submit" id="board_search_btn" value="검색">
						</form>
					</div>
					<div id="div_board_bottom_write">
						<input type="button" id="board_write_btn" value="글쓰기">
					</div>
				</div>
			</div>
			<%@ include file="footer.jsp"%>
		</div>

<!-------------------------  글쓰기 모달   ------------------------------- -->

		<div id="board_write_modal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">글쓰기</h4>
					</div>
					<form id="board_write_form" action="<%=request.getContextPath()%>/BoardInsert.do" method="post">
						<div class="modal-body">
								<table id="board_write_table">
									<tr>
										<td>제목</td>
										<td><input type="text" id="board_write_title" name="title" size="50"></td>
									</tr>
									<tr>
										<td>작성자</td>
										<td><input type="text" id="board_write_writer" name="writer" size="50"></td>
									</tr>
									<tr>
										<td>내용</td>
										<td><textarea id="board_write_content" name="content" cols="52" rows="10"></textarea></td>
									</tr>
								</table>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-default" id="board_write_insert_btn">저장</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>










