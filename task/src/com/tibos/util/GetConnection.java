package com.tibos.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/test";
	public static final String DBNAME = "root";
	public static final String PASSWORD = "root";
	public static Connection getConn() throws Exception{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, DBNAME, PASSWORD);
		return conn;
	}
}
