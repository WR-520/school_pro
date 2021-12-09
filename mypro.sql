/*
Navicat MySQL Data Transfer

Source Server         : localhost_1
Source Server Version : 50532
Source Host           : localhost:3306
Source Database       : mypro

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2021-12-09 13:31:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `editnews`
-- ----------------------------
DROP TABLE IF EXISTS `editnews`;
CREATE TABLE `editnews` (
  `id` int(8) DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `datetime` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of editnews
-- ----------------------------

-- ----------------------------
-- Table structure for `myproject`
-- ----------------------------
DROP TABLE IF EXISTS `myproject`;
CREATE TABLE `myproject` (
  `id` int(8) DEFAULT NULL,
  `tid` int(8) DEFAULT NULL,
  `proid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `members` varchar(500) DEFAULT NULL,
  `pass` int(50) DEFAULT NULL,
  PRIMARY KEY (`proid`),
  KEY `id` (`id`),
  KEY `tid` (`tid`),
  CONSTRAINT `myproject_ibfk_1` FOREIGN KEY (`id`) REFERENCES `projects` (`id`),
  CONSTRAINT `myproject_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of myproject
-- ----------------------------
INSERT INTO `myproject` VALUES ('1', '2', '1', '哈哈哈', '嘻嘻嘻', '哈哈哈夏明', '0');
INSERT INTO `myproject` VALUES ('1', '2', '2', 'ha', 'EEE', 'EEEEE', '1');
INSERT INTO `myproject` VALUES ('1', '2', '3', 'eee', 'eeee', 'eeeee', '-1');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `datetime` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '携手大米和小米集团，共同推进 “产学研”融合发展', '5月16日，省重点实验室常务副主任郑剑虹、副主任李清华、特殊教育系系主任杨溢、金肖博士、李栋宇博士、高美老师一行六人应邀到深圳大米小米集团总部，主要就自闭症儿童教育与研究领域的康复训练体系建设、共建产业学院、特教人才培养、行业标准制定、战略协议签订等产学研工作进行了深度探讨。\r\n\r\n          郑剑虹一行首先参观考察了大米和小米深圳云里校区，大米和小米人才发展中心首席人才官陈志想就云里校区办学理念、场地布局、功能室架构、自闭症儿童康复训练过程等做了详细介绍。', '2021-9-16 15:06:25');
INSERT INTO `news` VALUES ('2', '互联，共同推进 “产学研”融合发展', '5月16日，省重点实验室常务副主任小明、副主任李清华、特殊教育系系主任杨溢、金肖博士、李栋宇博士、高美老师一行六人应邀到深圳大米小米集团总部，主要就自闭症儿童教育与研究领域的康复训练体系建设、共建产业学院、特教人才培养、行业标准制定、战略协议签订等产学研工作进行了深度探讨。\r\n\r\n          郑剑虹一行首先参观考察了大米和小米深圳云里校区，大米和小米人才发展中心首席人才官陈志想就云里校区办学理念、场地布局、功能室架构、自闭症儿童康复训练过程等做了详细介绍。', '2021-9-16 15:06:25');

-- ----------------------------
-- Table structure for `projects`
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) DEFAULT NULL,
  `content` varchar(60) DEFAULT NULL,
  `ddl` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projects
-- ----------------------------
INSERT INTO `projects` VALUES ('1', '互联网+', '哈哈哈哈哈', '2020');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `pass` varchar(15) NOT NULL,
  `tname` char(10) NOT NULL,
  `sex` enum('男','女') NOT NULL,
  `education` enum('本科','硕士','博士') NOT NULL,
  `info` varchar(255) NOT NULL,
  `speciality` char(15) NOT NULL,
  `rank` char(10) NOT NULL,
  `admin` int(11) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '123456', '李梦', '女', '博士', '1016002920@qq.com', '人工智能', '副教授', '1');
INSERT INTO `teacher` VALUES ('2', '123456', '曾羽', '男', '硕士', '2038835087@qq.com', '大数据', '讲师', '0');
INSERT INTO `teacher` VALUES ('4', '123456', '吴荔', '女', '博士', '1016002920@qq.com', '服装工程', '教授', '1');
