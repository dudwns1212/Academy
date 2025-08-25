package ab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AddrBookDAO {
	static String sql = "select * from employees where DEPARTMENT_ID = ";
	static String driverClassName = "oracle.jdbc.driver.OracleDriver";
	static String connectionUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	static String userName = "hr";
	static String password = "hr";
	static String sqlInsertDB = "insert into addrbook(AB_NAME,ab_email,ab_comdept,ab_birth,ab_tel,ab_memo) "
											+ "values(?,?,?,?,?,?)";
	/*
	static {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	*/
	private static Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envContext.lookup("jdbc/mydb");
		Connection connection = dataSource.getConnection();
		return connection;
	}
	
	public boolean insertDB(AddrBookVO ab) throws Exception {
		Connection connection = null;
		connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sqlInsertDB);
		boolean result= false;
		try {
			pstmt.setString(1, ab.getAbName());
			//AB_ID,AB_NAME,ab_email,ab_comdept,ab_birth,ab_tel,ab_memo) "
			pstmt.setString(2, ab.getAbEmail());
			pstmt.setString(3, ab.getAbComdept());
			pstmt.setString(4, ab.getAbBirth());
			pstmt.setString(5, ab.getAbTel());
			pstmt.setString(6, ab.getAbMemo());
			result= pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<AddrBookVO> getDBList() throws Exception {
		List<AddrBookVO> result = new ArrayList<AddrBookVO>();
		Connection con = getConnection();
		String sql = "select * from addrbook";
		PreparedStatement psmt = con.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			AddrBookVO vo = new AddrBookVO();
			vo.setAbName(rs.getString("ab_name"));
			vo.setAbTel(rs.getString("ab_tel"));
			vo.setAbEmail(rs.getString("ab_email"));
			vo.setAbComdept(rs.getString("ab_comdept"));
			vo.setAbMemo(rs.getString("ab_memo"));
			vo.setAbId(rs.getInt("ab_id"));
			vo.setAbBirth(rs.getString("ab_birth"));
			result.add(vo);
		}
		con.close();
		return result;
	}

	public AddrBookVO getDB(int abId) throws Exception {
		AddrBookVO vo = new AddrBookVO();
		Connection con = getConnection();
		String sql = "select * from addrbook where ab_id = ?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setInt(1, abId);
		ResultSet rs = psmt.executeQuery();
		if(rs.next()) {
			vo.setAbName(rs.getString("ab_name"));
			vo.setAbTel(rs.getString("ab_tel"));
			vo.setAbEmail(rs.getString("ab_email"));
			vo.setAbComdept(rs.getString("ab_comdept"));
			vo.setAbMemo(rs.getString("ab_memo"));
			vo.setAbId(rs.getInt("ab_id"));
			vo.setAbBirth(rs.getString("ab_birth"));
		}
		con.close();
		return vo;
	}
	public boolean updateDB(AddrBookVO ab) throws Exception {
		return false;
	}

	public AddrBookVO deleteDB(int abId) throws Exception {
		AddrBookVO vo = new AddrBookVO();
		Connection con = getConnection();
		String sql = "delete from addrbook where ab_id= ?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setInt(1, abId);
		psmt.executeUpdate();
		return vo;
	}

}
