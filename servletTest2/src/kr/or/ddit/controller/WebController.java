package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.web.IAction;
import kr.or.ddit.web.URIActionMapper;

// 모든 요청을 받아서 처리하는 Servlet
public class WebController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		url ==> http://localhost/servletTest2/member/memberList.do
		uri ==> 				/servletTest2/member/memberList.do
		
		ContextPath ==> /servletTest2
		원하는 요청 URI ==> /member/memberList.do
		
		 */
		
		// 1. 사용자의 요청정보 가져오기
		String uri = request.getRequestURI();
		
		uri = uri.substring(request.getContextPath().length());
//		System.out.println("uri : " + uri);
		String viewPage = ""; // view 페이지가 저장될 변수
		IAction action = null;
		
		action = URIActionMapper.getAction(uri);
		
		if(action == null ){
			response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 에러
		} else {
			viewPage = action.process(request, response);
			if(viewPage != null){
				if(action.isRedirect()){ // 리다이렉트가 true일 경우
					response.sendRedirect(request.getContextPath()+viewPage);
				} else { // forward
					request.getRequestDispatcher("/WEB-INF/view" + viewPage).forward(request, response);
				}
			}
		}
	}
}









