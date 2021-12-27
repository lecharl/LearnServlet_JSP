package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app")
public class AppContextServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//ServletContext 영역을 가져와서 application에 대입
		ServletContext application = req.getServletContext();
		
		//그 application 영역에 key, value 세팅
		application.setAttribute("id", "sim");
		
		//key값을 넣어 넣으면 value 얻음
		//반환타입이 Object 이므로 캐스팅
		String x = String.valueOf(application.getAttribute("id"));
		System.out.println("어플리케이션 영역에서 가져온 아이디 : "+x);
	}
}
