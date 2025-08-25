package reserveList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReserveListDAO {

    // 예매 추가
	public boolean insertReservation(int userId, int scheduleId) {
        String sql = "INSERT INTO reservations (user_id, schedule_id) VALUES (?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement psmt = conn.prepareStatement(sql)) {
            
            psmt.setInt(1, userId);
            psmt.setInt(2, scheduleId);
            
            int result = psmt.executeUpdate();
            return result > 0;
            
        } catch (Exception e) {
            System.err.println("예매 추가 오류: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // 사용자의 예매 내역 조회
	public List<ReserveListVO> getReservationsByUserId(int userId) {
	    System.out.println("=== 예매내역 조회 시작 ===");
	    System.out.println("조회할 userId: " + userId);
	    
	    String sql = "SELECT " +
	                "  r.reservation_id, " +
	                "  r.user_id, " +
	                "  r.schedule_id, " +
	                "  r.reservation_time, " +
	                "  m.title AS movieTitle, " +
	                "  m.poster, " +
	                "  m.price, " +
	                "  c.name AS cinemaName, " +
	                "  s.show_date, " +
	                "  s.show_time " +
	                "FROM reservations r " +
	                "JOIN schedules s ON r.schedule_id = s.schedule_id " +
	                "JOIN movies m ON s.movie_id = m.movie_id " +
	                "JOIN cinemas c ON s.cinema_id = c.cinema_id " +
	                "WHERE r.user_id = ? " +
	                "ORDER BY r.reservation_time DESC";
	    
	    List<ReserveListVO> reservations = new ArrayList<>();
	    
	    try (Connection conn = getConnection();
	         PreparedStatement psmt = conn.prepareStatement(sql)) {
	        
	        psmt.setInt(1, userId);
	        System.out.println("실행할 SQL: " + sql);
	        
	        try (ResultSet rs = psmt.executeQuery()) {
	            int count = 0;
	            while (rs.next()) {
	                count++;
	                ReserveListVO reservation = new ReserveListVO();
	                
	                reservation.setReservationId(rs.getInt("reservation_id"));
	                reservation.setUserId(rs.getInt("user_id"));
	                reservation.setScheduleId(rs.getInt("schedule_id"));
	                reservation.setMovieTitle(rs.getString("movieTitle"));
	                reservation.setMoviePoster(rs.getString("poster"));
	                reservation.setPrice(rs.getInt("price"));
	                reservation.setCinemaName(rs.getString("cinemaName"));
	                reservation.setStartTime(rs.getTimestamp("reservation_time"));
	                reservation.setShowDate(rs.getDate("show_date"));
	                reservation.setShowTime(rs.getTime("show_time"));
	                
	                System.out.println("조회된 예매: " + reservation.getMovieTitle() + " - " + reservation.getCinemaName());
	                reservations.add(reservation);
	            }
	            System.out.println("총 조회된 예매 수: " + count);
	        }
	        
	    } catch (Exception e) {
	        System.err.println("예매 내역 조회 오류: " + e.getMessage());
	        e.printStackTrace();
	    }
	    
	    System.out.println("=== 예매내역 조회 완료 ===");
	    return reservations;
	}
    
    
    
    public boolean deleteReservation(int reservationId, int userId) {
        String sql = "DELETE FROM reservations WHERE reservation_id = ? AND user_id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement psmt = conn.prepareStatement(sql)) {
            
            psmt.setInt(1, reservationId);
            psmt.setInt(2, userId);
            
            int result = psmt.executeUpdate();
            return result > 0;
            
        } catch (Exception e) {
            System.err.println("예매 삭제 오류: " + e.getMessage());
            e.printStackTrace();
            return false;
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