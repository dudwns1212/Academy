CREATE SCHEMA teamproject COLLATE = utf8_general_ci;
use teamproject;

#회원정보
create table users (
user_id int auto_increment primary key,
id varchar(50) not null unique,
password varchar(200) not null,
name varchar(50) not null,
age int,
mobile varchar(20)
);

#영화
create table movies (
movie_id int auto_increment primary key,
title varchar(200) not null,
price int not null,
movieTime int not null,
genre varchar(50) not null,
poster varchar(300)
# rating decimal(2,1) not null #별점 
);

#영화관
create table cinemas (
cinema_id int auto_increment primary key,
name varchar(100) not null,
location varchar(100) not null,
address varchar(200)
);

# 상영관
create table rooms (
room_id int auto_increment primary key,
cinema_id int not null,
name varchar(100) not null,
foreign key (cinema_id) references cinemas(cinema_id)
);

#상영 스케쥴
create table schedules (
schedule_id int auto_increment primary key, 	
movie_id int not null,
room_id int not null,
start_time datetime not null, #datetime= 연월일시간 까지 time=시간만 date=연월일만
foreign key (movie_id) references movies(movie_id),
foreign key (room_id) references rooms(room_id)
);

#좌석
create table seats (
seat_id int auto_increment primary key,
room_id int not null,
row_name varchar(10) not null, 		#행 a,b,c 
col_number int not null, 			#열 1,2,3
foreign key (room_id) references rooms(room_id)
);

#예매
create table reservations (
reservation_id int auto_increment primary key,
user_id int not null,
schedule_id int not null,
seat_id int not null,
foreign key (user_id) references users(user_id),
foreign key (schedule_id) references schedules(schedule_id),
foreign key (seat_id) references seats(seat_id)
);



#영화
insert into movies (title, price, movieTime, genre, poster)
values
('올드보이', 14000, 120, '느와르', 'asset/images/oldboy.png'),
('신세계', 14000, 135, '느와르', 'asset/images/new.png'),
('아저씨', 14000, 120, '느와르', 'asset/images/goldteeth.png'),
('존윅', 14000, 101, '느와르', 'asset/images/john.png'),

('위대한쇼맨',14000, 104, '뮤지컬', 'asset/images/showman.png'),
('레미제라블', 14000, 104, '뮤지컬', 'asset/images/lesmi.png'),
('라라랜드', 14000, 128, '뮤지컬', 'asset/images/lalaland.png'),
('어거스트러쉬', 14000, 113, '뮤지컬', 'asset/images/august.png'), 

('그 시절, 우리가 좋아했던 소녀', 14000, 107, '로맨스', 'asset/images/lovegirl.png'),
('헤어질결심', 14000, 138, '로맨스', 'asset/images/byebye.png'),
('비긴어게인', 14000, 104, '로맨스', 'asset/images/begin.png'),
('엽기적인그녀', 14000, 137, '로맨스', 'asset/images/sassygirl.png'),

('월드워z', 14000, 115, '좀비', 'asset/images/warZ.png'),
('부산행', 14000, 120, '좀비', 'asset/images/busan.png'),
('28일 후', 14000, 114, '좀비', 'asset/images/28.png'),
('반도', 14000, 116, '좀비', 'asset/images/bando.png'),


('국제시장', 14000, 126, '가족', 'asset/images/sijang.png'),
('바람', 14000, 107, '가족', 'asset/images/baram.png'),
('업', 14000, 101, '가족', 'asset/images/up.png'),
('코코', 14000, 104, '가족', 'asset/images/coco.png'),

('분노의질주7 (더 세븐)', 14000, 140, '액션', 'asset/images/furious.png'),
('F1 더 무비', 14000, 155, '액션', 'asset/images/f1.png'), 
('어벤져스4 (엔드게임)', 14000, 189, '액션', 'asset/images/endgame.png'),
('탑건 매버릭', 14000, 130, '액션', 'asset/images/topgun.png'),

