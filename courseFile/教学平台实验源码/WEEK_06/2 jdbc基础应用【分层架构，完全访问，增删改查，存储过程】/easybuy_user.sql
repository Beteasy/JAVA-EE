/*
Navicat MySQL Data Transfer

Source Server         : MySQL57
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : easybuy

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-11-22 08:06:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for easybuy_user
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_user`;
CREATE TABLE `easybuy_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `loginName` varchar(255) NOT NULL COMMENT '登录名',
  `userName` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `sex` int(2) NOT NULL DEFAULT '1' COMMENT '性别(1:男 0：女)',
  `identityCode` varchar(60) DEFAULT NULL COMMENT '身份证号',
  `email` varchar(80) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `type` int(2) DEFAULT '0' COMMENT '类型（1：后台 0:前台）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___C96109CC3A81B327` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_user
-- ----------------------------
INSERT INTO `easybuy_user` VALUES ('2', 'admin', '系统管理员', 'e10adc3949ba59abbe56e057f20f883e', '1', '130406198302141869', 'hello11@bdqn.com', '1583233515', '1');
INSERT INTO `easybuy_user` VALUES ('10', 'cgn', '程广宁', 'e10adc3949ba59abbe56e057f20f883e', '1', '140225189987854589', '1044732267@qq.com', '13366055011', '0');
INSERT INTO `easybuy_user` VALUES ('11', 'hyl', '韩语良', '123456', '1', '140225198874584539', '1044732267@qq.com', '13366055010', '0');
INSERT INTO `easybuy_user` VALUES ('12', 'ck', '陈康', 'e10adc3949ba59abbe56e057f20f883e', '1', '140225189987854589', '1044732267@qq.com', '13366055010', '2');
INSERT INTO `easybuy_user` VALUES ('13', 'kys', '康有沈', 'e10adc3949ba59abbe56e057f20f883e', '1', '1402251985512541525', '1044732267@qq.com', '13366055010', '0');
INSERT INTO `easybuy_user` VALUES ('14', 'sb', '沈白', 'e10adc3949ba59abbe56e057f20f883e', '1', '140225158987854589', '1044732267@qq.com', '13366055010', '0');
INSERT INTO `easybuy_user` VALUES ('15', 'lb', '李白', 'e10adc3949ba59abbe56e057f20f883e', '1', '140225189987854589', '10447322658@qq.com', '1336998554', '0');
INSERT INTO `easybuy_user` VALUES ('16', 'lgw', '李高伟', 'e10adc3949ba59abbe56e057f20f883e', '1', '140225189987854589', '1011322658@qq.com', '1336998554', '0');
INSERT INTO `easybuy_user` VALUES ('18', 'shangzezhong', '尚泽忠', '4297f44b13955235245b2497399d7a93', '1', '140225198810013745', '1044888844@qq.com', '13366528458', '0');
INSERT INTO `easybuy_user` VALUES ('19', 'liguangliang', '李光亮', '25f9e794323b453885f5181f1b624d0b', '1', '140225198841547785', '1047777@qq.com', '13366055048', '0');
INSERT INTO `easybuy_user` VALUES ('20', 'szz', '李光亮', 'e10adc3949ba59abbe56e057f20f883e', '1', '140225198810013748', '1044732267@qq.com', '13366555010', '1');
INSERT INTO `easybuy_user` VALUES ('21', 'sunwutian2', '孙悟天2', '111111aaabbb', '1', '511111197812120045', '1111111@qq.com', '13300000000', '0');
INSERT INTO `easybuy_user` VALUES ('26', 'jtzheng001', '郑小龙', '123456', '0', '511103198912120023', '3040258@qq.com', '13744445555', '0');
INSERT INTO `easybuy_user` VALUES ('27', 'jtzheng002', '郑晓宇', '123456', '0', '511103198912120023', '3040258@qq.com', '13744445555', '0');
INSERT INTO `easybuy_user` VALUES ('28', 'sunwukong', '孙悟空', '888888', '1', '511103197912120023', '4444444@qq.com', '13811114444', '0');
INSERT INTO `easybuy_user` VALUES ('30', 'sunwufan', '孙悟饭', '888888', '1', '511103197912120023', '4444444@qq.com', '13811114444', '0');
