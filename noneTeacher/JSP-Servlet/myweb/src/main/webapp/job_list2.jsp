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

	List<String> jobList = EmpDAO.getJobList();
%>
<form action="emp_list.jsp">
	<select id="jobId" name="jobId">  <!-- onshange="handleJobId()" 이렇게 사용도 가능하지만 하지말아야 하는 방식! -->
		<% for(String jobId : jobList){ %>
		<option value="<%=jobId%>"><%=jobId%></option>
		<%} %>
	</select>
	<input type="submit" value="해당직무직원목록조회">
</form>
<script type="text/javascript">
	/*
 		1. select 태그를 참조한다.
 		2. select 태그의 선택이 변경되면 함수가 실행되게 한다.
 	*/
 	// let jobId = document.getElementById("jobId");
	let jobId = document.querySelector("#jobId");
	// eventhandler를 등록
 	
	jobId.addEventListener("change", handleJobId);
	
	//jobId.onchange = handleJobId; 위의 방식과 아래의 방식으로 나눠짐
 	function handleJobId() {
		alert(jobId.value);
 	}
	


</script>
</body>
</html>