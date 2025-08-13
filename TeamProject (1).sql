CREATE SCHEMA teamproject COLLATE = utf8_general_ci;
use teamproject;

create table users (
user_no int auto_increment primary key,
id varchar(50) not null unique,
password varchar(200) not null,
name varchar(50) not null,
age int,
mobile varchar(20)
);

create table movies (
movie_no int auto_increment primary key,
title varchar(200) not null,
price int not null,
movieTime int not null,
genre varchar(50) not null
);

create table cinemas (
cinema_no int auto_increment primary key,
name varchar(100) not null,
location varchar(100) not null,
address varchar(200)
);

insert into movies (title, price, movieTime, genre)
values
('올드보이', 14000, 120, '느와르'),
('신세계', 14000, 135, '느와르'),
('아저씨', 14000, 120, '느와르'),
('존윅', 14000, 101, '느와르'),

('위대한쇼맨',14000, 104, '뮤지컬'),
('레미제라블', 14000, 104, '뮤지컬'),
('라라랜드', 14000, 128, '뮤지컬'),
('어거스트러쉬', 14000, 113, '뮤지컬'),

('그 시절, 우리가 좋아했던 소녀', 14000, 107, '로맨스'),
('헤어질결심', 14000, 138, '로맨스'),
('비긴어게인', 14000, 104, '로맨스'),
('엽기적인그녀', 14000, 137, '로맨스'),

('월드워z', 14000, 115, '좀비'),
('부산행', 14000, 120, '좀비'),
('28일 후', 14000, 114, '좀비'),
('반도', 14000, 116, '좀비'),


('국제시장', 14000, 126, '가족'),
('바람', 14000, 107, '가족'),
('업', 14000, 101, '가족'),
('코코', 14000, 104, '가족'),

('분노의질주7 (더 세븐)', 14000, 140, '액션'),
('F1 더 무비', 14000, 155, '액션'),
('어벤져스4 (엔드게임)', 14000, 189, '액션'),
('탑건 매버릭', 14000, 130, '액션'),

('씽', 14000, 150, '애니메이션'),
('명탐정코난 화염의 해바라기', 14000, 112, '애니메이션'),
('귀멸의 칼날: 무한성편', 14000, 155, '애니메이션'),
('하울의 움직이는 성', 14000, 119, '애니메이션');






insert into cinemas (name, location, address)
values
('서울영화관', '서울특별시', '서울 구로점'),
('부산영화관', '부산광역시', '부산 해운대점'),
('대구영화관', '대구광역시', '대구 동성로점'),
('광주영화관', '광주광역시', '광주 남구점'),
('울산영화관', '울산광역시', '울산 바다점'),
('대전영화관', '대전광역시', '대전 야구장점'),
('인천영화관', '인천광역시', '인천 구월동점'),
('진주영화관', '진주시', '진주 혁신도시점'),
('청주영화관', '청주시', '청주 주영민집앞점');



select * from users;
select * from movies;
select * from cinemas;
