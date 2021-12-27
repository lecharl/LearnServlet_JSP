package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//쿠키 만들기
		Cookie cookie = new Cookie("num", "1");
		
		//쿠키 경로 설정 : url /abc 를 요청할 때만 ???
		cookie.setPath("/abc");
		//1초 뒤 쿠키 자동 소멸
//		cookie.setMaxAge(1);
		//하루동안 쿠키 자동 소멸
		cookie.setMaxAge(60*60*24);
		
		resp.addCookie(cookie);
		
		System.out.println("쿠키~~");
	}
}
