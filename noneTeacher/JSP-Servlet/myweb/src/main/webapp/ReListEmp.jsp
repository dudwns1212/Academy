<%@page import="myjsp.ReTo"%>
<%@page import="java.util.List"%>
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
	<h2>출력 결과 확인</h2>
	<select name="so">
		<option value="employee_id">employee_id</option>
		<option value="first_name">employee_id</option>
		<option value="department_id">employee_id</option>
	</select>
	<input type="text" name="to">
	<input type="submit" value="전송">
<% 
	String S = request.getParameter("to");
	String I = request.getParameter("so");
	List<ReTo> EmpList = new ArrayList<ReTo>();
	
	if ("first_name".equals(I)) {
		
	}
%>
	
	
</body>
</html>