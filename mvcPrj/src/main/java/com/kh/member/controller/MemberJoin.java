package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberJoin")
public class MemberJoin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost called ~~");
		
//		String userId = req.getParameter("userId");
//		System.out.println("id : "+ userId);

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userAge = request.getParameter("userAge");
		
		String model = "";
		if(Integer.parseInt(userAge) >= 20){
			model = "성인";
		}else{
			model = "미성년";
		}
		
		
		
		
		//회원가입 완료 되었으면
		//초기화면으로 보내주기
//		resp.sendRedirect("/mvc/index.jsp");
		//포워딩 : req가 오면 서버 -> 서블릿 -> 다른 서블릿 -> 클라
		//리다이렉트 : req가 오면 서버 -> 서블릿 -> 클라에게 "클라가 다시 요청하라고" resp -> 클라의 **새로운 req, 여기엔 데이터가 없다**
		
		
		//MVC1?
		
		request.setAttribute("userId", userId);
		request.setAttribute("userPwd", userPwd);
		request.setAttribute("userName", userName);
		request.setAttribute("userAge", userAge);
		request.setAttribute("model", model);
		
		request.getRequestDispatcher("/WEB-INF/views/member/result.jsp").forward(request, response);
	}
}
