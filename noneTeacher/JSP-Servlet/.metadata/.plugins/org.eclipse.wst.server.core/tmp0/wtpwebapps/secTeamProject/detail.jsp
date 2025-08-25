<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>${movie.title}- 상세보기</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background: #000; /* 전체 배경 검정 유지 */
	color: #fff;
	font-family: 'Noto Sans KR', sans-serif;
}

.container {
	padding: 40px 20px;
}

.detail-panel {
	background: rgba(255, 255, 255, 0.15); /* 반투명 유리판 */
	backdrop-filter: blur(12px);
	-webkit-backdrop-filter: blur(12px); /* 사파리 호환 */
	border-radius: 16px;
	padding: 100px;
	max-width: 1000px;
	min-height: 700px;
	margin: 20px auto;
	box-shadow: 0 8px 25px rgba(0, 0, 0, 0.6);
	color: #fff;
}

.movie-detail {
	display: flex;
	gap: 30px;
	flex-wrap: wrap;
}

.poster {
	flex: 1;
	min-width: 280px;
}

.poster img {
	width: 100%;
	border-radius: 12px;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.6);
}

.info {
	flex: 2;
	min-width: 300px;
}

.info h2 {
	margin-bottom: 15px;
}

.story-container {
	margin-top: 20px;
}

.story-content {
	max-height: 270px; /* 줄거리 스크롤 */
	overflow-y: auto;
	padding: 15px;
	background: rgba(255, 255, 255, 0.08); /* 줄거리도 유리판 느낌 */
	border-radius: 10px;
	line-height: 1.6;
	color: #fff;
}

.btn.brand { /* 예매버튼 */
	padding: 10px 100px;
	border-radius: 8px;
	background: #ff2f6e;
	color: #fff;
	text-decoration: none;
	text-align: center;
	font-weight: 700;
	transition: opacity 0.3s ease;
}
.trailer {
	margin-top: 30px;
}

.trailer iframe {
	width: 100%;
	height: 250px;
	border-radius: 12px;
	border: none;
}

@media ( max-width : 768px) {
	.movie-detail {
		flex-direction: column;
		gap: 20px;
	}
	.poster, .info {
		min-width: 100%;
	}
}
</style>
</head>
<body>
	<jsp:include page="/header.jsp" />

	<div class="container">
		<div class="detail-panel">
			<div class="movie-detail">
				<!-- 포스터 영역 -->
				<div class="poster">
					<img src="${selectedMovie.poster}" alt="${selectedMovie.movieTitle} 포스터">
					
				</div>

				<!-- 영화 정보 영역 -->
				<div class="info">
					<h2>${selectedMovie.movieTitle}</h2>
					<p>
						<strong>가격:</strong> ${selectedMovie.moviePrice}원 <strong>장르:</strong> ${selectedMovie.genre} <strong>상영시간:</strong> ${selectedMovie.movieTime}분
					</p>
				

					<!-- 줄거리 -->
					<div class="story-container">
						<h5>줄거리</h5>
						<div class="story-content">
							
							${selectedMovie.synopsis}  

						</div>
					</div>
						
					
				</div>
				<a class="btn brand"
									href="MovieGalleryServlet">뒤로가기</a>
			</div>
		</div>
	</div>
<jsp:include page="/bottom.jsp"/>
</body>
</html>
