package com.newlec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		req.setCharacterEncoding("UTF-8");
		
//		int x = Integer.valueOf(req.getParameter("x"));
//		int y = Integer.valueOf(req.getParameter("y"));
		
		String x0 = req.getParameter("x");
		String y0 = req.getParameter("y");
		
		int x = 0;
		int y = 0;
		
		if(x0 != null && !"".equals(x0))
			x = Integer.valueOf(x0);
		if(!(y0 == null || "".equals(y0)))
			y = Integer.valueOf(y0);
		
//		int result = x + y;
//		out.println(result);
		PrintWriter out = resp.getWriter();
		out.println(x + y);
		
	}
}
