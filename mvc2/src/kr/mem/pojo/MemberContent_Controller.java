package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.Member_DAO;
import kr.mem.model.Member_VO;

public class MemberContent_Controller implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		Member_DAO dao = new Member_DAO();
		Member_VO vo = dao.memberContent(num);
		
		//memberContent.jsp
		//°´Ã¼ ¹ÙÀÎµù
		request.setAttribute("vo", vo);
		
		return "member/memberContent.jsp";
	}

	
}
