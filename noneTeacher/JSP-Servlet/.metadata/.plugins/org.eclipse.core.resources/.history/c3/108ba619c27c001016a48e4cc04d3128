<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="ko">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1" /> 

<title>영화관 홈페이지</title>

<!-- Bootstrap CSS -->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
:root{
  --page-max: 1200px;     /* 헤더의 기준 폭과 동일 */
  --page-pad-x: 20px;     /* 좌우 패딩 */
  --grid-gap: 45px;       /* 카드 간격 */
  --card-min: 200px;      /* 카드 최소폭 */
}

/* --------------------------

   전체 페이지 기본 스타일

--------------------------- */
body {
	background-color: #000;
	color: #eee;
	font-family: 'Noto Sans KR', sans-serif;
	margin: 0;
}

.container {
    min-height: 100vh; /* 최소 화면 높이 */
    padding: 40px var(--page-pad-x) 80px; /* 아래 여유 공간 확보 */
	max-width: var(--page-max);
	margin: 0 auto;
	box-sizing: border-box;
}

section {
	margin: 40px 0 28px;
}

.sec-head {
	display: flex;
	align-items: baseline;
	justify-content: flex-start;
	margin-bottom: 14px;
}

.sec-title {
	font-size: 22px;
	font-weight: 800;
	color: #eee;
}

/* --------------------------

   영화 카드 그리드

--------------------------- */
.grid {
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(var(--card-min), 1fr));;
	gap: var(--grid-gap);
	justify-content: stretch;
}

/* --------------------------

   카드 스타일

--------------------------- */
.card {
	width: 100%;
	aspect-ratio: 2 / 3;   /* 높이 비율 고정 */
	height: auto;
	background: #151822;
	border-radius: 12px;
	overflow: hidden;
	position: relative;
	cursor: pointer;
	font-weight: 700;
	transition: 0.3s;
}

.poster {
	position: relative;
	aspect-ratio: 2/3;
	background: #0c0f15;
}

.poster img {
	width: 100%;
	height: 100%;
	object-fit: cover;
	display: block;
}

/* 카드 후버 오버레이 */
.overlay {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(128, 128, 128, 0.5);
	opacity: 0;
	transition: opacity 0.3s ease;
	z-index: 1;
}

.card:hover .overlay {
	opacity: 1;
}

/* 순위 뱃지 */
.rank-badge {
	position: absolute;
	left: 8px;
	top: 8px;
	background: gold;
	color: #111;
	border-radius: 8px;
	padding: 6px 10px;
	font-weight: 900;
	font-size: 14px;
	z-index: 3;
}

/* 좋아요 버튼 */
.like-btn {
	position: absolute;
	right: 8px;
	top: 8px;
	background: rgba(0, 0, 0, .45);
	width: 36px;
	height: 36px;
	border-radius: 10px;
	display: grid;
	place-items: center;
	cursor: pointer;
	color: #fff;
	z-index: 3;
}

/* 좋아요 숫자 */
.like-count{
	position: absolute;
	z-index: 3;
	right: 52px;
	top: 10px;
	height: 28px;
	padding: 0 10px;
	display: inline-flex;
	align-items: center;
	border-radius: 8px;
	background: rgba(0,0,0,.45);
	color: #fff;
	font-weight: 700;
	font-size: 13px;
	line-height: 28px;
}

/* 카드 후버 버튼 */
.card-foot {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	z-index: 2;
	display: flex;
	flex-direction: column;
	gap: 8px;
	opacity: 0;
	transition: opacity 0.3s ease;
	z-index: 2;
}

.card:hover .card-foot {
	opacity: 1;
}

.btn.brand {      /* 카드 예매버튼 */ 
	padding: 8px 14px;
	border-radius: 8px;
	background: #ff2f6e;
	color: #fff;
	text-decoration: none;
	text-align: center;
	font-weight: 700;
	transition: opacity 0.3s ease;
}

.btn.detail { /* 카드 상세정보 버튼 */
	padding: 8px 14px;
	border-radius: 8px;
	background: #ff2f6e;
	color: #fff;
	text-decoration: none;
	text-align: center;
	font-weight: 700;
	transition: opacity 0.3s ease;
}

