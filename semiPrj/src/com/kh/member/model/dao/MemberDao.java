package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.MemberVo;

public class MemberDao {

	public int insertMember(Connection conn, MemberVo m) throws SQLException {
		//쿼리 날리기
		String sql = "INSERT INTO MEMBER(MEMBER_NO, ID, PWD, NAME, DETAIL, ENROLL_DATE)"
				+ " VALUES(SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
//		String sql = "INSERT INTO BOARD(BOARD_NUM, BOARD_WRITER, BOARD_TITLE, BOARD_CONTENT, BOARD_DATE)"
//				+ " VALUES(PK_BOARD.NEXTVAL, FK_BOARD_WRITER.USERID, ?, ?,  SYSDATE)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//위의 thorws로 해결, try/catch 안함
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setInt(4, -1);
			
			result = pstmt.executeUpdate();
		} finally {
			JDBCTemplate.close(pstmt);			
		}
		
		return result;
	}

	public MemberVo selectMember(Connection conn, MemberVo m) {
		String query = "SELECT * FROM MEMBER WHERE ID = ? AND QUIT_YN ='N'";
		
		PreparedStatement pstmt = null;
		MemberVo selectedMember = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				int detail = rs.getInt("DETAIL");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				String openYn = rs.getString("OPEN_YN");
				//탈퇴 안한 사람만 조회하므로 QUIT_YN ㄴㄴ
				
				selectedMember = new MemberVo();
				selectedMember.setMemberNo(memberNo);
				selectedMember.setId(id);
				selectedMember.setPwd(pwd);
				selectedMember.setName(name);
				selectedMember.setDetail(detail);
				selectedMember.setEnrollDate(enrollDate);
				selectedMember.setModifyDate(modifyDate);
				selectedMember.setOpenYn(openYn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return selectedMember;
	}

	public List<MemberVo> selectMemberAll(Connection conn, int startNo, int endNo) {
		String sql = "SELECT * "
				+ "FROM ( "
				+ "SELECT ROWNUM AS RNUM, "
				+ "m.* FROM MEMBER m "
				+ "WHERE QUIT_YN = 'N' AND OPEN_YN = 'Y' "
				+ ") "
				+ "WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> list = new ArrayList<MemberVo>();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			MemberVo selectedMember = null;
			
			while(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				int detail = rs.getInt("DETAIL");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				String openYn = rs.getString("OPEN_YN");
				//탈퇴 안한 사람만 조회하므로 QUIT_YN ㄴㄴ
				
				//만들고
				selectedMember = new MemberVo();
				selectedMember.setMemberNo(memberNo);
				selectedMember.setId(id);
				selectedMember.setPwd(pwd);
				selectedMember.setName(name);
				selectedMember.setDetail(detail);
				selectedMember.setEnrollDate(enrollDate);
				selectedMember.setModifyDate(modifyDate);
				selectedMember.setOpenYn(openYn);
				
				//담아주고
				list.add(selectedMember);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int selectMemberById(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	public List<MemberVo> selectMemberBySearch(Connection conn, String type, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE %s LIKE ?";
		sql = String.format(sql, type);
		System.out.println("SQL ::: "+sql);
		
		List<MemberVo> list = new ArrayList<MemberVo>();

		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, type);
			pstmt.setString(1, "%"+value+"%");
//			System.out.println("SQL ::: "+sql);
			
			MemberVo selectedMember = null;
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				MemberVo m = new MemberVo();
//				
				int memberNo = rs.getInt("MEMBER_NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				int detail = rs.getInt("DETAIL");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				String openYn = rs.getString("OPEN_YN");
				//탈퇴 안한 사람만 조회하므로 QUIT_YN ㄴㄴ
				
				//만들고
				selectedMember = new MemberVo();
				selectedMember.setMemberNo(memberNo);
				selectedMember.setId(id);
				selectedMember.setPwd(pwd);
				selectedMember.setName(name);
				selectedMember.setDetail(detail);
				selectedMember.setEnrollDate(enrollDate);
				selectedMember.setModifyDate(modifyDate);
				selectedMember.setOpenYn(openYn);
				
				list.add(selectedMember);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int countMemberAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT (MEMBER_NO) FROM MEMBER WHERE QUIT_YN = 'N' AND OPEN_YN = 'Y'";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

}
