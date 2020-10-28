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

@WebServlet("/BoardInsert.do")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String board_title = request.getParameter("title");
		String board_writer = request.getParameter("writer");
		String board_content = request.getParameter("content");
		BoardVo vo = new BoardVo();
		vo.setBoard_title(board_title);
		vo.setBoard_writer(board_writer);
		vo.setBoard_content(board_content);
		
		IBoardService service = BoardServiceImpl.getInstance();
		service.insertBoard(vo);
		
		response.sendRedirect(request.getContextPath()+"/BoardList.do");
		
	}

}
