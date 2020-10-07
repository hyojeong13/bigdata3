package kr.mem.pojo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberMyBatisDAO;
import kr.mem.model.Member_DAO;
import kr.mem.model.Member_VO;

public class MemberList_Controller implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Member_DAO dao = new Member_DAO();
		MemberMyBatisDAO dao = new MemberMyBatisDAO();
		List<Member_VO> list = dao.memberAllList();
		
		request.setAttribute("list", list);
		
		
		return "member/memberList.jsp";
	}


	
	
	
	
	
	
}
