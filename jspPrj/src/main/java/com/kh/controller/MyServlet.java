package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("myServlet called....");
		
		//화면 만들어서 보여주는데, 서블릿은 너무 귀찮다. 
		//그래서!! 서블릿이 jsp에게 시킨다!! : req 이용
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/result.jsp");
		dispatcher.forward(req, resp);
		
		
	}
}
