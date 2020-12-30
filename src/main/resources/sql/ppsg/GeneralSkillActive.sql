-- 建表语句
CREATE TABLE `ppsg_general_skill_active` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`general_id` BIGINT(20)  DEFAULT NULL  COMMENT '武将主键',
`general_name` VARCHAR(32)  DEFAULT NULL  COMMENT '武将名称',
`name` VARCHAR(32)  DEFAULT NULL  COMMENT '技能名称',
`morale` INTEGER(11)  DEFAULT NULL  COMMENT '技能士气',
`effect` VARCHAR(32)  DEFAULT NULL  COMMENT '技能效果',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `ppsg_general_skill_active` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `ppsg_general_skill_active` ADD COLUMN general_id BIGINT(20)  DEFAULT NULL  COMMENT '武将主键';
ALTER TABLE `ppsg_general_skill_active` ADD COLUMN general_name VARCHAR(32)  DEFAULT NULL  COMMENT '武将名称';
ALTER TABLE `ppsg_general_skill_active` ADD COLUMN name VARCHAR(32)  DEFAULT NULL  COMMENT '技能名称';
ALTER TABLE `ppsg_general_skill_active` ADD COLUMN morale INTEGER(11)  DEFAULT NULL  COMMENT '技能士气';
ALTER TABLE `ppsg_general_skill_active` ADD COLUMN effect VARCHAR(32)  DEFAULT NULL  COMMENT '技能效果';

