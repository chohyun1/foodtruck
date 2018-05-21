package com.foodtruck.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {

	// connection 객체를 전달해 주는 프로그램 작성 //2. 연결
	public static Connection getConnection()
			throws Exception  {
		DataSource dataSource
		   = (DataSource) new InitialContext()
		   .lookup("java:comp/env/jdbc/OracleDB");
		return dataSource.getConnection();
	}
	
	// DB관련 객체를 닫는 메서드 - select
	public static void close
	(Connection con, PreparedStatement pstmt, ResultSet rs)
			throws SQLException {
		close(con,pstmt);
		if(rs != null) rs.close();
	}
	// DB관련 객체를 닫는 메서드 - insert, update, delete
	public static void close
	(Connection con, PreparedStatement pstmt)
			throws SQLException {
		if(con != null) con.close();
		if(pstmt != null) pstmt.close();
	}
}
