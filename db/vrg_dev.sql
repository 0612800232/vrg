/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : vrg_dev

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2016-02-19 16:56:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `goods_type` int(11) DEFAULT NULL,
  `goods_desc` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `creater_id` int(11) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for `goods_type`
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `goods_type_desc` varchar(512) DEFAULT NULL,
  `creater_id` int(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES ('5', 'dddddddadfd', '13757162418', null, null, null);
INSERT INTO `goods_type` VALUES ('6', '111111', '13757162418', '11', '2016-02-18 14:11:39', '2016-02-18 14:11:39');
INSERT INTO `goods_type` VALUES ('7', '1111112', '13757162418', '11', '2016-02-18 14:12:59', '2016-02-18 14:12:59');

-- ----------------------------
-- Table structure for `location`
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `location_desc` varchar(512) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `x` varchar(255) DEFAULT NULL,
  `y` varchar(255) DEFAULT NULL,
  `location_type` int(11) DEFAULT NULL,
  `day_hot` int(11) DEFAULT NULL,
  `week_hot` int(11) DEFAULT NULL,
  `month_hot` int(11) DEFAULT NULL,
  `year_hot` int(11) DEFAULT NULL,
  `creater_id` int(11) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES ('2', 'tesdddd', '13757162418', null, '1.1', '2.2', null, null, null, null, null, '11', null, null, null);

-- ----------------------------
-- Table structure for `location_type`
-- ----------------------------
DROP TABLE IF EXISTS `location_type`;
CREATE TABLE `location_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `location_type_desc` varchar(512) DEFAULT NULL,
  `creater_id` int(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location_type
-- ----------------------------
INSERT INTO `location_type` VALUES ('5', 'dddddddadfd', '13757162418', null, null, null);
INSERT INTO `location_type` VALUES ('6', '111111', '13757162418', '11', '2016-02-18 14:11:39', '2016-02-18 14:11:39');
INSERT INTO `location_type` VALUES ('7', '1111112', '13757162418', '11', '2016-02-18 14:12:59', '2016-02-18 14:12:59');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `mobile_no` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `card_no` varchar(255) DEFAULT NULL,
  `hometown_name` varchar(255) DEFAULT NULL,
  `hometown_address_x` varchar(255) DEFAULT NULL,
  `hometown_address_y` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'lee123', null, null, null, null, null, null, null, null, null, null, '2016-02-17 12:05:38', '2016-02-17 12:05:38');
INSERT INTO `user` VALUES ('3', 'lee123', null, null, null, null, null, null, null, null, null, null, '2016-02-17 12:10:22', '2016-02-17 12:10:22');
INSERT INTO `user` VALUES ('4', 'lee123', '13757162413', null, null, null, null, null, null, null, null, null, '2016-02-17 12:10:50', '2016-02-17 12:10:50');
INSERT INTO `user` VALUES ('5', 'lee123', '13757162413', null, null, null, null, null, null, null, null, null, '2016-02-17 12:11:25', '2016-02-17 12:11:25');
INSERT INTO `user` VALUES ('6', 'lee123', '13757162413', null, null, null, null, null, null, null, null, null, '2016-02-17 12:28:17', '2016-02-17 12:28:17');
INSERT INTO `user` VALUES ('7', 'lee123', '13757162413', null, null, null, null, null, null, null, null, null, '2016-02-17 12:28:49', '2016-02-17 12:28:49');
INSERT INTO `user` VALUES ('8', 'lee123', '13757162415', null, null, null, null, null, null, null, null, null, '2016-02-17 14:28:46', '2016-02-17 14:28:46');
INSERT INTO `user` VALUES ('9', 'lee1234', '13757162416', null, null, null, null, null, null, null, null, null, '2016-02-17 14:29:01', '2016-02-17 14:29:01');
INSERT INTO `user` VALUES ('10', 'lee1234', '13757162417', null, null, null, null, null, null, null, null, null, '2016-02-17 14:30:52', '2016-02-17 14:30:52');
INSERT INTO `user` VALUES ('11', 'lee12', '13757162418', null, null, null, null, null, null, null, null, null, '2016-02-17 18:39:11', '2016-02-17 18:39:11');
INSERT INTO `user` VALUES ('12', 'lee1234', '13757162419', null, null, null, null, null, null, null, null, null, '2016-02-17 14:43:44', '2016-02-17 14:43:44');
INSERT INTO `user` VALUES ('13', 'lee1234', '13757162421', null, null, null, null, null, null, null, null, null, '2016-02-17 15:43:41', '2016-02-17 15:43:41');
INSERT INTO `user` VALUES ('14', 'lee1234', '13757162432', null, null, null, null, null, null, null, null, null, '2016-02-17 18:08:54', '2016-02-17 18:08:54');

-- ----------------------------
-- Table structure for `user_location`
-- ----------------------------
DROP TABLE IF EXISTS `user_location`;
CREATE TABLE `user_location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `location_type` int(11) DEFAULT '0' COMMENT '地址类型枚举',
  `location_name` varchar(255) DEFAULT NULL,
  `location_x` varchar(255) DEFAULT NULL,
  `location_y` varchar(255) DEFAULT NULL,
  `location_status` int(11) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_location
-- ----------------------------

-- ----------------------------
-- Table structure for `user_location_log`
-- ----------------------------
DROP TABLE IF EXISTS `user_location_log`;
CREATE TABLE `user_location_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `location_name` varchar(255) DEFAULT NULL,
  `location_x` varchar(255) DEFAULT NULL,
  `location_y` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_location_log
-- ----------------------------
INSERT INTO `user_location_log` VALUES ('3', '11', null, '5', '5', '2016-02-18 15:15:40');
INSERT INTO `user_location_log` VALUES ('4', '11', null, '5', '5', '2016-02-18 15:15:40');
INSERT INTO `user_location_log` VALUES ('5', '11', null, '5', '5', '2016-02-18 15:15:41');
INSERT INTO `user_location_log` VALUES ('6', '11', null, '5', '5', '2016-02-18 15:15:41');
INSERT INTO `user_location_log` VALUES ('7', '11', null, '5', '5', '2016-02-18 15:15:41');
INSERT INTO `user_location_log` VALUES ('8', '11', null, '5', '5', '2016-02-18 15:17:20');
