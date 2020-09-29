package kr.or.ddit.basic;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.Cookies;

@WebServlet("/LoginCheckServlet.do")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		String pass = request.getParameter("pass");
		String check = request.getParameter("chkid");
		
		response.setCharacterEncoding("utf-8");
		if(check != null){
			Cookie idcookie = new Cookie("id", userId);
			response.addCookie(idcookie);
		} else {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies){
				String name = cookie.getName(); // 쿠키변수 가져오기
				if(name.equals("id")){// 삭제할 쿠키변수 인지 확인
					Cookie nameCookie = new Cookie("id", "dkanrjsk");
					nameCookie.setMaxAge(0); // 유지시간을 0으로 변경한다.
					response.addCookie(nameCookie);
				}
			}
			
		}
		
		RequestDispatcher rd;
		if(userId.equals("admin") && pass.equals("1234") ||
				userId.equals("dlsgur") && pass.equals("dlsgur")){
			rd = request.getRequestDispatcher("/basic/02/cookieMain.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("/servletTest/basic/02/cookieMain.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
