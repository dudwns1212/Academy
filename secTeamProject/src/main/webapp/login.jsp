<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
    <a href="home.do">집</a>
    <p></p>

    <form action="login.do">
        <input type="text" name="id" placeholder="아이디를 입력하세요" required>
        <input type="password" name="pw" placeholder="비밀번호를 입력하세요" required>
        <button type="submit">로그인</button>
        <a href="register.do">회원가입</a>
    </form>

    <c:if test="${not empty errorMsg}">
        <p style="color:red;">${errorMsg}</p>
    </c:if>
</body>
</html>
