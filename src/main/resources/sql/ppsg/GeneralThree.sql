-- 建表语句
CREATE TABLE `ppsg_general_three` (
`id` BIGINT(20)  NOT NULL AUTO_INCREMENT ,
`general_id` BIGINT(20)  DEFAULT NULL  COMMENT 'general主键',
`code` INTEGER(11)  DEFAULT NULL  COMMENT '编码',
`name` VARCHAR(32)  DEFAULT NULL  COMMENT '名称',
`force` INTEGER(11)  DEFAULT NULL  COMMENT '整数武力',
`intellect` INTEGER(11)  DEFAULT NULL  COMMENT '整数智力',
`troops` INTEGER(11)  DEFAULT NULL  COMMENT '整数兵力',
`combat` INTEGER(11)  DEFAULT NULL  COMMENT '整数战力',
`force0` DECIMAL(10,2)  DEFAULT NULL  COMMENT '精确武力',
`intellect0` DECIMAL(10,2)  DEFAULT NULL  COMMENT '精确智力',
`troops0` DECIMAL(10,2)  DEFAULT NULL  COMMENT '精确兵力',
`combat0` DECIMAL(10,2)  DEFAULT NULL  COMMENT '精确战力',
PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 新增字段
ALTER TABLE `ppsg_general_three` ADD COLUMN id BIGINT(20)  DEFAULT NULL ;
ALTER TABLE `ppsg_general_three` ADD COLUMN general_id BIGINT(20)  DEFAULT NULL  COMMENT 'general主键';
ALTER TABLE `ppsg_general_three` ADD COLUMN code INTEGER(11)  DEFAULT NULL  COMMENT '编码';
ALTER TABLE `ppsg_general_three` ADD COLUMN name VARCHAR(32)  DEFAULT NULL  COMMENT '名称';
ALTER TABLE `ppsg_general_three` ADD COLUMN force INTEGER(11)  DEFAULT NULL  COMMENT '整数武力';
ALTER TABLE `ppsg_general_three` ADD COLUMN intellect INTEGER(11)  DEFAULT NULL  COMMENT '整数智力';
ALTER TABLE `ppsg_general_three` ADD COLUMN troops INTEGER(11)  DEFAULT NULL  COMMENT '整数兵力';
ALTER TABLE `ppsg_general_three` ADD COLUMN combat INTEGER(11)  DEFAULT NULL  COMMENT '整数战力';
ALTER TABLE `ppsg_general_three` ADD COLUMN force0 DECIMAL(10,2)  DEFAULT NULL  COMMENT '精确武力';
ALTER TABLE `ppsg_general_three` ADD COLUMN intellect0 DECIMAL(10,2)  DEFAULT NULL  COMMENT '精确智力';
ALTER TABLE `ppsg_general_three` ADD COLUMN troops0 DECIMAL(10,2)  DEFAULT NULL  COMMENT '精确兵力';
ALTER TABLE `ppsg_general_three` ADD COLUMN combat0 DECIMAL(10,2)  DEFAULT NULL  COMMENT '精确战力';

