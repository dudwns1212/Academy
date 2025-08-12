package userList;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserListDAO udao = new UserListDAO();
	MovieListDAO mdao = new MovieListDAO();
	CinemaListDAO cdao = new CinemaListDAO();

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		System.out.println("uri=" + uri);

		String forwardPage = "/home.jsp";

		if (uri.endsWith("home.do")) {
			forwardPage = "/home.jsp";

		} else if (uri.endsWith("login.do")) {
			// 로그인 처리
			// 사용자가 로그인 폼에서 입력한 아이디와 비밀번호를 파라미터로 받아옴
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");

			// 아이디와 비밀번호가 모두 입력되었는지 확인
			if (id != null && pw != null) {
				// DAO의 login 메서드를 호출해 DB에서 사용자 정보 조회
				UserListVO user = dao.login(id, pw);

				if (user != null) {
					// 로그인 성공: 사용자 정보가 null이 아니면 세션에 저장
					HttpSession session = req.getSession();
					session.setAttribute("loginUser", user);
					forwardPage = "/home.jsp"; // 로그인 성공 후 홈으로 이동
				} else {
					// 로그인 실패: 아이디 또는 비밀번호가 틀린 경우
					req.setAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
					forwardPage = "/login.jsp"; // 다시 로그인 페이지로 이동
				}
			} else {
				// 아이디나 비밀번호 미입력 시 로그인 페이지 유지
				forwardPage = "/login.jsp";
			}

		} else if (uri.endsWith("register.do")) {
			// 회원가입 처리
			// 요청 파라미터를 UserListVO 객체로 생성
			UserListVO user = makeUserFromReq(req);
			// DAO의 register 메서드를 호출해 DB에 회원정보 저장 시도
			boolean success = dao.register(user);
			if (success) {
				// 회원가입 성공 시 메시지 전달 후 로그인 페이지로 이동 유도
				req.setAttribute("msg", "회원가입 성공! 로그인 해주세요.");
				forwardPage = "/login.jsp";
			} else {
				// 회원가입 실패 시 에러 메시지 전달 후 다시 회원가입 페이지로 이동
				req.setAttribute("errorMsg", "회원가입 실패. 다시 시도해주세요.");
				forwardPage = "/register.jsp";
			}
		} else if (uri.endsWith("movie.do")) {
			forwardPage = "/movie.jsp";
		} else if (uri.endsWith("seat.do")) {
			forwardPage = "/seat.jsp";
		} else if (uri.endsWith("cinema.do")) {
			forwardPage = "/cinema.jsp";
		}

		req.getRequestDispatcher(forwardPage).forward(req, resp);
	}

	// 요청 파라미터를 UserListVO 객체로 만들어 반환하는 헬퍼 메서드
	private UserListVO makeUserFromReq(HttpServletRequest req) {
		UserListVO user = new UserListVO();
		user.setUserId(req.getParameter("userId"));
		user.setUserPassword(req.getParameter("userPassword"));
		user.setUserName(req.getParameter("userName"));
		try {
			user.setUserAge(Integer.parseInt(req.getParameter("userAge")));
		} catch (NumberFormatException e) {
			user.setUserAge(0);
		}
		user.setUserMobile(req.getParameter("userMobile"));
		return user;
	}
}

