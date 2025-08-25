<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee 검색</h1>
	<form action="ex-05.jsp">
		<table>
			<tr>
				<td><select name="searchType">
						<option value="employeeId">employeeId</option>
						<option value="firstName">firstName</option>
						<option value="departmentId">departmentId</option>
					</select>
				</td>
				<td><input type="text" value="searchText"></td>
				<td><input type="submit" value="검색"></td>
			</tr>	
		</table>
	</form>
	<%
		String searchType = request.getParameter("searchType");
		if(searchType==null || searchType.length()==0){%>	
		전체를 출력한다. <br/>
<%		} else if(searchType.equals("employeeId")) {%>
		employee_id에 해당하는 조회결과를 출력한다. <br/>
<% 		} else if(searchType.equals("firstName")) {%>
		firstName에 해당하는 조회결과를 출력한다. <br/>
<%		} %>
</body>
</html>