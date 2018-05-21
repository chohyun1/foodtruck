package com.foodtruck.fest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.foodtruck.fest.dto.FestDTO;
import com.foodtruck.util.DBUtil;
import com.webjjang.util.PageObject2;

public class FestDAO {

	// 오라클에 접속할때 필요한 정보들
	// DBUtil에 다 선언함.

	// 글리스트를 가져오는 메서드
	public List<FestDTO> list(PageObject2 pageObject) {
		System.out.println(getClass().getName() + ".list()");
		List<FestDTO> list = null;
		// RDBMS에서 데이터를 가져 오는 프로그램 작성

		// 필요한 객체 선언
		Connection con = null; // 연결 객체
		PreparedStatement pstmt = null; // 처리문 객체
		ResultSet rs = null; // 결과 객체

		try {
			// 1. 드라이버 확인 //2. 연결
			con = DBUtil.getConnection();

			// 3. sql
			// 3-1. 원래 데이터를 순서에 맞게 가져온다.
			String sql = "select festno, festdate, festloc, festname, to_char(applydate, 'yyyy-mm-dd')applydate, hit from festboard order by festno desc ";
			// 3-2. 순서에 맞게 가져온 데이터에 rowNum을 붙인다.
			sql = "select rownum rnum, festno, festdate, festloc, festname, applydate, hit from (" + sql + ")";
			// 3-3. 페이지에 맞는 startRow, endRow를 설정한다.
			sql = "select * from (" + sql + ") where rnum between ? and ?";
			// idx가 필요한 이유: 검색이란 기능을 추가 할 당시 sql문의 rnum ?가 계속 뒤로 움직이게 된다. 따라서, idx로 변수를 선언하여
			// 간단하게 만들기
			// 4. 처리문 객체
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pageObject.getStartRow());
			pstmt.setInt(2, pageObject.getEndRow());
			// 5. 실행 -- select ->rs이 나온다.
			rs = pstmt.executeQuery();
			// 6. 표시 --> 데이터 담기
			while (rs.next()) {
				// 데이터가 있는데 list가 null이면 생성한다.
				if (list == null)
					list = new ArrayList<>();
				// 데이터 하나를 담을 수 있는 FestDTO 객체를 생성한다.
				FestDTO festDTO = new FestDTO();
				// 데이터를 rs에서 꺼내서 festDTO에 담는다.
				festDTO.setFestno(rs.getInt("festno"));
				festDTO.setFestname(rs.getString("festname"));
				festDTO.setFestdate(rs.getString("festdate"));
				festDTO.setFestloc(rs.getString("festloc"));
				festDTO.setApplydate(rs.getDate("applydate"));
				festDTO.setHit(rs.getInt("hit"));
				// list에 festDTO를 담는다.
				list.add(festDTO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// 7. 객체 닫기
				DBUtil.close(con, pstmt, rs);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return list;

	}

	// 글번호에 맞는 글보기 데이터를 가져오는 메서드
	public FestDTO view(int festno) {
		System.out.println(getClass().getName() + ".view()");
		FestDTO festDTO = null;
		// 오라클에서 데이터를 가져와서 채우는 프로그램 작성(생략)
		// 사용한 객체 선언
		Connection con = null; // 연결 객체
		PreparedStatement pstmt = null; // 처리문 객체
		ResultSet rs = null; // 결과 객체
		try {
			// 1. 드라이버 확인 //2. 연결
			con = DBUtil.getConnection();
			// 3. sql문 작성
			String sql = "select festno, festcomp, festname, festdate, festloc, festtime, to_char(applydate, 'yyyy-mm-dd')applydate, hit "
					+ " from festboard " + " where festno = ? "; // 변하는
			// 사용
			// 4. 처리문 객체
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, festno); // 첫번째 ?에 no를 int로 셋팅
			// 5. 실행
			rs = pstmt.executeQuery();
			// 6. 표시 rs에서 꺼내서 FestDTO에 담는다.
			if (rs.next()) {
				// 생성자가 만들어져 있어야 한다.
				festDTO = new FestDTO(rs.getInt("festno"), rs.getString("festcomp"), rs.getString("festname"),
						rs.getString("festdate"), rs.getString("festloc"), rs.getString("festtime"),
						rs.getDate("applydate"), rs.getInt("hit"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// 7. 닫기
				DBUtil.close(con, pstmt, rs);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return festDTO;
	}

	// 게시판 글쓰기 처리.
	public void write(FestDTO festDTO) {
		System.out.println(getClass().getName() + ".write()");
		// 사용한 객체 선언
		Connection con = null; // 연결 객체
		PreparedStatement pstmt = null; // 처리문 객체
		try {
			// 1. 드라이버 확인 //2. 연결
			con = DBUtil.getConnection();
			// 3. sql문 작성
			String sql = "insert into festboard(festno, festcomp, festname, festdate, festloc, festtime) "
					+ " values(festboard_seq.nextval," + " ?, ?, ?, ? ,?) "; // 변하는 데이터 대신 ? 사용
			// 4. 처리문 객체
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, festDTO.getFestcomp());
			pstmt.setString(2, festDTO.getFestname());
			pstmt.setString(3, festDTO.getFestdate());
			pstmt.setString(4, festDTO.getFestloc());
			pstmt.setString(5, festDTO.getFesttime());
			// 5. 실행 -> select: executeQuery()
			// insert, update, delete:executeUpdate()
			pstmt.executeUpdate();
			// 6. 표시 -> 오류가 없으면 정상처리
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// 7. 닫기
				DBUtil.close(con, pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	// 조회수를 1증가 시키는 메서드 -> 글번호를 받아서 글번호에 맞는 조회수 증가.
	public void increase(int festno) {
		System.out.println(getClass().getName() + ".increase()");
		// 사용한 객체 선언
		Connection con = null; // 연결 객체
		PreparedStatement pstmt = null; // 처리문 객체
		try {
			// 1. 드라이버 확인 //2. 연결
			con = DBUtil.getConnection();
			// 3. sql문 작성
			String sql = "update festboard set hit = hit + 1 where festno = ? "; // 변하는 데이터 대신 ? 사용
			// 4. 처리문 객체
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, festno); // 첫번째 ?에 no를 int로 셋팅
			// 5. 실행 -> select: executeQuery()
			// insert, update, delete:executeUpdate()
			pstmt.executeUpdate();
			// 6. 표시 -> 오류가 없으면 정상처리
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// 7. 닫기
				DBUtil.close(con, pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	// 게시판 글수정 처리.
	public void update(FestDTO festDTO) {
		System.out.println(getClass().getName() + ".update()");
		// 사용한 객체 선언
		Connection con = null; // 연결 객체
		PreparedStatement pstmt = null; // 처리문 객체
		try {
			// 1. 드라이버 확인 //2. 연결
			con = DBUtil.getConnection();
			// 3. sql문 작성
			String sql = "update festboard set festcomp = ?, festname = ?, festdate = ?, festloc= ?, festtime= ? "
					+ " where festno = ? "; // 변하는 데이터 대신
			// ? 사용
			// 4. 처리문 객체
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, festDTO.getFestcomp());
			pstmt.setString(2, festDTO.getFestname());
			pstmt.setString(3, festDTO.getFestdate());
			pstmt.setString(4, festDTO.getFestloc());
			pstmt.setString(5, festDTO.getFesttime());
			pstmt.setInt(6, festDTO.getFestno());
			// 5. 실행 -> select: executeQuery()
			// insert, update, delete:executeUpdate()
			pstmt.executeUpdate();
			// 6. 표시 -> 오류가 없으면 정상처리
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// 7. 닫기
				DBUtil.close(con, pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	// 게시판 글삭제 처리
	public void delete(int festno) {
		System.out.println(getClass().getName() + ".delete()");
		// 사용한 객체 선언
		Connection con = null; // 연결 객체
		PreparedStatement pstmt = null; // 처리문 객체
		try {
			// 1. 드라이버 확인 //2. 연결
			con = DBUtil.getConnection();
			// 3. sql문 작성
			String sql = "delete from festboard " + " where festno = ?"; // 변하는 데이터 대신 ? 사용
			// 4. 처리문 객체
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, festno);
			// 5. 실행 -> select: executeQuery()
			// insert, update, delete:executeUpdate()
			pstmt.executeUpdate();
			// 6. 표시 -> 오류가 없으면 정상처리
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// 7. 닫기
				DBUtil.close(con, pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
