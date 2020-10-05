package kr.or.ddit.basic.wrapper;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

// RequestWrapper클래스를 등록하는 Filter

public class RequestWrapperFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// RequestWrapper 객체 생성
		RequestWrapperTest requestWrapper = new RequestWrapperTest((HttpServletRequest)request);
		// 만약 ResponseWrapper도 등록하려면 이곳에서 같이 생성한다.
		
//		chain.doFilter(request, response); 대신에
		chain.doFilter(requestWrapper, response); // 로 만든다.
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
