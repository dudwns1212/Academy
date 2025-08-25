<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.List"%>
<%@ page import="movieList.MovieListVO"%>
<%@ page import="java.time.LocalDateTime"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>예매</title>
<!-- jQuery 라이브러리 추가 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
:root {
	--bg: #000000;
	--card: #ffffff;
	--line: #e0e0e0;
	--txt: #333333;
	--muted: #666666;
	--accent: #ff6b35;
	--radius: 8px;
	--red-accent: #ff0000;
}

* {
	box-sizing: border-box
}

body {
	margin: 0;
	background-color: var(--bg);
	color: var(--txt);
	font-family: system-ui, -apple-system, Segoe UI, Roboto, "Noto Sans KR",
		sans-serif;
	min-height: 100vh;
}

a {
	text-decoration: none;
	color: inherit
}

.wrap {
	max-width: 1200px;
	margin: 0 auto;
	padding: 20px 16px;
}

h1 {
	font-size: 24px;
	margin: 20px 0;
	color: white;
	font-weight: 700;
}

.grid {
	display: grid;
	grid-template-columns: 280px 1fr 300px;
	gap: 20px;
}

.panel {
	background: var(--card);
	color: var(--txt);
	border: 1px solid var(--line);
	border-radius: var(--radius);
	overflow: hidden;
	min-height: 600px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.panel h3 {
	margin: 0;
	padding: 40px;
	border-bottom: 1px solid var(--line);
	font-size: 18px;
	font-weight: 600;
	background-color: #f8f9fa;
}

.panel .body {
	padding: 20px;
	max-height: 70vh;
	overflow: auto;
}

/* 버튼 스타일 */
.btn {
	display: inline-flex;
	align-items: center;
	justify-content: center;
	gap: 8px;
	padding: 12px 16px;
	border-radius: 6px;
	border: 1px solid var(--line);
	background: white;
	color: var(--txt);
	font-weight: 500;
	cursor: pointer;
	transition: all 0.2s;
}

.btn:hover {
	background-color: #f8f9fa;
	border-color: var(--accent);
}

.btn.active {
	background-color: var(--accent);
	color: white;
	border-color: var(--accent);
}

.movie.active {
	color: white;
	border-color: var(--accent);
}

.btn.block {
	display: flex;
	width: 100%;
	margin-bottom: 8px;
}

.btn.ghost {
	background: white;
	border: 1px solid #ddd;
	color: var(--txt);
}

.btn.ghost:hover {
	background: #f8f9fa;
}

.btn.pill {
	border-radius: 20px;
}

.btn.small {
	padding: 8px 12px;
	font-size: 14px;
}

.btn[disabled] {
	opacity: 0.5;
	cursor: not-allowed;
}

/* 목록 */
.list {
	display: grid;
	gap: 8px;
}

.tag {
	font-size: 14px;
	font-weight: 600;
	color: var(--txt);
	margin: 16px 0 8px 0;
}

/* 영화 카드 */
.movie {
	display: flex;
	gap: 12px;
	align-items: center;
	padding: 16px;
	border: 2px solid var(--line);
	border-radius: var(--radius);
	margin-bottom: 12px;
	transition: all 0.2s;
	background: white;
	cursor: pointer;
}

.movie:hover {
	border-color: var(--accent);
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.movie img {
	width: 60px;
	height: 80px;
	object-fit: cover;
	border-radius: 4px;
	background: #f0f0f0;
}

.movie .content {
	flex: 1;
}

.movie .title {
	font-weight: 600;
	font-size: 16px;
	margin-bottom: 4px;
	color: var(--txt);
}

.movie .info {
	font-size: 14px;
	color: var(--muted);
	margin-bottom: 2px;
}

/* 날짜 선택 */
.date-list {
	display: flex;
	gap: 8px;
	margin-bottom: 16px;
	flex-wrap: wrap;
}

.date-btn {
	background: white;
	border: 1px solid var(--line);
	color: var(--txt);
	padding: 10px 16px;
	border-radius: 6px;
	cursor: pointer;
	font-size: 14px;
	transition: all 0.2s;
}

.date-btn:hover {
	border-color: var(--accent);
}

.date-btn.active {
	background: var(--accent);
	color: white;
	border-color: var(--accent);
}

/* 시간 목록 */
.time-list {
	display: flex;
	flex-wrap: wrap;
	gap: 8px;
	margin-top: 16px;
}

.time {
	padding: 8px 12px;
	border: 1px solid var(--line);
	border-radius: 4px;
	background: white;
	font-size: 14px;
	cursor: pointer;
	transition: all 0.2s;
}

.time.active {
	background: var(--accent);
	color: white;
	border-color: var(--accent);
}

.time:hover {
	border-color: var(--accent);
	background: #fff5f0;
}

.time.active:hover {
	background: #e55a2b;
}

.selected-date {
	color: var(--muted);
	font-size: 14px;
	margin-bottom: 16px;
	padding: 8px 0;
}

hr.line {
	border: 0;
	border-top: 1px solid var(--line);
	margin: 20px 0;
}

.empty-state {
	text-align: center;
	padding: 60px 20px;
	color: var(--muted);
}

/* 최종 버튼 */
.final-btn {
	background: var(--red-accent);
	color: white;
	border: none;
	padding: 16px;
	border-radius: 6px;
	font-size: 16px;
	font-weight: 600;
	cursor: pointer;
	transition: all 0.2s;
	width: 100%;
	margin-top: 20px;
}

.final-btn:hover {
	background: #e60000;
	transform: translateY(-1px);
}

/* ★★★ 수정된 지역/영화관 선택 스타일 ★★★ */
.region-section .btn {
	text-align: left;
	justify-content: flex-start;
	background: white;
	color: var(--txt);
	border: 2px solid var(--line);
}

.region-section .btn:hover {
	background: #f8f9fa;
	border-color: var(--accent);
}

.region-section .btn.active {
	background: var(--accent);
	color: white;
	border-color: var(--accent);
}

.cinema-section .btn.ghost {
	text-align: left;
	justify-content: flex-start;
	background: white;
	color: var(--txt);
	border: 2px solid var(--line);
	font-weight: 500;
}

.cinema-section .btn.ghost:hover {
	background: #f8f9fa;
	border-color: var(--accent);
}

.cinema-section .btn.ghost.active {
	background: var(--accent);
	color: white;
	border-color: var(--accent);
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>

	<main class="wrap">
		<div class="grid">
			<section class="panel">
				<h3>영화관</h3>
				<div class="body">
					<div class="region-section">
						<div class="tag">지역</div>
						<div class="list">
							<c:set var="locations" value="" />
							<c:forEach var="cinema" items="${cinemaList}">
								<c:if test="${not fn:contains(locations, cinema.location)}">
									<button type="button" class="btn block location-btn"
										data-location="${cinema.location}">
										${cinema.location}</button>
									<c:set var="locations" value="${locations}${cinema.location}," />
								</c:if>
							</c:forEach>
						</div>
					</div>
					<hr class="line">
					<div class="cinema-section">
						<div class="tag">영화관</div>
						<div class="list" id="cinemaList">
							<div class="empty-state">지역을 먼저 선택해주세요</div>
						</div>
					</div>
				</div>
			</section>

			<section class="panel">
				<h3>영화 선택</h3>
				<div class="body" id="movieList">
					<div class="empty-state">영화관을 먼저 선택해주세요</div>
				</div>
			</section>

			<section class="panel">
				<h3>영화 시간표</h3>
				<div class="body">
					<div class="tag">날짜</div>
					<div class="date-list" id="date-list">
						<div class="empty-state">영화를 먼저 선택해주세요</div>
					</div>

					<div class="selected-date" id="selected-date"></div>

					<div class="tag">시간</div>
					<div class="time-list" id="time-list">
						<div class="empty-state">영화를 먼저 선택해주세요</div>
					</div>

					<button type="button" class="final-btn" onclick="goToSeat()">예매
						하기</button>
				</div>
			</section>
		</div>
	</main>

	<script type="text/javascript">
		let selectedMovieId = null;
		let selectedMovieTitle = null;
		let selectedCinemaId = null;
		let selectedCinemaName = null;
		let selectedMoviePrice = null;
		let selectedMoviePoster = null;
		let selectedDate = null;
		let selectedTime = null;

		// 1. 지역 버튼 클릭 이벤트
		$(document).on('click', '.location-btn', function() {
			console.log('지역 버튼 클릭됨');

			$('.location-btn').removeClass('active');
			$(this).addClass('active');

			let location = $(this).data('location');
			console.log('선택된 지역:', location);

			// 선택 정보 초기화
			resetSelections();

			$.ajax({
				url : 'CinemaListApiServlet',
				data : {
					'location' : location
				},
				dataType : "json",
				success : changeCinema,
				error : function(xhr, status, error) {
					console.error('영화관 조회 실패:', error);
					console.error('상태:', status);
					console.error('응답:', xhr.responseText);
				}
			});
		});

		// 2. 영화관 데이터 업데이트 함수
		function changeCinema(data) {
			console.log('Ajax 성공! 받은 데이터:', data);
			console.log('데이터 타입:', typeof data);
			console.log('데이터 키 개수:', Object.keys(data).length);

			let cinemaListDiv = $('#cinemaList');
			cinemaListDiv.empty();
			
			if (!data || data.length == 0) {
		        cinemaListDiv.append('<div class="empty-state">해당 지역에 영화관이 없습니다</div>');
		        return;
		    }

			for (let i = 0; i < data.length; i++) {
		        let cinema = data[i];  // 올바른 접근!
		        console.log('영화관 추가:', cinema.cinemaId, cinema.name); // 올바른 변수명!

		        let newCinemaBtn = '<button type="button" class="btn block ghost cinema-btn" ' +
		                          'data-cinema-id="' + cinema.cinemaId + '" ' +
		                          'data-cinema-name="' + cinema.name + '">' +
		                          cinema.name + '</button>';
		        cinemaListDiv.append(newCinemaBtn);
		    }

		    console.log('총 ' + data.length + '개 영화관 추가 완료');
		}

		// 3. 영화관 선택 이벤트
		$(document).on('click', '.cinema-btn', function() {
			console.log('영화관 버튼 클릭됨');

			$('.cinema-btn').removeClass('active');
			$(this).addClass('active');

			selectedCinemaId = $(this).data('cinema-id');
			selectedCinemaName = $(this).data('cinema-name');

			console.log('선택된 영화관 ID:', selectedCinemaId);
			console.log('선택된 영화관 이름:', selectedCinemaName);

			// 영화관 변경 시 하위 선택 초기화
			resetMovieSelections();

			$.ajax({
				url : 'MovieListApiServlet',
				data : {
					'cinemaId' : selectedCinemaId
				},
				dataType : "json",
				success : changeMovie,
				error : function(xhr, status, error) {
					console.error('영화 조회 실패:', error);
					console.error('상태:', status);
					console.error('응답:', xhr.responseText);
				}
			});
		});

		// 4. 영화 목록 업데이트
		function changeMovie(data) {
			console.log('영화 데이터 받음:', data);

			let movieListDiv = $('#movieList');
			movieListDiv.empty();

			if (data.length == 0) {
				movieListDiv
						.append('<div class="empty-state">상영할 수 있는 영화가 없습니다.</div>');
				return;
			}

			for (let i = 0; i < data.length; i++) {
				let movie = data[i];

				// moviePrice 값 확인 및 기본값 설정
				let moviePrice = movie.moviePrice || 14000;
				let moviePoster = movie.poster
						|| 'asset/images/movie_default.png';

				console.log('영화 데이터:', movie);

				let newMovie = '<div class="movie" data-movie-id="'+ movie.movieId + 
                '" data-movie-title="' + movie.movieTitle + 
                '" data-movie-price="' + moviePrice + 
                '" data-movie-poster="' + moviePoster + '">'
						+ '<img src="' + moviePoster + '">'
						+ '<div class="content">'
						+ '<div class="title">'
						+ movie.movieTitle
						+ '</div>'
						+ '<div class="info">'
						+ movie.genre
						+ ' • '
						+ movie.movieTime
						+ '분</div>'
						+ '</div></div>';
				movieListDiv.append(newMovie);
			}
		}

		// 5. 영화 선택 이벤트
		$(document).on('click', '.movie', function() {
			$('.movie').removeClass('active');
			$(this).addClass('active');

			selectedMovieId = $(this).data('movie-id');
			selectedMovieTitle = $(this).data('movie-title');
			selectedMoviePrice = $(this).data('movie-price');
			selectedMoviePoster = $(this).data('movie-poster');

			console.log('선택된 영화 정보:');
			console.log('- ID:', selectedMovieId);
			console.log('- 제목:', selectedMovieTitle);
			console.log('- 가격:', selectedMoviePrice);
			console.log('- 포스터:', selectedMoviePoster);

			// 영화관이 선택되지 않았다면 경고
			if (!selectedCinemaId) {
				alert('영화관을 먼저 선택해주세요.');
				return;
			}

			// 날짜/시간 초기화
			resetDateTimeSelections();
			
			$.ajax({
				url : 'ShowDateListApiServlet',
				data : {
					'cinemaId' : selectedCinemaId,
					'movieId' : selectedMovieId
				},
				dataType : "json",
				success : changeDate,
				error : function(xhr, status, error) {
					console.error('날짜 조회 실패:', error);
					console.error('상태:', status);
					console.error('응답:', xhr.responseText);
				}
			});
		});

		// 6. 날짜 업데이트
		function changeDate(data) {
			console.log('날짜 데이터 받음:', data);

			let dateListDiv = $('#date-list');
			dateListDiv.empty();

			if (!data || !data.dates || data.dates.length == 0) {
				dateListDiv
						.append('<div class="empty-state">상영할 수 있는 날짜가 없습니다.</div>');
				return;
			}

			for (let i = 0; i < data.dates.length; i++) {
				let date = data.dates[i];
				let newDateBtn = '<button type="button" class="date-btn" data-date="' + date + '">'
						+ date + '</button>';
				dateListDiv.append(newDateBtn);
			}
		}

		// 7. 날짜 선택 이벤트
		$(document).on('click', '.date-btn', function() {
			console.log('날짜 버튼 클릭됨')

			$('.date-btn').removeClass('active');
			$(this).addClass('active');

			selectedDate = $(this).data("date");
			console.log('선택된 날짜:', selectedDate);

			selectedTime = null;
			$('#time-list').empty();

			$.ajax({
				url : 'ShowTimeListApiServlet',
				data : {
					'cinemaId' : selectedCinemaId,
					'movieId' : selectedMovieId,
					"date" : selectedDate
				},
				dataType : "json",
				success : changeTime,
				error : function(xhr, status, error) {
					console.error('시간 조회 실패:', error);
				}
			});
		});

		// 8. 시간 업데이트
		function changeTime(data) {
			console.log('시간 데이터 받음:', data);

			let timeListDiv = $('#time-list');
			timeListDiv.empty();

			if (!data || !data.times || data.times.length == 0) {
				timeListDiv
						.append('<div class="empty-state">상영할 수 있는 시간이 없습니다.</div>');
				return;
			}

			for (let i = 0; i < data.times.length; i++) {
				let time = data.times[i];
				let newTimeBtn = '<div class="time" data-time="' + time + '">'
						+ time + '</div>';
				timeListDiv.append(newTimeBtn);
			}
		}

		// 9. 시간 선택 이벤트
		$(document).on('click', '.time', function() {
			$('.time').removeClass('active');
			$(this).addClass('active');

			selectedTime = $(this).data('time');
			console.log('선택된 시간:', selectedTime);
		});

		function goToSeat() {
			// 모든 필수 정보가 선택되었는지 확인
			if (!selectedCinemaId) {
				alert('영화관을 선택해주세요.');
				return;
			}
			if (!selectedMovieId) {
				alert('영화를 선택해주세요.');
				return;
			}
			if (!selectedDate) {
				alert('날짜를 선택해주세요.');
				return;
			}
			if (!selectedTime) {
				alert('상영 시간을 선택해주세요.');
				return;
			}

			// moviePrice가 undefined인 경우 기본값 설정
			let finalMoviePrice = selectedMoviePrice || 14000;

			const params = new URLSearchParams({
				cinemaId : selectedCinemaId || '',
				cinemaName : selectedCinemaName || '',
				movieId : selectedMovieId || '',
				movieTitle : selectedMovieTitle || '',
				moviePrice : finalMoviePrice,
				moviePoster : selectedMoviePoster
						|| 'asset/images/movie_default.png',
				date : selectedDate || '',
				time : selectedTime || ''
			});

			console.log('전달할 파라미터:', params.toString());

			
			window.location.href = 'ReserveServlet?' + params.toString();
		}

		// 선택 정보 초기화 함수들
		function resetSelections() {
			resetMovieSelections();
			$('#cinemaList').html(
					'<div class="empty-state">지역을 먼저 선택해주세요</div>');
			selectedCinemaId = null;
			selectedCinemaName = null;
		}

		function resetMovieSelections() {
			resetDateTimeSelections();
			$('#movieList').html(
					'<div class="empty-state">영화관을 먼저 선택해주세요</div>');
			selectedMovieId = null;
			selectedMovieTitle = null;
			selectedMoviePrice = null;
			selectedMoviePoster = null;
		}

		function resetDateTimeSelections() {
			$('#date-list')
					.html('<div class="empty-state">영화를 먼저 선택해주세요</div>');
			$('#time-list')
					.html('<div class="empty-state">영화를 먼저 선택해주세요</div>');
			selectedDate = null;
			selectedTime = null;
		}
	</script>
	<jsp:include page="/bottom.jsp" />
</body>
</html>