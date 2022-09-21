package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private DBUtil() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static DBUtil instance = new DBUtil();

	public static DBUtil getInstance() {
		return instance;

	}

	
	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/bookdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
		String id = "ssafy";
		String pwd = "ssafy";
		Connection conn = DriverManager.getConnection(url, id, pwd);

		return conn;

	}

	
	public void close(AutoCloseable ...resources) {
		for(AutoCloseable resource:resources) {
			if (resource!=null) {
				try {
					resource.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
		
	}
}
