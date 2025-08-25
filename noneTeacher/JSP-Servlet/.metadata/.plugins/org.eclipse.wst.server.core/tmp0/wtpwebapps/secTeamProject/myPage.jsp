<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>마이페이지 - LX CINEMA</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
/* --- 1. body 태그 스타일 (수정) --- */
/* body에서는 전체 폰트와 글자색 등 기본 스타일만 남깁니다. */
body {
    margin: 0;
    color: #eee;
    font-family: 'Noto Sans KR', sans-serif;
    background-color: #000; /* 페이지 기본 배경색은 검정으로 설정 */
}

/* --- 2. 배경 이미지를 적용할 전체 래퍼(wrapper) 스타일 (추가) --- */
/* body에 있던 배경 이미지 관련 스타일을 이곳으로 옮깁니다. */
.page-wrapper {
    background-image: url('asset/images/mypageback.jpg'); 
    background-size: cover;
    background-position: center top; /* 이미지의 상단이 잘리지 않도록 top으로 조정 */
    background-repeat: no-repeat;
    /* background-attachment: fixed; 이 속성은 필요 시 사용 */
    
    /* 이미지 위에 어두운 오버레이를 씌우는 더 안정적인 방법 */
    position: relative;
}
.page-wrapper::before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(0, 0, 0, 0.7); /* 어두운 오버레이 효과 */
    z-index: 1;
}
/* 헤더와 메인 컨테이너가 오버레이 위에 오도록 z-index 설정 */
.header-container, .register-container {
    position: relative;
    z-index: 2;
}


/* --- 3. 헤더 스타일 (기존 스타일 유지) --- */
.header-container, .header-inner {
    background: none !important; /* 헤더의 검은 배경을 완전히 제거 */
}
.header-inner {
    border-bottom: 1px solid rgba(255, 255, 255, 0.2); 
    max-width: 1200px;
    margin: 0 auto;
    color: #eee;
    padding: 20px 0 60px;
    position: relative;
    text-align: center;
    box-sizing: border-box;
}
.header-inner h1 {
    margin: 0;
    font-size: 1.5rem;
    font-weight: 700;
    letter-spacing: 0.1em;
}
.user-section {
    position: absolute;
    right: 10px;
    top: 20px;
    font-size: 0.8rem;
    font-weight: 700;
    display: flex;
    gap: 10px;
    align-items: center;
}
.user-section button {
    background: transparent;
    border: 1px solid #666;
    color: #eee;
    padding: 5px 12px;
    border-radius: 5px;
    cursor: pointer;
    transition: 0.3s;
    margin-top: 15px
}
.user-section button:hover {
    background-color: #333;
}
.user-name {
	color: orange;
    font-weight: bold;
    margin-right: 10px;
    margin-top: 14px;
}
.ticketing_menu {
    display: flex;
    justify-content: center;
    gap: 15px;
    margin-top: 20px;
}
.ticketing_menu button {
    background: transparent;
    border: 1px solid #666;
    color: #eee;
    padding: 8px 20px;
    border-radius: 5px;
    cursor: pointer;
    font-weight: 700;
    transition: 0.3s;
}
.ticketing_menu button:hover {
    background-color: #333;
}
.logo button {
	position: absolute;
    left: 6px;
    top: 16px;
    border: none;
    margin-top: 2px;
}
.logo img {
	width: 70px;
	height: 70px;
	border: none;
}

/* --- 4. 마이페이지 고유 스타일 (기존 스타일 유지) --- */
.main-container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 40px 20px;
    box-sizing: border-box;
}
.page-title {
    text-align: center;
    margin-bottom: 100px;
    padding-top: 50px;
}
.page-title h1 {
    font-size: 2rem;
    font-weight: 700;
    margin: 0;
    background: linear-gradient(45deg, #E74C3C, #FF6B9D);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
}
.page-title p {
    margin: 10px 0 0;
    color: #999;
    font-size: 1rem;
    font-weight: 700;
}
.current-user-info {
    background: linear-gradient(45deg, #E74C3C, #FF6B9D);
    color: white;
    border-radius: 30px;
    padding: 20px;
    margin-bottom: 40px;
    text-align: center;
    max-width: 650px;
    margin-left: auto;
    margin-right: auto;
}
.current-user-info h3 { margin: 0; font-size: 1.2rem; }
.current-user-info p { margin: 5px 0 0; opacity: 0.9; }
.card-container {
    display: flex;
    justify-content: center;
    gap: 30px;
}
.edit-card, .check-card {
    width: 300px;
    background-color: #1a1a1a;
    border-radius: 15px;
    padding: 30px;
    border: 1px solid #333;
}
.edit-card h3, .check-card h3 { margin: 0 0 15px 0; font-size: 1.5rem; color: #fff; }
.edit-card p, .check-card p { margin: 0 0 25px 0; color: #999; font-size: 0.93rem; line-height: 1.5; font-weight: 700; }
.card-button {
    width: 100%; padding: 12px 20px; background: linear-gradient(45deg, #E74C3C, #FF6B9D);
    color: white; border: none; border-radius: 8px; font-size: 1rem; font-weight: 600;
}
#edit {
    height: 40px; width: 100%; margin-bottom: 5px; padding: 12px 20px; border-radius: 10px;
}
</style>
</head>
<body>

<!-- 새로 추가한 page-wapper 이걸로 컨트롤 했음 -->
<div class="page-wrapper">

    <%@ include file="header.jsp" %>

    <div class="register-container">
        <div class="main-container">
            <div class="page-title">
                <h1>마이페이지</h1>
                <p>회원정보 관리 및 예매 내역을 확인하세요</p>
            </div>
        
            <%
            userList.UserListVO currentUser = (userList.UserListVO)session.getAttribute("loginUser");
            %>
            <div class="current-user-info">
                <h3>환영합니다, <%=currentUser.getUserName()%>님!</h3>
                <p>회원 ID: <%=currentUser.getUserId()%></p>
            </div>
        
            <div class="card-container">
                <div class="edit-card">
                    <h3>회원정보 수정</h3>
                    <p>비밀번호를 확인하고 회원정보를 수정하세요</p>
                    <form action="checkPw.do" method="post">            	
                        <input type="password" name="pw" id="edit" placeholder="비밀번호를 입력하세요">
                        <input type="hidden" name="userNo" value="<%=currentUser.getUserNo()%>">
                        <button type="submit" class="card-button">정보 수정</button>
                        <c:if test="${not empty errorMsg}">
                            <p class="error-msg" style="color: red;">${errorMsg}</p>
                        </c:if>
                    </form>
                </div>
                <div class="check-card">
                    <h3>예매 확인</h3>
                    <p>여기서 예매한 내역를 확인하세요</p>
                    <form action="history.do">
                        <button type="submit" class="card-button">예매 내역</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
<jsp:include page="/bottom.jsp"/> 

</body>
</html>