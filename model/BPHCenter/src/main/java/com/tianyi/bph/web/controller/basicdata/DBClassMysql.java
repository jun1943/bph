package com.tianyi.bph.web.controller.basicdata;
 
import java.sql.Connection;
import java.sql.DriverManager; 

public class DBClassMysql {

	private static String user = null; // 用户名
	private static String password = null; // 密码 
	private static String url = null; // 数据库服务器IP地址
	private static String driver = "com.mysql.jdbc.Driver";
  
	public DBClassMysql() throws ClassNotFoundException {

	} 

	private static void initParams() {
		user = DbConfig.getInstance().getDb_user();
		password = DbConfig.getInstance().getDb_password();
		url = DbConfig.getInstance().getDb_url();
	}

	// Mysql

	public static Connection getMysql() {
		initParams();
		Connection conn = null;

		try {

			if (null == conn || conn.isClosed()) {

				Class.forName(driver).newInstance();

				conn = DriverManager.getConnection(url, user, password);

			}

		} catch (Exception e) {

			e.printStackTrace();

			throw new RuntimeException(e);

		}

		return conn;

	}
}