package com.newlec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//application : 서블릿들을 모아놓은 공간 ServletContext
		ServletContext application = request.getServletContext();
		//session
		HttpSession session = request.getSession();
		//cookie, 여러 개일 수도 있으므로 배열이다!!
		Cookie[] cookies = request.getCookies();

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String v0 = request.getParameter("v");
//		String[] op = request.getParameterValues("op");
		String op = request.getParameter("op");		
		
		int v = 0;
		if(v0 != null && !"".equals(v0))
			v = Integer.valueOf(v0);
		
	 	if(op.equals("=")) {
			//계산
			//application 저장했으니 꺼내서 써야지
//			int x = (Integer) application.getAttribute("value");
	 		//session
//			int x = (Integer) session.getAttribute("value");
	 		
			//cookie
	 		int x = 0;
	 		for(Cookie c : cookies) {
	 			//쿠키("key")가 서로 일치하면
	 			if("value".equals(c.getName())) {
	 				x = Integer.valueOf(c.getValue());
	 				//찾으면 for문 나가기
	 				break;
	 			}
	 		}
			
			int y = v;
//			String operator = (String) application.getAttribute("op");
			//session
//			String operator = (String) session.getAttribute("op");
			
			//cookie
			String operator = "";
			for(Cookie c : cookies) {
				if("op".equals(c.getName())) {
					operator = c.getValue();
					break;
				}
			}
			
			
			int result = 0;
			
			if("+".equals(operator))
				result = x + y;
			else if("-".equals(operator))
				result = x - y;
			else if("*".equals(operator))
				result = x * y;
			else
				result = x / y;
			
			PrintWriter out = response.getWriter();
			out.println(result);
			
		}else {
			//저장(applicaion에)
//			application.setAttribute("value", v);
//			application.setAttribute("op", op);
			
			//저장(session에)
//			session.setAttribute("value", v);
//			session.setAttribute("op", op);
			
			//쿠키 심기, 쿠키는 무조건 문자열이므로 형변환
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			
			//path 옵션
			//모든 경로를 요청할 때마다 이 valueCookie를 가져온다.
//			valueCookie.setPath("/");
//			opCookie.setPath("/");
			// /calc2가 포함된 하위 url을 요청할 때
			valueCookie.setPath("/calc2");
			//24*60*60 == 하루
			valueCookie.setMaxAge(60 * 60);
			opCookie.setPath("/calc2");
			
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			//**다른 페이지로 전환하기
			response.sendRedirect("/calc2.html"); 
		}
	}

}
