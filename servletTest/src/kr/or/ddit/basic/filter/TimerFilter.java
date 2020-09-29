package kr.or.ddit.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TimerFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		long startTime = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		HttpServletRequest req = (HttpServletRequest)request;
		long endTime = System.currentTimeMillis();
		
		long timer = endTime - startTime;
		System.out.println(req.getRequestURI() + " : => " + timer);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
