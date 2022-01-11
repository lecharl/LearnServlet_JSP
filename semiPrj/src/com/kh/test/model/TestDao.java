package com.kh.test.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TestDao {

	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@128.168.10.3:1521/xe";
		String id = "kh";
		String pwd = "kh";
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pwd);
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	public List<Test> selectList(Connection conn) {
		
		conn = getConnection();
		String sql = "SELECT * FROM TEST";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Test> list = new ArrayList<Test>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Test selectedTestList = null;
			
			while(rs.next()) {
				int seq = rs.getInt("SEQ");
				String writer = rs.getString("WRITER");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Timestamp regdate = rs.getTimestamp("REGDATE");
				
				selectedTestList = new Test();
				selectedTestList.setSeq(seq);
				selectedTestList.setWriter(writer);
				selectedTestList.setTitle(title);
				selectedTestList.setContent(content);
				selectedTestList.setRegdate(regdate);
				
				list.add(selectedTestList);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return list;
	}	
	
	
	
	//close 들(Connection, Statement, ResultSet)
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed())
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
