<%@page import="myjsp.EmployeeTO"%>
<%@page import="myjsp.EmpDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 클라이언트로 부터 전송된 데이터를 추출한다 --%>
<%-- job_list로 부터 전송된 파라미터를 jobId라는 스트링타입의 변수로 받음 --%>
<%
	String jobId = request.getParameter("jobId");
	List<EmployeeTO> empList = EmpDAO.getEmpList(jobId);
%>
<%
	for(EmployeeTO employInfo : empList){
%>	
		<%= employInfo %><br>
<%} %>


</body>
</html>