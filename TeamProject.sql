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
('올드보이', 14000, 170, '느와르'),
('어벤져스', 14000, 220, 'SF, 슈퍼히어로'),
('위대한쇼맨',14000, 190, '뮤지컬'),
('헤어질결심',14000, 180, '로맨스');

insert into cinemas (name, location, address)
values
('서울큰영화관', '서울특별시', '서울 구로점'),
('부산중간영화관', '부산광역시', '부산 해운대점'),
('인천작은영화관', '인천특별시', '인천 구월동점');


select * from users;
select * from movies;
select * from cinemas;
