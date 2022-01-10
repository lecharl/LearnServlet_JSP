package com.kh.member.model.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.MemberVo;

public class MemberService {
	
	private String encrypt(String pwd) {
		//패스워드 암호화
		//암호화된패스워드 = pwd.암호화
		//m.setPwd(암호화된패스워드);
//		String pwd = m.getPwd();
		
		StringBuilder sb = new StringBuilder();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
//			//sha-512 : 128 바이트 이므로, pwd는 varchar2(200)정도로?
			md.update(pwd.getBytes());
			byte[] digest = md.digest();
			for(byte b : digest) {
				sb.append(String.format("%02x", b));
			}
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return sb.toString();
	}

	public int join(MemberVo m) {

		m.setPwd(encrypt(m.getPwd()));
		
		
		//DB Connection 가져오기
		Connection conn = getConnection();
		
		//쿼리 날리기	//insert
		int result = 0;
		try {
			result = insertMember(conn, m);
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		//결과 반환하기
		
		return result;
	}
	
	public int insertMember(Connection conn, MemberVo m) throws SQLException {
		//dao 불러서 쿼리 실행
		//dao한테 쿼리 실행 결과 받기
		//throws 로 캐치블럭 X
		int result = new MemberDao().insertMember(conn, m);
		return result;
	}

	public MemberVo login(MemberVo m) {
		//커넥션 가져오기(디비 가져오기?)
		Connection conn = getConnection();
		
		//id 로 그 아이디의 비번 조회
		MemberVo selectedMember = selectMember(conn, m);
		
		close(conn);
		
		
		//가져온 pwd와 사용자가 입련한 pwd가 같은지 비교, 같으면
		if(selectedMember.getPwd().equals(encrypt(m.getPwd())))
			//결과 리턴
			return selectedMember;
		else
			return null;
		
//		return selectedMember.getPwd().equals(m.getPwd());
		
	}

	public MemberVo selectMember(Connection conn, MemberVo m) {
		return new MemberDao().selectMember(conn, m);
	}

	public List<MemberVo> selectMemberAll(Connection conn, String currentPage, int startNo, int endNo) {
//		Connection conn = getConnection();
		return new MemberDao().selectMemberAll(conn, startNo, endNo);
	}

	public List<MemberVo> search(String type, String value, String currentPage) {
		Connection conn = getConnection();
		
		//총 게시글 수 : select count(*)~~
		int totalBoardCount = countMemberAll(conn); //5개?
		//총 회원 수
//		countMemberAll();
		
		//페이징 목록 최대 개수
		int pageLimit = 5;
		//한 페이지 당 게시글 수
		int boardLimit = 3;
		//마지막 페이지
		int maxPage = 0;
		
		maxPage = totalBoardCount / boardLimit;
		if(totalBoardCount % boardLimit != 0) {
			maxPage++;
		}
		System.out.println("maxPage: "+maxPage);
		
		int p = Integer.parseInt(currentPage);
		
		int endNo = p * boardLimit;
		int startNo = endNo - boardLimit + 1;
		
		List<MemberVo> memberList;
		if(type == null || value == null) {
			//탐색만 눌렀을 때 null,null 이 나오는데, 이땐 전체 멤버 조회로
			memberList = selectMemberAll(conn, currentPage, startNo, endNo);			
		}else {
			//type과 value 둘다 값이 있을 경우
			memberList = selectMember(conn, type, value);						
		}
		close(conn);
		
		return memberList;
	}

	private int countMemberAll(Connection conn) {
		return new MemberDao().countMemberAll(conn);
	}

	private List<MemberVo> selectMember(Connection conn, String type, String value) {
		
		return new MemberDao().selectMemberBySearch(conn, type, value);
	}

	public int dupCheck(String id) {
		Connection conn = getConnection();
		int result = selectMemberById(conn, id);
		
		close(conn);
		return result;
	}

	private int selectMemberById(Connection conn, String id) {
		return new MemberDao().selectMemberById(conn, id);
	}
}
