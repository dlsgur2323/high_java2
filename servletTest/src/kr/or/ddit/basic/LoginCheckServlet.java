package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginCheckServlet.do")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		RequestDispatcher rd;
		if(userId.equals("admin") && pass.equals("1234") ||
				userId.equals("dlsgur") && pass.equals("dlsgur")){
			rd = request.getRequestDispatcher("/basic/01/main.jsp");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("/basic/01/login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
