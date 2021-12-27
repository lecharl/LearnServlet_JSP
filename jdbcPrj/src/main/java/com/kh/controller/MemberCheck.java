package com.kh.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberCheck")
public class MemberCheck extends HttpServlet {

	//회원 조회 페이지 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/memberCheck.jsp").forward(req, resp);
	}
	
	//회원 조회 해오기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String id = "kh";
		String pwd = "kh";
		
		String sql = "select * from MEMBER where id = ?";
		
		//아래들은 무조건 닫아줘야 함 
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
//			rs.next();
			
			if(rs.next()) {
				
			String memberId = rs.getString("ID");
			String memberPwd = rs.getString("PWD");
			String memberName = rs.getString("NAME");
			Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
			
			System.out.println(memberId);
			System.out.println(memberPwd);
			System.out.println(memberName);
			System.out.println(enrollDate);
			}
			
			conn.commit();
//			conn.rollback();
			
		} catch (Exception e) {
			System.out.println("errrrrror~~!");
//			conn.rollback();
		} finally {
//			pstmt.close();
//			rs.close();
//			conn.close();
		}
	}
}
