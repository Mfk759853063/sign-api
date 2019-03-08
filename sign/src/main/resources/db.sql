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

 Date: 08/03/2019 17:43:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for refinitiv_users
-- ----------------------------
DROP TABLE IF EXISTS `refinitiv_users`;
CREATE TABLE `refinitiv_users` (
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
-- Records of refinitiv_users
-- ----------------------------
BEGIN;
INSERT INTO `refinitiv_users` VALUES (123456789, 'wsnglzp00.s=', '周灿', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-03-08 00:00:00', '2019-03-08 17:01:57');
COMMIT;

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `id` varchar(255) NOT NULL,
  `activity_name` varchar(255) NOT NULL DEFAULT '',
  `activity_start_time` varchar(255) NOT NULL DEFAULT '',
  `activity_end_time` varchar(255) NOT NULL DEFAULT '',
  `activity_desc` varchar(1024) NOT NULL DEFAULT '',
  `extra` varchar(255) DEFAULT NULL,
  `status` tinyint(2) NOT NULL DEFAULT '1',
  `create_time` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_activity
-- ----------------------------
BEGIN;
INSERT INTO `t_activity` VALUES ('f23af432-d2cd-44d7-9bea-0fe73973d4be', '测试活动一', '1552089600000', '1552348800000', '测试活动一测试活动一测试活动一测试活动一', NULL, 1, '1552034751610');
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
  `create_time` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_ground
-- ----------------------------
BEGIN;
INSERT INTO `t_ground` VALUES ('130e89ce-8036-455a-90f3-75f809a01e82', 'f23af432-d2cd-44d7-9bea-0fe73973d4be', '主会场1', '重庆市渝北区101', NULL, 1, '1552034846574');
INSERT INTO `t_ground` VALUES ('7040a3e2-9529-4fb9-bf8a-0dec95ca3c12', '31567450-978e-4c1f-8b04-2a49b1b3a55c', '主会场', '重庆市渝北区101', NULL, 1, '1552029344205');
COMMIT;

-- ----------------------------
-- Table structure for t_ground_sign_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_ground_sign_rule`;
CREATE TABLE `t_ground_sign_rule` (
  `id` varchar(255) NOT NULL,
  `ground_id` varchar(255) NOT NULL,
  `sign_rule_name` varchar(255) DEFAULT NULL,
  `sign_start_time` varchar(255) NOT NULL DEFAULT '',
  `sign_end_time` varchar(255) NOT NULL DEFAULT '',
  `status` tinyint(2) NOT NULL DEFAULT '1',
  `extra` varchar(255) DEFAULT '',
  `create_time` varchar(255) NOT NULL,
  `user_sign_times` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_ground_sign_rule
-- ----------------------------
BEGIN;
INSERT INTO `t_ground_sign_rule` VALUES ('29360cc0-6627-4539-a29b-f2329f056f2b', '130e89ce-8036-455a-90f3-75f809a01e82', '上午签到时间', '1552003200000', '1552017600000', 1, NULL, '1552035404233', 1);
INSERT INTO `t_ground_sign_rule` VALUES ('b9e57f17-4f31-4220-90ab-4c47ef412377', '130e89ce-8036-455a-90f3-75f809a01e82', '下午签到时间', '1552021200000', '1552039200000', 1, NULL, '1552035506144', 1);
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

SET FOREIGN_KEY_CHECKS = 1;
