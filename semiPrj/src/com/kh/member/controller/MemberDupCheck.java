package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

@WebServlet("/memberDupCheck")
public class MemberDupCheck extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ajax 요청 들어옴!!");
		String id = req.getParameter("id");
		System.out.println("아이디 : "+ id);
				
		//입력받은 아이디를 DB의 데이터랑 비교해서, 중복이 있는지 확인, 결과 반환
		//result : 중복 개수
		int result = new MemberService().dupCheck(id);
		
		if(result>0) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("사용불가");
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("사용가능");
		}
		
		/*
		 * if("admin".equals(id)) { //위에거 갖다 쓴 거
		 * resp.setContentType("text/html; charset=UTF-8");
		 * resp.getWriter().print("관리자입니다."); }else {
		 * resp.setContentType("text/html; charset=UTF-8");
		 * resp.getWriter().print("관리자가 아닙니다.");
		 * 
		 * }
		 */
	}
}
