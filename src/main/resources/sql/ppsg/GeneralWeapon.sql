-- 建表语句
CREATE TABLE `ppsg_general_weapon` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`name` VARCHAR(32)  DEFAULT NULL  COMMENT '战器名称',
`weapon_code` INTEGER(11)  DEFAULT NULL  COMMENT '战器类型编码',
`weapon_name` VARCHAR(32)  DEFAULT NULL  COMMENT '战器类型名称',
`general_id` BIGINT(20)  DEFAULT NULL  COMMENT '武将主键',
`general_name` VARCHAR(32)  DEFAULT NULL  COMMENT '武将名称',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `ppsg_general_weapon` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `ppsg_general_weapon` ADD COLUMN name VARCHAR(32)  DEFAULT NULL  COMMENT '战器名称';
ALTER TABLE `ppsg_general_weapon` ADD COLUMN weapon_code INTEGER(11)  DEFAULT NULL  COMMENT '战器类型编码';
ALTER TABLE `ppsg_general_weapon` ADD COLUMN weapon_name VARCHAR(32)  DEFAULT NULL  COMMENT '战器类型名称';
ALTER TABLE `ppsg_general_weapon` ADD COLUMN general_id BIGINT(20)  DEFAULT NULL  COMMENT '武将主键';
ALTER TABLE `ppsg_general_weapon` ADD COLUMN general_name VARCHAR(32)  DEFAULT NULL  COMMENT '武将名称';

