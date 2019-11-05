/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : chat

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 04/11/2019 17:25:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for connect
-- ----------------------------
DROP TABLE IF EXISTS `connect`;
CREATE TABLE `connect`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `connectId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `adminId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `maxCount` smallint(3) NULL DEFAULT NULL,
  `needCheck` tinyint(1) NULL DEFAULT 0,
  `creaetTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of connect
-- ----------------------------
INSERT INTO `connect` VALUES ('26d731b8f16f471b94d3730ec7e09675', 'f2d9c35e2cb447bbb74e11e32a99145d', '2c46b9afa6a0ddcd116ec493a4ea21b2', 'sdf', 16, 1, '2019-11-01 17:00:07', '2019-11-01 17:00:07');
INSERT INTO `connect` VALUES ('2ec2b264c8d74db3b18e6a19c7d7da40', 'b5271d9df0b1418e937e9f0385549722', 'abb7cc3b0461ae22b21965876a586f14', '', 20, 0, '2019-11-04 11:36:24', '2019-11-04 11:36:24');
INSERT INTO `connect` VALUES ('b6b446fb4dbb4adc9ce08cd7f057b734', 'bc4d01cfc20947bfaf34f4993e2c8478', '2c46b9afa6a0ddcd116ec493a4ea21b2', '', 20, 0, '2019-11-01 17:00:00', '2019-11-01 17:00:00');
INSERT INTO `connect` VALUES ('c8a6025d07704cdd9e1255ed6526eb1b', '578afb62985c43d2bb47f817c75da3e5', 'd06a300b4df94c459a8b9e38d3f06c5b', '', 20, 0, '2019-11-01 16:56:09', '2019-11-01 16:56:09');
INSERT INTO `connect` VALUES ('d5fabb4423d544549f29345b035ecf99', 'e2acb11d32eb474cbe6256bc7f275bc2', '46613cfeb7454eec8bc64b80f757b741', 'ddd', 10, 1, '2019-11-01 16:57:03', '2019-11-01 16:57:03');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `createtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2d5ef65a2a744bf2bb39bac696dacc64', '3', '3', '2019-10-15 10:14:21', '2019-10-15 10:14:21');
INSERT INTO `user` VALUES ('35615d5b7f3f4d53ae78aed05723f9be', '5', '5', '2019-10-15 11:05:17', '2019-10-15 11:05:17');
INSERT INTO `user` VALUES ('6652873d3ff24d27874da021b45c4f4d', '6', '6', '2019-10-19 15:07:20', '2019-10-19 15:07:20');
INSERT INTO `user` VALUES ('712fa0fb7f204a3cbcfd81417f44feaf', '9', '9', '2019-10-19 15:15:54', '2019-10-19 15:15:54');
INSERT INTO `user` VALUES ('7c35ef8a9fa74fd888f72834e95ae423', '2', '2', '2019-10-15 11:02:24', '2019-10-15 11:02:24');
INSERT INTO `user` VALUES ('7fe30d6e997e446fa427c8d18798253d', '1', '2', '2019-10-15 10:15:33', '2019-10-15 10:15:33');
INSERT INTO `user` VALUES ('8ef731444b6f431e8e74a379defe734a', '7', '7', '2019-10-19 15:10:32', '2019-10-19 15:10:32');
INSERT INTO `user` VALUES ('a57b9ecde7774acca633a69671d01bd5', '4', '4', '2019-10-19 15:06:45', '2019-10-19 15:06:45');
INSERT INTO `user` VALUES ('bccc8abf70e648c1bb951d7b7b6f89b3', '8', '8', '2019-10-19 15:13:33', '2019-10-19 15:13:33');

SET FOREIGN_KEY_CHECKS = 1;
