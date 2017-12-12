/*
Navicat MySQL Data Transfer

Source Server         : dkl
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-12-12 16:08:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(100) DEFAULT NULL,
  `apassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for `cake`
-- ----------------------------
DROP TABLE IF EXISTS `cake`;
CREATE TABLE `cake` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(100) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `price` float(11,0) NOT NULL,
  `typeid` int(11) NOT NULL,
  `sizeid` int(11) NOT NULL,
  `stepid` int(11) NOT NULL,
  `listimg` varchar(100) DEFAULT NULL,
  `img1` varchar(100) DEFAULT NULL,
  `img2` varchar(100) DEFAULT NULL,
  `img3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sizeid` (`sizeid`),
  KEY `stepid` (`stepid`),
  KEY `typeid` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cake
-- ----------------------------
INSERT INTO `cake` VALUES ('1', '三层奶油粉红蛋糕', 'Cake cutting ', '2000', '1', '1', '3', 'm1.png', 's1.png', 's2.png', 's3.png');
INSERT INTO `cake` VALUES ('2', '三层巧克力蛋糕', '巧克力', '122', '1', '1', '1', 'm2.png', 's1.png', 's2.png', 's3.png');
INSERT INTO `cake` VALUES ('3', '两层小丑蛋糕', '小丑', '2000', '1', '1', '2', 'm3.png', 's1.png', 's2.png', 's3.png');
INSERT INTO `cake` VALUES ('4', '巧克力球蛋糕', '巧克力', '2000', '4', '1', '1', 'm4.png', 's1.png', 's2.png', 's3.png');
INSERT INTO `cake` VALUES ('5', '8村珊瑚蛋糕', '珊瑚', '2000', '5', '1', '1', 'm5.png', 's1.png', 's2.png', 's3.png');
INSERT INTO `cake` VALUES ('6', '15寸巧克力蛋糕', '巧克力', '2000', '4', '1', '1', 'm6.png', 's1.png', 's2.png', 's3.png');
INSERT INTO `cake` VALUES ('7', '10寸心形蛋糕', '心形', '2000', '2', '2', '1', 'm7.png', 's1.png', 's2.png', 's3.png');
INSERT INTO `cake` VALUES ('8', '12寸方形蛋糕', '方形', '2000', '1', '3', '1', 'm8.png', 's1.png', 's2.png', 's3.png');
INSERT INTO `cake` VALUES ('9', '15寸巧克力蛋糕', '巧克力', '2000', '4', '4', '1', 'm9.png', 's1.png', 's2.png', 's3.png');
INSERT INTO `cake` VALUES ('10', '15寸巧克力蛋糕', '巧克力', '2300', '4', '4', '1', 'g4.png', 's1.png', 's2.png', 's3.png');
INSERT INTO `cake` VALUES ('11', '三层奶油蛋糕', 'Cake cutting is one of the most beautiful thisg.', '1500', '1', '4', '3', 'g5.png', 's1.png', 's2.png', 's3.png');

-- ----------------------------
-- Table structure for `cakesize`
-- ----------------------------
DROP TABLE IF EXISTS `cakesize`;
CREATE TABLE `cakesize` (
  `sizeid` int(11) NOT NULL AUTO_INCREMENT,
  `sizename` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sizeid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cakesize
-- ----------------------------
INSERT INTO `cakesize` VALUES ('1', '8寸');
INSERT INTO `cakesize` VALUES ('2', '10寸');
INSERT INTO `cakesize` VALUES ('3', '12寸');
INSERT INTO `cakesize` VALUES ('4', '15寸');

-- ----------------------------
-- Table structure for `cakestep`
-- ----------------------------
DROP TABLE IF EXISTS `cakestep`;
CREATE TABLE `cakestep` (
  `stepid` int(11) NOT NULL AUTO_INCREMENT,
  `stepname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stepid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cakestep
-- ----------------------------
INSERT INTO `cakestep` VALUES ('1', '1层');
INSERT INTO `cakestep` VALUES ('2', '2层');
INSERT INTO `cakestep` VALUES ('3', '3层');

-- ----------------------------
-- Table structure for `caketype`
-- ----------------------------
DROP TABLE IF EXISTS `caketype`;
CREATE TABLE `caketype` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of caketype
-- ----------------------------
INSERT INTO `caketype` VALUES ('1', '水果');
INSERT INTO `caketype` VALUES ('2', '黑森林');
INSERT INTO `caketype` VALUES ('3', '黄油');
INSERT INTO `caketype` VALUES ('4', '巧克力');
INSERT INTO `caketype` VALUES ('5', '奶油');

-- ----------------------------
-- Table structure for `logfile`
-- ----------------------------
DROP TABLE IF EXISTS `logfile`;
CREATE TABLE `logfile` (
  `userid` int(11) NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `logtime` date DEFAULT NULL,
  `error` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  CONSTRAINT `useridlog` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logfile
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `total` float NOT NULL,
  `userid` int(11) NOT NULL,
  `cname` varchar(100) DEFAULT NULL,
  `cakeimg` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `goodid` (`cid`),
  KEY `useridor` (`userid`),
  CONSTRAINT `useridor` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '1', '2000', '1', '三层奶油粉红蛋糕', 'm1.png');
INSERT INTO `orders` VALUES ('2', '2', '1', '2000', '5', '三层巧克力蛋糕', 'm2.png');
INSERT INTO `orders` VALUES ('3', '2', '1', '2000', '5', '三层巧克力蛋糕', 'm2.png');
INSERT INTO `orders` VALUES ('4', '3', '1', '2000', '5', '两层小丑蛋糕', 'm3.png');
INSERT INTO `orders` VALUES ('5', '3', '1', '2000', '5', '两层小丑蛋糕', 'm3.png');
INSERT INTO `orders` VALUES ('7', '2', '1', '2000', '5', '三层巧克力蛋糕', 'm2.png');
INSERT INTO `orders` VALUES ('8', '1', '1', '2000', '5', '三层奶油粉红蛋糕', 'm1.png');
INSERT INTO `orders` VALUES ('9', '1', '1', '2000', '18', '三层奶油粉红蛋糕', 'm1.png');
INSERT INTO `orders` VALUES ('10', '4', '1', '2000', '5', '巧克力球蛋糕', 'm4.png');
INSERT INTO `orders` VALUES ('11', '4', '1', '2000', '1', '巧克力球蛋糕', 'm4.png');
INSERT INTO `orders` VALUES ('12', '1', '1', '2000', '1', '奶油粉红蛋糕', 'm1.png');
INSERT INTO `orders` VALUES ('13', '1', '1', '2000', '20', '三层奶油粉红蛋糕', 'm1.png');
INSERT INTO `orders` VALUES ('14', '1', '1', '2000', '1', '三层奶油粉红蛋糕', 'm1.png');
INSERT INTO `orders` VALUES ('15', '1', '1', '22', '1', '', null);
INSERT INTO `orders` VALUES ('16', '5', '1', '2000', '5', '8村珊瑚蛋糕', 'm5.png');

-- ----------------------------
-- Table structure for `shoppingcart`
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `cname` varchar(100) DEFAULT NULL,
  `price` float(11,0) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `cakeimg` varchar(100) DEFAULT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`sid`),
  KEY `useridsh` (`userid`),
  CONSTRAINT `useridsh` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------
INSERT INTO `shoppingcart` VALUES ('4', '1', '三层奶油粉红蛋糕', '2000', '2', 'm2.png', '1');
INSERT INTO `shoppingcart` VALUES ('5', '1', '三层奶油粉红蛋糕', '2000', '2', 'm2.png', '1');
INSERT INTO `shoppingcart` VALUES ('6', '6', '9寸巧克力蛋糕', '2000', '3', 'm6.png', '1');
INSERT INTO `shoppingcart` VALUES ('7', '5', '8村珊瑚蛋糕', '2000', '4', 'm5.png', '1');
INSERT INTO `shoppingcart` VALUES ('8', '7', '10寸心形蛋糕', '2000', '4', 'm7.png', '1');
INSERT INTO `shoppingcart` VALUES ('9', '6', '9寸巧克力蛋糕', '2000', '1', 'm6.png', '1');
INSERT INTO `shoppingcart` VALUES ('10', '2', '三层巧克力蛋糕', '2000', '1', 'm2.png', '1');
INSERT INTO `shoppingcart` VALUES ('15', '1', '三层奶油粉红蛋糕', '2000', '7', 'm1.png', '1');
INSERT INTO `shoppingcart` VALUES ('16', '1', '三层奶油粉红蛋糕', '2000', '7', 'm1.png', '1');
INSERT INTO `shoppingcart` VALUES ('29', '2', '三层巧克力蛋糕', '2000', '5', 'm2.png', '1');
INSERT INTO `shoppingcart` VALUES ('30', '5', '8村珊瑚蛋糕', '2000', '5', 'm5.png', '1');
INSERT INTO `shoppingcart` VALUES ('32', '1', '三层奶油粉红蛋糕', '2000', '1', 'm1.png', '1');
INSERT INTO `shoppingcart` VALUES ('34', '1', '三层奶油粉红蛋糕', '2000', '5', 'm1.png', '1');
INSERT INTO `shoppingcart` VALUES ('35', '10', '15寸巧克力蛋糕', '2300', '1', 'g4.png', '1');
INSERT INTO `shoppingcart` VALUES ('36', '10', '15寸巧克力蛋糕', '2300', '5', 'g4.png', '1');
INSERT INTO `shoppingcart` VALUES ('37', '1', '三层奶油粉红蛋糕', '2000', '1', 'm1.png', '1');
INSERT INTO `shoppingcart` VALUES ('38', '2', '三层巧克力蛋糕', '122', '1', 'm2.png', '1');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`name`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '赵一', '123', '123456788@qq.com', '石家庄');
INSERT INTO `users` VALUES ('2', '浅二', '1234', '1928764832@qq.com', '石家庄');
INSERT INTO `users` VALUES ('3', '孙珊', '12345', 'ncljahq@163.com', '美国');
INSERT INTO `users` VALUES ('4', '李思', '123456', 'jkaniua@163.com', '石家庄');
INSERT INTO `users` VALUES ('5', '周五', '123', '123984930@qq.com', '石家庄');
INSERT INTO `users` VALUES ('6', '吴奇', '1234', '973498178@qq.com', '呼和浩特');
INSERT INTO `users` VALUES ('7', '吴琦', '1234', '32914787@qq.com', '石家庄');
INSERT INTO `users` VALUES ('8', '郑芭', '12345', '140849018@qq.com', '内蒙古');
INSERT INTO `users` VALUES ('18', '凤九', '143256', '1892746738@qq.com', '北京朝阳区');
INSERT INTO `users` VALUES ('20', '卫子夫', '123456', '19839274@163.com', '美国');
