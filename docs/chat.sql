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

 Date: 29/10/2019 17:26:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `imgUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `creaetTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
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
