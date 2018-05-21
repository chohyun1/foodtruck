package com.foodtruck.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MariaDBUtil {

	public static Connection getConnection() throws Exception {
		DataSource dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc_maria");
		// 커넥션 연결 - 커넥션 풀에서 하나만 가져와서 커넥션 연결
		return dataSource.getConnection();

	}// end of getConnection()

	// DB관련 객체를 닫는 메서드 - select
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		close(con, pstmt);
		if (rs != null)
			rs.close();
	}// end of close(con,pstmt,rs)

	// DB관련 객체를 닫는 메서드 - insert, update, delete
	public static void close(Connection con, PreparedStatement pstmt) throws SQLException {
		if (con != null)
			con.close();
		if (pstmt != null)
			con.close();
	}// end of close(con,pstmt)

}// end of class MariaDBUtil
