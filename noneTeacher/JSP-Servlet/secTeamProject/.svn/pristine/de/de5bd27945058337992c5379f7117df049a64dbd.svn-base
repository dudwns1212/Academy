package userList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//유저 DAO 현: 로그인, 회원가입 / 추가 사항: 수정
public class UserListDAO {

	// 로그인 처리 메서드: id와 pw를 받아 DB에서 사용자 정보 조회
	public UserListVO login(String id, String pw) {
		// id, pw가 일치하는 사용자 정보를 조회하는 SQL문 (데이터베이스 컬럼명에 맞게 수정)
		String sql = "SELECT * FROM users WHERE id = ? AND password = ?";

		// try-with-resources 문법으로 try문이 끝나면 자동으로 닫음
		try (Connection conn = getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {

			psmt.setString(1, id); // 첫 번째 ?에 id 세팅
			psmt.setString(2, pw); // 두 번째 ?에 pw 세팅

			// ResultSet은 try 안에서 별도 선언해서 처리
			try (ResultSet rs = psmt.executeQuery()) {
				if (rs.next()) { // 일치하는 사용자 존재하면
					UserListVO vo = new UserListVO();
					vo.setUserNo(rs.getInt("user_id")); // DB의 user_no
					vo.setUserId(rs.getString("id")); // DB의 id
					vo.setUserPassword(rs.getString("password")); // DB의 password
					vo.setUserName(rs.getString("name")); // DB의 name
					vo.setUserAge(rs.getInt("age")); // DB의 age
					vo.setUserMobile(rs.getString("mobile")); // DB의 mobile
					return vo; // 완성된 VO 객체 반환 (로그인 성공)
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // 예외 발생 시 콘솔에 출력
		}
		return null; // 일치하는 사용자 없거나 에러 발생 시 null 반환 (로그인 실패)
	}

	// 회원가입 처리 메서드: UserListVO 객체를 받아 DB에 새 사용자 추가
	public boolean register(UserListVO user) {
		// 회원정보를 users 테이블에 삽입하는 SQL문 (user_no는 auto_increment이므로 제외)
		String sql = "INSERT INTO users (id, password, name, age, mobile) VALUES (?, ?, ?, ?, ?)";

		// try-with-resources로 Connection, PreparedStatement 자원 자동 해제
		try (Connection conn = getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {

			// VO에 담긴 사용자 정보를 각각 SQL 파라미터(?)에 세팅
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserPassword());
			psmt.setString(3, user.getUserName());
			psmt.setInt(4, user.getUserAge());
			psmt.setString(5, user.getUserMobile());

			int result = psmt.executeUpdate(); // insert 실행, 영향 받은 행 수 반환
			return result > 0; // 1 이상이면 성공, true 반환
		} catch (Exception e) {
			e.printStackTrace(); // 예외 발생 시 출력
		}
		return false; // 실패 시 false 반환
	}

	public UserListVO checkUser(String un) {
		String sql = "SELECT * FROM users WHERE user_id = ?";

		// try-with-resources 문법으로 try문이 끝나면 자동으로 닫음
		try (Connection conn = getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {

			psmt.setString(1, un); // 두 번째 ?에 pw 세팅

			// ResultSet은 try 안에서 별도 선언해서 처리
			try (ResultSet rs = psmt.executeQuery()) {
				if (rs.next()) { // 일치하는 사용자 존재하면
					UserListVO vo = new UserListVO();
					vo.setUserNo(rs.getInt("user_id")); // DB의 user_no
					vo.setUserId(rs.getString("id")); // DB의 id
					vo.setUserPassword(rs.getString("password")); // DB의 password
					vo.setUserName(rs.getString("name")); // DB의 name
					vo.setUserAge(rs.getInt("age")); // DB의 age
					vo.setUserMobile(rs.getString("mobile")); // DB의 mobile
					return vo; // 완성된 VO 객체 반환 (로그인 성공)
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // 예외 발생 시 콘솔에 출력
		}
		return null; // 일치하는 사용자 없거나 에러 발생 시 null 반환 (로그인 실패)
	}

	public int update(UserListVO user) {
		String sql = "UPDATE users SET " + "id = ?, " + "password = ?, " + "name = ?, " + "mobile = ?, " + "age = ? "
				+ "WHERE user_id = ?";

		int result = 0;

		try (Connection conn = getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {

			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserPassword());
			psmt.setString(3, user.getUserName());
			psmt.setString(4, user.getUserMobile());
			psmt.setInt(5, user.getUserAge());
			psmt.setInt(6, user.getUserNo());

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean delete(String userId) {
	    // userId 파라미터를 받아서 id 컬럼과 비교
	    
	    int result = 0;
	    	    
	    
	    try (Connection conn = getConnection();) {
	    	
	    	String deleteReservations = "DELETE FROM reservations WHERE user_id = (SELECT user_id FROM users WHERE id = ?)";
	        try (PreparedStatement ps1 = conn.prepareStatement(deleteReservations)) {
	            ps1.setString(1, userId);
	            ps1.executeUpdate();
	        }
	    	
	        // 디버깅용 로그
	        String sql = "DELETE FROM users WHERE id = ?";
	        PreparedStatement psmt = conn.prepareStatement(sql);
	        
	        psmt.setString(1, userId);
	        result = psmt.executeUpdate();
	        
	        return result > 0;
	        
	    } catch (Exception e) {
	        System.err.println("삭제 중 오류 발생: " + e.getMessage());
	        e.printStackTrace();
	        return false;
	    }
	}

	public boolean existsByUserId(String userId) throws Exception {
		String sql = "SELECT COUNT(*) FROM users WHERE id = ?";
		try (Connection conn = getConnection(); PreparedStatement psmt = conn.prepareStatement(sql)) {
			psmt.setString(1, userId);

			try (ResultSet rs = psmt.executeQuery()) {
				return rs.next() && rs.getInt(1) > 0;
			}
		}
	}

	private static Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envContext.lookup("jdbc/teamproject");
		Connection connection = dataSource.getConnection();
		return connection;
	}
}