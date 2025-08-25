package myaddrbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import addrbook.AddrBookDAO;
import addrbook.AddrBookVO;

@WebServlet("/addrbook.do")
public class AddrbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
    	//여기서 addrbook_control.jsp가 하는 일을 수행한다.
    	String action = req.getParameter("action");
    	String forwardPage = "/addrbook_list.jsp";
    	AddrBookDAO dao = new AddrBookDAO();
    	try {
    	
    	if("insert".equals(action)){
    		AddrBookVO ab = makeAddrBookFromReq(req);
    		dao.insertDB(ab); //객체를 통해 메서드 실행 / ab는 위의 유즈빈으로 가져온 파라미터들
    		List<AddrBookVO> list = dao.getDBList();
    		req.setAttribute("data", list);
    		
    	} else if("edit".equals(action)){
    		//1.클라이언트가 전송한 데이터 중에서 방명록id를 추출
    		String abIdStr = req.getParameter("ab_id");
    		//2.DB에서 해당 방명록 정보를 조회
    		AddrBookVO vo = dao.getDB(Integer.parseInt(abIdStr));
    		//3.방명록 정보를 request에 넣기
    		req.setAttribute("ab", vo);
    		forwardPage = "/addrbook_edit_form.jsp";
    		//pageContext.forward(forwardPage);
    	} else if("list".equals(action)){
    		List<AddrBookVO> list = dao.getDBList(); //리스트를 만들고
    		req.setAttribute("data", list); //data라는 이름으로 list값을 넣음
    		//pageContext.forward(forwardPage); // 위에서는 response로 끝냈지만 여기서는 안썻기에 list.jsp로 forward 해줘야함 
    		//jsp에서 꺼내서 출력한다.
    	} else if("delete".equals(action)){
    		String abIdStr = req.getParameter("ab_id");
    		AddrBookVO vo = dao.deleteDB(Integer.parseInt(abIdStr));
    	} else {
    		//forwardPage = "addrbook_form.jsp";
    	}
    } catch (Exception e) {
    
    }
	RequestDispatcher rd = getServletContext().getRequestDispatcher(forwardPage);
	rd.forward(req, res);
    }
    
	private AddrBookVO makeAddrBookFromReq(ServletRequest req) {
		AddrBookVO vo = new AddrBookVO();
		vo.setAbName(req.getParameter("abName"));
		vo.setAbBirth(req.getParameter("abBirth"));
		vo.setAbComdept(req.getParameter("abComdept"));
		vo.setAbEmail(req.getParameter("abEmail"));
		vo.setAbMemo(req.getParameter("abMemo"));
		vo.setAbTel(req.getParameter("abTel"));
		return vo;
		
	}

}
