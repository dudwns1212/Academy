<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Map<String, String> menuList = new HashMap<String, String>();
	menuList.put("jja", "짜장면");
	menuList.put("jjam", "짬뽕");
	menuList.put("ls", "라면");
	menuList.put("kim", "김");
	menuList.put("can", "참치캔");
	menuList.put("hamberger", "햄버거");
%>
<%
	Map<String, String> hobbyList = new HashMap<String, String>();
	hobbyList.put("sports", "운동");
	hobbyList.put("music", "음악");
	hobbyList.put("trip", "여행");
%>
<% 
	request.setCharacterEncoding("utf-8");  // post 방식으로 전송해도 한글이 안깨지도록 설정
	String name = request.getParameter("name");
	String menu = request.getParameter("dinner");
	String email = request.getParameter("email");
	String[] hobbies = request.getParameterValues("hobby");
%>
당신의 이름은 : <%= name %> 이군요!
<br>
이메일은 <%= email %> 입니다.
<br>
<%
	int i=0;
	if(hobbies != null) {
		out.print("취미로는 ");
		for(i=0;i<hobbies.length;i++) {
			String h = hobbies[i];
			String g = hobbyList.get(h);
			out.print(g);
			
			if(i < hobbies.length -1) {
				out.print(", ");
			}
%>
<% 
		}
		out.print("이군요!");
	}
%>
<br>
<%
	if(menuList.containsKey(menu)) {
		String dinner = menuList.get(menu);
		out.print("저녁으로는 " + dinner + "을 드시려 하시는군요!");
	}
%>
<p>
<%
	Enumeration paramList = request.getParameterNames();
	while(paramList.hasMoreElements()) {
		String param = (String)paramList.nextElement();
		String value = request.getParameter(param);
		out.print(param + "=" + value + "<br>");
	}
%>
</body>
</html>