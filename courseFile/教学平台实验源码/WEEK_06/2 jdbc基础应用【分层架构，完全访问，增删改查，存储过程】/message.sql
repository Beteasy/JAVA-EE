/*
Navicat MySQL Data Transfer

Source Server         : MySQL57
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : message

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-11-22 08:11:35
*/
use javaeetest;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message_info
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `message_content` varchar(250) DEFAULT NULL,
  `message_time` datetime DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_info
-- ----------------------------
INSERT INTO `message_info` VALUES ('1', '1', '你们的网站( ^_^ )不错嘛', '2017-12-10 00:00:00');
INSERT INTO `message_info` VALUES ('2', '1', '推荐大家都去学习JAVAEE，从入门到放弃啊。。。。', '2017-11-06 14:22:07');
INSERT INTO `message_info` VALUES ('3', '1', 'asdfasdf', '2018-11-20 13:57:47');
INSERT INTO `message_info` VALUES ('4', '1', 'asdfasdf', '2018-11-20 13:57:51');
INSERT INTO `message_info` VALUES ('5', '0', '我是aaa', '2018-11-20 13:58:10');
INSERT INTO `message_info` VALUES ('6', '1', '有话好好说，说好了不给零分的。', '2018-11-20 14:13:43');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(100) DEFAULT NULL,
  `user_pwd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'fhzheng', '123546');
