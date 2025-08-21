use newhr;

select * from employees;

# my_order, my_order_item 테이블을 만듦
create table my_order(
	id int auto_increment primary key,
    order_date date
);

insert into my_order(order_date) values(curdate());
select * from my_order;

create table my_order_item (
	order_id int,
    item_id varchar(50),
    amount int,
    primary key(order_id, item_id),
    foreign key(order_id) references my_order(id)
);

insert into my_order_item(order_id,item_id, amount) values(1, 'GAL25', 100);
select * from my_order_item;

create table branch (
	branch_id int auto_increment primary key,
    branch_name varchar(20),
    branch_adress varchar(50) unique,
    branch_mobile int
);
create table branch_customer (
	branch_id int,
    customer_id int,
    customer_mobile int,
    customer_hnumber int,
    customer_name varchar(20),
    customer_adress varchar(50),
    primary key(branch_id, customer_id),
    foreign key(branch_id) references branch(branch_id)
);
create table branch_account (
	branch_adress varchar(50),
	account_id int,
    account_number int,
    account_type varchar(50),
    account_balance int,
    primary key(branch_adress ,account_type),
    foreign key(branch_adress) references branch(branch_adress)
);

drop table branch;

    
    
    