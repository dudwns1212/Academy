package myaddrbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.htm")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String uri = req.getRequestURI();
			System.out.println("uri=" + uri);
			if(uri.endsWith("/list.htm")) {
				
			} else if(uri.endsWith("/form.htm")) {
				
			}
		}
}
