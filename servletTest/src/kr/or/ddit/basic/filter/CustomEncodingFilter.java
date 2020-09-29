package kr.or.ddit.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomEncodingFilter implements Filter{
	private String enco;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(enco);
		chain.doFilter(request, response);
		response.setCharacterEncoding(enco);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if(filterConfig.getInitParameter("encoding")==null){
			enco = "utf-8";
		} else {
			enco = filterConfig.getInitParameter("encoding");
		}
		
	}

}
