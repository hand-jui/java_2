package albums2.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DB_NAME = "juiblog";
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_USER_NAME = "bloguser";
	private static final String DB_PASSWORD = "1q2w3e4r5t";
	
	private Connection conn;
	
	public DBHelper() {
	}
	
	private static DBHelper dbHelper;
	
	public static DBHelper getInstance() {
		if(dbHelper==null) {
			dbHelper = new DBHelper();
		}
		return dbHelper;
	}
	
	
	public Connection getConnection() {
		if (conn == null) {
			String urlFormat = "jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST,DB_PORT,DB_NAME,DB_CHARSET);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url,DB_USER_NAME,DB_PASSWORD);
				System.out.println("DB 연결 성공");
			} catch (Exception e) {
				System.out.println("DB 연결 오류");
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn = null;
	}

}
