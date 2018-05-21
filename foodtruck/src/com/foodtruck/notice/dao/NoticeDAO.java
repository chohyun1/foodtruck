package com.foodtruck.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.foodtruck.notice.dto.NoticeDTO;
import com.foodtruck.util.DBUtil;
import com.webjjang.util.PageObject2;

public class NoticeDAO {
	// 오라클에 접속 할 때 필요한 정보들
	// DBUtil에 다 선언.

	// 글 리스트를 가져오는 메서드
	public List<NoticeDTO> list(PageObject2 pageObject) {
		System.out.println("NoticeDAO.list()");
		List<NoticeDTO> list = null;
		// RDBMS에서 데이터를 가져 오는 프로그램 작성
		
		// 필요한 객체 선언
		Connection con = null; // 연결 객체
		PreparedStatement pstmt = null; // 처리문 객체
		ResultSet rs = null;  // 결과 객체
		
		try {
			//1. 드라이버 확인 //2. 연결
			con = DBUtil.getConnection();
			// ** 검색 처리 문구를 만든다. pageObject.searchWord가 있는 경우 검색을 해야한다.
			String search = "";
			String searchWord = pageObject.getSearchWord();
			if(searchWord !=null && !searchWord.equals("") ) {
				search += " where 1=0 ";
				// title -> where 1=0  title like ? 
				// title, content  -> where 1=0 or title like ? or content like ?
				for(String field : pageObject.getSearchKeys())
					search += " or "+field+" like ? ";
			}
			//3. sql
			//   1. 원래 데이터를 순서에 맞게 다가져온다.
			String sql = "select no, title, id, "
					+ " writedate, hit from noticeboard "
					+ search
					+ " order by no desc ";
			//   2. 순서에 맞게 가져온 데이터에 rownum rnum 을 붙인다.
			sql = " select rownum rnum, no, title, id, "
					+" writedate, hit from ("+sql+")";
			sql = "select * from (" + sql+ ")"
					+ " where rnum between ? and ? ";
			System.out.println(sql);
			//4. 처리문 객체
			int idx = 1;
			pstmt = con.prepareStatement(sql);
			System.out.println("pstmt setDate : searchWord:"+searchWord);
//			System.out.println(pageObject.getSearchKeys().length);
			if(searchWord != null && !searchWord.equals("")) {
				for(String field : pageObject.getSearchKeys()) {
//					System.out.println(idx);
					pstmt.setString(idx++, "%"+searchWord+"%");
				}
			}
//			System.out.println(idx);
			pstmt.setInt(idx++, pageObject.getStartRow());
			pstmt.setInt(idx++, pageObject.getEndRow());
			//5. 실행 -- select ->rs이 나온다.
			rs = pstmt.executeQuery();
			//6. 표시 --> 데이터 담기
			while(rs.next()) {
				// 데이터가 있는데 list가 null이면 생성한다.
				if(list == null) list = new ArrayList<>();
				// 데이터 하나를 담을 수 있는 BoardDTO 객체를 생성한다.
				NoticeDTO noticeDTO = new NoticeDTO();
				// 데이터를 rs에서 꺼내서 boardDTO에 담는다.
				noticeDTO.setNo(rs.getInt("no"));
				noticeDTO.setTitle(rs.getString("title"));
				noticeDTO.setId(rs.getString("id"));
				noticeDTO.setWriteDate
				(rs.getString("writedate"));
				noticeDTO.setHit(rs.getInt("hit"));
				// list에 boardDTO를 담는다.
				list.add(noticeDTO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				//7. 객체 닫기
				DBUtil.close(con, pstmt, rs);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
				
		return list;
	}

	// 글번호에 맞는 글보기 데이터를 가져오는 메서드.
	public NoticeDTO view(int no) {
		System.out.println("NoticeDAO.view()");
		NoticeDTO noticeDTO = null;
		// 오라클에서 데이터를 가져와서 채우는 프로그램 작성.
		// 필요한 객체 선언
		Connection con = null; // 연결 객체
		PreparedStatement pstmt = null; // 처리문 객체
		ResultSet rs = null; // 결과 객체
		try {
			// 1.드라이버 확인 //2.연결
			con = DBUtil.getConnection();
			// 3. sql 작성 - 변하는 데이터 대신 ?를 사용한다.
			String sql = "select no, title, content, id, writedate, hit from noticeboard where no = ? ";
			// 4. 처리 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no); // 첫번재 ?에 no를 int로 세팅
			// 5. 처리 객체 실행
			rs = pstmt.executeQuery();
			// 6. 표시 rs에서 꺼내서 boardDTO에 담는다.
			if (rs.next()) {
				// 생성자가 만들어져 있어야 한다.
				noticeDTO = new NoticeDTO(rs.getInt("no"), rs.getString("title"), rs.getString("content"),
						rs.getString("id"), rs.getString("writeDate"), rs.getInt("hit"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 7. 종료
				DBUtil.close(con, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return noticeDTO;
	}

	// 조회수를 1 증가시키는 메서드. -> 글번호를 받아서 글번호에 맞는 조회수 증가.
	public void increase(int no) {
		System.out.println("NoticeDAO.increase()");
		// 오라클에서 데이터를 가져와서 채우는 프로그램 작성.
		// 필요한 객체 선언
		Connection con = null; // 연결 객체
		PreparedStatement pstmt = null; // 처리문 객체
		try {
			// 1.드라이버 확인 //2.연결
			con = DBUtil.getConnection();
			// 3. sql 작성 - 변하는 데이터 대신 ?를 사용한다.
			String sql = "update noticeboard set hit = hit + 1 where no = ? ";
			// 4. 처리 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no); // 첫번재 ?에 no를 int로 세팅
			// 5. 처리 객체 실행 -> select: executeQuery(), 그 외: executeUpdate()
			pstmt.executeUpdate();
			// 6. 표시 -> 오류가 없으면 정상처리
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 7. 종료
				DBUtil.close(con, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 게시판 글쓰기 처리
	public void write(NoticeDTO noticeDTO) {
		System.out.println("NoticeDAO.write()");
		// 오라클에서 데이터를 가져와서 채우는 프로그램 작성.
		// 필요한 객체 선언
		Connection con = null; // 연결 객체
		PreparedStatement pstmt = null; // 처리문 객체
		try {
			// 1.드라이버 확인 //2.연결
			con = DBUtil.getConnection();
			// 3. sql 작성 - 변하는 데이터 대신 ?를 사용한다.
			String sql = "insert into noticeboard(no, title, content, id) values(noticeboard_seq.nextval, ?, ?, ?) ";
			// 4. 처리 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, noticeDTO.getTitle()); // 첫번재 ?에 no 세팅
			pstmt.setString(2, noticeDTO.getContent()); // 첫번재 ?에 no 세팅
			pstmt.setString(3, noticeDTO.getId()); // 첫번재 ?에 no 세팅
			// 5. 처리 객체 실행 -> select: executeQuery(), 그 외: executeUpdate()
			pstmt.executeUpdate();
			// 6. 표시 -> 오류가 없으면 정상처리
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 7. 종료
				DBUtil.close(con, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 게시판 글수정 처리
	public void update(NoticeDTO noticeDTO) {
		System.out.println("NoticeDAO.update()");
		// 오라클에서 데이터를 가져와서 채우는 프로그램 작성.
		// 필요한 객체 선언
		Connection con = null; // 연결 객체
		PreparedStatement pstmt = null; // 처리문 객체
		try {
			// 1.드라이버 확인 //2.연결
			con = DBUtil.getConnection();
			// 3. sql 작성 - 변하는 데이터 대신 ?를 사용한다.
			String sql = "update noticeboard set title=?, content=? where no = ? ";
			// 4. 처리 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, noticeDTO.getTitle()); // 첫번재 ?에 title 세팅
			pstmt.setString(2, noticeDTO.getContent()); // 두번재 ?에 content 세팅
			pstmt.setInt(3, noticeDTO.getNo()); // 네번재 ?에 no 세팅
			// 5. 처리 객체 실행 -> select: executeQuery(), 그 외: executeUpdate()
			pstmt.executeUpdate();
			// 6. 표시 -> 오류가 없으면 정상처리
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 7. 종료
				DBUtil.close(con, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 게시판 글삭제 처리
	public void delete(int no) {
		System.out.println("NoticeDAO.delete()");
		// 오라클에서 데이터를 가져와서 채우는 프로그램 작성.
		// 필요한 객체 선언
		Connection con = null; // 연결 객체
		PreparedStatement pstmt = null; // 처리문 객체
		try {
			// 1.드라이버 확인 //2.연결
			con = DBUtil.getConnection();
			// 3. sql 작성 - 변하는 데이터 대신 ?를 사용한다.
			String sql = "delete from noticeboard where no = ? ";
			// 4. 처리 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no); // 첫번재 ?에 no 세팅
			// 5. 처리 객체 실행 -> select: executeQuery(), 그 외: executeUpdate()
			pstmt.executeUpdate();
			// 6. 표시 -> 오류가 없으면 정상처리
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 7. 종료
				DBUtil.close(con, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
