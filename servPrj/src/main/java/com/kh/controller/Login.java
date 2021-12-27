package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//"login"요청이 왔을 때 아래를 실행하라.
@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	//req : 리퀘스트, 클라이언트가 서버에게 요청한 것
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		System.out.println("id : "+id + ", password : "+pwd);
		
		
		//out : 화면과 연결되어 있는 스트림?
	 	PrintWriter out = resp.getWriter();
	 	//기본 인코딩 방식 : ISO-8859-1 이라서 한글은 깨진다.
	 	out.println("<h1>서버에서 만든 글씨~!~!</h1>");	
	 	//맨위에 인코딩 방식을 바꿔야 한다.
	 	
	 	//관리자인지 아닌지 판단
	 	//id가 admin으로 들어오면 "관리자입니다"
	 	//아니면 "일반유저입니다."
	 	if(id.equals("admin")) {
	 		out.println("<p style=\"color: red\">관리자입니다~~~</p>");
	 	} else {
	 		out.println("<p>일반유저입니다.</p>");
	 	}
	 	
	 	out.flush();
	}
}
