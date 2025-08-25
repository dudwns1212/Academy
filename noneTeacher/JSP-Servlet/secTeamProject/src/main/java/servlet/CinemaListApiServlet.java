package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinemaList.CinemaListDAO;

import java.util.ArrayList;
import java.util.List;
import cinemaList.CinemaListVO;
import com.google.gson.Gson;

@WebServlet("/CinemaListApiServlet")
public class CinemaListApiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Gson gson = new Gson();  // 멤버 변수로 선언
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");  // JSON 명시
        
        PrintWriter out = resp.getWriter();
        String location = req.getParameter("location");
        
        try {
            if (location == null || location.isEmpty()) {
                out.println("[]");
                return;
            }
            
            CinemaListDAO cdao = new CinemaListDAO();
            List<CinemaListVO> cinemas = cdao.getCinemasByLocation(location);
            
            // 1줄로 JSON 변환! 🎉
            String jsonResult = gson.toJson(cinemas != null ? cinemas : new ArrayList<>());
            out.println(jsonResult);
            
        } catch (Exception e) {
            e.printStackTrace();
            out.println("[]");  // 에러 시 빈 배열
        } finally {
            out.close();
        }
    }
}