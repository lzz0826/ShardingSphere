-- V<version>__<description>.sql
USE edu_db_1;
CREATE TABLE IF NOT EXISTS `course_1` (
                                          `cid` BIGINT(20) NOT NULL COMMENT 'userId',
    `cname` VARCHAR(40) NOT NULL COMMENT '名稱',
    `user_id` BIGINT(20) NOT NULL COMMENT 'userId',
    `cstatus` VARCHAR(10) NOT NULL COMMENT '狀態',
    PRIMARY KEY (`cid`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='course_1';

CREATE TABLE IF NOT EXISTS `course_2` (
                                          `cid` BIGINT(20) NOT NULL COMMENT 'userId',
    `cname` VARCHAR(40) NOT NULL COMMENT '名稱',
    `user_id` BIGINT(20) NOT NULL COMMENT 'userId',
    `cstatus` VARCHAR(10) NOT NULL COMMENT '狀態',
    PRIMARY KEY (`cid`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='course_2';

USE edu_db_2;
CREATE TABLE IF NOT EXISTS `course_1` (
                                          `cid` BIGINT(20) NOT NULL COMMENT 'userId',
    `cname` VARCHAR(40) NOT NULL COMMENT '名稱',
    `user_id` BIGINT(20) NOT NULL COMMENT 'userId',
    `cstatus` VARCHAR(10) NOT NULL COMMENT '狀態',
    PRIMARY KEY (`cid`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='course_1';

CREATE TABLE IF NOT EXISTS `course_2` (
                                          `cid` BIGINT(20) NOT NULL COMMENT 'userId',
    `cname` VARCHAR(40) NOT NULL COMMENT '名稱',
    `user_id` BIGINT(20) NOT NULL COMMENT 'userId',
    `cstatus` VARCHAR(10) NOT NULL COMMENT '狀態',
    PRIMARY KEY (`cid`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='course_2';