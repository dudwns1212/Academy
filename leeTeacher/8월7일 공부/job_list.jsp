<%@page import="java.util.List"%>
<%@page import="myjsp.EmpDAO"%>
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
// job_id_list를 출력
	List<String> jobList = EmpDAO.getJobList();
%>
<form action="emp_list.jsp">
	<select name="jobId">
		<% for(String jobId : jobList){ %>
		<option value="<%=jobId%>"><%=jobId%></option>
		<%} %>
	</select>
	<input type="submit" value="부서원보기">
</form>
<!-- select가 다른 것을 선택했을 때, eventhandler로 emp_list가 바뀌는 자바스크립트문을 작성 -->
</body>
<script type="text/javascript">
	let jobId = document.querySelector("#jobId")
	jobId.onchange = handleJobId;
	function handleJobId() {
		alert(jobId.value)
	}
</script>
</html>