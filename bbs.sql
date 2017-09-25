/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50018
Source Host           : 127.0.0.1:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2017-09-19 08:03:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `replyId` int(11) NOT NULL auto_increment,
  `replyContent` varchar(255) NOT NULL,
  `topicId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `reply_time` datetime NOT NULL,
  `status` int(5) NOT NULL,
  PRIMARY KEY  (`replyId`),
  KEY `FK_4` (`topicId`),
  KEY `FK_5` (`userId`),
  CONSTRAINT `FK_4` FOREIGN KEY (`topicId`) REFERENCES `topic` (`topicId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_5` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '女毒耳机误终身。', '2', '2', '2017-09-18 17:03:16', '1');
INSERT INTO `reply` VALUES ('2', '1楼说得对！', '2', '1', '2017-09-18 17:47:02', '1');
INSERT INTO `reply` VALUES ('3', 'msr7也不错哦，就是有点夹耳朵！', '2', '1', '2017-09-18 18:49:01', '1');

-- ----------------------------
-- Table structure for section
-- ----------------------------
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `sectionId` int(11) NOT NULL auto_increment,
  `sectionName` varchar(50) NOT NULL,
  `sectionRemarks` varchar(255) default NULL,
  `topicCount` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `status` int(5) NOT NULL,
  PRIMARY KEY  (`sectionId`),
  KEY `FK_1` (`userId`),
  CONSTRAINT `FK_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of section
-- ----------------------------
INSERT INTO `section` VALUES ('1', '爱音乐', '音乐发烧友聚集之地', '3', '9', '1');
INSERT INTO `section` VALUES ('2', '爱动漫', '宅腐基真的好吗', '5', '3', '1');
INSERT INTO `section` VALUES ('3', '爱游戏', '想体验竞技之美吗', '3', '9', '1');
INSERT INTO `section` VALUES ('4', '爱学习', '活到老学到老', '2', '1', '1');
INSERT INTO `section` VALUES ('5', '爱运动', '强身健体', '0', '9', '1');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `topicId` int(11) NOT NULL auto_increment,
  `topicTitle` varchar(50) NOT NULL,
  `topicContent` varchar(255) NOT NULL,
  `replyCount` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `post_time` datetime NOT NULL,
  `status` int(5) NOT NULL,
  PRIMARY KEY  (`topicId`),
  KEY `FK_2` (`sectionId`),
  KEY `FK_3` (`userId`),
  CONSTRAINT `FK_2` FOREIGN KEY (`sectionId`) REFERENCES `section` (`sectionId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_3` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('1', '无聊啊无聊', '大家一起来畅聊吧', '0', '2', '3', '2017-09-17 00:00:00', '1');
INSERT INTO `topic` VALUES ('2', '铁三角耳机咨询帖', '力荐樱花女王！EW9采用的是耳挂式设计，这类耳机并不是很多，即便把耳塞式的耳挂耳机算上，知名型号也屈指可数。耳挂式的佩戴有众多优点，尤其是在耳机足够轻便的条件下。它的支架可以先展开一定角度，挂在耳朵上后再合拢，佩戴较为方便。', '3', '1', '1', '2017-09-17 21:40:01', '1');
INSERT INTO `topic` VALUES ('3', '呆毛王之谜', '大家畅所欲言吧', '0', '2', '1', '2017-09-17 21:58:27', '1');
INSERT INTO `topic` VALUES ('4', '崩坏三和FGO你支持哪个？', '本人支持崩坏三！', '0', '2', '1', '2017-09-17 22:01:59', '1');
INSERT INTO `topic` VALUES ('5', '加州旅馆大家怎么看', '个人觉得加州旅馆煲机神器啊！(手动滑稽)', '0', '1', '18', '2017-09-18 19:50:49', '1');
INSERT INTO `topic` VALUES ('6', '怎么看待王者荣耀？', '自顶！', '0', '3', '18', '2017-09-18 19:55:42', '1');
INSERT INTO `topic` VALUES ('7', 'LOL组团拉！', '一区来开黑小伙伴。ID：天苗君王', '0', '3', '18', '2017-09-18 20:10:49', '1');
INSERT INTO `topic` VALUES ('8', 'JVM原理结构是啥', '来大神啊！', '0', '4', '18', '2017-09-18 20:13:45', '1');
INSERT INTO `topic` VALUES ('9', '补番啦', '详情见10086！', '0', '2', '18', '2017-09-18 20:15:17', '1');
INSERT INTO `topic` VALUES ('10', '从零开始的异世界讨论帖', '大家多多交流。', '0', '2', '10', '2017-09-18 20:18:15', '1');
INSERT INTO `topic` VALUES ('11', '有什么注重新人的软件公司啊', '来老司机！！！', '0', '4', '10', '2017-09-18 20:21:02', '1');
INSERT INTO `topic` VALUES ('12', '大家推荐几个好玩的单机', '。。。。。。。。。。。。。。。。。。。。', '0', '3', '10', '2017-09-18 20:23:20', '1');
INSERT INTO `topic` VALUES ('13', '1000以内最强性价比耳机求推荐', '发烧友们开始showtime啦。', '0', '1', '10', '2017-09-18 20:25:34', '1');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL auto_increment,
  `userName` varchar(25) NOT NULL,
  `userPassword` varchar(25) NOT NULL,
  `status` int(5) NOT NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '123', '1');
INSERT INTO `users` VALUES ('2', 'dy', '123', '3');
INSERT INTO `users` VALUES ('3', 'wzl', '123', '2');
INSERT INTO `users` VALUES ('4', 'ybw', '123', '2');
INSERT INTO `users` VALUES ('5', 'asd', '123', '3');
INSERT INTO `users` VALUES ('6', 'fgh', '123', '3');
INSERT INTO `users` VALUES ('7', 'jkl', '123', '3');
INSERT INTO `users` VALUES ('8', 'qwe', '123', '3');
INSERT INTO `users` VALUES ('9', 'zx', '123', '2');
INSERT INTO `users` VALUES ('10', 'adfaf', '123', '3');
INSERT INTO `users` VALUES ('17', 'faf', '123', '3');
INSERT INTO `users` VALUES ('18', 'sfafss', '123', '3');
