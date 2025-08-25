<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>나의 예매내역 - LX CINEMA</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
body {
	background: #000;
	color: #fff;
	font-family: 'Noto Sans KR', sans-serif;
}

.main-container {
   max-width: 1200px;
   margin: 0 auto;
   padding: 40px 20px;
   
}

.page-title {
   text-align: center;
   margin-bottom: 60px;
}
.page-title p {
   color: #fff;
   transform: translateY(-150%);
}

.page-title h1 {
   color: #ff2f6e;
   transform: translateY(-150%);
}

/* 카드 리스트 영역 - 가로 배치 */
.reservation-list {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
	justify-content: center;
}

/* 개별 카드 */
.reservation-card {
	background-color: rgba(30, 30, 30, 0.8);
	border: 1px solid #333;
	border-radius: 12px;
	padding: 20px;
	display: flex;
	flex-wrap: wrap;
	align-items: center;
	gap: 20px;
	width: 500px; /* 카드 너비 */
}

.poster img {
	width: 140px;
	border-radius: 8px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.6);
}

.reservation-info {
	flex: 1;
	min-width: 250px;
}

.reservation-info h4 {
	margin: 0 0 10px;
	color: #fff;
	font-size: 1.3rem;
}

.reservation-info p {
	margin: 4px 0;
	color: #ccc;
	font-size: 0.95rem;
}

/* 상태+삭제 버튼 영역 */
.status-actions {
	display: flex;
	align-items: center;
	gap: 10px;
	margin-top: 8px;
}

/* 예매완료 + 삭제 버튼 통일 스타일 */
.status-actions .badge-status, .status-actions .btn-delete {
	display: inline-block;
	padding: 6px 16px;
	border-radius: 20px; /* pill 모양 */
	background: #ff2f6e; /* 빨강 */
	color: #fff;
	font-weight: 600;
	font-size: 0.85rem;
	text-decoration: none;
	transition: background 0.3s;
	cursor: pointer;
}

.status-actions .badge-status:hover, .status-actions .btn-delete:hover {
	background: #444; /* hover 시 회색 */
}

/* 뒤로가기 버튼 */
.btn-back {
	display: inline-block;
	margin-top: 30px;
	padding: 12px 50px;
	border-radius: 8px;
	background: #ff2f6e;
	color: #fff;
	font-weight: 700;
	text-decoration: none;
	text-align: center;
	transform: translateX(45%);
}

/* 예매내역이 없을 때 */
.no-reservations {
	text-align: center;
	padding: 60px 20px;
	color: #ccc;
}

.no-reservations h3 {
	color: #ff2f6e;
	margin-bottom: 20px;
}

/* 모바일 대응 */
@media ( max-width : 768px) {
	.reservation-card {
		flex-direction: column;
		align-items: flex-start;
		width: 100%;
	}
	.poster img {
		width: 100%;
		max-width: 250px;
	}
	.btn-back {
		transform: none;
		width: 100%;
		text-align: center;
	}
}
</style>
</head>
<body>
<jsp:include page="/header.jsp" />

<div class="main-container">
	<div class="page-title">
		<h1>나의 예매내역</h1>
		<p>현장에서 발권하실 경우 반드시 예매번호를 확인하세요</p>
	</div>

	<!-- 카드 리스트 -->
	<div class="reservation-list">
		<c:choose>
			<c:when test="${empty reservations}">
				<div class="no-reservations">
					<h3>예매내역이 없습니다</h3>
					<p>지금 바로 영화를 예매해보세요!</p>
					<a href="MovieListServlet" class="btn-delete" style="margin-top: 20px;">영화 예매하기</a>
				</div>
			</c:when>
			<c:otherwise>
				<c:forEach var="reservation" items="${reservations}">
					<div class="reservation-card">
						<div class="poster">
							<img src="${reservation.moviePoster}" alt="${reservation.movieTitle} 포스터" 
								 onerror="this.src='asset/images/movie_default.png'">
						</div>
						<div class="reservation-info">
							<h4>${reservation.movieTitle}</h4>
							<p><strong>극장:</strong> ${reservation.cinemaName}</p>
							<p><strong>일시:</strong> ${reservation.showDate} ${reservation.showTime}</p>
							<p><strong>결제금액:</strong> <fmt:formatNumber value="${reservation.price}" pattern="#,###"/>원</p>
							<p><strong>예매번호:</strong> ${reservation.reservationId}</p>
							<p><strong>예매일시:</strong> 
								<fmt:parseDate value="${reservation.startTime}" pattern="yyyy-MM-dd HH:mm:ss" var="reservationDateTime"/>
								<fmt:formatDate value="${reservationDateTime}" pattern="yyyy-MM-dd HH:mm"/>
							</p>
							<div class="status-actions">
								<span class="badge-status">예매완료</span>
								<a href="javascript:void(0)" class="btn-delete" 
								   onclick="cancelReservation(${reservation.reservationId}, '${reservation.movieTitle}')">취소</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>

	<a class="btn-back" href="myPage.do">뒤로가기</a>
</div>

<script>
function cancelReservation(reservationId, movieTitle) {
	if (confirm('정말로 "' + movieTitle + '" 예매를 취소하시겠습니까?')) {
		location.href = 'DeleteReservationServlet?id=' + reservationId;
	}
}
</script>

<jsp:include page="/bottom.jsp"/>
</body>
</html>