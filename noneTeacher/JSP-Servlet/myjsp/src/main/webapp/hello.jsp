<%@page import="java.util.Date"%>
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

String user = request.getParameter("name");
	
	if(user==null) {
		user = "Guest";
	}
	
%>

Hello~! <%=user %>
<br/>
time : <%= new Date() %>
<br/>
<a href="http://www.naver.com">navvvver</a>
<form action="http://www.naver.com">
	<input type="submit" value="naver">
</form>

</body>
</html>