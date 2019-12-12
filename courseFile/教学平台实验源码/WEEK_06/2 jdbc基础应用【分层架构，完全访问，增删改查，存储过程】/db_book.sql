/*
Navicat MySQL Data Transfer

Source Server         : MySQL57
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : db_book

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-11-22 08:10:58
*/
use javaeetest;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `price` int(10) unsigned DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `intro` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('4', '计算机文化基础', '张浩太', '20', '电子工业出版社', '无');
INSERT INTO `books` VALUES ('8', 'Ruby从入门到精通', '刘明', '433', '人民邮电出版社', '大数据教材');
INSERT INTO `books` VALUES ('15', '猫和老鼠', '汤姆', '18', '教育出版社', '无');
INSERT INTO `books` VALUES ('20', '猫和老鼠', '汤姆', '18', '教育出版社', '无');
INSERT INTO `books` VALUES ('32', '老人与狗', '222', '222', '222', '222');
INSERT INTO `books` VALUES ('35', '猫和老鼠2', '汤姆2', '20', '教育出版社2', '无2');
INSERT INTO `books` VALUES ('36', '猫和老鼠3', '汤姆4', '20', '教育出版社42', '无42');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `memo` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '软件开发类', '像Java、C#');
INSERT INTO `category` VALUES ('3', '动态网页', '像PHP、Ruby');
INSERT INTO `category` VALUES ('4', 'HIBERNATE', null);
INSERT INTO `category` VALUES ('5', 'MYBATIS', null);
INSERT INTO `category` VALUES ('6', null, 'Linux');
INSERT INTO `category` VALUES ('7', null, 'Office');
INSERT INTO `category` VALUES ('8', '前台设计', null);
INSERT INTO `category` VALUES ('9', '基础应用', null);

-- ----------------------------
-- Procedure structure for p_searchBooksByPrice
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_searchBooksByPrice`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_searchBooksByPrice`(IN `minprice` integer,IN `maxprice` integer)
BEGIN
SELECT * FROM books where price>=minprice and price<=maxprice;
END
;;
DELIMITER ;
