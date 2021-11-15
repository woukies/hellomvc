select * from mvc_member;

create table mvc_member (
mem_uid varchar(15),
mem_pwd varchar(15),
mem_name varchar(10)
);

insert into mvc_member values ('dev', 'admin', 'developoer');
update mvc_member set mem_name = 'developoer' where mem_uid = 'dev';

delete from mvc_member where mem_uid is null;

commit;