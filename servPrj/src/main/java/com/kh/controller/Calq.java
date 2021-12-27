package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calq")
public class Calq extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
//		String num1_ = req.getParameter("num1");
//		String num2_ = req.getParameter("num2");
		String[] nums = req.getParameterValues("num");
		
//		int num1 = Integer.parseInt(num1_);
//		int num2 = Integer.parseInt(num2_);
		
		
		String op = req.getParameter("oper");
		int result = 0;
		
//		if("+".equals(op)) {
//			for (int i = 0; i < nums.length; i++) {
//				result += Integer.parseInt(nums[i]);
//			}
//		}
//		out.println("<h1>"+result+"</h1>");
		
		//계산기
		if("+".equals(op)) {
			result = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
//			out.println("<h1>"+result+"</h1>");
		} else {
			result = Integer.parseInt(nums[0]) - Integer.parseInt(nums[1]);
		}
//		out.println("<h1>"+result+"</h1>");
		out.println("<h1>"+Math.abs(result)+"</h1>");
		
	}
}
