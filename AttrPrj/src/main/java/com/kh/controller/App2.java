package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app2")
public class App2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//어플리케이션 영역(서블릿컨텍스트)에 접근해서, id가 키 값인 속성 가져오기
		
//		String id = app.setAttribute("id", );
		
		ServletContext app = req.getServletContext();
		String id = (String) app.getAttribute("id");
		System.out.println("app2에서 출력해본 id : "+id);
	}
}
