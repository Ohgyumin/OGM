select * from client;
select * from board;
drop table board;
drop table client;

create table client(
	userID varchar(20) primary key,
	userPW varchar(20) not null,
	name varchar(20) not null
);
create table board(
	bnum int primary key,
	userID varchar(20) not null,
    title varchar(15) not null,
    content varchar(50) not null,
    wdate date
);
insert into client values ('oh','1234','오');
insert into board values(1,'oh','제목','글 내용입니다',sysdate);