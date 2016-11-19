/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : usermanager

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-11-19 20:19:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` char(255) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_remark` varchar(255) DEFAULT NULL,
  `user_status` tinyint(255) DEFAULT NULL,
  `user_lastlogin` datetime DEFAULT NULL,
  `user_creattime` datetime DEFAULT NULL,
  `user_role` tinyint(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_num` (`user_num`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;
