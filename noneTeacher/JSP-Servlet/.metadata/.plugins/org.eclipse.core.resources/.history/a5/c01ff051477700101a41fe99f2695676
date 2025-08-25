package jq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JQServlet")
public class JQservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query= request.getParameter("type");
		response.setContentType("application/json;charset=euc-kr");
		PrintWriter out= response.getWriter();
		String param= request.getParameter("type");
		String result=null;
		if(param==null|| param.equals("saladbar")){
			result= "{\"ashley\":\"¾Ö½¶¸®\",\"lblue\":\"¿¤ºí·ç\"}";
		} else {
			result= "{\"sodam\":\"¼Ò´ã\",\"babnbool\":\"¹ä¾ØºÒ°í±â\"}";
		}
		//String result="sample test";
		out.println(result);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query= request.getParameter("type");
		//response.setContentType("text/html;charset=euc-kr");
		response.setContentType("application/json;charset=euc-kr");
		PrintWriter out= response.getWriter();
		String param= request.getParameter("type");
		String result=null;
		if(param==null|| param.equals("saladbar")){
			result= "{{\"value\":\"asuly\",\"alias\":\"¾Ö½¶¸®\"},{\"value\":\"asuly2\",\"alias\":\"¾Ö½¶¸®2\"}}";
		} else {
			result= "{{\"value\":\"sodam\",\"alias\":\"¼Ò´ã\"},{\"value\":\"babnbool\",\"alias\":\"¹ä¾ØºÒ°í±â\"}}";
		}
		//String result="sample test";
		out.println(result);
		out.close();
	}

}
