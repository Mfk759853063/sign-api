/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : sign

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 14/03/2019 16:46:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `id` varchar(255) NOT NULL,
  `activity_name` varchar(255) NOT NULL DEFAULT '',
  `activity_start_time` bigint(13) NOT NULL,
  `activity_end_time` bigint(13) NOT NULL,
  `activity_desc` varchar(1024) NOT NULL DEFAULT '',
  `extra` varchar(255) DEFAULT NULL,
  `status` tinyint(2) NOT NULL DEFAULT '1',
  `create_time` bigint(13) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_activity
-- ----------------------------
BEGIN;
INSERT INTO `t_activity` VALUES ('1d2b1a43-242e-4009-801b-1dead5207843', 'simpleVue', 1552406400000, 1553097600000, 'desccc', NULL, 9, 1552469710516);
INSERT INTO `t_activity` VALUES ('38817dba-bddb-4281-9337-4f99cda44b30', '11223', 0, 0, 'sdfsdf', NULL, 9, 1552468345389);
INSERT INTO `t_activity` VALUES ('6466f8bd-537a-420d-8e09-9b4dcc1f37aa', 'helloworld', 1552406400000, 1553097600000, 'yes11111', NULL, 9, 1552471026651);
INSERT INTO `t_activity` VALUES ('7c190b11-2d6a-431e-a527-64f172e84c38', '12', 0, 0, '34', NULL, 9, 1552468196652);
INSERT INTO `t_activity` VALUES ('98868f11-841a-41fa-86fb-c246eef50ba0', 'vue create', 1552406400000, 1553011200000, 'simple', NULL, 9, 1552470903122);
INSERT INTO `t_activity` VALUES ('a4b865e9-2d7d-4951-86ed-80acd2d2dbf9', '2221', 43, 43, '12232', NULL, 9, 1552468213051);
INSERT INTO `t_activity` VALUES ('f23af432-d2cd-44d7-9bea-0fe14731973d422e', '测试活动4', 1552089600000, 1552348800000, '测试活动一测试活动一测试活动一测试活动一', NULL, 9, 1552034751610);
INSERT INTO `t_activity` VALUES ('f23af432-d2cd-44d7-9bea-0fe147319w73d422e', '测试活动5', 1552089600000, 1552348800000, '测试活动一测试活动一测试活动一测试活动一', NULL, 9, 1552034751610);
INSERT INTO `t_activity` VALUES ('f23af432-d2cd-44d7-9bea-0fe1731973d422e', '测试活动3', 1552089600000, 1552348800000, '测试活动一测试活动一测试活动一测试活动一', NULL, 9, 1552034751610);
INSERT INTO `t_activity` VALUES ('f23af432-d2cd-44d7-9bea-0fe173973d422e', '测试活动二', 1552089600000, 1552348800000, '测试活动一测试活动一测试活动一测试活动一', NULL, 9, 1552034751610);
INSERT INTO `t_activity` VALUES ('f23af432-d2cd-44d7-9bea-0fe732973d422e', '测试活动二', 1552089600000, 1552348800000, '测试活动一测试活动一测试活动一测试活动一', NULL, 9, 1552034751610);
INSERT INTO `t_activity` VALUES ('f23af432-d2cd-44d7-9bea-0fe73973d422e', '测试活动二', 1552089600000, 1552348800000, '测试活动一测试活动一测试活动一测试活动一', NULL, 9, 1552034751610);
INSERT INTO `t_activity` VALUES ('f23af432-d2cd-44d7-9bea-0fe73973d4232e2', '测试活动二', 1552089600000, 1552348800000, '测试活动一测试活动一测试活动一测试活动一', NULL, 9, 1552034751610);
INSERT INTO `t_activity` VALUES ('f23af432-d2cd-44d7-9bea-0fe73973d4be', '测试活动一', 1552089600000, 1552348800000, '测试活动一测试活动一测试活动一测试活动一', NULL, 1, 1552034751610);
COMMIT;

