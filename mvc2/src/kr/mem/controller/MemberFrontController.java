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
		
		//1. � ��û���� �ľ��ϴ� �۾� -> *.do
		
		// WEB-INF -> web.xml���ٰ� ����,
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
		
		//Ŭ���̾�Ʈ�� ��û�� ���
		String command = reqUrl.substring(ctxPath.length());
		System.out.println(command);
		
	
		Controller controller = null;
		String nextView = null;
		
		//�ڵ鷯 ����
		//�� ��û�� ���� ó���ϱ�
//		if (command.equals("/list.do")) {
//			controller = new MemberList_Controller();
//			//�������̽�.
//			//setAttribute�� �ϸ� ������?
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
		
		//View �������� �����ϴ� �κ�
		if (nextView != null) {
			//�ϴ� null�� �ƴϾ����
			if (nextView.indexOf("redirect:")!=-1) { //redirect�� ������ ��.
				String[] sp= nextView.split(":");
				response.sendRedirect(sp[1]);
				
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/"+nextView);
				rd.forward(request, response);
			}
			
		}
		
		
		
	}

}
