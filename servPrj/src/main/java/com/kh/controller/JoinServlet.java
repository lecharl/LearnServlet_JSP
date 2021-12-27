package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class JoinServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String addr = req.getParameter("userAddr");	//null
		
		String id = req.getParameter("userId");
		String pwd = req.getParameter("userPwd");
		String email = req.getParameter("userEmail");
		String[] colors = req.getParameterValues("userColor");
		String gender = req.getParameter("gender");
		String age = req.getParameter("userAge");
		
		System.out.println("아이디 : "+id);
		System.out.println("비밀번호 : "+pwd);
		System.out.println("이메일 : "+email);
		System.out.print("좋아하는 색 : ");
		for (String color : colors) {
			System.out.print(color+", ");
		}
		System.out.println();
//		System.out.println("좋아하는 색 : "+colors);
		System.out.println("성별 : "+gender);
		System.out.println("나이 : "+age);
	}
}
