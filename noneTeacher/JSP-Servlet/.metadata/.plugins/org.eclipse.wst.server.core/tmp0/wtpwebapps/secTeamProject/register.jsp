<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<style>
body {
	margin: 0;
	font-family: Arial, sans-serif;
	background-color: #000;
	color: #fff;
}

/* -- 1. 배경 이미지를 적용할 전체 래퍼(wrapper) 스타일 (추가) -- */
.page-wrapper {
	background-image: url('asset/images/mypageback.jpg'); /* 배경 이미지 경로 확인 필요 */
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

/* --- 2. 헤더와 콘텐츠 z-index 설정 (추가) --- */
.header-container, .register-container {
	position: relative;
	z-index: 2;
}

/* 헤더 배경 투명화 (추가) */
.header-container, .header-inner {
	background: transparent !important;
}


/* --- 3. 기존 register-container 스타일 (수정) --- */
/* 배경 관련 스타일은 제거하고 레이아웃만 남깁니다. */
.register-container {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: calc(100vh - 80px); /* 헤더 높이(80px 가정)를 뺀 높이 */
    padding: 40px 0; /* 너무 붙지 않도록 상하 여백 추가 */
}

.register-box {
	background-color: #141414;
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
	width: 400px;
	text-align: center;
}

.register-box h1 {
	margin-bottom: 30px;
	color: #e0e0e0;
	font-size: 28px;
	font-weight: bold;
}

.register-box input {
	box-sizing: border-box; /* 너비 계산이 쉽도록 추가 */
	width: 100%;
	padding: 12px 15px;
	margin: 10px 0;
	border: none;
	border-radius: 5px;
	background-color: #333;
	color: #fff;
	font-size: 16px;
}

.register-box input::placeholder {
	color: #aaa;
}

.register-box button[type="submit"] {
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

.register-box button:hover {
	background: linear-gradient(45deg, #FF6B9D, #E74C3C);
}

.register-box a {
	display: block;
	margin-top: 15px;
	color: #aaa;
	text-decoration: none;
}

.register-box a:hover {
	color: #fff;
	text-decoration: underline;
}

.input-row {
  display: flex;
  gap: 6px;
  align-items: center;
}

.input-row input {
  flex: 1;
}

.btn-inline {
  width: auto;
  margin: 0;
  padding: 11px 15px; /* 높이를 input과 맞추기 위해 조정 */
  font-size: 14px;
  background: #555;
  border: none;
  border-radius: 5px;
  color: #fff;
  cursor: pointer;
  font-weight: bold;
}

.btn-inline:hover {
  background: #666;
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

		<div class="register-container">
			<div class="register-box">
				<h1>회원가입</h1>
				<form action="register.do" method="post" id="registerForm">
					<input type="hidden" name="userNo">
					
					<div class="input-row">
						<input type="text" name="userId" id="userId" placeholder="아이디를 입력하세요"
							required
							oninput="resetIdStatus()"> <button type="button" id="checkIdBtn" class="btn-inline">중복확인</button>	
					</div>
					<small id="idStatus"
						   style="display: block; text-align: left; padding: 5px 0; color: ${empty idStatusColor ? '#aaa' : idStatusColor};">
					  <c:out value="${empty idStatusMsg ? '아이디 중복여부를 확인하세요.' : idStatusMsg}"/>
					</small>
					
					<input type="password" name="userPassword" placeholder="비밀번호를 입력하세요" required> 
					<input type="text" name="userName" placeholder="이름을 입력하세요" required> 
					<input type="tel" name="userMobile" placeholder="전화번호를 입력하세요" required> 
					<input type="number" name="userAge" placeholder="나이를 입력하세요" required>

					<button type="submit" id="submitBtn">회원가입</button>
					<a href="login.jsp">로그인 페이지로 돌아가기</a>
				</form>

				<c:if test="${not empty errorMsg || not empty msg}">
					<p style="color: red;">${errorMsg}</p>
					<p style="color: blue;">${msg}</p>
				</c:if>
			</div>
		</div>

	</div>
	<script>

let idAvailable = false;

// 입력 바뀌면 상태 초기화
function resetIdStatus() {
	idAvailable = false;
	const status = document.getElementById('idStatus');
	status.textContent = '아이디 중복여부를 확인하세요'
	status.style.color = '#aaa';
}

// 아이디 규칙: 4자 이상만 체크
function validateUserId(uid) {
	return uid && uid.trim().length >= 4;
}

// 중복확인 버튼 클릭
document.getElementById('checkIdBtn').addEventListener('click', async () => {
	const userId = document.getElementById('userId').value.trim();
	const status = document.getElementById('idStatus');
	
	if (!validateUserId(userId)) {
		status.textContent = '아이디는 최소 4자 이상이어야 합니다.';
		status.style.color = '#e87c03';
		return;
	}
	
	try {
		// 서버에 중복 여부 조회 (checkId.do는 {"available":true/false} 반환)
		const url = 'checkId.do?userId=' + encodeURIComponent(userId);
		const res = await fetch(url, {
			method: 'GET',
			headers: { 'Accept': 'application/json' }
		});
		
		if (!res.ok) throw new Error('HTTP ' + res.status);
		const data = await res.json();
		
		if (data && data.available === true) {
			status.textContent = '사용 가능한 아이디입니다.';
			status.style.color = '#4caf50';
			idAvailable = true;
		} else {
			status.textContent = '이미 사용 중인 아이디입니다.';
			status.style.color = '#e87c03';
			idAvailable = false;
		}
	} catch (e) {
		console.error(e);
		status.textContent = '중복확인 중 오류가 발생했습니다.';
		status.style.color = '#e87c03';
		idAvailable = false;
	}
});

// 중복확인 없이 제출하려 하면 막기
document.getElementById('registerForm').addEventListener('submit', (e) => {
	if (!idAvailable) {
		e.preventDefault();
		const status = document.getElementById('idStatus');
		status.textContent = '아이디 중복확인을 먼저 진행해주세요.';
		status.style.color = '#e87c03';
	}
});
</script>
<jsp:include page="/bottom.jsp"/>
</body>
</html>