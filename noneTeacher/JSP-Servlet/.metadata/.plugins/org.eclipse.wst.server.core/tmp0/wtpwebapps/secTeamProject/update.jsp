<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>정보 수정</title>
<style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
    background-color: #000;
    color: #fff;
}


.page-wrapper {
    background-image: url('asset/images/mypageback.jpg');
    background-size: cover;
    background-position: center;
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

/* ▼▼▼ 2. 헤더와 컨텐츠가 오버레이 위에 오도록 z-index 설정 ▼▼▼ */
.header-container, .register-container {
    position: relative;
    z-index: 2;
}

/* ▼▼▼ 3. 헤더 배경을 투명하게 만드는 스타일 추가 ▼▼▼ */
.header-container, .header-inner {
    background: transparent !important;
}

/* ▼▼▼ 4. 기존 register-container 스타일 수정 ▼▼▼ */
.register-container {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: calc(100vh - 150px); /* 헤더/푸터 높이를 제외한 영역을 채우도록 수정 */
    padding: 20px 0;
    /* 배경 관련 속성들은 page-wrapper로 옮겼으므로 모두 제거 */
}

/* 아래는 기존 스타일과 동일합니다 */
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
    font-size: 28px;
    font-weight: bold;
}

.register-box input {
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

.register-box button {
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
                <h1>정보 수정</h1>
                <form action="update.do" method="post">
                    <%
                    userList.UserListVO currentUser = (userList.UserListVO) session.getAttribute("loginUser");
                    %>
                    <input type="hidden" name="userNo"
                        value="<%=currentUser.getUserNo()%>"> <input type="text"
                        name="userId" placeholder="아이디 : <%=currentUser.getUserId()%>"
                        required> <input type="password" name="userPassword"
                        placeholder="비밀번호는 보안입니다." required> <input type="text"
                        name="userName" placeholder="이름 : <%=currentUser.getUserName()%>"
                        required> <input type="tel" name="userMobile"
                        placeholder="전화번호 : <%=currentUser.getUserMobile()%>" required>
                    <input type="number" name="userAge"
                        placeholder="나이 : <%=currentUser.getUserAge()%>" required>

                    <button type="submit" method="post">확인</button>
                    <a href="myPage.jsp">마이페이지로 돌아가기</a> <a
                        href="delete.do?userId=<%=currentUser.getUserId()%>"
                        onclick="return confirm('정말로 탈퇴하시겠습니까? 존재하는 모든 예매 내역이 삭제됩니다.')"> 
                        회원 탈퇴 </a>
                </form>

                <c:if test="${not empty errorMsg || not empty msg}">
                    <p style="color: red;">${errorMsg}</p>
                    <p style="color: blue;">${msg}</p>
                </c:if>
            </div>
        </div>

    </div> <jsp:include page="/bottom.jsp"/>

</body>
</html>