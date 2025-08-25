<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
/* 헤더 컨테이너 */
body {
    background-color: black;
}
.header-container {
    width: 100%;
    background-color: rgba(0, 0, 0, 0.9);
    font-family: 'Noto Sans KR', sans-serif;
}

/* 실제 검은색 배경 영역 */
.header-inner {
    max-width: 1200px;
    margin: 0 auto;
    background-color: #000;
    color: #eee;
    padding: 20px 0 60px;
    position: relative;
    text-align: center;
    box-sizing: border-box;
}

.brand .en {
    margin: 0;
    color: #FF7961;
    font-size: 1.6rem;
    font-weight: 700;
    letter-spacing: 0.1em;
}

.brand .ko {
    margin: 0;
    font-size: 1.3rem;
    font-weight: 700;
    letter-spacing: 0.1em;
}

/* 언더라인 */
.underline {
    width: 100%;
    border-bottom: 2px solid #666;
    margin: 20px auto 0;
}

/* 로그인/회원정보 영역 */
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
    margin-top: 15px;
}

.user-section button:hover {
    background-color: #333;
}

/* 사용자 이름 */
.user-name {
    color: orange;
    font-weight: bold;
    margin-right: 10px;
    margin-top: 14px;
}

/* 로고 */
.logo button {
    position: absolute;
    left: 6px;
    top: 16px;
    background-color: black;
    border: none;
    margin-top: 2px;
}
.logo img {
    width: 70px;
    height: 70px;
    border: none;
}

/* 언더라인 아래 메뉴 */
.ticketing_menu {
    display: flex;
    justify-content: center;
    gap: 18px;
    margin-top: 20px;
}

.ticketing_menu button {
    position: relative;
    background: transparent;
    border: none;
    color: #eee;
    padding: 8px 20px;
    border-radius: 5px;
    cursor: pointer;
    font-weight: 700;
    transition: color 0.3s;
}

/* 슬라이딩 밑줄 */
.ticketing_menu button::after {
    content: '';
    position: absolute;
    left: 50%;
    bottom: 0;
    width: 0;
    height: 3px;
    background-color: Orange;
    border-radius: 2px;
    transition: all 0.3s ease;
    transform: translateX(-50%);
}

/* 호버 시 밑줄 확장 및 글자 색상 변경 */
.ticketing_menu button:hover {
    
}

.ticketing_menu button:hover::after {
    width: 100%;
}
</style>

<div class="header-container">
    <div class="header-inner">
        <!-- 로고 -->
        <div class="logo">
            <form action="home.do">
                <button type="submit"><img src="asset/images/lxcinema.png"></button>
            </form>
        </div>
        
        <!-- 사용자 섹션 -->
        <div class="user-section">
            <% 
            userList.UserListVO loginUser = (userList.UserListVO)session.getAttribute("loginUser");
            if (loginUser != null) { 
            %>
                <span class="user-name"><%=loginUser.getUserName()%>님</span>
                <form action="myPage.do" style="display: inline;">
                    <button type="submit">마이페이지</button>
                </form>
                <form action="logout.do" style="display: inline;">
                    <button type="submit">로그아웃</button>
                </form>
            <% 
            } else { 
            %>
                <form action="login.jsp" method="post" style="display: inline;">
                    <button type="submit">로그인</button>
                </form>
                <form action="register.jsp" method="post" style="display: inline;">
                    <button type="submit">회원가입</button>
                </form>
            <% } %>
        </div>

        <!-- 사이트명 -->
        <h1 class="brand">
            <a href="home.do" style="color: inherit; text-decoration: none;">
                <div class="en">LX-CINEMA</div>
                <div class="ko">공간 시네마</div>
            </a>
        </h1>

        <!-- 언더라인 -->
        <div class="underline"></div>

        <!-- 메뉴 -->
        <div class="ticketing_menu">
            <form action="MovieListServlet" method="get" style="display: inline;">
                <button type="submit">예매</button>
            </form>
            <form action="MovieGalleryServlet" method="get" style="display: inline;">
                <button type="submit">영화</button>
            </form>
            <form action="event.do" method="get" style="display: inline;">
                <button type="submit">이벤트</button>
            </form>
        </div>
    </div>
</div>
