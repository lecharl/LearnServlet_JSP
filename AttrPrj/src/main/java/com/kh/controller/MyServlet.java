package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myServlet")
public class MyServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("testzzz");
		
		//getParameter
		String id = req.getParameter("id");
		System.out.println(id);
		
		//attribute
		req.setAttribute("id", id);
		
		//보내버린다.
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/attrTest.jsp");
		dispatcher.forward(req, resp);
	}
}
