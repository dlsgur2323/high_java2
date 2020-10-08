package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.action.MemberListAction;
import kr.or.ddit.web.IAction;

public class TestController2 extends HttpServlet{
	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		/*
			url ==> http://localhost/servletTest2/member/memberList.do
			uri ==> 				/servletTest2/member/memberList.do
			
			ContextPath ==> /servletTest2
			원하는 요청 URI ==> /member/memberList.do
		
		 */
		
		// 1. 사용자의 요청정보 가져오기
		String uri = req.getRequestURI();
		
		uri = uri.substring(req.getContextPath().length());
		System.out.println("uri : " + uri);
		String viewPage = "/WEB-INF/view"; // view 페이지가 저장될 변수
		IAction action = null;
		
		if(uri == null){
		} else if("/member/memberList.do".equals(uri)){
			action = new MemberListAction();
			viewPage += action.process(req, resp);
		} else if("/member/memberView.do".equals(uri)){
			
		}
		
		// 해당 viewPage로 포워딩
		req.getRequestDispatcher(viewPage).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	public void destroy() {

	}
}
