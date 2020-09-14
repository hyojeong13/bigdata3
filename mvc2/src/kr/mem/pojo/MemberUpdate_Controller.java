package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.Member_DAO;
import kr.mem.model.Member_VO;

public class MemberUpdate_Controller implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page=null;
		//3개 가져오기
		String cpath = request.getContextPath();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		
		Member_VO vo = new Member_VO();
		//묶어주기
		vo.setNum(num);
		vo.setPhone(phone);
		vo.setAddr(addr);
		
		Member_DAO dao = new Member_DAO();
		int cnt = dao.MemberUpdate(vo);
		
		if (cnt > 0) {
			page = "redirect:"+cpath+"/list.do";
			//page = "redirect:/mvc1/list.do";
		} else {
			throw new ServletException("error");
		}
		
		return page;
	}

}
