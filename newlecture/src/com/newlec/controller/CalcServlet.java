package com.newlec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		
		String x0 = request.getParameter("x");
		String y0 = request.getParameter("y");
		String op = request.getParameter("op");
		
		int x = 0;
		int y = 0;
		int result = 0;
		
		if(x0 != null && !"".equals(x0))
			x = Integer.valueOf(x0);
		if(!(y0 == null || "".equals(y0)))
			y = Integer.valueOf(y0);
		
		if("덧셈".equals(op)) {
			result = x+y;
		} else if("뺄셈".equals(op)) {
			result = x-y;
		} else if("곱셈".equals(op)) {
			result = x * y;
		} else {
			result = x / y;
		}
		
		PrintWriter out = response.getWriter();
		out.println(result);
	}

}
