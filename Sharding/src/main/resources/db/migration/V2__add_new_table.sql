-- V<version>__<description>.sql
USE course_db;

CREATE TABLE IF NOT EXISTS `course_2` (
    `cid` BIGINT(20) NOT NULL COMMENT 'userId',
    `cname` VARCHAR(40) NOT NULL COMMENT '名稱',
    `user_id` BIGINT(20) NOT NULL COMMENT 'userId',
    `cstatus` VARCHAR(10) NOT NULL COMMENT '狀態',
    PRIMARY KEY (`cid`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='course_2';