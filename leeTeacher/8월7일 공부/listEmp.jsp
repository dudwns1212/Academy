<%@page import="java.util.ArrayList"%>
<%@page import="myjsp.EmpDAO"%>
<%@page import="java.util.List"%>
<%@page import="myjsp.EmployeeTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 조회</title>
</head>
<body>
<% 

%>
	<h2>출력 결과 확인</h2>
	<form action="listEmp.jsp">
		<select name="op">
			<option value="employee_id">employee_id</option>
			<option value="first_name">first_name</option>
			<option value="department_id">department_id</option>
		</select>
		<input type="text" name="ok">
		<button type="submit">search</button>
	</form>

<%
	String name = request.getParameter("ok");
	String column = request.getParameter("op");
	List<EmployeeTO> EmpList = new ArrayList<EmployeeTO>();

	if ("first_name".equals(column)) {
		EmpList = EmpDAO.getEmpListByName(name);
	} else if ("employee_id".equals(column)) {
		EmpList = EmpDAO.getEmpListByEmpId(name);
	} else if ("department_id".equals(column)) {
		EmpList = EmpDAO.getEmpListByDpId(name);
	} else {
		EmpList = EmpDAO.getEmpListALL();
	}
%>

	<p>
	<table cellspacing="2" cellpadding="2" border="1">
		<tr>
			<th>직원번호</th>
			<th>부서번호</th>
			<th>이름</th>
			<th>급여</th>
		</tr>

<%
		for(EmployeeTO emp : EmpList) {
%>
		<tr>
			<td><%= emp.getEmployeeId() %></td>
			<td><%= emp.getDepartmentId() %></td>
			<td><%= emp.getLastName() %></td>
			<td><%= emp.getSalary() %></td>
		</tr>
<%
		} 

%>

	</table>
</body>
</html>
