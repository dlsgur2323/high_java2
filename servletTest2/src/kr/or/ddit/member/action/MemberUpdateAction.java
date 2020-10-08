package kr.or.ddit.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.web.IAction;

public class MemberUpdateAction implements IAction {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 
		request.setCharacterEncoding("utf-8");
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(request.getParameter("mem_id"));
		memVo.setMem_name(request.getParameter("mem_name"));
		memVo.setMem_tel(request.getParameter("mem_tel"));
		memVo.setMem_addr(request.getParameter("mem_addr"));
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		service.updateMember(memVo);
		
		return "/member/memberList.do";
	}

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

}
