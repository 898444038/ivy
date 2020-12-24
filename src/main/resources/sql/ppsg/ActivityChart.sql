-- 建表语句
CREATE TABLE `ppsg_activity_chart` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`title` VARCHAR(32)  DEFAULT NULL  COMMENT '名称',
`create_time` datetime  DEFAULT NULL  COMMENT '创建日期',
`url` VARCHAR(32)  DEFAULT NULL  COMMENT '二进制数据',
`del_flag` TINYINT(1)  DEFAULT NULL  COMMENT '删除标识【0：删除，1：未删除】',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `ppsg_activity_chart` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `ppsg_activity_chart` ADD COLUMN title VARCHAR(32)  DEFAULT NULL  COMMENT '名称';
ALTER TABLE `ppsg_activity_chart` ADD COLUMN create_time datetime  DEFAULT NULL  COMMENT '创建日期';
ALTER TABLE `ppsg_activity_chart` ADD COLUMN url VARCHAR(32)  DEFAULT NULL  COMMENT '二进制数据';
ALTER TABLE `ppsg_activity_chart` ADD COLUMN del_flag TINYINT(1)  DEFAULT NULL  COMMENT '删除标识【0：删除，1：未删除】';

