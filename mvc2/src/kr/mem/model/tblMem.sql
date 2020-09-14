
select * from EMPLOYEES;

create table tblMem(
num number primary key,
name varchar2(20) not null,
phone varchar2(20) not null,
addr varchar2(50),
lat number(16,12),--위도
-- 16자, 소수점 12까지
lng number(16,12)--경도
);

drop table tblMem;

create sequence seq_num;

insert into tblMem values(
seq_num.nextval, '김선바', '010-1111-1111',
'광주광역시 광산구 첨단', 35.1257699845615,
126.852047602507);

select * from tblMem;

