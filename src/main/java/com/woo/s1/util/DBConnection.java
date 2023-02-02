package com.woo.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	// getConnection
	
	public static Connection getConnection() throws Exception {
		
		// 1. 연결 정보
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		// 2. Driver를 메모리에 로딩
		Class.forName(driver);
		
		// 3. DB 연결
		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
		
	}
	
	public static void disConnect(PreparedStatement st, Connection connection) throws Exception {
		st.close();
		connection.close();
	}
	
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection connection) throws Exception {
		rs.close();
		st.close();
		connection.close();
	}
	
}
