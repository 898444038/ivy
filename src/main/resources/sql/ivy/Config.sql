-- 建表语句
CREATE TABLE `ivy_config` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`name` VARCHAR(32)  DEFAULT NULL  COMMENT '名称',
`code` VARCHAR(32)  DEFAULT NULL  COMMENT '编号',
`val` VARCHAR(32)  DEFAULT NULL  COMMENT '值',
`default_val` VARCHAR(32)  DEFAULT NULL  COMMENT '默认值',
`remark` VARCHAR(32)  DEFAULT NULL  COMMENT '备注',
`is_enable` TINYINT(1)  DEFAULT NULL  COMMENT '是否启用[0:未启用,1:启用]',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `ivy_config` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `ivy_config` ADD COLUMN name VARCHAR(32)  DEFAULT NULL  COMMENT '名称';
ALTER TABLE `ivy_config` ADD COLUMN code VARCHAR(32)  DEFAULT NULL  COMMENT '编号';
ALTER TABLE `ivy_config` ADD COLUMN val VARCHAR(32)  DEFAULT NULL  COMMENT '值';
ALTER TABLE `ivy_config` ADD COLUMN default_val VARCHAR(32)  DEFAULT NULL  COMMENT '默认值';
ALTER TABLE `ivy_config` ADD COLUMN remark VARCHAR(32)  DEFAULT NULL  COMMENT '备注';
ALTER TABLE `ivy_config` ADD COLUMN is_enable TINYINT(1)  DEFAULT NULL  COMMENT '是否启用[0:未启用,1:启用]';

