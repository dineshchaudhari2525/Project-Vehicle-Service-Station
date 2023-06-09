package com.project.util;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL="";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	
	static {
		try{
			Class.forName(DRIVER);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}

}
