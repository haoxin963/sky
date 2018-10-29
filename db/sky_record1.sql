/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : sky_record1

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-10-29 14:19:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rr_repair_item_0
-- ----------------------------
DROP TABLE IF EXISTS `rr_repair_item_0`;
CREATE TABLE `rr_repair_item_0` (
  `item_id` varchar(64) NOT NULL COMMENT '主键id',
  `record_id` varchar(64) DEFAULT NULL COMMENT '维修记录id',
  `maint_id` bigint(20) DEFAULT NULL COMMENT '维修企业id',
  `repairproject` varchar(200) DEFAULT NULL COMMENT '维修项目名称',
  `workinghours` double(12,1) DEFAULT NULL COMMENT '维修工时',
  `repairmark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `del_flag` char(1) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`item_id`),
  KEY `repairid` (`record_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='维修项目';

-- ----------------------------
-- Records of rr_repair_item_0
-- ----------------------------

-- ----------------------------
-- Table structure for rr_repair_item_1
-- ----------------------------
DROP TABLE IF EXISTS `rr_repair_item_1`;
CREATE TABLE `rr_repair_item_1` (
  `item_id` varchar(64) NOT NULL COMMENT '主键id',
  `record_id` varchar(64) DEFAULT NULL COMMENT '维修记录id',
  `maint_id` bigint(20) DEFAULT NULL COMMENT '维修企业id',
  `repairproject` varchar(200) DEFAULT NULL COMMENT '维修项目名称',
  `workinghours` double(12,1) DEFAULT NULL COMMENT '维修工时',
  `repairmark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `del_flag` char(1) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`item_id`),
  KEY `repairid` (`record_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='维修项目';

-- ----------------------------
-- Records of rr_repair_item_1
-- ----------------------------
INSERT INTO `rr_repair_item_1` VALUES ('506468978567151617', '506468978567151616', '37', '换机油', '2.0', null, '2018-10-29 14:06:54', null, null, null, '0');

-- ----------------------------
-- Table structure for rr_repair_item_2
-- ----------------------------
DROP TABLE IF EXISTS `rr_repair_item_2`;
CREATE TABLE `rr_repair_item_2` (
  `item_id` varchar(64) NOT NULL COMMENT '主键id',
  `record_id` varchar(64) DEFAULT NULL COMMENT '维修记录id',
  `maint_id` bigint(20) DEFAULT NULL COMMENT '维修企业id',
  `repairproject` varchar(200) DEFAULT NULL COMMENT '维修项目名称',
  `workinghours` double(12,1) DEFAULT NULL COMMENT '维修工时',
  `repairmark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `del_flag` char(1) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`item_id`),
  KEY `repairid` (`record_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='维修项目';

-- ----------------------------
-- Records of rr_repair_item_2
-- ----------------------------

-- ----------------------------
-- Table structure for rr_repair_part_0
-- ----------------------------
DROP TABLE IF EXISTS `rr_repair_part_0`;
CREATE TABLE `rr_repair_part_0` (
  `part_id` varchar(64) NOT NULL COMMENT '主键id',
  `record_id` varchar(64) DEFAULT NULL COMMENT '维修记录id',
  `maint_id` bigint(20) DEFAULT NULL COMMENT '维修企业id',
  `partsname` varchar(50) DEFAULT NULL COMMENT '配件名称',
  `partsquantity` double(12,2) DEFAULT NULL COMMENT '配件数量',
  `partscode` varchar(50) DEFAULT NULL COMMENT '配件编码',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `del_flag` char(1) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`part_id`),
  KEY `repairid` (`record_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='维修配件';

-- ----------------------------
-- Records of rr_repair_part_0
-- ----------------------------

-- ----------------------------
-- Table structure for rr_repair_part_1
-- ----------------------------
DROP TABLE IF EXISTS `rr_repair_part_1`;
CREATE TABLE `rr_repair_part_1` (
  `part_id` varchar(64) NOT NULL COMMENT '主键id',
  `record_id` varchar(64) DEFAULT NULL COMMENT '维修记录id',
  `maint_id` bigint(20) DEFAULT NULL COMMENT '维修企业id',
  `partsname` varchar(50) DEFAULT NULL COMMENT '配件名称',
  `partsquantity` double(12,2) DEFAULT NULL COMMENT '配件数量',
  `partscode` varchar(50) DEFAULT NULL COMMENT '配件编码',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `del_flag` char(1) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`part_id`),
  KEY `repairid` (`record_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='维修配件';

-- ----------------------------
-- Records of rr_repair_part_1
-- ----------------------------
INSERT INTO `rr_repair_part_1` VALUES ('506468978567151618', '506468978567151616', '37', '机油', '2.00', 'CC001', '2018-10-29 14:06:54', null, null, null, '0');

-- ----------------------------
-- Table structure for rr_repair_part_2
-- ----------------------------
DROP TABLE IF EXISTS `rr_repair_part_2`;
CREATE TABLE `rr_repair_part_2` (
  `part_id` varchar(64) NOT NULL COMMENT '主键id',
  `record_id` varchar(64) DEFAULT NULL COMMENT '维修记录id',
  `maint_id` bigint(20) DEFAULT NULL COMMENT '维修企业id',
  `partsname` varchar(50) DEFAULT NULL COMMENT '配件名称',
  `partsquantity` double(12,2) DEFAULT NULL COMMENT '配件数量',
  `partscode` varchar(50) DEFAULT NULL COMMENT '配件编码',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `del_flag` char(1) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`part_id`),
  KEY `repairid` (`record_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='维修配件';

-- ----------------------------
-- Records of rr_repair_part_2
-- ----------------------------

-- ----------------------------
-- Table structure for rr_repair_record_0
-- ----------------------------
DROP TABLE IF EXISTS `rr_repair_record_0`;
CREATE TABLE `rr_repair_record_0` (
  `record_id` varchar(64) NOT NULL COMMENT '主键id',
  `maint_id` bigint(20) DEFAULT NULL COMMENT '维修企业id',
  `maint_name` varchar(100) DEFAULT NULL COMMENT '维修企业名称',
  `maint_code` varchar(15) DEFAULT NULL COMMENT '维修企业编码',
  `vin` varchar(32) DEFAULT NULL COMMENT '维修车辆识别码',
  `vehicleplatenumber` varchar(8) DEFAULT NULL COMMENT '维修车辆车牌号码',
  `repairdate` date DEFAULT NULL COMMENT '送修日期',
  `repairrmileate` double(8,0) DEFAULT NULL COMMENT '送修里程',
  `settledate` datetime DEFAULT NULL COMMENT '维修结算日期',
  `faultdescription` varchar(200) DEFAULT NULL COMMENT '故障描述',
  `costlistcode` varchar(50) DEFAULT NULL COMMENT '故障结算清单编号',
  `repaircomefrom` char(2) DEFAULT NULL COMMENT '维修企业来源（1-同步，2-上级下发）',
  `repairtype` varchar(20) DEFAULT NULL COMMENT '维修类别（字典表）',
  `repeirnature` varchar(2) DEFAULT NULL COMMENT '维修性质（字典表）',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`record_id`),
  UNIQUE KEY `uneque` (`record_id`) USING BTREE,
  KEY `car_num` (`vehicleplatenumber`) USING BTREE,
  KEY `vin` (`vin`) USING BTREE,
  KEY `repair_company_id` (`maint_id`) USING BTREE,
  KEY `carnum_vin` (`vehicleplatenumber`,`vin`) USING BTREE,
  KEY `companycode` (`maint_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='维修记录';

-- ----------------------------
-- Records of rr_repair_record_0
-- ----------------------------

-- ----------------------------
-- Table structure for rr_repair_record_1
-- ----------------------------
DROP TABLE IF EXISTS `rr_repair_record_1`;
CREATE TABLE `rr_repair_record_1` (
  `record_id` varchar(64) NOT NULL COMMENT '主键id',
  `maint_id` bigint(20) DEFAULT NULL COMMENT '维修企业id',
  `maint_name` varchar(100) DEFAULT NULL COMMENT '维修企业名称',
  `maint_code` varchar(15) DEFAULT NULL COMMENT '维修企业编码',
  `vin` varchar(32) DEFAULT NULL COMMENT '维修车辆识别码',
  `vehicleplatenumber` varchar(8) DEFAULT NULL COMMENT '维修车辆车牌号码',
  `repairdate` date DEFAULT NULL COMMENT '送修日期',
  `repairrmileate` double(8,0) DEFAULT NULL COMMENT '送修里程',
  `settledate` datetime DEFAULT NULL COMMENT '维修结算日期',
  `faultdescription` varchar(200) DEFAULT NULL COMMENT '故障描述',
  `costlistcode` varchar(50) DEFAULT NULL COMMENT '故障结算清单编号',
  `repaircomefrom` char(2) DEFAULT NULL COMMENT '维修企业来源（1-同步，2-上级下发）',
  `repairtype` varchar(20) DEFAULT NULL COMMENT '维修类别（字典表）',
  `repeirnature` varchar(2) DEFAULT NULL COMMENT '维修性质（字典表）',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`record_id`),
  UNIQUE KEY `uneque` (`record_id`) USING BTREE,
  KEY `car_num` (`vehicleplatenumber`) USING BTREE,
  KEY `vin` (`vin`) USING BTREE,
  KEY `repair_company_id` (`maint_id`) USING BTREE,
  KEY `carnum_vin` (`vehicleplatenumber`,`vin`) USING BTREE,
  KEY `companycode` (`maint_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='维修记录';

-- ----------------------------
-- Records of rr_repair_record_1
-- ----------------------------
INSERT INTO `rr_repair_record_1` VALUES ('506468978567151616', '37', '汽修厂', null, 'LS123344333', '苏B12345', '2018-10-10', '7000', '2018-10-10 08:00:00', '保养', 'BY001', null, null, null, '2018-10-29 14:06:54', null, null, null, '0');

-- ----------------------------
-- Table structure for rr_repair_record_2
-- ----------------------------
DROP TABLE IF EXISTS `rr_repair_record_2`;
CREATE TABLE `rr_repair_record_2` (
  `record_id` varchar(64) NOT NULL COMMENT '主键id',
  `maint_id` bigint(20) DEFAULT NULL COMMENT '维修企业id',
  `maint_name` varchar(100) DEFAULT NULL COMMENT '维修企业名称',
  `maint_code` varchar(15) DEFAULT NULL COMMENT '维修企业编码',
  `vin` varchar(32) DEFAULT NULL COMMENT '维修车辆识别码',
  `vehicleplatenumber` varchar(8) DEFAULT NULL COMMENT '维修车辆车牌号码',
  `repairdate` date DEFAULT NULL COMMENT '送修日期',
  `repairrmileate` double(8,0) DEFAULT NULL COMMENT '送修里程',
  `settledate` datetime DEFAULT NULL COMMENT '维修结算日期',
  `faultdescription` varchar(200) DEFAULT NULL COMMENT '故障描述',
  `costlistcode` varchar(50) DEFAULT NULL COMMENT '故障结算清单编号',
  `repaircomefrom` char(2) DEFAULT NULL COMMENT '维修企业来源（1-同步，2-上级下发）',
  `repairtype` varchar(20) DEFAULT NULL COMMENT '维修类别（字典表）',
  `repeirnature` varchar(2) DEFAULT NULL COMMENT '维修性质（字典表）',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`record_id`),
  UNIQUE KEY `uneque` (`record_id`) USING BTREE,
  KEY `car_num` (`vehicleplatenumber`) USING BTREE,
  KEY `vin` (`vin`) USING BTREE,
  KEY `repair_company_id` (`maint_id`) USING BTREE,
  KEY `carnum_vin` (`vehicleplatenumber`,`vin`) USING BTREE,
  KEY `companycode` (`maint_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='维修记录';

-- ----------------------------
-- Records of rr_repair_record_2
-- ----------------------------
