package kr.or.ddit.basic.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 방식으로 요청하면 세션을 확인해서 없으면 로그인 페이지로 이동
		// 세션에 값이 있으면 result로 이동
		HttpSession session = request.getSession();
		if(session.getAttribute("id")==null){
			response.sendRedirect("/servletTest/basic/03/sessionLogin.jsp");
		} else {
			response.sendRedirect("/servletTest/basic/03/sessionLoginResult.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		RequestDispatcher rd;
		if(userId.equals("admin") && pass.equals("1234") ||
				userId.equals("dlsgur") && pass.equals("dlsgur")){
			HttpSession session = request.getSession();
			session.setAttribute("id", userId);
			session.setAttribute("pass", pass);
		}
		rd = request.getRequestDispatcher("/basic/03/sessionLoginResult.jsp");
		rd.forward(request, response);
	}

}
