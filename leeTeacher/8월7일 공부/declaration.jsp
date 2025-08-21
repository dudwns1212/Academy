<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	// 지역 변수를 생성 여기서만 사용 가능 / java 구문을 페이지에 삽입
	String str = "jsp"; 
	name = "newlx12";  // name이 인스턴스 변수로 만들어졌기 때문에 오류가 발생하지 않음
%>
<%! // 인스턴스 변수 생성
	String name = "lx12";
%>
<%=
	// 자바 표현식을 문자열로 출력
%>
<!-- 페이지 전체에 적용되는 조건을 설정, 보통 import-->
<%@%>

<%-- 그냥 주석 --%>
</body>
</html>