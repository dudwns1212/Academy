<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>이벤트</title>
<style>
body {
	margin: 0;
	font-family: Arial, sans-serif;
	background-color: #000;
	color: #fff;
}

/* 상단 배너 느낌 */
.event-banner {
	width: 100%;
	height: 70px;
	background-image: url('images/event-banner.jpg');
	background-size: cover;
	background-position: center;
	display: flex;
	align-items: center;
	justify-content: center;
	text-align: center;
	color: #fff;
	font-size: 36px;
	font-weight: bold;
	text-shadow: 2px 2px 6px rgba(0, 0, 0, 0.7);
}

.event-container {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	padding: 40px 20px;
	min-height: 100vh;
	box-sizing: border-box;
	max-width: 1300px; /* 컨테이너의 최대 너비를 3개 카드가 들어갈 크기로 제한 */
	margin: 0 auto; /* 컨테이너를 화면 중앙에 오도록 정렬 */
}

.event-card {
	background-color: #141414;
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
	width: 300px;
	margin: 20px;
	overflow: hidden;
	position: relative;
	transition: transform 0.3s;
	display: flex;
	flex-direction: column; /* 세로 정렬 */
}

.event-card:hover {
	transform: scale(1.05);
}

.event-card img {
	width: 100%;
	height: 180px;
	object-fit: cover;
}

.event-card-content {
	flex: 1; /* 남은 공간 채우기 */
	display: flex;
	flex-direction: column;
	justify-content: space-between; /* 버튼을 아래쪽으로 */
	padding: 20px;
	text-align: center;
}

.event-card-content h2 {
	margin: 10px 0;
	font-size: 22px;
	color: #e0e0e0;
	font-weight: bold;
}

.event-card-content p {
	font-size: 16px;
	margin: 10px 0;
	color: #ccc;
}

.event-card-content button {
	padding: 10px 20px;
	margin-top: 10px;
	background: linear-gradient(45deg, #E74C3C, #FF6B9D);
	border: none;
	border-radius: 5px;
	color: #fff;
	font-weight: bold;
	cursor: pointer;
	font-size: 16px;
}

.event-card-content button:hover {
	background: linear-gradient(45deg, #FF6B9D, #E74C3C);
}

@media ( max-width : 1000px) {
	.event-card {
		width: 45%;
	}
}

@media ( max-width : 600px) {
	.event-card {
		width: 90%;
	}
}
</style>
</head>
<body>

	<jsp:include page="/header.jsp" />

	<div class="event-banner">지금 진행 중인 이벤트</div>

	<div class="event-container">
		<!-- 이벤트 카드 1 -->
		<div class="event-card">
			<img src="asset/images/conjuring.jpg" alt="이벤트1">
			<div class="event-card-content">
				<h2>신작 시사회 초대</h2>
				<p>
					회원 전용 신작 영화 시사회에 <br> 참여해보세요!
				</p>
				<button onclick="alert('참여 완료!')">참여하기</button>
			</div>
		</div>

		<!-- 이벤트 카드 2 -->
		<div class="event-card">
			<img src="asset/images/popcorn.jpeg" alt="이벤트2">
			<div class="event-card-content">
				<h2>함께하면 달콤한 시간</h2>
				<p>
					2인이상 예매 시 <br>팝콘 1+1 행사 진행중!
				</p>
				<!-- c영화 예매 시 팝콘 1+1 쿠폰을 드립니다. -->
				<button onclick="alert('참여 완료!')">참여하기</button>
			</div>
		</div>

		<!-- 이벤트 카드 3 -->
		<div class="event-card">
			<img src="asset/images/coin.jpg" alt="이벤트3">
			<div class="event-card-content">
				<h2>영화는 1번, 포인트는 2번!</h2>
				<p>
					특정 영화 예매 시<br>포인트를 두 배로 적립!
				</p>
				<button onclick="alert('참여 완료!')">참여하기</button>
			</div>
		</div>

		<!-- 이벤트 카드 4 -->
		<div class="event-card">
			<img src="asset/images/f1.jpeg" alt="이벤트4">
			<div class="event-card-content">
				<h2>영화 굿즈 증정</h2>
				<p>
					신작 영화 예매 하고<br>한정 굿즈도 받아가세요!
				</p>
				<button onclick="alert('참여 완료!')">참여하기</button>
			</div>
		</div>

		<!-- 이벤트 카드 5 -->
		<div class="event-card">
			<img src="asset/images/couple.jpeg" alt="이벤트5">
			<div class="event-card-content">
				<h2>커플 예매 이벤트</h2>
				<p>
					커플 예매 시 티켓<br>티켓비용 120% 적용!
				</p>
				<button onclick="alert('....?')">참여하기</button>
			</div>
		</div>

		<!-- 이벤트 카드 6 -->
		<div class="event-card">
			<img src="asset/images/sns.jpeg" alt="이벤트6">
			<div class="event-card-content">
				<h2>SNS 인증 이벤트</h2>
				<p>
					영화 관람 후 SNS 인증 시<br>최대 5만원 스타벅스 쿠폰 증정!
				</p>
				<button onclick="alert('참여 완료!')">참여하기</button>
			</div>
		</div>
	</div>
<jsp:include page="/bottom.jsp"/>
</body>
</html>


