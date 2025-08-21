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
<%
	String[] buyFruit = request.getParameterValues("fruit");
	List<String> fruitList = (List<String>)session.getAttribute("fruitList");
	Integer totalPrice = (Integer) session.getAttribute("totalPrice");
	
	if (fruitList == null) fruitList = new ArrayList<>(); //파리미터 값이 비어있을 때, null과 0으로 처리
    if (totalPrice == null) totalPrice = 0;
	
	if(buyFruit!=null) { // null이 아닐 때 실행 시작
		
		for(String fruit : buyFruit) {
			if(fruit.equals("체리")){
				fruitList.add("체리");
				totalPrice+=25000;
			} else if(fruit.equals("오렌지")){
				totalPrice+=23000;
				fruitList.add("오렌지");
			} else if(fruit.equals("사과")){
				totalPrice+=16000;
				fruitList.add("사과");
			}
		}
	}
	session.setAttribute("fruitList", fruitList);
	session.setAttribute("totalPrice", totalPrice);
%>

<form action="first.jsp">
	<table border="1" cellspacing="2" cellpadding="5">
		<tr>
			<td>구입한 과일</td>
			<td><%
				for(int i=0;i<fruitList.size();i++){
					out.print(fruitList.get(i));
					if(i<fruitList.size()-1){
						out.print("<br>");
					}
				}
			%></td>
		</tr>
		<tr>
			<td>합계</td>
			<td><%= totalPrice %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			    <input type="submit" value="과일구입화면">
			</td>
		</tr>
	</table>
</form>
</body>
</html>