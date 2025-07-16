package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		Connection conn =
					
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		
		String sql = "select * from employees";
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			String lastName = rs.getString("last_name");
			int salary = rs.getInt("salary");
			System.out.println("last_name=" + lastName + ", salary=" + salary);
		}
		conn.close();
		
		
	}
}
