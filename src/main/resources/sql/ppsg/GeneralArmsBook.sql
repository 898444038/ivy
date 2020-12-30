-- 建表语句
CREATE TABLE `ppsg_general_arms_book` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`general_id` BIGINT(20)  DEFAULT NULL  COMMENT '武将主键',
`general_name` VARCHAR(32)  DEFAULT NULL  COMMENT '武将名称',
`position_code1` INTEGER(11)  DEFAULT NULL  COMMENT '位置编码1',
`position_name1` VARCHAR(32)  DEFAULT NULL  COMMENT '位置名称1',
`position_code2` INTEGER(11)  DEFAULT NULL  COMMENT '位置编码2',
`position_name2` VARCHAR(32)  DEFAULT NULL  COMMENT '位置名称2',
`position_code3` INTEGER(11)  DEFAULT NULL  COMMENT '位置编码3',
`position_name3` VARCHAR(32)  DEFAULT NULL  COMMENT '位置名称3',
`position_code4` INTEGER(11)  DEFAULT NULL  COMMENT '位置编码4',
`position_name4` VARCHAR(32)  DEFAULT NULL  COMMENT '位置名称4',
`position_code5` INTEGER(11)  DEFAULT NULL  COMMENT '位置编码5',
`position_name5` VARCHAR(32)  DEFAULT NULL  COMMENT '位置名称5',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `ppsg_general_arms_book` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `ppsg_general_arms_book` ADD COLUMN general_id BIGINT(20)  DEFAULT NULL  COMMENT '武将主键';
ALTER TABLE `ppsg_general_arms_book` ADD COLUMN general_name VARCHAR(32)  DEFAULT NULL  COMMENT '武将名称';
ALTER TABLE `ppsg_general_arms_book` ADD COLUMN position_code1 INTEGER(11)  DEFAULT NULL  COMMENT '位置编码1';
ALTER TABLE `ppsg_general_arms_book` ADD COLUMN position_name1 VARCHAR(32)  DEFAULT NULL  COMMENT '位置名称1';
ALTER TABLE `ppsg_general_arms_book` ADD COLUMN position_code2 INTEGER(11)  DEFAULT NULL  COMMENT '位置编码2';
ALTER TABLE `ppsg_general_arms_book` ADD COLUMN position_name2 VARCHAR(32)  DEFAULT NULL  COMMENT '位置名称2';
ALTER TABLE `ppsg_general_arms_book` ADD COLUMN position_code3 INTEGER(11)  DEFAULT NULL  COMMENT '位置编码3';
ALTER TABLE `ppsg_general_arms_book` ADD COLUMN position_name3 VARCHAR(32)  DEFAULT NULL  COMMENT '位置名称3';
ALTER TABLE `ppsg_general_arms_book` ADD COLUMN position_code4 INTEGER(11)  DEFAULT NULL  COMMENT '位置编码4';
ALTER TABLE `ppsg_general_arms_book` ADD COLUMN position_name4 VARCHAR(32)  DEFAULT NULL  COMMENT '位置名称4';
ALTER TABLE `ppsg_general_arms_book` ADD COLUMN position_code5 INTEGER(11)  DEFAULT NULL  COMMENT '位置编码5';
ALTER TABLE `ppsg_general_arms_book` ADD COLUMN position_name5 VARCHAR(32)  DEFAULT NULL  COMMENT '位置名称5';

