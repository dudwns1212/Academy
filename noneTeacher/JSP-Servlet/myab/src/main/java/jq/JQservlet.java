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
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out= response.getWriter();
		String param= request.getParameter("type");
		String result=null;
		if(param==null|| param.equals("saladbar")){
			result= "{\"ashley\":\"애슐리\",\"lblue\":\"엘블루\"}";
		} else {
			result= "{\"sodam\":\"소담\",\"babnbool\":\"밥앤불고기\"}";
		}
		//String result="sample test";
		out.println(result);
		out.close();
	}

}
