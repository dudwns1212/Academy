package scheduleList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ScheduleListDAO {

	public List<String> getScheduleDateList(int movieId, int cinemaId) {
		String sql = "SELECT DISTINCT show_date FROM schedules " + "WHERE movie_id = ? AND cinema_id = ? "
				+ "ORDER BY show_date";

		List<String> dates = new ArrayList<>();

		System.out.println("DAO - 스케줄 날짜 조회: movieId=" + movieId + ", cinemaId=" + cinemaId);

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, movieId);
			ps.setInt(2, cinemaId);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					dates.add(rs.getString("show_date"));
					System.out.println("조회된 날짜: " + rs.getString("show_date"));
				}
			}
		} catch (Exception e) {
			System.err.println("스케줄 날짜 조회 오류: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("DAO - 총 " + dates.size() + "개 날짜 조회됨");
		return dates;
	}

	public List<String> getScheduleTimeList(int movieId, int cinemaId, String showDate) {
		String sql = "SELECT show_time FROM schedules " + "WHERE movie_id = ? AND cinema_id = ? AND show_date = ? "
				+ "ORDER BY show_time";

		List<String> times = new ArrayList<>();

		System.out.println("DAO - 스케줄 시간 조회: movieId=" + movieId + ", cinemaId=" + cinemaId + ", showDate=" + showDate);

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, movieId);
			ps.setInt(2, cinemaId);
			ps.setString(3, showDate);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					times.add(rs.getString("show_time"));
					System.out.println("조회된 시간: " + rs.getString("show_time"));
				}
			}
		} catch (Exception e) {
			System.err.println("스케줄 시간 조회 오류: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("DAO - 총 " + times.size() + "개 시간 조회됨");
		return times;
	}
	
	// ScheduleListDAO.java에 추가할 메소드

	public List<ScheduleListVO> getScheduleTimeWithId(int movieId, int cinemaId, String showDate) {
	    String sql = "SELECT schedule_id, show_time FROM schedules " +
	                "WHERE movie_id = ? AND cinema_id = ? AND show_date = ? " +
	                "ORDER BY show_time";

	    List<ScheduleListVO> schedules = new ArrayList<>();
	    
	    System.out.println("DAO - 스케줄 ID와 시간 조회: movieId=" + movieId + ", cinemaId=" + cinemaId + ", showDate=" + showDate);

	    try (Connection conn = getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, movieId);
	        ps.setInt(2, cinemaId);
	        ps.setString(3, showDate);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                ScheduleListVO schedule = new ScheduleListVO();
	                schedule.setScheduleId(rs.getInt("schedule_id"));
	                schedule.setShowTime(rs.getTime("show_time"));
	                schedules.add(schedule);
	                
	                System.out.println("조회된 스케줄: ID=" + schedule.getScheduleId() + ", 시간=" + schedule.getShowTime());
	            }
	        }
	    } catch (Exception e) {
	        System.err.println("스케줄 ID와 시간 조회 오류: " + e.getMessage());
	        e.printStackTrace();
	    }
	    
	    System.out.println("DAO - 총 " + schedules.size() + "개 스케줄 조회됨");
	    return schedules;
	}

	// ScheduleListDAO.java에 추가할 메소드

	// 스케줄 ID로 스케줄 상세 정보 조회
	public ScheduleListVO getScheduleById(int scheduleId) {
		String sql = "SELECT s.schedule_id, s.movie_id, s.cinema_id, s.show_date, s.show_time, "
				+ "       m.title as movieTitle, c.name as cinemaName, m.poster " + "FROM schedules s "
				+ "JOIN movies m ON s.movie_id = m.movie_id " + "JOIN cinemas c ON s.cinema_id = c.cinema_id "
				+ "WHERE s.schedule_id = ?";

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, scheduleId);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					ScheduleListVO schedule = new ScheduleListVO();
					schedule.setScheduleId(rs.getInt("schedule_id"));
					schedule.setMovieId(rs.getInt("movie_id"));
					schedule.setCinemaId(rs.getInt("cinema_id"));
					schedule.setShowDate(rs.getDate("show_date"));
					schedule.setShowTime(rs.getTime("show_time"));
					schedule.setMovieTitle(rs.getString("movieTitle"));
					schedule.setCinemaName(rs.getString("cinemaName"));
					schedule.setPoster(rs.getString("poster"));
					return schedule;
				}
			}
		} catch (Exception e) {
			System.err.println("스케줄 상세 조회 오류: " + e.getMessage());
			e.printStackTrace();
		}

		return null;
	}
	
	public int getScheduleId(int movieId, int cinemaId, String showDate, String showTime) {
        String sql = "SELECT schedule_id FROM schedules WHERE movie_id = ? AND cinema_id = ? AND show_date = ? AND show_time = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement psmt = conn.prepareStatement(sql)) {
            
            psmt.setInt(1, movieId);
            psmt.setInt(2, cinemaId);
            psmt.setString(3, showDate);
            psmt.setString(4, showTime);
            
            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("schedule_id");
                }
            }
            
        } catch (Exception e) {
            System.err.println("스케줄 ID 조회 오류: " + e.getMessage());
            e.printStackTrace();
        }
        
        return -1; // 찾지 못했을 경우
    }

	private static Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envContext.lookup("jdbc/teamproject");
		Connection connection = dataSource.getConnection();
		return connection;
	}
}