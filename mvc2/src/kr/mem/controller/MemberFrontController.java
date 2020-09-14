package kr.mem.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.Member_DAO;
import kr.mem.model.Member_VO;
import kr.mem.pojo.Controller;
import kr.mem.pojo.MemberDelete_Controller;
import kr.mem.pojo.MemberInsertForm_Controller;
import kr.mem.pojo.MemberInsert_Controller;
import kr.mem.pojo.MemberList_Controller;


public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		
		//1. 어떤 요청인지 파악하는 작업 -> *.do
		
		// WEB-INF -> web.xml에다가 쓰고,
//		  <servlet>
//		  <servlet-name>MemberFrontController</servlet-name>
//		  	<servlet-class>kr.mem.controller.MemberFrontController</servlet-class>
//		  </servlet>
//		  
//		  <servlet-mapping>
//		  	<servlet-name>MemberFrontController</servlet-name>
//		  	<url-pattern>*.do</url-pattern>
//		  </servlet-mapping>
		
		
		String reqUrl = request.getRequestURI();
		//System.out.println(reqUrl);
		
		
		String ctxPath = request.getContextPath();
		//System.out.println(ctxPath);
		
		//클아이언트가 요청한 명령
		String command = reqUrl.substring(ctxPath.length());
		System.out.println(command);
		
	
		Controller controller = null;
		String nextView = null;
		
		//핸들러 매핑
		//각 요청에 따라 처리하기
//		if (command.equals("/list.do")) {
//			controller = new MemberList_Controller();
//			//인터페이스.
//			//setAttribute를 하면 포워딩?
//			nextView = controller.requestHandle(request, response);
//			
//		}else if(command.equals("/insert.do")) {
//			controller = new MemberInsert_Controller();
//			nextView = controller.requestHandle(request, response);
//			
//		}else if(command.equals("/insertForm.do")) {
//			controller = new MemberInsertForm_Controller();
//			nextView = controller.requestHandle(request, response);
//				
//		}else if(command.equals("/delete.do")) {
//			controller = new MemberDelete_Controller();
//			nextView = controller.requestHandle(request, response);
//		}
		
		HandlerMapping mappings = new HandlerMapping();
		
		controller = mappings.getController(command);
		nextView = controller.requestHandle(request, response);
		
		//View 페이지로 연동하는 부분
		if (nextView != null) {
			//일단 null이 아니어야함
			if (nextView.indexOf("redirect:")!=-1) { //redirect의 유무를 봄.
				String[] sp= nextView.split(":");
				response.sendRedirect(sp[1]);
				
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/"+nextView);
				rd.forward(request, response);
			}
			
		}
		
		
		
	}

}
