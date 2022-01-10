package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/test")
public class MyServlet extends HttpServlet {
	
	//서블릿의 생명주기(life cycle)
	@Override
	public void init() throws ServletException {
//		클래스파일을 톰캣으로 읽어올 때의 서블릿 생명주기 시작점
//		새로고침해도 다시 안나옴
		System.out.println("init called ...");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doGet이든 doPost든 상관없이 처리해야 할 때
//		서비스가 기본적으로 받아옴
//		그후 doGet, doPost
		System.out.println("service called ...");
//		아래를 해야 doGet()이 호출된다!!!
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet called...");
//		***서블릿에서 jsp로 req, resp 객체를 넘겨줄때 ReuestDispatcher가 필요하다.!!!!
//		리퀘스트에서 인코딩
		request.setCharacterEncoding("UTF-8");
//		리스폰스에서 인코딩
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write("zzzz한글!~!~!~!~!");
		RequestDispatcher x = request.getRequestDispatcher("/index.jsp");
		x.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	@Override
	public void destroy() {
//		서블릿이 파괴될 때 : 톰캣 종료
		System.out.println("destroy..");
	}

}
