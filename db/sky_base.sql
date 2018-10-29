/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : sky_base

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-10-29 14:18:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  `name` varchar(32) NOT NULL COMMENT '菜单名称',
  `permission` varchar(32) DEFAULT NULL COMMENT '菜单权限标识',
  `path` varchar(128) DEFAULT NULL COMMENT '前端URL',
  `url` varchar(128) DEFAULT NULL COMMENT '请求链接',
  `method` varchar(32) DEFAULT NULL COMMENT '请求方法',
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单ID',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `component` varchar(64) DEFAULT NULL COMMENT 'VUE页面',
  `sort` int(11) DEFAULT '1' COMMENT '排序值',
  `type` char(1) DEFAULT NULL COMMENT '菜单类型 （0菜单 1按钮）',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '0--正常 1--删除',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '上传记录', '', null, '/restApi/record/addRecord*', 'POST', null, null, null, null, '1', '2017-11-08 09:52:09', '2018-10-26 15:39:32', '0');
INSERT INTO `sys_menu` VALUES ('2', '查询记录', '', null, '/restApi/record/*', 'GET', null, null, null, null, '1', '2018-01-20 14:56:59', '2018-10-29 14:10:37', '0');

-- ----------------------------
-- Table structure for sys_oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_oauth_client_details`;
CREATE TABLE `sys_oauth_client_details` (
  `client_id` varchar(40) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_oauth_client_details
-- ----------------------------
INSERT INTO `sys_oauth_client_details` VALUES ('app', null, 'app', 'server', 'password,refresh_token', null, null, '72000', '72000', null, 'true');
INSERT INTO `sys_oauth_client_details` VALUES ('sky', null, 'sky', 'server', 'password,refresh_token,authorization_code', null, null, '72000', '72000', null, 'false');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `role_code` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `role_desc` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` char(1) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_idx1_role_code` (`role_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', 'ROLE_ADMIN', '超级管理员', '2017-10-29 15:45:51', '2018-04-22 11:40:29', '0');
INSERT INTO `sys_role` VALUES ('2', 'rest', 'REST', 'rest接口', '2018-04-20 07:14:32', '2018-10-26 15:41:49', '0');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(64) NOT NULL COMMENT '登陆名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `last_login_ip` varchar(32) DEFAULT NULL COMMENT '最后登陆ip',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `user_image` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '是否有效(0-未删除，1-已删除)',
  PRIMARY KEY (`user_id`),
  KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '$2a$10$inY5j/9VEE5VCyRReD79EeGwijRMLlNN4CcWvvoUMQsk2HiHWocc2', '18500367895', '2018-10-25 18:37:13', '', 'admin', '', '', '2018-09-29 16:31:43', '1', '2018-09-29 16:31:46', null, '0');
