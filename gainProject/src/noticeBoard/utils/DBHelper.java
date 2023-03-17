package noticeBoard.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {

	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DB_NAME = "noticedb";
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_USER_NAME = "juispro";
	private static final String DB_PASSWORD = "14148288";

	private Connection conn;

	public DBHelper() {
	}

	private static DBHelper dbHelper;

	public static DBHelper getInstance() {
		if (dbHelper == null) {
			dbHelper = new DBHelper();
		}
		return dbHelper;
	}

	public Connection getConnection() {
		if (conn == null) {
			String urlFormat = "jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST, DB_PORT, DB_NAME, DB_CHARSET);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
				System.out.println("DB 연결완료");
			} catch (Exception e) {
				System.err.println("DB Helper에서 오류 발생");
				e.printStackTrace();
			}
		}
		return conn;
	}

}
