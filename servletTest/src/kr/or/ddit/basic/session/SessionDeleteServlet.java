package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDeleteServlet
 */
@WebServlet("/SessionDeleteServlet.do")
public class SessionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session 삭제하기
		
		// 1. Session객체 구하기
		HttpSession session = request.getSession();
		
		// 2. 세션값만 삭제하기 ==> removeAttribute("세션key값")
		// 형식) session객체.removeAttribute("삭제할세션key값")
//		session.removeAttribute("testSession");
		
		// 3. 세션 자체를 삭제하기 ==> invalidate() 메서드 사용
		// 형식 ) session객페.invalidate();
		
		session.invalidate();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>Cookie 연습</title></head>");
		out.println("<body>");
		out.println("<h2>저장된Session 데이터 삭제하기<h2>");
		out.println("<a href='" + request.getContextPath() + "/basic/03/sessionTest.jsp'>시작 문서로 이동</a>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
