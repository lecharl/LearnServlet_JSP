package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCheck")
public class CookieCheck extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//쿠키 가져오기
		//반환타입 : 쿠키배열타입!!
		Cookie[] cookies = req.getCookies();
		for(Cookie c : cookies) {
			String name = c.getName();
			String value = c.getValue();
			System.out.println("[쿠키] : "+ name +" : "+ value);
		}
		System.out.println("쿠키 체크~~");
	}
}
