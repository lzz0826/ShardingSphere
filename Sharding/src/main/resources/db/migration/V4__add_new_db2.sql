-- V<version>__<description>.sql
USE user_db;
CREATE TABLE IF NOT EXISTS `t_user` (
    `user_id` BIGINT(20) NOT NULL COMMENT 'userId',
    `username` VARCHAR(40) NOT NULL COMMENT 'username',
    `ustatus` VARCHAR(10) NOT NULL COMMENT '狀態',
    PRIMARY KEY (`user_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='course_1';

