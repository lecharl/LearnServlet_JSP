package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("myServlet service called ...");
		
		//ajax에서 전달받은 데이터를 처리할 수 있다.
		//1. 사용자로부터 전달받은 데이터 꺼내기
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String addr = req.getParameter("addr");
		//2. 꺼낸 데이터 출력하기
		System.out.println("name : "+name);
		System.out.println("age : "+age);
		System.out.println("addr : "+addr);
		
		//응답을 보내줄 수 있음
		resp.setContentType("text/html; charset=UTF-8");
//		resp.getWriter().print("data from server");
		
		if(Integer.parseInt(age) >= 20) {
			resp.getWriter().print("adult");
		} else {
			resp.getWriter().print("KID");
			
		}
	}
}
