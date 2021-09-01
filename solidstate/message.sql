create table member(
	m_num int primary key,
	m_id varchar(15) not null,
    m_pw varchar(15) not null
);
insert into member values(1, 'hong', 'aaaa');

create table message(
	mnum int primary key,
	writer varchar(15) not null,
	title varchar(15) not null,
	m_id varchar(15) not null,
	content varchar(100) not null,
	wdate date default sysdate
);
select * from message;
insert into message values(1,'kim','제목','hong','내용',sysdate);
insert into message values(2,'kim2','제목2','amumu','내용2',sysdate);
/* 샘플데이터 : 일반적으로 서비스 될때에는 샘플데이터 有! */
select * from member;
drop table message;
drop table member;
drop table ticket_info;
select * from all_tables;