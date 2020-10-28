package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVo;

@WebServlet("/BoardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int board_no = Integer.parseInt(request.getParameter("no"));
		String board_title = request.getParameter("title");
		String board_writer = request.getParameter("writer");
		String board_content = request.getParameter("content");
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_no(board_no);
		boardVo.setBoard_title(board_title);
		boardVo.setBoard_writer(board_writer);
		boardVo.setBoard_content(board_content);
		
		IBoardService service = BoardServiceImpl.getInstance();
		service.updateBoard(boardVo);
		
		response.sendRedirect(request.getContextPath()+"/BoardPage.do?board_no="+board_no+"&update=true");
		
	}

}
