package junha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBController {

    // 커넥션 얻는 메서드: 호출하는 쪽에서 try-with-resources로 닫기 처리
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            DBConfig.set("url"),
            DBConfig.set("userName"),
            DBConfig.set("passWord")
        );
    }

}
