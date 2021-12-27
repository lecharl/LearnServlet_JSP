package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kh.vo.Member;

public class MyDao {

	public void ddd(Member m) {
		System.out.println("DAO > ddd called...");
		System.out.println(m);
		
		//JDBC 사용해서 DB에 접근해서 데이터 처리
		//CRUD(Create Read Update Delete)
		//insert
		//select
		//update
		//delete
		
		//thin : java
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String id = "SYSTEM";
		String pwd = "qlsjtm1122";
		String sql = "SELECT 1 AS DATA FROM DUAL";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, id, pwd);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);	
			//로우 0을 가리키는 커서? 컬럼명들이 있는 로우를 가리킨다??
			//커서를 한 줄 내려야 DATA컬럼의 데이터 1인 인덱스 0을 가져올 수 있다!!
			//rs.next() 할수록 로우가 한줄씩 내려간다.
			
			while(rs.next()) {
				int data = rs.getInt("DATA");
				System.out.println("DB에서 가져온 데이터 : " + data);				
			}
			
			rs.next();
			//컬럼이름이 DATA인 값 가져오기?
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
