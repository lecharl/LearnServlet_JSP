package com.kh.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kh.dao.MyDao;
import com.kh.vo.Member;

public class MyService {

	public void sss(Member m) {
		System.out.println("service > sss called...");
		
		//비즈니스 로직 수행
		//service에서 dao(data access object) 호출
		MyDao dao = new MyDao();
		dao.ddd(m);
		
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
//		String id = "kh";
//		String pwd = "kh123";
//		
//		String sql = "select 1 fron dual";
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection conn = DriverManager.getConnection(url, id, pwd);
//			Statement stmt = conn.createStatement();
//			
//			ResultSet rs = stmt.executeQuery(sql);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
