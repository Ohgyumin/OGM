create table userTable(
	userid varchar(15) primary key,
	name varchar(15),
	passwd varchar(10),
    datetime date
);
create table messageTable(
    mid int primary key,
    userid varchar(15),
    msg varchar(100),
    favcount int default 0,
    replycount int default 0,
    datetime date 
);
create table reply(
    rid int primary key,
    mid int,
    userid varchar(15),
    datetime date ,
    rmsg varchar(50),
    constraint msgrp foreign key (mid) references messageTable (mid) on delete cascade
);
insert into userTable values('timo','티모','1234', sysdate);
insert into messageTable values(1,'timo','글1',2,3,sysdate);
insert into reply values(1,1,'timo',sysdate,'댓글1');
insert into reply values(2,1,'timo',sysdate,'댓글2');
insert into messageTable values(2,'timo','글2',3,3,sysdate);
insert into reply values(3,2,'timo',sysdate,'댓글2-1');
insert into reply values(4,2,'timo',sysdate,'댓글2-2');
insert into reply values(5,2,'timo',sysdate,'댓글2-3');
insert into messageTable values(3,'timo','글3',2,0,sysdate);
insert into userTable values('oh','오','1234', sysdate);
insert into messageTable values(4,'oh','오글',1,2,sysdate);
insert into reply values(6,4,'oh',sysdate,'오글1');
insert into reply values(7,4,'oh',sysdate,'오글2');

select * from messagetable;
select * from messagetable where rownum<=2 order by datetime desc;
select * from userTable;
select * from reply;
select * from messageTable;

drop table userTable;
drop table reply;
drop table messageTable;