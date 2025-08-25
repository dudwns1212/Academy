package userList;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkId.do")
public class CheckIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserListDAO userDAO = new UserListDAO();
		
		res.setContentType("application/json; charset=utf-8");
		
		String userId = req.getParameter("userId");
		
		boolean available = false;
		int status = HttpServletResponse.SC_OK; // SC_OK = 코드 200
		
		try {
			if (userId != null && (userId = userId.trim()).length() >= 4) {
				boolean exists = userDAO.existsByUserId(userId);
				available = !exists;
			} else {
				status = HttpServletResponse.SC_BAD_REQUEST; //SC_BAD_REQUEST = 코드 400 
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR; //SC_INTERNAL_SERVER_ERROR = 코드 500
			available = false;
		}
		
		res.setStatus(status);
		try (PrintWriter out = res.getWriter()) {
			out.write("{\"available\":" + available + "}");
		}
	}

}
