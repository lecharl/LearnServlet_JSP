package com.newlec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class AddServlet2 extends HttpServlet {	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		req.setCharacterEncoding("UTF-8");
		
		String[] numArr = req.getParameterValues("num");
		
		int result = 0;
		
		for(String num : numArr) {
			if(num != null && !"".equals(num))
				result += Integer.valueOf(num);
		}
		
		PrintWriter out = resp.getWriter();
		out.println(result);
		
	}
}
