<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
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
	Context initContext = new InitialContext();
	Context envContext = (Context) initContext.lookup("java:comp/env");
	DataSource dataSource = (DataSource) envContext.lookup("jdbc/mydb");
	Connection connection = dataSource.getConnection();
	String sql = "select distinct job_id from employees";
	PreparedStatement psmt = connection.prepareStatement(sql);
	ResultSet rs = psmt. executeQuery();
	while(rs.next()) {
		out.println(rs.getString(1) + "<br/>");
	}
	connection.close();
%>
</body>
</html>