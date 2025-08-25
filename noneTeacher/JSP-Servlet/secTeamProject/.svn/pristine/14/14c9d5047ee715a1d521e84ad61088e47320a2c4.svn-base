package movieList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// 데이터베이스의 'movies' 테이블과 직접 소통하는 클래스
public class MovieListDAO {
	
	private String formatSynopsis(String raw) {
        if (raw == null) return null;
        return raw.replaceAll("([.!?])", "$1\n");
    }

    public List<MovieListVO> getMovieList() {
        List<MovieListVO> movieList = new ArrayList<>();
        
        // movies 테이블의 모든 영화를 조회하는 SQL
        String sql = 
            "SELECT " +
            "  m.movie_id AS movieId, " +      // ← VO와 맞추는 별칭
            "  m.title    AS movieTitle, " +
            "  m.price    AS moviePrice, " +
            "  m.movieTime, " +
            "  m.genre, " +
            "  m.poster, " +                     // poster 컬럼 추가
            "  m.synopsis, " +
            "  COALESCE(ml.cnt,0) AS likeCount " +
            "FROM movies m " +
            "LEFT JOIN (SELECT movie_id, COUNT(*) AS cnt FROM movie_like GROUP BY movie_id) ml " +
            "  ON ml.movie_id = m.movie_id " +
            "ORDER BY m.movie_id DESC";

        //try-with-resources 문법으로 try문이 끝나면 자동으로 닫음
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // ResultSet은 try 안에서 별도 선언해서 처리
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // MovieListVO 그릇을 준비하고, DB에서 가져온 데이터를 담습니다.
                    MovieListVO movie = new MovieListVO();
                    
                    // DB의 컬럼명과 VO의 set 메소드를 일치시켜주는 것이 중요해요.
                    movie.setMovieId(rs.getInt("movieId"));
                    movie.setMovieTitle(rs.getString("movieTitle"));
                    movie.setMoviePrice(rs.getInt("moviePrice"));
                    movie.setMovieTime(rs.getInt("movieTime"));
                    movie.setGenre(rs.getString("genre"));
                    movie.setPoster(rs.getString("poster"));  // poster 설정 추가
                    movie.setSynopsis(formatSynopsis(rs.getString("synopsis")));
                    movie.setLikeCount(rs.getInt("likeCount"));
                    
                    movieList.add(movie); // 데이터가 채워진 그릇을 리스트에 추가
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 콘솔에 출력
        }
        return movieList; // 영화 정보가 가득 담긴 리스트를 반환
    }
    
    // 인기 상영작 TOP을 가져오는 메소드 추가
    public List<MovieListVO> getTopMovies() {
        List<MovieListVO> movieList = new ArrayList<>();
        
        // 영화를 조회하는 SQL (movie_id 순서로)
        String sql = 
            "SELECT " +
            "  m.movie_id AS movieId, " +
            "  m.title    AS movieTitle, " +
            "  m.price    AS moviePrice, " +
            "  m.movieTime, " +
            "  m.genre, " +
            "  m.poster, " +
            "  m.synopsis, " +
            "  COALESCE(ml.cnt,0) AS likeCount " +
            "FROM movies m " +
            "LEFT JOIN (SELECT movie_id, COUNT(*) AS cnt FROM movie_like GROUP BY movie_id) ml " +
            "  ON ml.movie_id = m.movie_id " +
            "ORDER BY COALESCE(ml.cnt,0) DESC, m.movie_id ASC ";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    MovieListVO movie = new MovieListVO();
                    
                    movie.setMovieId(rs.getInt("movieId"));
                    movie.setMovieTitle(rs.getString("movieTitle"));
                    movie.setMoviePrice(rs.getInt("moviePrice"));
                    movie.setMovieTime(rs.getInt("movieTime"));
                    movie.setGenre(rs.getString("genre"));
                    movie.setPoster(rs.getString("poster"));
                    movie.setSynopsis(formatSynopsis(rs.getString("synopsis")));
                    movie.setLikeCount(rs.getInt("likeCount"));
                    
                    movieList.add(movie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieList;
    }
    
    // reserve 페이지에서 영화검색
    public MovieListVO getMovieDetail(int movieId) {
        // movie_id를 기준으로 특정 영화 한 편만 조회하는 SQL
        String sql = "SELECT * FROM movies WHERE movie_id = ?";
        
        //try-with-resources 문법으로 try문이 끝나면 자동으로 닫음
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, movieId); // SQL의 첫 번째 ?에 파라미터로 받은 movieId 값을 설정
            
            // ResultSet은 try 안에서 별도 선언해서 처리
            try (ResultSet rs = pstmt.executeQuery()) {
                // 결과가 있다면 (영화가 존재한다면)
                if (rs.next()) {
                    MovieListVO movie = new MovieListVO(); // VO 객체 생성
                    
                    // 결과를 VO 객체에 담기
                    movie.setMovieId(rs.getInt("movie_id"));
                    movie.setMovieTitle(rs.getString("title"));
                    movie.setMoviePrice(rs.getInt("price"));
                    movie.setMovieTime(rs.getInt("movieTime"));
                    movie.setGenre(rs.getString("genre"));
                    movie.setPoster(rs.getString("poster"));  // poster 설정 추가
                    movie.setSynopsis(formatSynopsis(rs.getString("synopsis")));
                    movie.setLikeCount(rs.getInt("like_count"));
                    
                    return movie; // 완성된 VO 객체 반환
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 콘솔에 출력
        }
        return null; // 일치하는 영화 없거나 에러 발생 시 null 반환
    }
    
    public List<MovieListVO> getGenreMovies(String genre) {
        List<MovieListVO> movieList = new ArrayList<>();
        
        // 영화를 조회하는 SQL (movie_id 순서로)
        String sql = 
            "SELECT " +
            "  m.movie_id AS movieId, " +
            "  m.title    AS movieTitle, " +
            "  m.price    AS moviePrice, " +
            "  m.movieTime, " +
            "  m.genre, " +
            "  m.poster, " +
            "  m.synopsis, " +
            "  COALESCE(ml.cnt,0) AS likeCount " +
            "FROM movies m " +
            "LEFT JOIN (SELECT movie_id, COUNT(*) AS cnt FROM movie_like GROUP BY movie_id) ml " +
            "  ON ml.movie_id = m.movie_id " +
            "WHERE genre = ? " +
            "ORDER BY COALESCE(ml.cnt,0) DESC, m.movie_id DESC";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	
        	pstmt.setString(1, genre);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    MovieListVO movie = new MovieListVO();
                    
                    movie.setMovieId(rs.getInt("movieId"));
                    movie.setMovieTitle(rs.getString("movieTitle"));
                    movie.setMoviePrice(rs.getInt("moviePrice"));
                    movie.setMovieTime(rs.getInt("movieTime"));
                    movie.setGenre(rs.getString("genre"));
                    movie.setPoster(rs.getString("poster"));
                    movie.setSynopsis(rs.getString("synopsis"));
                    movie.setLikeCount(rs.getInt("likeCount"));
                    
                    movieList.add(movie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieList;
    }
    
    public List<MovieListVO> getMovieListByCinema(int cinemaId) {
        List<MovieListVO> movieList = new ArrayList<>();
        
        String sql = 
            "SELECT DISTINCT " +
            "  m.movie_id AS movieId, " +
            "  m.title AS movieTitle, " +
            "  m.price AS moviePrice, " +
            "  m.movieTime, " +
            "  m.genre, " +
            "  m.poster, " +
            "  m.synopsis, " +
            "  COALESCE(ml.cnt,0) AS likeCount " +
            "FROM movies m " +
            "JOIN schedules s ON m.movie_id = s.movie_id " +
            "LEFT JOIN (SELECT movie_id, COUNT(*) AS cnt FROM movie_like GROUP BY movie_id) ml " +
            "  ON ml.movie_id = m.movie_id " +
            "WHERE s.cinema_id = ? " +
            "ORDER BY COALESCE(ml.cnt,0) DESC, m.movie_id ASC";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, cinemaId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    MovieListVO movie = new MovieListVO();
                    
                    movie.setMovieId(rs.getInt("movieId"));
                    movie.setMovieTitle(rs.getString("movieTitle"));
                    movie.setMoviePrice(rs.getInt("moviePrice"));
                    movie.setMovieTime(rs.getInt("movieTime"));
                    movie.setGenre(rs.getString("genre"));
                    movie.setPoster(rs.getString("poster"));
                    movie.setSynopsis(rs.getString("synopsis"));
                    movie.setLikeCount(rs.getInt("likeCount"));
                    
                    movieList.add(movie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieList;
    }
    
    public int toggleLike(int userId, int movieId) throws Exception {
        try (Connection c = getConnection()) {
            c.setAutoCommit(false);
            try {
                // 처음 누르면 INSERT → like_count +1
                try (PreparedStatement ps = c.prepareStatement(
                        "INSERT INTO movie_like(user_id, movie_id) VALUES(?, ?)")) {
                    ps.setInt(1, userId);
                    ps.setInt(2, movieId);
                    ps.executeUpdate();
                }
                try (PreparedStatement up = c.prepareStatement(
                        "UPDATE movies SET like_count = like_count + 1 WHERE movie_id=?")) {
                    up.setInt(1, movieId);
                    up.executeUpdate();
                }
                c.commit();
                return 1; // now liked
            } catch (SQLIntegrityConstraintViolationException dup) {
                // 이미 있었다면 취소 → like_count -1
                try (PreparedStatement del = c.prepareStatement(
                        "DELETE FROM movie_like WHERE user_id=? AND movie_id=?")) {
                    del.setInt(1, userId);
                    del.setInt(2, movieId);
                    del.executeUpdate();
                }
                try (PreparedStatement down = c.prepareStatement(
                        "UPDATE movies SET like_count = GREATEST(like_count - 1, 0) WHERE movie_id=?")) {
                    down.setInt(1, movieId);
                    down.executeUpdate();
                }
                c.commit();
                return 0; // now unliked
            } catch (Exception e) {
                c.rollback();
                throw e;
            } finally {
                try { c.setAutoCommit(true); } catch (Exception ignore) {}
            }
        }
    }

    public int countLikes(int movieId) throws Exception {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(
                 "SELECT COUNT(*) FROM movie_like WHERE movie_id=?")) {
            ps.setInt(1, movieId);
            try (ResultSet rs = ps.executeQuery()) {               
                return rs.next() ? rs.getInt(1) : 0;
            }
        }
    }
    
    public Map<Integer, Boolean> getLikedMapByUser(int userNo) {
        Map<Integer, Boolean> map = new HashMap<>();
        String sql = "SELECT movie_id FROM movie_like WHERE user_id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userNo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) map.put(rs.getInt(1), Boolean.TRUE);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return map;
    }
    
    private static Connection getConnection() throws Exception {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:comp/env");
        DataSource dataSource = (DataSource) envContext.lookup("jdbc/teamproject");
        Connection connection = dataSource.getConnection();
        return connection;
    }
}