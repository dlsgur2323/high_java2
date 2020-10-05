package kr.or.ddit.basic.wrapper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WrapperTestServlet.do")
public class WrapperTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String remoteIp = request.getRemoteAddr();
		
		System.out.println("접속한 컴퓨터의 IP주소 : " + remoteIp);
		
		String memId = request.getParameter("mem_id");
		String memName = request.getParameter("mem_name");
		String memPass = request.getParameter("mem_pass");
		
		System.out.println("ID : " + memId);
		System.out.println("Name : " + memName);
		System.out.println("Pass : " + memPass);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
