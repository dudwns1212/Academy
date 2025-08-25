<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>영화관 홈페이지</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Plyr CSS -->
<link rel="stylesheet" href="https://cdn.plyr.io/3.7.8/plyr.css" />

<style>
body {
	margin: 0;
	background-color: #000;
	color: #eee;
	font-family: 'Noto Sans KR', sans-serif;
}

.carousel-item {
	position: relative;
	width: 100%;
	padding-top: 41%;
	overflow: hidden;
}

.carousel-item img {
	position: absolute;
	top: 0;
	left: 50%;
	width: auto;
	height: 100%;
	transform: translateX(-70%);
	object-fit: cover;
	object-position: top center;
	cursor: pointer;
}

.carousel-caption {
	position: absolute;
	top: 0px;
	transform: translateX(40%);
	padding: 10px 20px;
	border-radius: 5px;
	z-index: 1;
}

.carousel-caption p, h3 {
	text-align: left;
	transform: translateX(20%);
	padding: 10px 30px;
}

#playerContainer {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.85);
	justify-content: center;
	align-items: center;
	flex-direction: column;
	z-index: 9999;
}

#playerContainer iframe {
	width: 80%;
	height: 80%;
	transform: translateX(20%);
	top: 20px;
}

#closeBtn {
	margin-top: 10px;
	padding: 5px 15px;
	font-size: 1.2rem;
	cursor: pointer;
	color: #fff;
	background: rgba(255, 255, 255, 0.1);
	border: none;
	border-radius: 5px;
	transform: translateY(60%);
	
}
</style>
</head>
<body>

<jsp:include page="/header.jsp" />

<% 
String deleteMsg = (String) request.getAttribute("deleteMsg");
if (deleteMsg != null) {
%>
<script>
    alert('<%= deleteMsg %>');
</script>
<%
}
%>
<main>
	<div id="movieCarousel" class="carousel slide" data-bs-ride="carousel" data-bs-interval="4000">

		<!-- 인디케이터 -->
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#movieCarousel" data-bs-slide-to="0" class="active"></button>
			<button type="button" data-bs-target="#movieCarousel" data-bs-slide-to="1"></button>
			<button type="button" data-bs-target="#movieCarousel" data-bs-slide-to="2"></button>
			<button type="button" data-bs-target="#movieCarousel" data-bs-slide-to="3"></button>
		</div>

		<!-- 슬라이드 -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="asset/images/oldboy.png" alt="올드보이"
				     data-video="https://www.youtube.com/embed/hBNBpNcuQHI?autoplay=1">
				<div class="carousel-caption">
					<h3>올드보이</h3>
					<p>“누가, 왜 나를 가두었는가?”</p>
					<p>15년 동안 이유도 모른 채 감금당한 오대수는 풀려난 후,</p>
					<p>자신을 가둔 자를 찾아 복수와 진실의 퍼즐을 맞춰가기 시작한다.</p>
				</div>
			</div>

			<div class="carousel-item">
				<img src="asset/images/new.png" alt="신세계"
				       data-video="https://www.youtube.com/embed/I_-q5SJ6zPI?autoplay=1">
				<div class="carousel-caption">
					<h3>신세계</h3>
					<p>“너, 나랑 일 하나 같이하자”</p>
					<p>잠입 형사 이자성과 조직원 정청의 충성과 배신이 얽히며,</p>
					<p>숨겨진 권력과 음모가 서서히 드러난다.</p>
				</div>
			</div>

			<div class="carousel-item">
				<img src="asset/images/showman.png" alt="위대한 쇼맨"
				     data-video="https://www.youtube.com/embed/cnIOq6P8PUU?autoplay=1">
				<div class="carousel-caption">
					<h3>위대한 쇼맨</h3>
					<p>한 남자, 피니어스 배너햄은 세상의 편견과 맞서</p>
					<p>위대한 공연을 만들어 나간다.</p>
					<p>열정과 도전, 그리고 희망이 사람들을 사로잡는다.</p>
				</div>
			</div>
			
			<div class="carousel-item">
				<img src="asset/images/infinity.png" alt="위대한 쇼맨"
				     data-video="https://www.youtube.com/embed/zN8K_uE1LYg?autoplay=1">
				<div class="carousel-caption">
					<h3>귀멸의 칼날 무한성편</h3>
					<p>결전의 포문이 열린다⸺</p>
					<p>탄지로 일행이 떨어진 곳, 그곳은 혈귀의 본거지 《무한성》─</p>
					<p>“귀살대”와 “혈귀”의 최종 결전의 포문이 열린다.</p>
				</div>
			</div>
		</div>

		<!-- 캐러셀 컨트롤 -->
		<button class="carousel-control-prev" type="button" data-bs-target="#movieCarousel" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
		<button class="carousel-control-next" type="button" data-bs-target="#movieCarousel" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>
	</div>

	<!-- 동영상 플레이어 -->
	<div id="playerContainer">
		<iframe id="player" src="" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
		<button id="closeBtn">닫기</button>
	</div>
</main>

<!-- JS -->
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script src="https://cdn.plyr.io/3.7.8/plyr.polyfilled.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
$(function() {
	let player;

	$('.carousel-item img').click(function() {
		const url = $(this).data('video');
		$('#player').attr('src', url); // iframe src 변경
		$('#playerContainer').fadeIn();
	});

	$('#closeBtn').click(function() {
		$('#playerContainer').fadeOut();
		$('#player').attr('src', ''); // iframe 비우기
	});
});
</script>
<jsp:include page="/bottom.jsp"/>
</body>
</html>