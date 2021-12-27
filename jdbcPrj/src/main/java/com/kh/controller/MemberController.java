//package com.kh.controller;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/member")
//public class MemberController extends HttpServlet {
//	//회원가입 페이지 보여주기
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("/WEB-INF/views/memberJoin.jsp").forward(request, response);
//	}
//	
//	//회원가입 진행
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//최종목표 : 전달받은 데이터 디비에 넣기
//		String userId = request.getParameter("userId");
//		String userPwd = request.getParameter("userPwd");
//		String userName = request.getParameter("userName");
//		
//		//JDBC
////		String url = "jdbc:oracle:thin:@localhost:1521/xe";
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
//		String id = "SYSTEM";
//		String pwd = "qlsjtm1122";
////		String query = "INSERT INTO MEMBER (ID, PWD, NAME, ENROLL_DATE) "
////				+ "VALUES ('"+ userId + "', '" + userPwd + "', '" + userName + "', SYSDATE)";
////		String query = "INSERT INTO MEMBER(ID, PWD, NAME, ENROLL_DATE)" 
////		        + " VALUES ('" +userId+ "','"+userPwd+"', '"+userName+"', SYSDATE)";
//		String query = "INSERT INTO MEMBER (ID, PWD, NAME, ENROLL_DATE) "
//				+ "VALUES ('"+ userId + "', '" + userPwd + "', '" + userName + "', SYSDATE)";
//
//		
//		//1. driver 를 lib에 등록
//		//2. 클래스 등록
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			//3. 커넥션 가져옴 (getConnection)
//			Connection conn = DriverManager.getConnection(url, id, pwd);
//			Statement stmt = conn.createStatement();
//			stmt.executeQuery(query);
////			stmt.executeQuery("select 1 from dual");
//			
//		} catch (ClassNotFoundException e) {
//			System.out.println("class ~~~");
//		} catch (SQLException e) {
//			System.out.println("SQL error~~~");
//		}
//	}//doPost method end
//}

package com.kh.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.kh.common.JdbcTemplate.*;

@WebServlet("/member")
public class MemberController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        requset.getRequestDispatcher("/WEB-INF/views/memberJoin.jsp").forward(requset, response);
    }
    @Override
    protected void doPost(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        //이 메소드의 최종 목표 : 전달받은 데이터 디비에 넣기
        String userId = requset.getParameter("userId");
        String userPwd = requset.getParameter("userPwd");
        String userName = requset.getParameter("userName");
        
        //JDBC
        String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
        String id = "kh";
        String pwd = "kh";
        
//        String query = "INSERT INTO MEMBER(ID, PWD, NAME, ENROLL_DATE)" 
//        + " VALUES ('" +userId+ "','"+userPwd+"', '"+userName+"', SYSDATE)";
        String sql = "INSERT INTO MEMBER(ID, PWD, NAME, ENROLL_DATE)"
        		+ " VALUES (?, ?, ?, SYSDATE)";
        
        //1. driver를 lib에 등록
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        //2. 클래스 등록
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //3. 커넥션 가져옴(getConnection)
            conn = DriverManager.getConnection(url, id, pwd);
            //오토커밋 끄기
            conn.setAutoCommit(false);
            
//            Statement stmt = conn.createStatement();
//            stmt.executeQuery(query);
            
            //아직 완성이 안된 쿼리
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPwd);
            pstmt.setString(3, userName);
            
//            pstmt.execute();
            //반환타입 불린
            
            //INSERT, UPDATE, DELETE 등의 경우, 이에 맞는 메소드가 따로 있다.
            //몇개의 행에 영향을 줬는지 알려준다.
            int result = pstmt.executeUpdate();
            
            //이건 아래에서 잡아주기 때문에 안바꿔도 된다.
//            JdbcTemplate.commit(conn);
            conn.commit();	
            
            System.out.println("업데이트된 행 개수(result) : "+result);
            
        } catch (ClassNotFoundException e) {
            System.out.println("class exception");
        } catch (SQLException e) {
            System.out.println("sql exception");
            e.printStackTrace();
//            JdbcTemplate.rollback(conn);
            rollback(conn);
        } finally {
//        	JdbcTemplate.close(conn);
//        	JdbcTemplate.close(pstmt);
        	close(conn);
        	close(pstmt);
        }
    }
}