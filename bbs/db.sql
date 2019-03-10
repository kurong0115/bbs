create database bbs44;


create table tbl_user(
	uid int primary key auto_increment,
	uname varchar(20),
	upass varchar(100),
	head varchar(100),
	regtime datetime,
	gender int
);

select * from tbl_user;
delete from tbl_user;
insert into tbl_user(uname,upass,head,regtime,gender) values('a','d7afde3e7059cd0a0fe09eec4b0008cd','1.gif',now(),1);

create table tbl_board(
	boardid int primary key auto_increment,
	boardname varchar(50),
	parentid int
);

select * from tbl_board order by parentid;

insert into tbl_board(boardname,parentid) values('.net°æ¿é',0);
insert into tbl_board(boardname,parentid) values('java°æ¿é',0);
insert into tbl_board(boardname,parentid) values('Êı¾İ¿â°æ¿é',0);
insert into tbl_board(boardname,parentid) values('Èí¼ş¹¤³Ì°æ¿é',0);


insert into tbl_board(boardname,parentid) values('ado.net',1);
insert into tbl_board(boardname,parentid) values('asp.net',1);
insert into tbl_board(boardname,parentid) values('vb.net',1);


insert into tbl_board(boardname,parentid) values('jsp',2);
insert into tbl_board(boardname,parentid) values('struts',2);
insert into tbl_board(boardname,parentid) values('hibernate',2);


insert into tbl_board(boardname,parentid) values('sql',3);
insert into tbl_board(boardname,parentid) values('oracle',3);
insert into tbl_board(boardname,parentid) values('mysql',3);





create table tbl_topic(
	topicid int primary key auto_increment,
	title varchar(50),
	content varchar(1000),
	publishtime datetime,
	modifytime datetime,
	uid int,
	boardid int
);


select * from tbl_topic

go
alter table tbl_topic
   add constraint FK_topic_uid
      foreign key(uid) references tbl_user(uid);
      
alter table tbl_topic
   add constraint FK_topic_boardid
     foreign key(boardid) references tbl_board(boardid);
     
create table tbl_reply(
	replyid int primary key auto_increment,
	title varchar(50),
	content varchar(1000),
	publishtime datetime,
	modifytime datetime,
	uid int,
	topicid int
);

select top pagesize * from tbl_reply where replyid not in
(
	select top rows replyid from tbl_reply where topicid=? order by publishtime desc
) 
and topicid=? order by publishtime desc




go
alter table tbl_reply
   add constraint FK_reply_uid
      foreign key(uid) references tbl_user(uid);
      
alter table tbl_reply
	add constraint FK_reply_topicid
	   foreign key(topicid) references tbl_topic(topicid);

