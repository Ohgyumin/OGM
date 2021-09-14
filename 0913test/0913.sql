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
insert into userTable values('timo','Æ¼¸ð','1234', sysdate);
insert into messageTable values(1,'timo','±ÛÀÛ¼º',1,2,sysdate);
insert into reply values(1,1,'timo',sysdate,'´ñ±Û1');
insert into reply values(2,1,'timo',sysdate,'´ñ±Û2');
insert into messageTable values(2,'timo','¹ö¼¸',2,3,sysdate);
insert into reply values(3,2,'timo',sysdate,'´ñ±Û1');
insert into reply values(4,2,'timo',sysdate,'´ñ±Û2');
insert into reply values(5,2,'timo',sysdate,'´ñ±Û3');
insert into messageTable values(3,'timo','È®ÀÎ',2,0,sysdate);
insert into userTable values('oh','¿À','1234', sysdate);
insert into messageTable values(4,'oh','Ã¼Å©',1,2,sysdate);
insert into reply values(6,4,'oh',sysdate,'´ñ±Û1');
insert into reply values(7,4,'oh',sysdate,'´ñ±Û2');

select * from messagetable;
select * from messagetable where rownum<=2 order by datetime desc;
select * from userTable;
select * from reply;
select * from messageTable;

drop table u_T;
drop table reply;
drop table message_T;