-- ----------------------------
-- Table structure for t_ground
-- ----------------------------
DROP TABLE IF EXISTS `t_ground`;
CREATE TABLE `t_ground` (
  `id` varchar(255) NOT NULL,
  `activity_id` varchar(255) NOT NULL,
  `ground_name` varchar(255) NOT NULL DEFAULT '',
  `ground_addr` varchar(255) NOT NULL DEFAULT '',
  `extra` varchar(255) DEFAULT '',
  `status` tinyint(2) NOT NULL DEFAULT '1',
  `create_time` bigint(13) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_ground
-- ----------------------------
BEGIN;
INSERT INTO `t_ground` VALUES ('130e89ce-8036-455a-90f3-75f809a01e82', 'f23af432-d2cd-44d7-9bea-0fe73973d4be', '主会场1', '重庆市渝北区101', NULL, 1, 1552034846574);
INSERT INTO `t_ground` VALUES ('7040a3e2-9529-4fb9-bf8a-0dec95ca3c12', '31567450-978e-4c1f-8b04-2a49b1b3a55c', '主会场', '重庆市渝北区101', NULL, 1, 1552029344205);
INSERT INTO `t_ground` VALUES ('99116df8-7b5a-41d5-ab04-071837f4abb0', 'f23af432-d2cd-44d7-9bea-0fe73973d4be', '8888', '77777', NULL, 9, 1552534082163);
INSERT INTO `t_ground` VALUES ('9cef039c-1590-4048-a565-0d4196285702', 'f23af432-d2cd-44d7-9bea-0fe73973d4be', 'sdhfdgfdsf', 'fdsfdsfds', NULL, 9, 1552534019015);
INSERT INTO `t_ground` VALUES ('ada517ad-6f2b-4cc7-86bf-ce5c4bce75e1', '98868f11-841a-41fa-86fb-c246eef50ba0', '1123456789', '908765432', NULL, 1, 1552530298501);
INSERT INTO `t_ground` VALUES ('ead46a17-60aa-43b9-87cf-0bf76db144d2', '98868f11-841a-41fa-86fb-c246eef50ba0', 'dsdfsdf', 'sdfsfdfdfffff', NULL, 9, 1552530267654);
COMMIT;

-- ----------------------------
-- Table structure for t_ground_sign_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_ground_sign_rule`;
CREATE TABLE `t_ground_sign_rule` (
  `id` varchar(255) NOT NULL,
  `ground_id` varchar(255) NOT NULL,
  `sign_rule_name` varchar(255) DEFAULT NULL,
  `sign_start_time` bigint(13) NOT NULL,
  `sign_end_time` bigint(13) NOT NULL,
  `status` tinyint(2) NOT NULL DEFAULT '1',
  `extra` varchar(255) DEFAULT '',
  `create_time` bigint(13) NOT NULL,
  `user_sign_times` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_ground_sign_rule
-- ----------------------------
BEGIN;
INSERT INTO `t_ground_sign_rule` VALUES ('015bef43-52cf-4715-9d65-5b6e702a8797', '130e89ce-8036-455a-90f3-75f809a01e82', 'simple', 1552089600000, 1552345200000, 1, NULL, 1552546571483, 1);
INSERT INTO `t_ground_sign_rule` VALUES ('29360cc0-6627-4539-a29b-f2329f056f2b', '130e89ce-8036-455a-90f3-75f809a01e82', '上午签到时间', 1552003200000, 1552233600000, 9, NULL, 1552035404233, 1);
INSERT INTO `t_ground_sign_rule` VALUES ('6294597a-9d3d-4c12-99a9-324aaf7c9498', '130e89ce-8036-455a-90f3-75f809a01e82', 'simple', 1552089600000, 1552348800000, 9, NULL, 1552546487052, 2);
INSERT INTO `t_ground_sign_rule` VALUES ('b9e57f17-4f31-4220-90ab-4c47ef412377', '130e89ce-8036-455a-90f3-75f809a01e82', '下午签到时间', 1552021200000, 1552039200000, 9, NULL, 1552035506144, 1);
COMMIT;

-- ----------------------------
-- Table structure for t_sign
-- ----------------------------
DROP TABLE IF EXISTS `t_sign`;
CREATE TABLE `t_sign` (
  `id` varchar(255) NOT NULL,
  `activity_id` varchar(255) NOT NULL DEFAULT '',
  `ground_id` varchar(255) NOT NULL DEFAULT '',
  `sign_rule_id` varchar(255) NOT NULL,
  `sign_time` varchar(255) NOT NULL DEFAULT '',
  `user_id` varchar(255) NOT NULL DEFAULT '',
  `status` tinyint(2) NOT NULL DEFAULT '1',
  `extra` varchar(255) DEFAULT '',
  `create_time` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_sign
-- ----------------------------
BEGIN;
INSERT INTO `t_sign` VALUES ('a9346469-d5c3-4c3c-835e-00bab18cb880', 'f23af432-d2cd-44d7-9bea-0fe73973d4be', '130e89ce-8036-455a-90f3-75f809a01e82', 'b9e57f17-4f31-4220-90ab-4c47ef412377', '1552036759574', '123456789', 1, NULL, '1552036759574');
COMMIT;

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `user_name` varchar(255) NOT NULL,
  `user_pwd` varchar(255) DEFAULT NULL,
  `user_type` tinyint(1) DEFAULT NULL,
  `create_time` bigint(14) DEFAULT NULL,
  `extra` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_user` VALUES ('admin', '123456', 1, 1552089600000, NULL, 'skjfkdsjlfjsdkljfkdlsjkfljdsklfjl', 1, 'admin');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `card` varchar(255) DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `startAddress` varchar(255) DEFAULT NULL,
  `seat` varchar(255) DEFAULT NULL,
  `shuttle` varchar(255) DEFAULT NULL,
  `signIn` int(11) DEFAULT NULL,
  `signTime` datetime DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123456790 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (123456789, 'wsnglzp00.s=', '周灿', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-03-08 00:00:00', '2019-03-08 17:01:57');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
