-- V<version>__<description>.sql
USE user_db;

CREATE TABLE IF NOT EXISTS `t_master` (
    `masterid` BIGINT(20) NOT NULL COMMENT 'master',
    `mname` VARCHAR(40) NOT NULL COMMENT '名稱',
    `mstatus` VARCHAR(10) NOT NULL COMMENT '狀態',
    PRIMARY KEY (`masterid`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_master';