-- V<version>__<description>.sql
-- 添加公共表在 edu_db_1 edu_db_2 t_user course_db 中都添加t_udict表 可以同事對三個庫裡的 t_udict 增刪改查
USE user_db;
CREATE TABLE IF NOT EXISTS `t_udict` (
    `dict_id` BIGINT(20) NOT NULL COMMENT 'dict_id',
    `ustatus` VARCHAR(100) NOT NULL COMMENT 'ustatus',
    `uvalue` VARCHAR(100) NOT NULL COMMENT 'bvalue',
    PRIMARY KEY (`dict_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_udict';

USE edu_db_1;
CREATE TABLE IF NOT EXISTS `t_udict` (
                                         `dict_id` BIGINT(20) NOT NULL COMMENT 'dict_id',
    `ustatus` VARCHAR(100) NOT NULL COMMENT 'ustatus',
    `uvalue` VARCHAR(100) NOT NULL COMMENT 'bvalue',
    PRIMARY KEY (`dict_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_udict';

USE edu_db_2;
CREATE TABLE IF NOT EXISTS `t_udict` (
    `dict_id` BIGINT(20) NOT NULL COMMENT 'dict_id',
    `ustatus` VARCHAR(100) NOT NULL COMMENT 'ustatus',
    `uvalue` VARCHAR(100) NOT NULL COMMENT 'bvalue',
    PRIMARY KEY (`dict_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_udict';

USE course_db;
CREATE TABLE IF NOT EXISTS `t_udict` (
    `dict_id` BIGINT(20) NOT NULL COMMENT 'dict_id',
    `ustatus` VARCHAR(100) NOT NULL COMMENT 'ustatus',
    `uvalue` VARCHAR(100) NOT NULL COMMENT 'bvalue',
    PRIMARY KEY (`dict_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_udict';