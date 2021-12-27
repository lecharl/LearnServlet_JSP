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

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

//		계산
		if(op != null && !"=".equals(op)) {
//			스크립트 실행하는 방법, 구버전
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp)) ;
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		}else {
			exp += (val == null)? "" : val;
			exp += (op == null)? "" : op;
			exp += (dot == null)? "" : dot;
			
		}
		
		
		Cookie expCookie = new Cookie("exp", exp);
		response.addCookie(expCookie);
	}

}
