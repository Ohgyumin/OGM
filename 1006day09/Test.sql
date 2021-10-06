select * from all_tables;

create table board(
	id int primary key,
	title varchar(30),
	writer varchar(15),
	content varchar(100),
	wdate date default sysdate 
);

create table member2(
	id varchar(15) primary key,
	password varchar(10),
	name varchar(15),
	role varchar(15)
);

insert into member2 values('kim','1234','�达','USER');
insert into member2 values('admin','1234','������','ADMIN');
select * from member2;

insert into board (id,title,writer,content) values(1,'����','kim','�� ����');
select * from board;
drop table board;