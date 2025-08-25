
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserveList.ReserveListDAO;
import reserveList.ReserveListVO;
import scheduleList.ScheduleListDAO;
import userList.UserListVO;

@WebServlet(urlPatterns = { "/ReserveServlet", "/MyReservationServlet", "/DeleteReservationServlet" })
public class ReserveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    ReserveListDAO rdao = new ReserveListDAO();
    
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        
        String uri = req.getRequestURI();
        HttpSession session = req.getSession();
        String forwardPage = "/home.jsp";
        
        System.out.println("예약 관련 요청 URI: " + uri);
        
        if (uri.endsWith("/ReserveServlet")) {
            // 예매하기 처리
            PrintWriter out = resp.getWriter();
            UserListVO loginUser = (UserListVO) session.getAttribute("loginUser");
            ScheduleListDAO sdao = new ScheduleListDAO();
            
            if (loginUser == null) {
                req.setAttribute("loginMsg", "로그인이 필요합니다.");
                forwardPage = "/login.jsp";
            } else {
                // 예매 정보 받기
                String cinemaId = req.getParameter("cinemaId");
                String movieId = req.getParameter("movieId");
                String movieDate = req.getParameter("date");
                String movieTime = req.getParameter("time");
                
                if (cinemaId != null && movieId != null && movieDate != null && movieTime != null) {
                    try {
                        int scheduleId = sdao.getScheduleId(Integer.parseInt(movieId), Integer.parseInt(cinemaId), movieDate, movieTime);
                        
                        if (scheduleId != -1) {
                            boolean result = rdao.insertReservation(loginUser.getUserNo(), scheduleId);
                            
                            if (result) {
                                out.println("<script>");
                                out.println("alert('예매가 완료되었습니다!');");
                                
                                out.println("location.href='home.do';");
                                out.println("</script>");
                                return;
                            } else {
                                out.println("<script>");
                                out.println("alert('예매 처리 중 오류가 발생했습니다.');");
                                out.println("history.back();");
                                out.println("</script>");
                                return;
                            }
                        } else {
                            out.println("<script>");
                            out.println("alert('해당 상영 일정을 찾을 수 없습니다.');");
                            out.println("history.back();");
                            out.println("</script>");
                            return;
                        }
                    } catch (Exception e) {
                        out.println("<script>");
                        out.println("alert('오류가 발생했습니다.');");
                        out.println("history.back();");
                        out.println("</script>");
                        return;
                    }
                } else {
                    out.println("<script>");
                    out.println("alert('예매 정보가 올바르지 않습니다.');");
                    out.println("history.back();");
                    out.println("</script>");
                    return;
                }
            }
            
        } else if (uri.endsWith("/MyReservationServlet")) {
            // 예매내역 조회 처리
            UserListVO loginUser = (UserListVO) session.getAttribute("loginUser");
            
            if (loginUser == null) {
                req.setAttribute("loginMsg", "로그인이 필요합니다.");
                forwardPage = "/login.jsp";
            } else {
                List<ReserveListVO> reservations = rdao.getReservationsByUserId(loginUser.getUserNo());
                req.setAttribute("reservations", reservations);
                forwardPage = "/history.jsp";
            }
            
        } else if (uri.endsWith("/DeleteReservationServlet")) {
            // 예매 취소 처리
            PrintWriter out = resp.getWriter();
            UserListVO loginUser = (UserListVO) session.getAttribute("loginUser");
            
            if (loginUser == null) {
                req.setAttribute("loginMsg", "로그인이 필요합니다.");
                forwardPage = "/login.jsp";
            } else {
                String reservationId = req.getParameter("id");
                
                if (reservationId != null) {
                    try {
                        boolean result = rdao.deleteReservation(Integer.parseInt(reservationId), loginUser.getUserNo());
                        
                        if (result) {
                            out.println("<script>");
                            out.println("alert('예매가 취소되었습니다.');");
                            out.println("location.href='reservationHistory.do';");
                            out.println("</script>");
                        } else {
                            out.println("<script>");
                            out.println("alert('예매 취소에 실패했습니다.');");
                            out.println("history.back();");
                            out.println("</script>");
                        }
                        return;
                    } catch (Exception e) {
                        out.println("<script>");
                        out.println("alert('오류가 발생했습니다.');");
                        out.println("history.back();");
                        out.println("</script>");
                        return;
                    }
                } else {
                    out.println("<script>");
                    out.println("alert('잘못된 요청입니다.');");
                    out.println("history.back();");
                    out.println("</script>");
                    return;
                }
            }
        }
        
        req.getRequestDispatcher(forwardPage).forward(req, resp);
    }
}