INSERT INTO `sys_user` VALUES ('2', 'test', '$2a$10$S/oOIrzfFKx70BrKHW8Er.b/.pYD.N7CnjBa9nklXV8SM8ikf4vHC', null, null, null, null, null, null, '2018-10-26 14:14:52', null, '2018-10-26 14:14:52', null, '0');
INSERT INTO `sys_user` VALUES ('37', 'test1', '$2a$10$9B8udMNPlR8rZQFTqIcthu5Iccc0IYz4iEWyOHcIzUrg426YHCEUu', null, null, null, null, null, null, '2018-10-29 14:06:24', null, '2018-10-29 14:06:24', null, '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
INSERT INTO `sys_user_role` VALUES ('37', '2');

-- ----------------------------
-- Table structure for zipkin_annotations
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_annotations`;
CREATE TABLE `zipkin_annotations` (
  `trace_id_high` bigint(20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.trace_id',
  `span_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.id',
  `a_key` varchar(255) NOT NULL COMMENT 'BinaryAnnotation.key or Annotation.value if type == -1',
  `a_value` blob COMMENT 'BinaryAnnotation.value(), which must be smaller than 64KB',
  `a_type` int(11) NOT NULL COMMENT 'BinaryAnnotation.type() or -1 if Annotation',
  `a_timestamp` bigint(20) DEFAULT NULL COMMENT 'Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp',
  `endpoint_ipv4` int(11) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_ipv6` binary(16) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null, or no IPv6 address',
  `endpoint_port` smallint(6) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_service_name` varchar(255) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_4` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job',
  KEY `trace_id_high_5` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_6` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name_2` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type_2` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key_2` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id_2` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_annotations
-- ----------------------------
INSERT INTO `zipkin_annotations` VALUES ('0', '-3693830684733373707', '-3693830684733373707', 'lc', 0x72786A617661, '6', '1540276390545000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3693830684733373707', '-3693830684733373707', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276390545000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-5349148889329074346', '-5349148889329074346', 'lc', 0x72786A617661, '6', '1540276394545000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-5349148889329074346', '-5349148889329074346', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276394545000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '527625637083776786', '527625637083776786', 'lc', 0x72786A617661, '6', '1540276399044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '527625637083776786', '527625637083776786', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276399044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2624265059132153927', '-2624265059132153927', 'lc', 0x72786A617661, '6', '1540276403044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2624265059132153927', '-2624265059132153927', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276403044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2874671207276830102', '3406238328981916598', 'cs', null, '-1', '1540276403166000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2874671207276830102', '3406238328981916598', 'cr', null, '-1', '1540276403173000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2874671207276830102', '3406238328981916598', 'http.method', 0x504F5354, '6', '1540276403166000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2874671207276830102', '3406238328981916598', 'http.path', 0x2F7265737473657276696365732F746F6B656E, '6', '1540276403166000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2874671207276830102', '3406238328981916598', 'http.status_code', 0x353033, '6', '1540276403166000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2874671207276830102', '3406238328981916598', 'http.url', 0x2F7265737473657276696365732F746F6B656E, '6', '1540276403166000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2874671207276830102', '3406238328981916598', 'lc', 0x7A75756C, '6', '1540276403166000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2874671207276830102', '3406238328981916598', 'spring.instance_id', 0x3139322E3136382E31302E35303A716364612D676174657761793A39393939, '6', '1540276403166000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '4828440306962546423', '4828440306962546423', 'lc', 0x72786A617661, '6', '1540276406044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '4828440306962546423', '4828440306962546423', 'thread', 0x5278496F5363686564756C65722D32, '6', '1540276406044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '3408618531279535526', '3408618531279535526', 'lc', 0x72786A617661, '6', '1540276406544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '3408618531279535526', '3408618531279535526', 'thread', 0x5278496F5363686564756C65722D32, '6', '1540276406544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '5477836435878903205', '5477836435878903205', 'sr', null, '-1', '1540276407067000', '-1062729166', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '5477836435878903205', '5477836435878903205', 'ss', null, '-1', '1540276407132522', '-1062729166', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '5477836435878903205', '5477836435878903205', 'http.host', 0x3139322E3136382E31302E3530, '6', '1540276407067000', '-1062729166', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '5477836435878903205', '5477836435878903205', 'http.method', 0x474554, '6', '1540276407067000', '-1062729166', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '5477836435878903205', '5477836435878903205', 'http.path', 0x2F757365722F66696E64557365724279557365726E616D652F313131313131313131313131303037, '6', '1540276407067000', '-1062729166', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '5477836435878903205', '5477836435878903205', 'http.status_code', 0x323030, '6', '1540276407067000', '-1062729166', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '5477836435878903205', '5477836435878903205', 'http.url', 0x687474703A2F2F3139322E3136382E31302E35303A383030332F757365722F66696E64557365724279557365726E616D652F313131313131313131313131303037, '6', '1540276407067000', '-1062729166', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '5477836435878903205', '5477836435878903205', 'mvc.controller.class', 0x55736572436F6E74726F6C6C6572, '6', '1540276407067000', '-1062729166', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '5477836435878903205', '5477836435878903205', 'mvc.controller.method', 0x66696E64557365724279557365726E616D65, '6', '1540276407067000', '-1062729166', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '5477836435878903205', '5477836435878903205', 'spring.instance_id', 0x3139322E3136382E31302E35303A716364612D726261632D736572766963653A38303033, '6', '1540276407067000', '-1062729166', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '1834303823889076620', '1834303823889076620', 'sr', null, '-1', '1540276409552000', '-1062729165', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '1834303823889076620', '1834303823889076620', 'ss', null, '-1', '1540276409573454', '-1062729165', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '1834303823889076620', '1834303823889076620', 'http.host', 0x3139322E3136382E31302E3531, '6', '1540276409552000', '-1062729165', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '1834303823889076620', '1834303823889076620', 'http.method', 0x474554, '6', '1540276409552000', '-1062729165', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '1834303823889076620', '1834303823889076620', 'http.path', 0x2F757365722F66696E64557365724279557365726E616D652F313131313131313131313131303037, '6', '1540276409552000', '-1062729165', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '1834303823889076620', '1834303823889076620', 'http.status_code', 0x323030, '6', '1540276409552000', '-1062729165', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '1834303823889076620', '1834303823889076620', 'http.url', 0x687474703A2F2F3139322E3136382E31302E35313A383030332F757365722F66696E64557365724279557365726E616D652F313131313131313131313131303037, '6', '1540276409552000', '-1062729165', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '1834303823889076620', '1834303823889076620', 'mvc.controller.class', 0x55736572436F6E74726F6C6C6572, '6', '1540276409552000', '-1062729165', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '1834303823889076620', '1834303823889076620', 'mvc.controller.method', 0x66696E64557365724279557365726E616D65, '6', '1540276409552000', '-1062729165', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '1834303823889076620', '1834303823889076620', 'spring.instance_id', 0x3139322E3136382E31302E35313A716364612D726261632D736572766963653A38303033, '6', '1540276409552000', '-1062729165', null, '8003', 'qcda-rbac-service');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8847934302990295813', '-8847934302990295813', 'lc', 0x72786A617661, '6', '1540276416544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8847934302990295813', '-8847934302990295813', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276416544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2501238671350282139', '-2501238671350282139', 'lc', 0x72786A617661, '6', '1540276421044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2501238671350282139', '-2501238671350282139', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276421044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-4756973990384537192', '-4756973990384537192', 'lc', 0x72786A617661, '6', '1540276424044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-4756973990384537192', '-4756973990384537192', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276424044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-1676714589389774224', '-1676714589389774224', 'lc', 0x72786A617661, '6', '1540276428544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-1676714589389774224', '-1676714589389774224', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276428544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-4245219222448749449', '-4245219222448749449', 'lc', 0x72786A617661, '6', '1540276431044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-4245219222448749449', '-4245219222448749449', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276431044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-4748024178585333365', '-4748024178585333365', 'lc', 0x72786A617661, '6', '1540276431544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-4748024178585333365', '-4748024178585333365', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276431544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3950906354848936684', '-3950906354848936684', 'lc', 0x72786A617661, '6', '1540276440044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3950906354848936684', '-3950906354848936684', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276440044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8460617070372484554', '-8460617070372484554', 'lc', 0x72786A617661, '6', '1540276444044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8460617070372484554', '-8460617070372484554', 'thread', 0x5278496F5363686564756C65722D32, '6', '1540276444044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '6294275827123034153', '6294275827123034153', 'lc', 0x72786A617661, '6', '1540276448044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '6294275827123034153', '6294275827123034153', 'thread', 0x5278496F5363686564756C65722D32, '6', '1540276448044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6374991834511147977', '-6374991834511147977', 'lc', 0x72786A617661, '6', '1540276452043000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6374991834511147977', '-6374991834511147977', 'thread', 0x5278496F5363686564756C65722D32, '6', '1540276452043000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6678023472513427057', '-6678023472513427057', 'lc', 0x72786A617661, '6', '1540276455043000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6678023472513427057', '-6678023472513427057', 'thread', 0x5278496F5363686564756C65722D32, '6', '1540276455043000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '7746064167742453453', '7746064167742453453', 'lc', 0x72786A617661, '6', '1540276462543000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '7746064167742453453', '7746064167742453453', 'thread', 0x5278496F5363686564756C65722D32, '6', '1540276462543000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '5488696713830785379', '5488696713830785379', 'lc', 0x72786A617661, '6', '1540276462543000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '5488696713830785379', '5488696713830785379', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276462543000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-5762277176725721721', '-5762277176725721721', 'lc', 0x72786A617661, '6', '1540276468044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-5762277176725721721', '-5762277176725721721', 'thread', 0x5278496F5363686564756C65722D32, '6', '1540276468044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '6258920026642908808', '6258920026642908808', 'lc', 0x72786A617661, '6', '1540276468544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '6258920026642908808', '6258920026642908808', 'thread', 0x5278496F5363686564756C65722D32, '6', '1540276468544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '7671915850724881635', '7671915850724881635', 'lc', 0x72786A617661, '6', '1540276472544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '7671915850724881635', '7671915850724881635', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276472544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2191374823085449166', '2191374823085449166', 'lc', 0x72786A617661, '6', '1540276476044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2191374823085449166', '2191374823085449166', 'thread', 0x5278496F5363686564756C65722D32, '6', '1540276476044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-951835506215741733', '-951835506215741733', 'lc', 0x72786A617661, '6', '1540276476044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-951835506215741733', '-951835506215741733', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276476044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-5148586091517556977', '-5148586091517556977', 'lc', 0x72786A617661, '6', '1540276479544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-5148586091517556977', '-5148586091517556977', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276479544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '137369103037570058', '137369103037570058', 'lc', 0x72786A617661, '6', '1540276483544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '137369103037570058', '137369103037570058', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276483544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-1436509535674043838', '-1436509535674043838', 'lc', 0x72786A617661, '6', '1540276491544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-1436509535674043838', '-1436509535674043838', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276491544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '4201544735715390979', '4201544735715390979', 'lc', 0x72786A617661, '6', '1540276496044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '4201544735715390979', '4201544735715390979', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276496044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '1883203013478571280', '1883203013478571280', 'lc', 0x72786A617661, '6', '1540276499044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '1883203013478571280', '1883203013478571280', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276499044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6084179574517791155', '-6084179574517791155', 'lc', 0x72786A617661, '6', '1540276503543000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6084179574517791155', '-6084179574517791155', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276503543000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2143996804839518958', '2143996804839518958', 'lc', 0x72786A617661, '6', '1540276506044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2143996804839518958', '2143996804839518958', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276506044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6352286269211428847', '-6352286269211428847', 'lc', 0x72786A617661, '6', '1540276506544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6352286269211428847', '-6352286269211428847', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276506544000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2010203414694443433', '2010203414694443433', 'lc', 0x72786A617661, '6', '1540276515043000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2010203414694443433', '2010203414694443433', 'thread', 0x5278496F5363686564756C65722D34, '6', '1540276515043000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2835884011311693828', '2835884011311693828', 'lc', 0x72786A617661, '6', '1540276519044000', '-1062729166', null, '9999', 'qcda-gateway');
INSERT INTO `zipkin_annotations` VALUES ('0', '2835884011311693828', '2835884011311693828', 'thread', 0x5278496F5363686564756C65722D32, '6', '1540276519044000', '-1062729166', null, '9999', 'qcda-gateway');

-- ----------------------------
-- Table structure for zipkin_dependencies
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_dependencies`;
CREATE TABLE `zipkin_dependencies` (
  `day` date NOT NULL,
  `parent` varchar(255) NOT NULL,
  `child` varchar(255) NOT NULL,
  `call_count` bigint(20) DEFAULT NULL,
  UNIQUE KEY `day` (`day`,`parent`,`child`),
  UNIQUE KEY `day_2` (`day`,`parent`,`child`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_dependencies
-- ----------------------------

-- ----------------------------
-- Table structure for zipkin_spans
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_spans`;
CREATE TABLE `zipkin_spans` (
  `trace_id_high` bigint(20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `debug` bit(1) DEFAULT NULL,
  `start_ts` bigint(20) DEFAULT NULL COMMENT 'Span.timestamp(): epoch micros used for endTs query and to implement TTL',
  `duration` bigint(20) DEFAULT NULL COMMENT 'Span.duration(): micros used for minDuration and maxDuration query',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_4` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts` (`start_ts`) COMMENT 'for getTraces ordering and range',
  KEY `trace_id_high_5` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_6` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name_2` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts_2` (`start_ts`) COMMENT 'for getTraces ordering and range'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_spans
-- ----------------------------
INSERT INTO `zipkin_spans` VALUES ('0', '-8847934302990295813', '-8847934302990295813', 'rxjava', null, null, '1540276416544000', '647');
INSERT INTO `zipkin_spans` VALUES ('0', '-8460617070372484554', '-8460617070372484554', 'rxjava', null, null, '1540276444044000', '414');
INSERT INTO `zipkin_spans` VALUES ('0', '-6678023472513427057', '-6678023472513427057', 'rxjava', null, null, '1540276455043000', '407');
INSERT INTO `zipkin_spans` VALUES ('0', '-6374991834511147977', '-6374991834511147977', 'rxjava', null, null, '1540276452043000', '501');
INSERT INTO `zipkin_spans` VALUES ('0', '-6352286269211428847', '-6352286269211428847', 'rxjava', null, null, '1540276506544000', '392');
INSERT INTO `zipkin_spans` VALUES ('0', '-6084179574517791155', '-6084179574517791155', 'rxjava', null, null, '1540276503543000', '328');
INSERT INTO `zipkin_spans` VALUES ('0', '-5762277176725721721', '-5762277176725721721', 'rxjava', null, null, '1540276468044000', '455');
INSERT INTO `zipkin_spans` VALUES ('0', '-5349148889329074346', '-5349148889329074346', 'rxjava', null, null, '1540276394545000', '669');
INSERT INTO `zipkin_spans` VALUES ('0', '-5148586091517556977', '-5148586091517556977', 'rxjava', null, null, '1540276479544000', '438');
INSERT INTO `zipkin_spans` VALUES ('0', '-4756973990384537192', '-4756973990384537192', 'rxjava', null, null, '1540276424044000', '267');
INSERT INTO `zipkin_spans` VALUES ('0', '-4748024178585333365', '-4748024178585333365', 'rxjava', null, null, '1540276431544000', '489');
INSERT INTO `zipkin_spans` VALUES ('0', '-4245219222448749449', '-4245219222448749449', 'rxjava', null, null, '1540276431044000', '663');
INSERT INTO `zipkin_spans` VALUES ('0', '-3950906354848936684', '-3950906354848936684', 'rxjava', null, null, '1540276440044000', '340');
INSERT INTO `zipkin_spans` VALUES ('0', '-3693830684733373707', '-3693830684733373707', 'rxjava', null, null, '1540276390545000', '592');
INSERT INTO `zipkin_spans` VALUES ('0', '-2624265059132153927', '-2624265059132153927', 'rxjava', null, null, '1540276403044000', '545');
INSERT INTO `zipkin_spans` VALUES ('0', '-2501238671350282139', '-2501238671350282139', 'rxjava', null, null, '1540276421044000', '435');
INSERT INTO `zipkin_spans` VALUES ('0', '-1676714589389774224', '-1676714589389774224', 'rxjava', null, null, '1540276428544000', '421');
INSERT INTO `zipkin_spans` VALUES ('0', '-1436509535674043838', '-1436509535674043838', 'rxjava', null, null, '1540276491544000', '352');
INSERT INTO `zipkin_spans` VALUES ('0', '-951835506215741733', '-951835506215741733', 'rxjava', null, null, '1540276476044000', '352');
INSERT INTO `zipkin_spans` VALUES ('0', '137369103037570058', '137369103037570058', 'rxjava', null, null, '1540276483544000', '364');
INSERT INTO `zipkin_spans` VALUES ('0', '527625637083776786', '527625637083776786', 'rxjava', null, null, '1540276399044000', '701');
INSERT INTO `zipkin_spans` VALUES ('0', '1834303823889076620', '1834303823889076620', 'http:/user/finduserbyusername/111111111111007', null, null, '1540276409552000', '21454');
INSERT INTO `zipkin_spans` VALUES ('0', '1883203013478571280', '1883203013478571280', 'rxjava', null, null, '1540276499044000', '289');
INSERT INTO `zipkin_spans` VALUES ('0', '2010203414694443433', '2010203414694443433', 'rxjava', null, null, '1540276515043000', '270');
INSERT INTO `zipkin_spans` VALUES ('0', '2143996804839518958', '2143996804839518958', 'rxjava', null, null, '1540276506044000', '274');
INSERT INTO `zipkin_spans` VALUES ('0', '2191374823085449166', '2191374823085449166', 'rxjava', null, null, '1540276476044000', '392');
INSERT INTO `zipkin_spans` VALUES ('0', '2835884011311693828', '2835884011311693828', 'rxjava', null, null, '1540276519044000', '443');
INSERT INTO `zipkin_spans` VALUES ('0', '2874671207276830102', '3406238328981916598', 'http:/auth/restservices/token', '2874671207276830102', null, '1540276403166000', '7000');
INSERT INTO `zipkin_spans` VALUES ('0', '3408618531279535526', '3408618531279535526', 'rxjava', null, null, '1540276406544000', '855');
INSERT INTO `zipkin_spans` VALUES ('0', '4201544735715390979', '4201544735715390979', 'rxjava', null, null, '1540276496044000', '363');
INSERT INTO `zipkin_spans` VALUES ('0', '4828440306962546423', '4828440306962546423', 'rxjava', null, null, '1540276406044000', '485');
INSERT INTO `zipkin_spans` VALUES ('0', '5477836435878903205', '5477836435878903205', 'http:/user/finduserbyusername/111111111111007', null, null, '1540276407067000', '65522');
INSERT INTO `zipkin_spans` VALUES ('0', '5488696713830785379', '5488696713830785379', 'rxjava', null, null, '1540276462543000', '288');
INSERT INTO `zipkin_spans` VALUES ('0', '6258920026642908808', '6258920026642908808', 'rxjava', null, null, '1540276468544000', '437');
INSERT INTO `zipkin_spans` VALUES ('0', '6294275827123034153', '6294275827123034153', 'rxjava', null, null, '1540276448044000', '539');
INSERT INTO `zipkin_spans` VALUES ('0', '7671915850724881635', '7671915850724881635', 'rxjava', null, null, '1540276472544000', '424');
INSERT INTO `zipkin_spans` VALUES ('0', '7746064167742453453', '7746064167742453453', 'rxjava', null, null, '1540276462543000', '415');
