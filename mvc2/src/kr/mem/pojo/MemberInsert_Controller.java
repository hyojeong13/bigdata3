package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.Member_DAO;
import kr.mem.model.Member_VO;

public class MemberInsert_Controller implements Controller{

	
	
	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpath = request.getContextPath();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		
		Member_VO vo = new Member_VO();
		vo.setName(name);
		vo.setPhone(phone);
		vo.setAddr(addr);
		
		Member_DAO dao = new Member_DAO();
		int cnt = dao.MemInsert(vo);
		
		String page=null;
		
		if (cnt>0) {
			//성공하면 list 창을 다시 보여줘야함.
			//front에서
			//sendRedirect 를 사용하는 경우. no 포워딩.
			// :을 기준으로 쪼개서 뒤만 사용.
			// redirect가 있으면, rediriect를 사용하기 위해.
			page= "redirect:"+cpath+"/list.do";
			
		}else {
			throw new ServletException("error");
		}
		
		return page;
	}

	
	
	
	
	
}
