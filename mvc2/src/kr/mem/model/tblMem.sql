
select * from EMPLOYEES;

create table tblMem(
num number primary key,
name varchar2(20) not null,
phone varchar2(20) not null,
addr varchar2(50),
lat number(16,12),--����
-- 16��, �Ҽ��� 12����
lng number(16,12)--�浵
);

drop table tblMem;

create sequence seq_num;

insert into tblMem values(
seq_num.nextval, '�輱��', '010-1111-1111',
'���ֱ����� ���걸 ÷��', 35.1257699845615,
126.852047602507);

select * from tblMem;

