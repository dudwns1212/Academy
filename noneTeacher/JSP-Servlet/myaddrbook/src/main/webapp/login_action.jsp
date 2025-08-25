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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String forwardPage = "login.jsp";
	if(id!=null && id.equals(pw)){
		session.setAttribute("id", id);
		forwardPage = "addrbook_form.jsp";
	}
%>
<jsp:forward page="<%= forwardPage %>"></jsp:forward>
</body>
</html>