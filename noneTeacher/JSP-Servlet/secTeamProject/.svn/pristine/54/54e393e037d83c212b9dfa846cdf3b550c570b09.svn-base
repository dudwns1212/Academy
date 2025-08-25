package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinemaList.CinemaListDAO;
import cinemaList.CinemaListVO;
import movieList.MovieListDAO;
import movieList.MovieListVO;

import com.google.gson.Gson;

// 모든 영화 관련 요청을 하나의 서블릿에서 처리
@WebServlet(urlPatterns = { "/MovieListServlet", "/MovieGalleryServlet", "/OneMovieServlet", "/MovieGenreServlet",
		"/MovieListApiServlet", "/MovieLike" })
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");

		String uri = req.getRequestURI();
		String forwardPage = "/movie.jsp"; // 기본 페이지

		System.out.println("요청된 URI: " + uri);

		MovieListDAO mdao = new MovieListDAO();
		CinemaListDAO cdao = new CinemaListDAO();

		// URI에 따라 다른 처리 수행
		if (uri.endsWith("/MovieListServlet")) {
			// 영화 목록 조회 (예매 페이지용)
			System.out.println("영화 목록 조회 요청");
			List<MovieListVO> movieList = mdao.getMovieList();
			List<CinemaListVO> cinemaList = cdao.getCinemaList();
			req.setAttribute("movieList", movieList);
			req.setAttribute("cinemaList", cinemaList);

			forwardPage = "/reserve.jsp";

		} else if (uri.endsWith("/MovieGalleryServlet")) {

			List<MovieListVO> movieList = mdao.getTopMovies();

			// 확인용 로그
			if (movieList != null && !movieList.isEmpty()) {
				System.out.println("서블릿: DB에서 TOP 10 영화 " + movieList.size() + "개의 정보를 가져왔습니다.");
				System.out.println("첫 번째 영화 제목: " + movieList.get(0).getMovieTitle());
				System.out.println("첫 번째 영화 포스터: " + movieList.get(0).getPoster());
			} else {
				System.out.println("서블릿: DB에서 영화 정보를 가져오지 못했거나, 목록이 비어있습니다.");
			}

			req.setAttribute("movieList", movieList);

			userList.UserListVO login = (userList.UserListVO) req.getSession().getAttribute("loginUser");
			if (login != null) {
				req.setAttribute("likedMap", mdao.getLikedMapByUser(login.getUserNo()));
			}
			forwardPage = "/movie.jsp";

		} else if (uri.endsWith("/OneMovieServlet")) {
			// 예매 페이지 처리 (특정 영화 선택)
			System.out.println("예매 페이지 요청");

			String movieIdStr = req.getParameter("movieId");

			if (movieIdStr != null && !movieIdStr.isEmpty()) {
				// 특정 영화가 선택된 경우
				try {
					int movieId = Integer.parseInt(movieIdStr);
					MovieListVO selectedMovie = mdao.getMovieDetail(movieId);

					if (selectedMovie != null) {
						System.out.println("선택된 영화: " + selectedMovie.getMovieTitle());
						req.setAttribute("selectedMovie", selectedMovie);
					} else {
						System.out.println("해당 ID의 영화를 찾을 수 없습니다: " + movieId);
						forwardPage = "/home.jsp";
					}

				} catch (NumberFormatException e) {
					System.out.println("잘못된 movieId 형식: " + movieIdStr);
					forwardPage = "/home.jsp";
				}
			}
			forwardPage = "/detail.jsp";
		} else if (uri.endsWith("/MovieGenreServlet")) {
			String genre = req.getParameter("genre");
			List<MovieListVO> movieList = mdao.getGenreMovies(genre);
			req.setAttribute("movieList", movieList);

			userList.UserListVO login = (userList.UserListVO) req.getSession().getAttribute("loginUser");
			if (login != null) {
				req.setAttribute("likedMap", mdao.getLikedMapByUser(login.getUserNo()));
			}
			forwardPage = "/movie.jsp";
		} else if (uri.endsWith("/MovieLike")) {
			userList.UserListVO u = (userList.UserListVO) req.getSession().getAttribute("loginUser");
			if (u == null) {
				resp.setStatus(401);
				return;
			}

			String movieIdParam = req.getParameter("movieId");
			int movieId;
			try {
				movieId = Integer.parseInt(movieIdParam);
			} catch (NumberFormatException e) {
				resp.setStatus(400);
				return;
			}

			try {
				int liked = mdao.toggleLike(u.getUserNo(), movieId);
				int cnt = mdao.countLikes(movieId);
				resp.setContentType("application/json; charset=UTF-8");
				resp.getWriter().print("{\"liked\":" + (liked == 1) + ",\"likeCount\":" + cnt + "}");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setStatus(500);
			}
			return;
		} else if (uri.endsWith("/MovieListApiServlet")) {
			resp.setContentType("application/json; charset=utf-8");
			PrintWriter out = resp.getWriter();
			String cinemaIdStr = req.getParameter("cinemaId");

			try {
				if (cinemaIdStr == null || cinemaIdStr.equals("")) {
					out.println("[]");
				} else {
					int cinemaId = Integer.parseInt(cinemaIdStr);
					List<MovieListVO> movies = mdao.getMovieListByCinema(cinemaId);

					// Gson으로 1줄 변환! 🎉
					Gson gson = new Gson();
					String jsonResult = gson.toJson(movies != null ? movies : new ArrayList<>());

					System.out.println("서블릿 응답: " + jsonResult);
					out.println(jsonResult);
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못된 cinemaId 형식: " + cinemaIdStr);
				out.println("[]");
			} finally {
				out.close();
			}
			return;
		}

		// JSP로 포워드
		System.out.println("포워드할 페이지: " + forwardPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPage);
		dispatcher.forward(req, resp);

	}
}
