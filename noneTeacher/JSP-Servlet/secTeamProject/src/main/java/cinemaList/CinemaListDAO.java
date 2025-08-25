package cinemaList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CinemaListDAO {
	
	public List<CinemaListVO> getCinemaList() {
		String sql = "SELECT * FROM cinemas";
		List<CinemaListVO> result = new ArrayList<>();
		
		try(Connection conn = getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql)) {
			
			try (ResultSet rs = psmt.executeQuery()) {
				while(rs.next()) {
					CinemaListVO vo = new CinemaListVO();
					vo.setCinemaId(rs.getInt("cinema_id"));
					vo.setName(rs.getString("name"));
					vo.setLocation(rs.getString("location"));
					vo.setAddress(rs.getString("address"));
					
					result.add(vo);
				}
				return result;
			}
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null;		
	}
	
	public List<CinemaListVO> getCinemasByLocation(String location) {
	    String sql = "SELECT cinema_id, name, location, address FROM cinemas WHERE location = ?";
	    List<CinemaListVO> result = new ArrayList<>();
	    
	    System.out.println("DAO - 지역별 영화관 조회: " + location);
	    
	    try (Connection conn = getConnection();
	         PreparedStatement psmt = conn.prepareStatement(sql)) {
	        
	        psmt.setString(1, location);
	        
	        try (ResultSet rs = psmt.executeQuery()) {
	            while (rs.next()) {
	                CinemaListVO cinema = new CinemaListVO();
	                cinema.setCinemaId(rs.getInt("cinema_id"));
	                cinema.setName(rs.getString("name"));
	                cinema.setLocation(rs.getString("location"));
	                cinema.setAddress(rs.getString("address"));
	                result.add(cinema);
	                
	                System.out.println("조회된 영화관: " + cinema.getName());
	            }
	        }
	        
	    } catch (Exception e) {
	        System.err.println("지역별 영화관 조회 오류: " + e.getMessage());
	        e.printStackTrace();
	    }
	    
	    System.out.println("DAO - 총 " + result.size() + "개 영화관 조회됨");
	    return result;
	}
	
	private static Connection getConnection() throws Exception {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:comp/env");
        DataSource dataSource = (DataSource) envContext.lookup("jdbc/teamproject");
        Connection connection = dataSource.getConnection();
        return connection;
    }
}
