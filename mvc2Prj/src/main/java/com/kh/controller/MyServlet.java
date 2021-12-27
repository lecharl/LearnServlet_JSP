package com.kh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.service.MyService;
import com.kh.vo.Member;

@WebServlet("/my")
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller > doGet called...");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		Member member = new Member(id, pwd);
		
		//컨트롤러(my)가 서비스 호출, 서비스에게 비즈니스 로직이나 데이터 넘김
		MyService service = new MyService();
		service.sss(member);
	}

}
