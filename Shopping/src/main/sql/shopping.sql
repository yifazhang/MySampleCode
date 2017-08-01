
CREATE USER 'Ivan'@'%' IDENTIFIED BY '123456';
GRANT ALL ON *.* TO 'Ivan'@'%';
flush privileges;

-- 数据库表结构：
-- 创建数据库
CREATE DATABASE `shopping0718`;

USE `shopping0718`;


-- 用户表
create table person(
id int auto_increment primary key comment '主键',
user_name varchar(100) comment '用户名',
pass_word varchar(100) comment '密码md5加密',
nick_name varchar(50) comment '用户昵称',
user_type tinyint(3) comment '类型，买家0，卖家1')
ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- 内容表
create table content(
id int auto_increment primary key comment '主键',
price DOUBLE  comment '当前价格',
title varchar(100) comment '标题',
image varchar(500) comment '图片',
summary varchar(200) comment '摘要',
detail blob comment '正文'  )
ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- 交易记录表
create table trx(
id int auto_increment primary key comment '主键',
content_id int  comment '内容ID',
person_id int comment '用户ID',
price DOUBLE comment '购买价格',
num INT COMMENT '购买数量',
time DATETIME DEFAULT CURRENT_TIMESTAMP comment '购买时间')
ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- 用户数据：
-- 买家用户：buyer，密码：reyub
-- 卖家用户：seller，密码：relles
insert into `person` (`user_name`, `pass_word`, `nick_name`, `user_type`) values('buyer','37254660e226ea65ce6f1efd54233424','buyer','0');
insert into `person` (`user_name`, `pass_word`, `nick_name`, `user_type`) values('seller','981c57a5cfb0f868e064904b8745766f','seller','1');

SELECT sum(num) FROM trx t
WHERE t.content_id = 11



