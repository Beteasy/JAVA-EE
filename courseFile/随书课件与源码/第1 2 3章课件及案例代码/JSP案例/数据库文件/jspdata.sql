/*
MySQL Data Transfer
Source Host: localhost
Source Database: jspdata
Target Host: localhost
Target Database: jspdata
Date: 2016/4/22 21:26:31
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for student
-- ----------------------------
CREATE TABLE `student` (
  
	`id` int(11) NOT NULL
	,`name` varchar(50) default NULL
	,`age` varchar(50) default NULL
	,`gender` varchar(50) default NULL
	,`major` varchar(255) default NULL
	,PRIMARY KEY  (`id`)

) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (

	`logname` varchar(50) NOT NULL
	,`password` varchar(50) NOT NULL
	,PRIMARY KEY  (`logname`)

) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `student` VALUES ('1', '王小虎', '21', '男', '网络工程');
INSERT INTO `student` VALUES ('2', '杨晨晨', '21', '女', '信息管理与信息系统');
INSERT INTO `student` VALUES ('4', '李紫霄', '19', '女', '信息管理与信息系统');

INSERT INTO `user` VALUES ('admin', 'admin');
INSERT INTO `user` VALUES ('client', 'client');
