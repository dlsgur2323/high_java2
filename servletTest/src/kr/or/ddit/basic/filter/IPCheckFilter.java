package kr.or.ddit.basic.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IPCheckFilter implements Filter{
	private Map<String, String> ipMap;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String ip = request.getRemoteAddr(); // 접속한 IP주소
		System.out.println("접속IP : " + ip);
		if(ip != null & ipMap.containsKey(ip)) {// 목록에서 찾기
			
			if("T".equals(ipMap.get(ip))){
				chain.doFilter(request, response); 
			} else {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter(); 
				out.println("<h2>접근이 거부된 IP입니다.<br>");
				out.println("관리자에게 문의하세요<h2>");
			}
			
		} else { // 목록에 없으면 
			HttpServletResponse res = (HttpServletResponse) response;
			HttpServletRequest req = (HttpServletRequest) request;
			
			res.sendRedirect(req.getContextPath()+"/basic/01/doBasicServlet.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// 허용 또는 불허되는 IP주소 정보를 구성한다.
		ipMap = new HashMap<>();
		ipMap.put("127.0.0.1", "T");
		ipMap.put("0:0:0:0:0:0:0:1", "T");
		ipMap.put("192.168.43.40", "T");
		ipMap.put("192.168.43.53", "T");
		
		
	}

}











