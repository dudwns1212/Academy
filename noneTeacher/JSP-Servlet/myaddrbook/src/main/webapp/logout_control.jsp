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
	session.setAttribute("id", null);
	// session.invalidate(); 위와 같음, 하지만 세션이 필요할 때마다 세션을 새로 만들어야되는 불편함이 있음
%>
<jsp:forward page="login.jsp"></jsp:forward>
</body>
</html>