('씽', 14000, 150, '애니메이션', 'asset/images/sing.png'),
('명탐정코난 화염의 해바라기', 14000, 112, '애니메이션', 'asset/images/conan.png'),
('귀멸의 칼날: 무한성편', 14000, 155, '애니메이션', 'asset/images/infinity.png'),
('하울의 움직이는 성', 14000, 119, '애니메이션', 'asset/images/castle.png');



#영화관
insert into cinemas (name, location, address)
values
('서울도심영화관', '서울특별시', '서울 구로점'),
('부산돼지국밥영화관', '부산광역시', '부산 해운대점'),
('대구뭉티기영화관', '대구광역시', '대구 동성로점'),
('광주육전영화관', '광주광역시', '광주 남구점'),
('울산고래영화관', '울산광역시', '울산 바다점'),
('대전빵영화관', '대전광역시', '대전 야구장점'),
('인천비행기영화관', '인천광역시', '인천 구월동점'),
('진주킹영화관', '진주시', '진주 혁신도시점'),
('청주대지적영화관', '청주시', '청주 주영민집앞점'),
('전주한옥영화관', '전주시', '전주 회장님집앞점');

#상영관
insert into rooms (cinema_id, name)
values
(1, '1관'),
(1, '2관'),
(2, '1관'),
(2, '2관'),
(3, '1관'),
(3, '2관'),
(4, '1관'),
(4, '2관'),
(5, '1관'),
(5, '2관'),
(6, '1관'),
(6, '2관'),
(7, '1관'),
(7, '2관'),
(8, '1관'),
(8, '2관'),
(9, '1관'),
(9, '2관'),
(10, '1관'),
(10, '2관');


#상영시간
insert into schedules (movie_id, room_id, start_time)
select m.movie_id, t.room_id, concat(d.dt, ' ', t.HHMM) as start_time
from
  (select movie_id from movies where movie_id between 1 and 28) m
join (
select 1 as room_id, '12:00' as HHMM union all
select 1, '15:00' union all
select 1, '18:00' union all
select 1, '21:00' union all
select 2, '13:30' union all
select 2, '16:30' union all
select 2, '19:30' union all
select 2, '22:30'
) t
join (
select '2025-08-31' as dt union all
select '2025-08-30' union all
select '2025-08-29' union all
select '2025-08-28' union all
select '2025-08-27' union all
select '2025-08-26' union all
select '2025-08-25' union all
select '2025-08-24' union all
select '2025-08-23' union all
select '2025-08-22' union all
select '2025-08-21' union all
select '2025-08-20'
) d;

