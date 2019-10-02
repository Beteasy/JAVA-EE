/*
MySQL Data Transfer
Source Host: localhost
Source Database: servlet
Target Host: localhost
Target Database: servlet
Date: 2016/4/22 21:50:20
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for student
-- ----------------------------
CREATE TABLE `student` (

	`id` int(11) NOT NULL
	,`name` varchar(50) default NULL
	,`age` int(50) default NULL
	,`gender` varchar(50) default NULL
	,`major` varchar(255) default NULL
	,PRIMARY KEY  (`id`)

) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `student` VALUES ('1', '王小虎', '22', '男', '数字媒体');
INSERT INTO `student` VALUES ('2', '李丽', '19', '女', '信管');
