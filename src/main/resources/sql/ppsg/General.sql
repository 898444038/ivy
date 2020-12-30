-- 建表语句
CREATE TABLE `ppsg_general` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`parent_id` BIGINT(20)  DEFAULT NULL  COMMENT '父级ID',
`parent_name` VARCHAR(32)  DEFAULT NULL  COMMENT '父级名称',
`name` VARCHAR(32)  DEFAULT NULL  COMMENT '武将名称',
`level` INTEGER(11)  DEFAULT NULL  COMMENT '等级',
`gender_code` INTEGER(11)  DEFAULT NULL  COMMENT '性别编码',
`gender_name` VARCHAR(32)  DEFAULT NULL  COMMENT '性别名称',
`country_code` INTEGER(11)  DEFAULT NULL  COMMENT '国家编码',
`country_name` VARCHAR(32)  DEFAULT NULL  COMMENT '国家名称',
`star_code` INTEGER(11)  DEFAULT NULL  COMMENT '星级编码',
`star_name` VARCHAR(32)  DEFAULT NULL  COMMENT '星级名称',
`arms_code` INTEGER(11)  DEFAULT NULL  COMMENT '兵种编码',
`arms_name` VARCHAR(32)  DEFAULT NULL  COMMENT '兵种名称',
`type_code` INTEGER(11)  DEFAULT NULL  COMMENT '武将类型编码',
`type_name` VARCHAR(32)  DEFAULT NULL  COMMENT '武将类型名称',
`category_code` INTEGER(11)  DEFAULT NULL  COMMENT '分类编码',
`category_name` VARCHAR(32)  DEFAULT NULL  COMMENT '分类名称',
`destiny_code` INTEGER(11)  DEFAULT NULL  COMMENT '命格编码',
`destiny_name` VARCHAR(32)  DEFAULT NULL  COMMENT '命格名称',
`enable_flag` TINYINT(1)  DEFAULT NULL  COMMENT '启用标识【0：未启用，1：启用】',
`del_flag` TINYINT(1)  DEFAULT NULL  COMMENT '删除标识【0：删除，1：未删除】',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `ppsg_general` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `ppsg_general` ADD COLUMN parent_id BIGINT(20)  DEFAULT NULL  COMMENT '父级ID';
ALTER TABLE `ppsg_general` ADD COLUMN parent_name VARCHAR(32)  DEFAULT NULL  COMMENT '父级名称';
ALTER TABLE `ppsg_general` ADD COLUMN name VARCHAR(32)  DEFAULT NULL  COMMENT '武将名称';
ALTER TABLE `ppsg_general` ADD COLUMN level INTEGER(11)  DEFAULT NULL  COMMENT '等级';
ALTER TABLE `ppsg_general` ADD COLUMN gender_code INTEGER(11)  DEFAULT NULL  COMMENT '性别编码';
ALTER TABLE `ppsg_general` ADD COLUMN gender_name VARCHAR(32)  DEFAULT NULL  COMMENT '性别名称';
ALTER TABLE `ppsg_general` ADD COLUMN country_code INTEGER(11)  DEFAULT NULL  COMMENT '国家编码';
ALTER TABLE `ppsg_general` ADD COLUMN country_name VARCHAR(32)  DEFAULT NULL  COMMENT '国家名称';
ALTER TABLE `ppsg_general` ADD COLUMN star_code INTEGER(11)  DEFAULT NULL  COMMENT '星级编码';
ALTER TABLE `ppsg_general` ADD COLUMN star_name VARCHAR(32)  DEFAULT NULL  COMMENT '星级名称';
ALTER TABLE `ppsg_general` ADD COLUMN arms_code INTEGER(11)  DEFAULT NULL  COMMENT '兵种编码';
ALTER TABLE `ppsg_general` ADD COLUMN arms_name VARCHAR(32)  DEFAULT NULL  COMMENT '兵种名称';
ALTER TABLE `ppsg_general` ADD COLUMN type_code INTEGER(11)  DEFAULT NULL  COMMENT '武将类型编码';
ALTER TABLE `ppsg_general` ADD COLUMN type_name VARCHAR(32)  DEFAULT NULL  COMMENT '武将类型名称';
ALTER TABLE `ppsg_general` ADD COLUMN category_code INTEGER(11)  DEFAULT NULL  COMMENT '分类编码';
ALTER TABLE `ppsg_general` ADD COLUMN category_name VARCHAR(32)  DEFAULT NULL  COMMENT '分类名称';
ALTER TABLE `ppsg_general` ADD COLUMN destiny_code INTEGER(11)  DEFAULT NULL  COMMENT '命格编码';
ALTER TABLE `ppsg_general` ADD COLUMN destiny_name VARCHAR(32)  DEFAULT NULL  COMMENT '命格名称';
ALTER TABLE `ppsg_general` ADD COLUMN enable_flag TINYINT(1)  DEFAULT NULL  COMMENT '启用标识【0：未启用，1：启用】';
ALTER TABLE `ppsg_general` ADD COLUMN del_flag TINYINT(1)  DEFAULT NULL  COMMENT '删除标识【0：删除，1：未删除】';

