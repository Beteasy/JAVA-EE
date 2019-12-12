/*
Navicat MySQL Data Transfer

Source Server         : MySQL57
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : jspdb

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-11-20 14:50:37
*/
use javaeetest;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(200) DEFAULT NULL,
  `goods_price` float DEFAULT NULL,
  `goods_num` int(11) DEFAULT NULL,
  `goods_img` varchar(200) DEFAULT NULL,
  `goods_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`goods_id`),
  KEY `goods_type` (`goods_type`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`goods_type`) REFERENCES `goods_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 3072 kB; (`goods_type`) REFER `no8/goods_type`(';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'Blackmores EPO月见草', '230', '97', 'pro2.png', '4');
INSERT INTO `goods` VALUES ('2', 'Sukin苏芊 玫瑰果补湿日霜 ', '130', '100', 'pro1.png', '4');
INSERT INTO `goods` VALUES ('3', 'Swisse 澳洲活力胶原蛋白液', '150', '99', 'pro3.png', '4');
INSERT INTO `goods` VALUES ('4', 'Doppelherz 双心 补充毛囊防脱头发营养胶囊', '159', '100', 'pro4.png', '4');
INSERT INTO `goods` VALUES ('5', 'Swisse 发肤甲润泽口服液', '209', '99', 'pro5.png', '5');
INSERT INTO `goods` VALUES ('6', 'GNC 健安喜 女性胶原蛋白营养片', '115', '99', 'pro6.png', '5');
INSERT INTO `goods` VALUES ('7', 'HECH赫熙纯天然鱼子酱胶原蛋白肽粉胶囊', '200', '999', 'pro7.png', '5');
INSERT INTO `goods` VALUES ('8', 'EltaMD 氨基酸泡沫卸妆洁面乳', '119', '100', 'pro21.png', '4');
INSERT INTO `goods` VALUES ('9', 'Freeplus 芙丽芳丝 净润洗面霜 ', '108', '100', 'pro21.png', '4');
INSERT INTO `goods` VALUES ('10', 'SHISEIDO 资生堂 洗颜专科 超柔密泡泡洗面乳', '46', '100', 'pro21.png', '4');
INSERT INTO `goods` VALUES ('11', 'Freeplus 芙丽芳丝 净润洗面霜', '99', '100', 'pro21.png', '4');
INSERT INTO `goods` VALUES ('12', 'It\'S SKIN 伊思 美肌蜗牛修复洗面奶', '115', '100', 'pro21.png', '4');
INSERT INTO `goods` VALUES ('13', 'SHISEIDO 资生堂 洗颜专科 超柔密泡泡洗面乳 ', '99', '100', 'pro21.png', '4');
INSERT INTO `goods` VALUES ('14', 'SHISEIDO 资生堂 UNO 男士洗面奶 黑炭控油型', '44', '100', 'pro21.png', '4');
INSERT INTO `goods` VALUES ('15', 'Kanebo 佳丽宝 Suisai药用酵母酵素洗颜粉', '115', '100', 'pro21.png', '4');
INSERT INTO `goods` VALUES ('16', 'SHISEIDO 资生堂 UNO 男士泡沫快速洁面奶', '48', '99', 'pro21.png', '4');
INSERT INTO `goods` VALUES ('17', '【3件装】Freeplus 芙丽芳丝 净润洗面霜', '289', '197', 'pro21.png', '4');

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) DEFAULT NULL,
  `type_pid` int(11) DEFAULT NULL,
  `type_lv` int(11) DEFAULT NULL,
  `type_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`type_id`),
  KEY `type_pid` (`type_pid`),
  CONSTRAINT `goods_type_ibfk_1` FOREIGN KEY (`type_pid`) REFERENCES `goods_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES ('1', '护肤', null, '1', '|1|');
INSERT INTO `goods_type` VALUES ('2', '个人洗护', null, '1', '|2|');
INSERT INTO `goods_type` VALUES ('3', '健康生活', null, '1', '|3|');
INSERT INTO `goods_type` VALUES ('4', '面部洗护', '1', '2', '|1|4|');
INSERT INTO `goods_type` VALUES ('5', '眼部护理', '1', '2', '|1|5|');
INSERT INTO `goods_type` VALUES ('6', '唇部护理', '1', '2', '|1|6|');
INSERT INTO `goods_type` VALUES ('7', '祛斑祛痘', '1', '2', '|1|7|');
INSERT INTO `goods_type` VALUES ('8', '手足洗护', '1', '2', '|1|8|');
INSERT INTO `goods_type` VALUES ('9', '眼部护理', '1', '2', '|1|9|');
INSERT INTO `goods_type` VALUES ('10', '防晒修复', '1', '2', '|1|10|');
INSERT INTO `goods_type` VALUES ('11', '沐浴护肤', '2', '2', '|2|11|');
INSERT INTO `goods_type` VALUES ('12', '洗发护发', '2', '2', '|2|12|');
INSERT INTO `goods_type` VALUES ('13', '口腔护理', '2', '2', '|2|13|');
INSERT INTO `goods_type` VALUES ('14', '消毒液', '3', '2', '|3|14|');
INSERT INTO `goods_type` VALUES ('15', '洗洁精', '3', '2', '|3|15|');
INSERT INTO `goods_type` VALUES ('16', '测试', '1', '2', '|1||16|');
