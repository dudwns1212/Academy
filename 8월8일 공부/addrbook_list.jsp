<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="addrbook_error.jsp" import="java.util.*, addrbook.*"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="addrbook.css" type="text/css" media="screen" />

<script type="text/javascript">
	function check(ab_id) {
		//pwd = prompt('수정/삭제 하려면 비밀번호를 넣으세요');
		document.location.href="addrbook_control.jsp?action=edit&ab_id="+ab_id;
		//document.location.href="editview.do?ab_id="+ab_id+"&upasswd="+pwd;
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록:목록화면</title>

</head>
<%-- 
<jsp:useBean id="data" scope="request" type="java.util.List<AddrBookVO>" />
--%>
<body>
<div align="center"> 
<H2>주소록:목록화면</H2>
<HR>
<form>
<a href="addrbook_form.jsp">주소록 등록</a><P>

		<table border="1">
			<tr><th>번호</th><th>이 름</th><th>전화번호</th><th>생 일</th><th>회 사</th><th>메 모</th></tr>
			<%					
				List<AddrBookVO> data = (ArrayList<AddrBookVO>)request.getAttribute("data"); // -> control.jsp의 list를 받아옴
				if(data!=null){					
				for(AddrBookVO  ab : (ArrayList<AddrBookVO>)data) {
			%>
			  <tr>
			   <td><a href="javascript:check(<%=ab.getAbId()%>)"><%=ab.getAbId() %></a></td>
				<td><%=ab.getAbName() %></td>
				<td><%=ab.getAbTel() %></td>
				<td><%=ab.getAbBirth() %></td>
				<td><%=ab.getAbComdept() %></td>
				<td><%=ab.getAbMemo() %></td>
			  </tr>
			 <%
				}
				}
			 %>
		</table>
</form>

</div>
</body>
</html>