#좌석
insert into seats (room_id, row_name, col_number)
values
(1, 'A', 1), (1, 'A', 2), (1, 'A', 3), (1, 'A', 4), (1, 'B', 1), (1, 'B', 2), (1, 'B', 3), (1, 'C', 1), (1, 'C', 2), (1, 'C', 3),
(2, 'A', 1), (2, 'A', 2), (2, 'A', 3), (2, 'A', 4), (2, 'B', 1), (2, 'B', 2), (2, 'B', 3), (2, 'B', 4), (2, 'C', 1), (2, 'C', 2), (2, 'C', 3), (2, 'C', 4),
(3, 'A', 1), (3, 'A', 2), (3, 'A', 3), (3, 'A', 4), (3, 'B', 1), (3, 'B', 2), (3, 'B', 3), (3, 'C', 1), (3, 'C', 2), (3, 'C', 3),
(4, 'A', 1), (4, 'A', 2), (4, 'A', 3), (4, 'A', 4), (4, 'B', 1), (4, 'B', 2), (4, 'B', 3), (4, 'B', 4), (4, 'C', 1), (4, 'C', 2), (4, 'C', 3), (4, 'C', 4),
(5, 'A', 1), (5, 'A', 2), (5, 'A', 3), (5, 'A', 4), (5, 'B', 1), (5, 'B', 2), (5, 'B', 3), (5, 'C', 1), (5, 'C', 2), (5, 'C', 3),
(6, 'A', 1), (6, 'A', 2), (6, 'A', 3), (6, 'A', 4), (6, 'B', 1), (6, 'B', 2), (6, 'B', 3), (6, 'B', 4), (6, 'C', 1), (6, 'C', 2), (6, 'C', 3), (6, 'C', 4),
(7, 'A', 1), (7, 'A', 2), (7, 'A', 3), (7, 'A', 4), (7, 'B', 1), (7, 'B', 2), (7, 'B', 3), (7, 'C', 1), (7, 'C', 2), (7, 'C', 3),
(8, 'A', 1), (8, 'A', 2), (8, 'A', 3), (8, 'A', 4), (8, 'B', 1), (8, 'B', 2), (8, 'B', 3), (8, 'B', 4), (8, 'C', 1), (8, 'C', 2), (8, 'C', 3), (8, 'C', 4),
(9, 'A', 1), (9, 'A', 2), (9, 'A', 3), (9, 'A', 4), (9, 'B', 1), (9, 'B', 2), (9, 'B', 3), (9, 'C', 1), (9, 'C', 2), (9, 'C', 3),
(10, 'A', 1), (10, 'A', 2), (10, 'A', 3), (10, 'A', 4), (10, 'B', 1), (10, 'B', 2), (10, 'B', 3), (10, 'B', 4), (10, 'C', 1), (10, 'C', 2), (10, 'C', 3), (10, 'C', 4),
(11, 'A', 1), (11, 'A', 2), (11, 'A', 3), (11, 'A', 4), (11, 'B', 1), (11, 'B', 2), (11, 'B', 3), (11, 'C', 1), (11, 'C', 2), (11, 'C', 3),
(12, 'A', 1), (12, 'A', 2), (12, 'A', 3), (12, 'A', 4), (12, 'B', 1), (12, 'B', 2), (12, 'B', 3), (12, 'B', 4), (12, 'C', 1), (12, 'C', 2), (12, 'C', 3), (12, 'C', 4),
(13, 'A', 1), (13, 'A', 2), (13, 'A', 3), (13, 'A', 4), (13, 'B', 1), (13, 'B', 2), (13, 'B', 3), (13, 'C', 1), (13, 'C', 2), (13, 'C', 3),
(14, 'A', 1), (14, 'A', 2), (14, 'A', 3), (14, 'A', 4), (14, 'B', 1), (14, 'B', 2), (14, 'B', 3), (14, 'B', 4), (14, 'C', 1), (14, 'C', 2), (14, 'C', 3), (14, 'C', 4),
(15, 'A', 1), (15, 'A', 2), (15, 'A', 3), (15, 'A', 4), (15, 'B', 1), (15, 'B', 2), (15, 'B', 3), (15, 'C', 1), (15, 'C', 2), (15, 'C', 3),
(16, 'A', 1), (16, 'A', 2), (16, 'A', 3), (16, 'A', 4), (16, 'B', 1), (16, 'B', 2), (16, 'B', 3), (16, 'B', 4), (16, 'C', 1), (16, 'C', 2), (16, 'C', 3), (16, 'C', 4),
(17, 'A', 1), (17, 'A', 2), (17, 'A', 3), (17, 'A', 4), (17, 'B', 1), (17, 'B', 2), (17, 'B', 3), (17, 'C', 1), (17, 'C', 2), (17, 'C', 3),
(18, 'A', 1), (18, 'A', 2), (18, 'A', 3), (18, 'A', 4), (18, 'B', 1), (18, 'B', 2), (18, 'B', 3), (18, 'B', 4), (18, 'C', 1), (18, 'C', 2), (18, 'C', 3), (18, 'C', 4),
(19, 'A', 1), (19, 'A', 2), (19, 'A', 3), (19, 'A', 4), (19, 'B', 1), (19, 'B', 2), (19, 'B', 3), (19, 'C', 1), (19, 'C', 2), (19, 'C', 3),
(20, 'A', 1), (20, 'A', 2), (20, 'A', 3), (20, 'A', 4), (20, 'B', 1), (20, 'B', 2), (20, 'B', 3), (20, 'B', 4), (20, 'C', 1), (20, 'C', 2), (20, 'C', 3), (20, 'C', 4);



select * from users;
select * from movies;
select * from cinemas;
select * from rooms;
select * from seats; 
select * from schedules;