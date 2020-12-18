-- 建表语句
CREATE TABLE `ivy_update_log` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`title` VARCHAR(32)  DEFAULT NULL  COMMENT '更新标题',
`remark` TEXT  DEFAULT NULL  COMMENT '更新内容',
`update_time` VARCHAR(32)  DEFAULT NULL  COMMENT '更新时间',
`color` VARCHAR(32)  DEFAULT NULL  COMMENT '颜色',
`icon` VARCHAR(32)  DEFAULT NULL  COMMENT '图标',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `ivy_update_log` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `ivy_update_log` ADD COLUMN title VARCHAR(32)  DEFAULT NULL  COMMENT '更新标题';
ALTER TABLE `ivy_update_log` ADD COLUMN remark TEXT  DEFAULT NULL  COMMENT '更新内容';
ALTER TABLE `ivy_update_log` ADD COLUMN update_time VARCHAR(32)  DEFAULT NULL  COMMENT '更新时间';
ALTER TABLE `ivy_update_log` ADD COLUMN color VARCHAR(32)  DEFAULT NULL  COMMENT '颜色';
ALTER TABLE `ivy_update_log` ADD COLUMN icon VARCHAR(32)  DEFAULT NULL  COMMENT '图标';

