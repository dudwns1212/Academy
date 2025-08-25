<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
<style>
body {
	margin: 0;
	font-family: Arial, sans-serif;
	background-color: #000;
	color: #fff;
}

/* --- 1. 배경 이미지를 적용할 전체 래퍼(wrapper) 스타일 --- */
.page-wrapper {
	background-image: url('asset/images/mypageback.jpg');
	background-size: cover;
	background-position: center top;
	background-repeat: no-repeat;
	position: relative;
	min-height: 100vh;
}

.page-wrapper::before {
	content: '';
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: rgba(0, 0, 0, 0.7);
	z-index: 1;
}

/* --- 2. 헤더와 로그인 컨테이너 z-index 설정 --- */
.header-container, .login-container {
	position: relative;
	z-index: 2;
}

/* --- ★★★ 진짜 해결을 위한 코드 (수정) ★★★ --- */
/* 헤더와 헤더 '내부(inner)'의 배경까지 모두 투명하게 만듭니다. */
.header-container, .header-inner {
	background: transparent !important;
}
/* ------------------------------------------- */

/* --- 3. 기존 로그인 컨테이너 스타일 --- */
.login-container {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: calc(100vh - 80px);
	padding: 20px 0;
}

.login-box {
	background-color: #141414; /* 로그인 박스 배경 */
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
	width: 350px;
	text-align: center;
	/* z-index는 이제 필요 없으므로 제거해도 됩니다. */
}

.login-box h1 {
	margin-bottom: 30px;
	font-size: 28px;
	font-weight: bold;
	color: #e0e0e0;
}

.login-box input {
	width: 100%;
	padding: 12px 15px;
	margin: 10px 0;
	border: none;
	border-radius: 5px;
	background-color: #333;
	color: #fff;
	font-size: 16px;
}

.login-box input::placeholder {
	color: #aaa;
}

.login-box button {
	width: 100%;
	padding: 12px;
	margin-top: 20px;
	background: linear-gradient(45deg, #E74C3C, #FF6B9D);
	border: none;
	border-radius: 5px;
	color: #fff;
	font-size: 18px;
	cursor: pointer;
	font-weight: bold;
}

.login-box button:hover {
	background: linear-gradient(45deg, #FF6B9D, #E74C3C);
}

.login-box a {
	display: block;
	margin-top: 15px;
	color: #aaa;
	text-decoration: none;
}

.login-box a:hover {
	color: #fff;
	text-decoration: underline;
}

.error-msg {
	color: #e87c03;
	margin-top: 15px;
}
</style>
</head>
<body>

	<div class="page-wrapper">

		<jsp:include page="/header.jsp" />
		<% 
    String loginMsg = (String) request.getAttribute("loginMsg");
    if (loginMsg != null) {
    %>
		<script>
        alert('<%= loginMsg %>');
    </script>
		<%
    }
    %>
		<div class="login-container">
			<div class="login-box">
				<h1>로그인</h1>
				<form action="login.do" method="post">
					<input type="text" name="id" placeholder="아이디를 입력하세요" required>
					<input type="password" name="pw" placeholder="비밀번호를 입력하세요" required>
					<button type="submit">로그인</button>
					<a href="register.jsp">회원가입</a>
				</form>
				<c:if test="${not empty errorMsg}">
					<p class="error-msg">${errorMsg}</p>
				</c:if>
			</div>
		</div>

	</div>
<jsp:include page="/bottom.jsp"/>
</body>
</html>