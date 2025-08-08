<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>emp_list</h1>
<%
	String action = request.getParameter("action");
	out.println(action + "<br/>");
%>
<%= action %>
<p>jsp forward를 하면 이렇게 넘어오는구나 </p>
</body>
</html>