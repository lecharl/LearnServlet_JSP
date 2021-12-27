package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionGet")
public class SessionGet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//session에서 키값이 data인 애 가져오기
		//가져온 값 출력하기
		HttpSession session = req.getSession();
		String data = (String)session.getAttribute("data");
		System.out.println("sessionGet에서 가져온 data : "+ data);
	}
}
