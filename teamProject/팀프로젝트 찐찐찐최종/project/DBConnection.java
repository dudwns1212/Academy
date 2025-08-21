package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.DBConnectException;

public class DBConnection {
	public static Connection conn;
	
	public DBConnection() {
		try {
			conn = DriverManager.getConnection(DBConfig.set("url"), DBConfig.set("userName"), DBConfig.set("passWord"));
	// 실행 오류 시 DB 연결 실패 메세지 전송
		} catch (SQLException e) {
			System.out.println(new DBConnectException(DBConfig.set("url"), DBConfig.set("userName"), DBConfig.set("passWord")).getMessage());
		}
	}
	
	public void close() {
		try {
			if (DBConnection.conn != null && !DBConnection.conn.isClosed()) {
				DBConnection.conn.close();
				System.out.println("DB 연결 해제");
			}
		} catch (SQLException e) {
				
		}
	}
	
}
