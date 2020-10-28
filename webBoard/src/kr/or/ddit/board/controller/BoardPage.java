package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVo;

@WebServlet("/BoardPage.do")
public class BoardPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String update = request.getParameter("update");
		IBoardService service = BoardServiceImpl.getInstance();
		if(update == null){
			service.updateCnt(board_no);
		}
		BoardVo vo = new BoardVo();
		vo = service.getOneBoard(board_no);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/boardPage.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
