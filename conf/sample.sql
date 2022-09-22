use web;
-- 建立 Emp 資料表
create table if not exists emp (
	eid int not null auto_increment, -- 序號(主鍵, 會每次自動 +1 新增)
    ename varchar(30) not null unique, -- 姓名(具有唯一性)
    age int, -- 年齡
    createtime timestamp default current_timestamp, -- 建檔時間(有預設值=現在時間) 
    primary key(eid) -- 主鍵設定
);

-- 建立 Job 資料表
create table if not exists job (
	jid int not null auto_increment, -- 序號(主鍵, 會每次自動 +1 新增)
    jname varchar(30) not null, -- 工作名稱
    eid int, -- 員工 eid
    foreign key(eid) references emp(eid), -- 外鍵約束
    primary key(jid) -- 主鍵設定
);

-- 建立初始數據
insert into emp(ename, age) values ('A01', 21);
insert into emp(ename, age) values ('A02', 22);
insert into emp(ename, age) values ('A03', 23);
insert into emp(ename, age) values ('A04', 24);
insert into emp(ename, age) values ('A05', 25);
insert into emp(ename, age) values ('A06', 26);
insert into emp(ename, age) values ('A07', 27);
insert into emp(ename, age) values ('A08', 28);
insert into emp(ename, age) values ('A09', 29);
insert into emp(ename, age) values ('A10', 30);
insert into emp(ename, age) values ('A11', 31);
insert into emp(ename, age) values ('A12', 32);
insert into emp(ename, age) values ('A13', 33);

insert into job(jname, eid) values ('report', 1);
insert into job(jname, eid) values ('coding', 3);
insert into job(jname, eid) values ('jobA', 3);
insert into job(jname, eid) values ('jobB', 4);
insert into job(jname, eid) values ('jobC', 7);
insert into job(jname, eid) values ('jobD', 12);
insert into job(jname, eid) values ('jobE', 13);
insert into job(jname, eid) values ('jobF', 1);
insert into job(jname, eid) values ('jobG', 1);
insert into job(jname, eid) values ('jobH', 3);
insert into job(jname, eid) values ('jobI', 12);
insert into job(jname, eid) values ('jobJ', 7);
insert into job(jname, eid) values ('jobK', 4);
insert into job(jname, eid) values ('jobL', 3);
insert into job(jname) values ('jobM');
insert into job(jname) values ('jobN');


use web;

-- 1. 查詢所有員工資料
-- select * from emp;
-- 2. 查詢所有有工作的員工姓名, 工作名稱
/*
select e.ename, j.jname
from emp e, job j
where e.eid = j.eid
*/
-- 3. 請找出每一個員工有哪些工作 ? 
--    透過 left join (向左關聯) 來實現
--    因為是向左關聯, 所以會發現有些員工有工作, 有些員工沒有工作
/*
select e.ename, j.jname
from emp e left join job j on e.eid = j.eid
*/

-- 4. 請找出每一個有工作的員工, 有員工的工作 ? 
--    透過 inner join (交集) 來實現
/*
select e.ename, j.jname
from emp e inner join job j on e.eid = j.eid 
*/

-- 5. 列出所有工作與對應的員工 ? 
--    透過 right join (向右關聯) 來實現
/*
select e.ename, j.jname
from emp e right join job j on e.eid = j.eid 
*/

-- 6. 利用 left join 找出沒工作的員工
--    left join 配合 where 實現差集
/*
select e.ename, j.jname
from emp e left join job j on e.eid = j.eid
where j.jname is null
*/

-- 7. 利用 right join 找出沒員工的工作
--    right join 配合 where 實現差集
/*
select e.ename, j.jname
from emp e right join job j on e.eid = j.eid 
where e.ename is null
*/

-- 8. 利用 left join 找出沒有工作的員工 與 right join 找出沒員工的工作
--    最後透過 union all 來加在一起 
select e.ename, j.jname
from emp e left join job j on e.eid = j.eid
where j.jname is null
union all
select e.ename, j.jname
from emp e right join job j on e.eid = j.eid 
where e.ename is null

