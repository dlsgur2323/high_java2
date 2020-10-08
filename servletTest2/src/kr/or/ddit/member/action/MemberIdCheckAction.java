package kr.or.ddit.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.web.IAction;

import com.google.gson.Gson;

public class MemberIdCheckAction implements IAction {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8"); // gson 으로 보낼 때 해줘야 함
		response.setContentType("application/json; charset=utf-8"); // gson 으로 보낼 때 해줘야 함
		
		String mem_id = request.getParameter("mem_id");
		
		IMemberService service = MemberServiceImpl.getInstance();
		int cnt = service.getMemberCount(mem_id);
		
		Gson gson = new Gson();
		String result = null;
		
		if(cnt==1){
			result = gson.toJson("Fail");
		} else {
			result = gson.toJson("OK");
		}
		PrintWriter out = response.getWriter();
		out.println(result);
		response.flushBuffer();
		
		return null; // ajax로 호출한 Action은 null 반환
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

}
