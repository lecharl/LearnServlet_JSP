package com.newlec.controller;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {

//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		//get 요청이 왔을 때
//		if("GET".equals(request.getMethod())){
//			System.out.println("get 요청 옴");
//		//post 요청이 왔을 때
//		} else if("POST".equals(request.getMethod())) {
//			System.out.println("post 요청 옴");
//		}
//		
//		//아래처럼 부모의 service()를 호출한다면, 밖에 따로 doPost()/doGet()를 오버라이드를 해야 한다.
//		super.service(request, response);
//	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메소드 호출");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			
			Cookie[] cookies = request.getCookies();

			String val = request.getParameter("val");
			String op = request.getParameter("op");
			String dot = request.getParameter("dot");
			
			String exp = "";
			if(cookies != null) {
				for(Cookie c : cookies) {
					if("exp".equals(c.getName())) {
						exp = c.getValue();
						break;
					}
				}
			}

//			계산
			if(op != null && !"=".equals(op)) {
//				스크립트 실행하는 방법, 구버전
				ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
				try {
					exp = String.valueOf(engine.eval(exp)) ;
				} catch (ScriptException e) {
					e.printStackTrace();
				}
//			쿠키 삭제
			}else if(op != null && !"C".equals(op)){
				exp = "";
			}else {
				exp += (val == null)? "" : val;
				exp += (op == null)? "" : op;
				exp += (dot == null)? "" : dot;
				
			}
			
			
			Cookie expCookie = new Cookie("exp", exp);
			if(op != null && !"C".equals(op))
				expCookie.setMaxAge(0);
			expCookie.setPath("/calculator");
			response.addCookie(expCookie);
			response.sendRedirect("calcpage");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드 호출");
	}
}
