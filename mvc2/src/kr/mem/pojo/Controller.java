package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	// front Cotroller�� �ؾ��� ���� POJO���� ������ִ� �޼ҵ�
	//request�� response�� �Ķ���ͷ� ��
	public String requestHandle(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException ;
		

	
}
