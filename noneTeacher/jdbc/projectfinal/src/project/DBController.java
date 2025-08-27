package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.DBConnectException;

public class DBController {
	static public Connection conn;
	// 생성자에 커넥션을 넣어서 실행 -> main에 db객체 생성
	
	public DBController() {
		try {
			conn = DriverManager.getConnection(DBConfig.set("url"), DBConfig.set("userName"), DBConfig.set("passWord"));
	// 실행 오류 시 DB 연결 실패 메세지 전송
		} catch (Exception e) {
			System.out.println(new DBConnectException(DBConfig.set("url"), DBConfig.set("userName"), DBConfig.set("passWord")).getMessage());
		}
	}
	
	// 콘솔 닫는 메서드 
	public void close() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("DB 연결 해제");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
