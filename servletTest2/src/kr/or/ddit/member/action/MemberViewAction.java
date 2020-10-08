package kr.or.ddit.member.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.web.IAction;

public class MemberViewAction implements IAction {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String viewPage = null;
		
		String mem_id = request.getParameter("mem_id");
		
		IMemberService service = MemberServiceImpl.getInstance();
		MemberVO vo = service.getMember(mem_id);
		
		request.setAttribute("memberVo", vo);
		
		return "/member/memberView.jsp";
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

}
