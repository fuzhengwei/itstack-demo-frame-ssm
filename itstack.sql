DROP TABLE user;
CREATE TABLE user ( id bigint(11) NOT NULL AUTO_INCREMENT, name varchar(32), age int(4), address varchar(128), entryTime datetime, remark varchar(64), createTime datetime, updateTime datetime, status int(4) DEFAULT '0', PRIMARY KEY (id), INDEX idx_name (name) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into user (id, name, age, address, entryTime, remark, createTime, updateTime, status) values (1, '水水', 18, '吉林省榆树市黑林镇尹家村5组', '2019-12-22 00:00:00', '无', '2019-12-22 00:00:00', '2019-12-22 00:00:00', 0);
insert into user (id, name, age, address, entryTime, remark, createTime, updateTime, status) values (2, '豆豆', 18, '辽宁省大连市清河湾司马道407路', '2019-12-22 00:00:00', '无', '2019-12-22 00:00:00', '2019-12-22 00:00:00', 1);
insert into user (id, name, age, address, entryTime, remark, createTime, updateTime, status) values (3, '花花', 19, '辽宁省大连市清河湾司马道407路', '2019-12-22 00:00:00', '无', '2019-12-22 00:00:00', '2019-12-22 00:00:00', 0);
