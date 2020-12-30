-- 建表语句
CREATE TABLE `ppsg_general_association` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`name` VARCHAR(32)  DEFAULT NULL  COMMENT '联协名称',
`general_id` BIGINT(20)  DEFAULT NULL  COMMENT '武将主键',
`general_name` VARCHAR(32)  DEFAULT NULL  COMMENT '武将名称',
`rate` DECIMAL(10,2)  DEFAULT NULL  COMMENT '加成',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `ppsg_general_association` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `ppsg_general_association` ADD COLUMN name VARCHAR(32)  DEFAULT NULL  COMMENT '联协名称';
ALTER TABLE `ppsg_general_association` ADD COLUMN general_id BIGINT(20)  DEFAULT NULL  COMMENT '武将主键';
ALTER TABLE `ppsg_general_association` ADD COLUMN general_name VARCHAR(32)  DEFAULT NULL  COMMENT '武将名称';
ALTER TABLE `ppsg_general_association` ADD COLUMN rate DECIMAL(10,2)  DEFAULT NULL  COMMENT '加成';

