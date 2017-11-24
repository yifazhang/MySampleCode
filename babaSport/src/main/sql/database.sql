-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE babaSport;

USE babaSport;

CREATE TABLE `test_db` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `birthday` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET = utf8 COMMENT = '测试表';


