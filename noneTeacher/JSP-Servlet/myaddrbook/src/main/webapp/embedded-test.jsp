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
		String ip = request.getRemoteAddr();
		out.println(new Date() + ", ip= " + ip + "<br/>");
		System.out.println(new Date() + ", ip= " + ip);
	%>
</body>
</html>