/* 카드에 커서 올린 상태: 두 버튼은 기본 투명 아웃라인 */
.card:hover .card-foot .btn.brand,
.card:hover .card-foot .btn.detail {
	 background: transparent;
	 color: #ff2f6e;
	 border-color: #ff2f6e;
}

/* 버튼 자체에 커서 올리면: 그 버튼만 핑크로 강조 */
.card:hover .card-foot .btn.brand:hover,
.card:hover .card-foot .btn.detail:hover,
.card:hover .card-foot .btn.brand:focus-visible,
.card:hover .card-foot .btn.detail:focus-visible {
	background: #ff2f6e;
	color: #fff;
	border-color: #ff2f6e;
}

/* --------------------------

   카드 아래 영화 정보

--------------------------- */
.movie-wrapper {
	display: flex;
	flex-direction: column;
	gap: 6px;
	width: 200px;
}

.movie-info {
	display: flex;
	align-items: center;
	justify-content: space-between;
	gap: 8px;
	font-size: 14px;
	color: #eee;
	padding: 0 4px;
	box-sizing: border-box;
}

.movie-title {
	font-weight: 700;
	flex: 1;
	min-width: 0;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.movie-time {
	font-weight: 500;
	flex: 0 0 auto;
	white-space: nowrap;
}

/* --------------------------

   캐러셀 스타일

--------------------------- */
.carousel.slide {
  width: 100%;
}

.carousel-item img {
	max-height: 400px;
	object-fit: cover;
}

/* ===== 장르 칩 ===== */
.genre-filter {
  display: flex;
  gap: 10px;
  margin-top: 10px;
  overflow-x: auto;               /* 모바일 가로 스크롤 */
  padding-bottom: 2px;            /* 스크롤바와 살짝 띄움 */
  scrollbar-width: none;          /* 파폭 스크롤바 숨김 */
}
.genre-filter::-webkit-scrollbar { display: none; }  /* 크롬 스크롤바 숨김 */

.genre-chip {
  display: inline-flex;
  align-items: center;
  height: 34px;
  padding: 0 14px;
  border: 1px solid #2a2a2a;
  border-radius: 999px;           /* 캡슐 */
  color: #eee;
  text-decoration: none;
  font-weight: 700;
  white-space: nowrap;
  transition: border-color .15s ease, background-color .15s ease, transform .1s ease;
}
.genre-chip:hover { border-color: #3a3a3a; background: #101010; transform: translateY(-1px); }
.genre-chip:focus-visible { outline: 2px solid #ff2f6e; outline-offset: 2px; }

/* 활성 칩 */
.genre-chip.active {
  border-color: #ff2f6e;
  background: rgba(255,47,110, .08);
}

/* 섹션 제목과 같은 줄 배치 */
.sec-head { align-items: center; gap: 14px; flex-wrap: wrap; }
.sec-title { margin-right: 6px; }

</style>

</head>
<body>

	<!-- 공통 헤더 include -->

	<jsp:include page="/header.jsp" />



	<main class="container">

		<!-- --------------------------

     Bootstrap 캐러셀

--------------------------- -->

		<div id="movieCarousel" class="carousel slide" data-bs-ride="carousel">

			<div class="carousel-inner">

				<div class="carousel-item active">

					<img
						src="asset/images/love.png"
						class="d-block w-100" alt="슬라이드1">

					<div class="carousel-caption d-none d-md-block"></div>

				</div>

				<div class="carousel-item">

					<img
						src="asset/images/lx.png"
						class="d-block w-100" alt="슬라이드2">

				</div>

				<div class="carousel-item">

					<img src="asset/images/princess.png" class="d-block w-100" alt="슬라이드3">

				</div>

			</div>

			<button class="carousel-control-prev" type="button"
				data-bs-target="#movieCarousel" data-bs-slide="prev">

				<span class="carousel-control-prev-icon" aria-hidden="true"></span>

				<span class="visually-hidden">Previous</span>

			</button>

			<button class="carousel-control-next" type="button"
				data-bs-target="#movieCarousel" data-bs-slide="next">

				<span class="carousel-control-next-icon" aria-hidden="true"></span>

				<span class="visually-hidden">Next</span>

			</button>

		</div>



		<!-- --------------------------

     인기 상영작 TOP

--------------------------- -->

		<section>

			<%-- 현재 선택된 장르를 읽어서 active 클래스 부여 --%>
			<%
			  String selected = request.getParameter("genre");  // null이면 전체(기본)
			%>
			
			<div class="sec-head">
			  <div class="sec-title">
			    인기 상영작 <span style="color:#ff2f6e">TOP</span>
			  </div>
		
			  <nav class="genre-filter" aria-label="장르 필터">
			    <%-- 필요시 '전체' 탭도 추가 --%>
			    <a class="genre-chip <%= (selected==null ? "active" : "") %>" href="MovieGalleryServlet">전체</a>
			    <a class="genre-chip <%= "로맨스".equals(selected) ? "active" : "" %>" href="MovieGenreServlet?genre=로맨스">로맨스</a>
			    <a class="genre-chip <%= "느와르".equals(selected) ? "active" : "" %>" href="MovieGenreServlet?genre=느와르">느와르</a>
			    <a class="genre-chip <%= "뮤지컬".equals(selected) ? "active" : "" %>" href="MovieGenreServlet?genre=뮤지컬">뮤지컬</a>
			    <a class="genre-chip <%= "좀비".equals(selected) ? "active" : "" %>" href="MovieGenreServlet?genre=좀비">좀비</a>
			    <a class="genre-chip <%= "가족".equals(selected) ? "active" : "" %>" href="MovieGenreServlet?genre=가족">가족</a>
			    <a class="genre-chip <%= "액션".equals(selected) ? "active" : "" %>" href="MovieGenreServlet?genre=액션">액션</a>
			    <a class="genre-chip <%= "애니메이션".equals(selected) ? "active" : "" %>" href="MovieGenreServlet?genre=애니메이션">애니메이션</a>
			  </nav>
			</div>

			<!-- 영화 카드 그리드 -->

			<div class="grid" id="movieGrid">
				
				<!-- JSTL forEach를 사용하여 영화 목록을 반복 출력 -->
				<c:forEach var="movie" items="${movieList}" varStatus="status">
					<div class="movie-wrapper">

						<article class="card">

							<div class="poster">

								<img src="${movie.poster}" alt="${movie.movieTitle}">

								<div class="rank-badge">${status.count}</div>

								<c:set var="isLiked" value="${likedMap != null && likedMap[movie.movieId] == true}" />
								
								<div class="like-btn"
								     data-movie-id="${movie.movieId}"
								     aria-pressed="${isLiked ? 'true' : 'false'}"
								     title="좋아요">
								  <c:choose>
								    <c:when test="${isLiked}">♥</c:when>
								    <c:otherwise>♡</c:otherwise>
								  </c:choose>
								</div>
								
								<span class="like-count" id="like-count-${movie.movieId}">
								  <c:out value="${movie.likeCount}" default="0" />
								</span>

								<div class="overlay"></div>

							</div>

							<div class="card-foot">
								
								<a class="btn brand" href="MovieListServlet">예매하기</a> 
								<a class="btn detail" href="OneMovieServlet?movieId=${movie.movieId}">상세정보</a>

							</div>

						</article>

						<div class="movie-info">

							<span class="movie-title">${movie.movieTitle}</span> 
							<span class="movie-time">⏱ ${movie.movieTime}분</span>

						</div>

					</div>
				</c:forEach>

			</div>
			<!-- /grid -->

		</section>

	</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
document.querySelectorAll('.like-btn').forEach(btn => {
	  btn.addEventListener('click', async () => {
	    const movieId = btn.dataset.movieId;
	    if (!movieId) { console.warn('movieId 없음'); return; }

	    const res = await fetch('MovieLike?movieId=' + encodeURIComponent(movieId), { method:'POST' });
	    if (res.status === 401) { alert('로그인 후 이용해주세요.'); return; }

	    const data = await res.json();
	    btn.textContent = data.liked ? '♥' : '♡';
	    btn.setAttribute('aria-pressed', data.liked ? 'true' : 'false');

	    const c = document.getElementById('like-count-' + movieId);
	    if (c) c.textContent = data.likeCount;
	  });
	});
</script>

</body>
<jsp:include page="/bottom.jsp"/>
</html>