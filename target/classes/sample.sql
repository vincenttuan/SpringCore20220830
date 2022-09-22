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