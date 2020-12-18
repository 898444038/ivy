-- 建表语句
CREATE TABLE `ivy_mysql_status` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`code` VARCHAR(32)  DEFAULT NULL  COMMENT '状态名',
`scope` VARCHAR(32)  DEFAULT NULL  COMMENT '作用域',
`explicate` VARCHAR(32)  DEFAULT NULL  COMMENT '详细解释',
`create_time` datetime  DEFAULT NULL  COMMENT '创建时间',
`enable_flag` TINYINT(1)  DEFAULT NULL  COMMENT '是否启用[0:未启用,1:已启用]',
`del_flag` TINYINT(1)  DEFAULT NULL  COMMENT '是否删除[0:未删除,1:已删除]',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `ivy_mysql_status` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `ivy_mysql_status` ADD COLUMN code VARCHAR(32)  DEFAULT NULL  COMMENT '状态名';
ALTER TABLE `ivy_mysql_status` ADD COLUMN scope VARCHAR(32)  DEFAULT NULL  COMMENT '作用域';
ALTER TABLE `ivy_mysql_status` ADD COLUMN explicate VARCHAR(32)  DEFAULT NULL  COMMENT '详细解释';
ALTER TABLE `ivy_mysql_status` ADD COLUMN create_time datetime  DEFAULT NULL  COMMENT '创建时间';
ALTER TABLE `ivy_mysql_status` ADD COLUMN enable_flag TINYINT(1)  DEFAULT NULL  COMMENT '是否启用[0:未启用,1:已启用]';
ALTER TABLE `ivy_mysql_status` ADD COLUMN del_flag TINYINT(1)  DEFAULT NULL  COMMENT '是否删除[0:未删除,1:已删除]';

