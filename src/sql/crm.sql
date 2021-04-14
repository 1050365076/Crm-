/*
 Navicat Premium Data Transfer

 Source Server         : study
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 127.0.0.1:3306
 Source Schema         : crm

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 14/04/2021 19:23:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_cus_dev_plan
-- ----------------------------
DROP TABLE IF EXISTS `t_cus_dev_plan`;
CREATE TABLE `t_cus_dev_plan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户开发计划表',
  `sale_chance_id` int(11) NULL DEFAULT NULL,
  `plan_item` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `plan_date` datetime(0) NULL DEFAULT NULL,
  `exe_affect` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_t_cus_dev_plan`(`sale_chance_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 135 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_cus_dev_plan
-- ----------------------------
INSERT INTO `t_cus_dev_plan` VALUES (69, 96, 'test01', '2017-02-28 00:00:00', 'test01', '2017-02-28 00:00:00', '2017-02-28 21:06:24', 0);
INSERT INTO `t_cus_dev_plan` VALUES (70, 97, 'test02', '2017-02-28 00:00:00', 'test02', '2017-02-28 00:00:00', '2017-02-28 21:06:25', 0);
INSERT INTO `t_cus_dev_plan` VALUES (71, 97, 'test03', '2017-02-28 00:00:00', 'test03', '2017-02-28 16:44:17', '2017-02-28 16:44:17', 0);
INSERT INTO `t_cus_dev_plan` VALUES (72, 97, 'test06', '2017-02-27 00:00:00', 'test06', '2017-02-28 00:00:00', '2017-02-28 16:48:11', 1);
INSERT INTO `t_cus_dev_plan` VALUES (73, 97, 'test05', '2017-02-22 00:00:00', 'test05', '2017-02-28 00:00:00', '2017-02-28 16:48:10', 1);
INSERT INTO `t_cus_dev_plan` VALUES (74, 97, '23424', '2017-02-23 00:00:00', '234324', '2017-02-28 21:08:02', '2017-02-28 21:08:02', 1);
INSERT INTO `t_cus_dev_plan` VALUES (75, 97, '123213', '2017-04-10 00:00:00', '21321', '2017-04-10 19:06:06', '2017-04-10 19:06:06', 1);
INSERT INTO `t_cus_dev_plan` VALUES (76, 134, 'test', '2017-04-11 00:00:00', 'qqqq', '2017-04-11 16:37:24', '2019-09-23 17:28:43', 1);
INSERT INTO `t_cus_dev_plan` VALUES (77, 134, '345435', '2017-04-11 00:00:00', '345435', '2017-04-11 00:00:00', '2017-04-11 16:52:06', 0);
INSERT INTO `t_cus_dev_plan` VALUES (78, 134, '456546', '2017-04-27 00:00:00', '456546', '2017-04-11 00:00:00', '2017-04-11 16:52:18', 0);
INSERT INTO `t_cus_dev_plan` VALUES (79, 134, '567657', '2017-04-10 00:00:00', '567657', '2017-04-11 16:52:13', '2017-04-11 16:52:13', 0);
INSERT INTO `t_cus_dev_plan` VALUES (80, 137, 'test20', '2017-05-20 00:00:00', 'ok', '2017-05-23 16:22:51', '2017-05-23 16:32:34', 0);
INSERT INTO `t_cus_dev_plan` VALUES (81, 137, '向小小勇', '2017-05-22 00:00:00', 'ok', '2017-05-23 16:28:41', '2021-03-24 19:37:08', 1);
INSERT INTO `t_cus_dev_plan` VALUES (82, 137, '测试编辑', '2017-05-30 00:00:00', '345435', '2017-05-23 16:37:05', '2021-03-24 19:36:52', 1);
INSERT INTO `t_cus_dev_plan` VALUES (83, 137, '345435', '2017-05-31 00:00:00', '345435', '2017-05-23 16:37:13', '2017-05-23 16:37:13', 0);
INSERT INTO `t_cus_dev_plan` VALUES (85, 138, '111', '2017-09-16 00:44:58', 'qqq', '2017-09-16 00:44:58', '2017-09-16 00:44:58', 1);
INSERT INTO `t_cus_dev_plan` VALUES (86, 138, '111', '2017-09-16 00:45:41', 'qqq', '2017-09-16 00:45:41', '2017-09-16 00:45:41', 1);
INSERT INTO `t_cus_dev_plan` VALUES (87, 138, '111', '2017-09-16 00:00:00', 'qqq', '2017-09-16 00:45:50', '2017-09-16 00:45:50', 1);
INSERT INTO `t_cus_dev_plan` VALUES (88, 138, '111', '2017-09-16 00:45:55', 'qqq', '2017-09-16 00:45:55', '2017-09-16 00:45:55', 0);
INSERT INTO `t_cus_dev_plan` VALUES (89, 66, '3434543', '2017-09-16 00:00:00', 'ok', '2017-09-16 11:42:03', '2017-09-16 11:42:03', 1);
INSERT INTO `t_cus_dev_plan` VALUES (90, 66, '34353', '2017-09-16 00:00:00', 'ok', '2017-09-16 11:43:28', '2017-09-16 11:43:28', 1);
INSERT INTO `t_cus_dev_plan` VALUES (91, 66, '678678', '2017-09-02 00:00:00', '678678', '2017-09-16 11:44:16', '2017-09-16 11:44:16', 1);
INSERT INTO `t_cus_dev_plan` VALUES (92, 66, 'aaaa', '2017-09-16 00:00:00', '678678', '2017-09-16 11:59:24', '2017-09-16 11:59:24', 0);
INSERT INTO `t_cus_dev_plan` VALUES (93, 66, 'abc', '2017-09-16 00:00:00', '678678', '2017-09-16 11:59:56', '2017-09-16 11:59:56', 1);
INSERT INTO `t_cus_dev_plan` VALUES (94, 66, '客户即将开发成功', '2017-09-16 00:00:00', 'very good', '2017-09-16 12:01:35', '2017-09-16 12:01:35', 1);
INSERT INTO `t_cus_dev_plan` VALUES (95, 66, '请客吃饭', '2017-10-20 00:00:00', 'ok', '2017-10-20 17:28:20', '2017-10-20 17:28:20', 1);
INSERT INTO `t_cus_dev_plan` VALUES (96, 66, 'test02', '2017-10-18 00:00:00', 'test02', '2017-10-20 17:28:45', '2017-10-20 17:33:42', 0);
INSERT INTO `t_cus_dev_plan` VALUES (97, 67, 'test', '2018-01-11 00:00:00', 'ok', '2018-01-11 00:00:00', '2018-01-11 11:29:07', 1);
INSERT INTO `t_cus_dev_plan` VALUES (98, 67, 'test02', '2018-01-11 00:00:00', 'ok', '2018-01-11 00:00:00', '2018-01-11 11:29:06', 1);
INSERT INTO `t_cus_dev_plan` VALUES (99, 67, 'test03', '2018-01-11 00:00:00', 'ok', '2018-01-11 00:00:00', '2018-01-11 11:29:05', 1);
INSERT INTO `t_cus_dev_plan` VALUES (100, 67, 'test04', '2018-01-11 00:00:00', 'ok', '2018-01-11 00:00:00', '2018-01-11 11:29:06', 1);
INSERT INTO `t_cus_dev_plan` VALUES (101, 67, 'test05', '2018-01-11 00:00:00', 'ok', '2018-01-11 11:02:44', '2018-01-11 11:02:44', 0);
INSERT INTO `t_cus_dev_plan` VALUES (102, 67, 'test07', '2018-01-11 00:00:00', 'ok', '2018-01-11 00:00:00', '2018-01-11 11:09:15', 0);
INSERT INTO `t_cus_dev_plan` VALUES (103, 67, '请老王吃饭', '2018-01-11 00:00:00', 'ok', '2018-01-11 00:00:00', '2018-01-11 11:07:45', 0);
INSERT INTO `t_cus_dev_plan` VALUES (104, 73, '133', '2018-05-02 00:00:00', '1', '2018-05-02 00:00:00', '2018-05-02 09:23:31', 1);
INSERT INTO `t_cus_dev_plan` VALUES (105, 73, '3', '2018-05-09 00:00:00', '3', '2018-05-02 09:23:43', '2018-05-02 09:23:43', 0);
INSERT INTO `t_cus_dev_plan` VALUES (106, 56, 'test', '2019-09-23 00:00:00', 'ok', '2019-09-23 17:20:51', '2019-09-23 17:20:51', 1);
INSERT INTO `t_cus_dev_plan` VALUES (107, 56, 'test', '2019-09-23 00:00:00', '123213', '2019-09-23 17:21:12', '2019-09-23 17:21:12', 0);
INSERT INTO `t_cus_dev_plan` VALUES (108, 56, 'test002', '2019-09-23 00:00:00', 'ok', '2019-09-23 17:23:33', '2019-09-23 17:28:17', 0);
INSERT INTO `t_cus_dev_plan` VALUES (109, 56, 'test00001', '2019-09-22 00:00:00', 'ok', '2019-09-23 17:24:41', '2019-09-23 17:28:28', 0);
INSERT INTO `t_cus_dev_plan` VALUES (110, 56, 'aaaa', '2019-09-23 00:00:00', 'ok', '2019-09-23 17:29:40', '2019-09-23 17:29:40', 0);
INSERT INTO `t_cus_dev_plan` VALUES (111, 97, '请客吃饭', '2019-11-04 00:00:00', '满意', '2019-11-05 00:00:00', '2019-11-05 16:08:35', 1);
INSERT INTO `t_cus_dev_plan` VALUES (112, 97, 'test', '2019-11-03 00:00:00', 'test', '2019-11-05 16:09:26', '2019-11-05 16:09:26', 1);
INSERT INTO `t_cus_dev_plan` VALUES (113, 97, 'test01', '2019-11-01 00:00:00', 'test01', '2019-11-05 16:10:34', '2019-11-05 16:10:34', 1);
INSERT INTO `t_cus_dev_plan` VALUES (114, 97, 'test02', '2019-11-02 00:00:00', 'test02', '2019-11-05 16:11:34', '2019-11-05 16:11:34', 1);
INSERT INTO `t_cus_dev_plan` VALUES (115, 98, '客户见面', '2019-12-06 00:00:00', '总体ok ，等待下一步沟通', '2019-12-06 11:15:35', '2019-12-06 11:15:35', 0);
INSERT INTO `t_cus_dev_plan` VALUES (116, 98, 'test01', '2019-12-05 00:00:00', 'test', '2019-12-06 00:00:00', '2019-12-06 11:17:58', 0);
INSERT INTO `t_cus_dev_plan` VALUES (117, 98, 'test02', '2019-12-06 00:00:00', 'test02', '2019-12-06 00:00:00', '2019-12-06 11:17:43', 0);
INSERT INTO `t_cus_dev_plan` VALUES (118, 98, '产品购买', '2019-12-06 00:00:00', '成交', '2019-12-06 11:37:13', '2019-12-06 11:37:13', 0);
INSERT INTO `t_cus_dev_plan` VALUES (119, 98, '产品购买', '2019-12-06 00:00:00', '成功', '2019-12-06 11:37:44', '2019-12-06 11:37:44', 0);
INSERT INTO `t_cus_dev_plan` VALUES (120, 96, 'test', '2020-01-11 00:00:00', 'test', '2020-01-11 11:46:09', '2020-01-11 11:46:09', 0);
INSERT INTO `t_cus_dev_plan` VALUES (121, 96, 'test05', '2020-01-03 00:00:00', 'test05', '2020-01-11 00:00:00', '2020-01-11 11:48:26', 0);
INSERT INTO `t_cus_dev_plan` VALUES (122, 93, 'test01', '2020-01-02 00:00:00', 'test01', '2020-01-11 00:00:00', '2020-01-11 11:48:54', 0);
INSERT INTO `t_cus_dev_plan` VALUES (123, 93, 'test', '2020-01-11 00:00:00', 'test', '2020-01-11 12:02:24', '2020-01-11 12:02:24', 1);
INSERT INTO `t_cus_dev_plan` VALUES (124, 124, 'test', '2020-01-10 00:00:00', 'test23423', '2020-02-18 22:41:13', '2020-02-18 22:43:20', 0);
INSERT INTO `t_cus_dev_plan` VALUES (125, 98, 'test', '2020-01-10 00:00:00', 'testasd', '2020-02-18 22:48:28', '2020-02-18 22:48:34', 1);
INSERT INTO `t_cus_dev_plan` VALUES (126, 98, 'test', '2020-01-10 00:00:00', 'test23423', '2020-02-18 22:48:41', '2020-02-18 22:48:41', 0);
INSERT INTO `t_cus_dev_plan` VALUES (127, 124, 'test', '2020-01-10 00:00:00', 'test23423', '2020-02-18 22:49:14', '2020-02-18 22:49:14', 1);
INSERT INTO `t_cus_dev_plan` VALUES (128, 97, 'test', '2020-01-10 00:00:00', 'test23423', '2020-02-23 23:29:27', '2020-02-23 23:29:27', 0);
INSERT INTO `t_cus_dev_plan` VALUES (129, 97, 'test01', '2020-01-20 00:00:00', 'ok', '2020-03-14 16:37:35', '2020-03-14 16:46:39', 0);
INSERT INTO `t_cus_dev_plan` VALUES (130, 130, '计划A', '2020-11-11 00:00:00', NULL, '2020-11-04 20:15:06', '2020-11-04 20:15:06', 1);
INSERT INTO `t_cus_dev_plan` VALUES (131, 130, '计划B', '2020-11-12 00:00:00', '执行成功', '2020-11-04 20:15:50', '2020-11-04 20:15:50', 1);
INSERT INTO `t_cus_dev_plan` VALUES (132, 127, '计划BB', '2020-12-13 00:00:00', '执行ok', '2020-11-04 21:12:29', '2020-11-04 21:48:19', 1);
INSERT INTO `t_cus_dev_plan` VALUES (133, 127, '计划一', '2020-12-13 00:00:00', 'ok', '2020-11-05 10:29:47', '2020-11-05 10:30:10', 0);
INSERT INTO `t_cus_dev_plan` VALUES (134, 137, '测试向勇添加', '2021-03-24 00:00:00', '正常执行', '2021-03-24 20:24:14', '2021-03-24 20:24:14', 1);

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `khno` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cus_manager` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `myd` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `xyd` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fax` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `web_site` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `yyzzzch` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fr` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zczj` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nyye` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `khyh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `khzh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dsdjh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gsdjh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES (1, 'KH21321321', '北京大牛科技', '北京', 'test', '战略合作伙伴', '☆☆☆', '☆☆☆', '北京海淀区双榆树东里15号', '100027', '010-62263393', '010-62263393', 'www.daniu.com', '420103000057404', '赵飞翔', '1000', '5000', '中国银行', '6225231243641', '4422214321321', '4104322332', 0, 1, '2017-01-16 11:28:43', '2016-08-24 18:42:19');
INSERT INTO `t_customer` VALUES (2, 'KH20150526073022', '风驰科技', '北京', 'test', '大客户', '☆☆☆☆', '☆☆☆☆', '321', '21', '321', '321', '321', '321', '码云', '', '21', '321', '321', '321', '3213', 0, 1, '2017-01-16 12:15:19', '2016-11-28 11:46:24');
INSERT INTO `t_customer` VALUES (20, 'KH201709181013450', '腾讯', '测试', 'test', '大客户', '☆☆☆☆☆', '☆☆☆☆', '', '', '13327792156', '', '', NULL, '赵飞翔', '', '', '', '', '', '', 0, 1, '2017-01-16 10:13:57', '2020-02-19 10:30:26');
INSERT INTO `t_customer` VALUES (21, 'KH201709181112739', '阿里巴巴', '北京', 'test01', '战略合作伙伴', '☆☆☆☆☆', '☆☆☆☆☆', '浙江杭州', '324324', '23424324324', '2343', 'www.alibaba.com', '232432', '码云', '100', '100000', '杭州', '23432432', '4324324', '234324234', 1, 1, '2017-01-16 11:12:16', '2017-09-18 11:25:25');
INSERT INTO `t_customer` VALUES (22, 'KH20171021105508617', '中国工商银行', '上海', 'test', '战略合作伙伴', '☆☆☆☆☆', '☆☆☆☆☆', '浦东', '201600', '18920156732', '12312321', 'www.icbc.com', '12323', '吴三强', '1000000', '100000', '工商', '212321', '', '', 1, 1, '2017-01-16 10:55:09', '2020-11-14 02:28:37');
INSERT INTO `t_customer` VALUES (23, 'KH20180115104723756', '百度', '北京', 'test', '战略合作伙伴', '☆☆☆☆', '☆☆☆☆☆', '北京西二旗', '100000', '2321321', '213123', '123213', '2321321', '李彦宏', '10000', '100000', '工商', '121321313', '', '', 1, 1, '2018-01-16 10:47:23', '2018-01-15 10:50:00');
INSERT INTO `t_customer` VALUES (24, 'KH20180504112003301', '小米科技', '上海', 'test', '重点开发客户', '☆☆☆☆☆', '☆☆☆☆☆', '北京市海淀区清河中街68号华润五彩城购物中心二期13层', '1000000', '010-12345678', '123123131', 'www.xiaomi.com', '110108012660422', '雷军', '185000', '5000000', '中国银行', '99999999999', '91110108551385082Q', '91110108551385082Q', 0, 1, '2018-05-04 11:16:21', '2018-05-04 11:22:24');
INSERT INTO `t_customer` VALUES (32, 'KH1605352800204', '网易test', '上海', 'admin', '大客户', NULL, '', '', '', '13787654345', '', '', NULL, '张三test', '', '', '', '', '', '', 0, 1, '2020-11-14 19:20:00', '2020-11-14 20:20:59');
INSERT INTO `t_customer` VALUES (33, 'KH1605352897591', '网易科技', NULL, NULL, '战略合作伙伴', NULL, NULL, NULL, NULL, '1589876543', NULL, NULL, NULL, '张三', NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, '2020-11-14 19:21:38', '2020-11-14 19:21:38');
INSERT INTO `t_customer` VALUES (34, 'KH1605352974388', '网易科技有限公司', NULL, NULL, '战略合作伙伴', NULL, NULL, NULL, NULL, '15898765437', NULL, NULL, NULL, '张三', NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, '2020-11-14 19:22:54', '2020-11-14 19:22:54');
INSERT INTO `t_customer` VALUES (35, 'KH1605353772927', '腾讯科技', '', '', '战略合作伙伴', NULL, '', '', '', '13787654345', '', '', NULL, '马化腾', '', '', '', '', '', '', 0, 1, '2020-11-14 19:36:13', '2020-11-14 20:21:04');
INSERT INTO `t_customer` VALUES (36, 'KH1605353908782', '测试测试', '深圳', '赵飞翔', '重点开发客户', NULL, '☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆', 'shenz', '222@163.com', '15898765437', '22', 'www.test.com', NULL, 'zhangsan', '22', '22', '22', '22', '22', '22', 0, 1, '2020-11-14 19:38:29', '2021-04-06 21:36:11');
INSERT INTO `t_customer` VALUES (37, 'KH_20210406213358', '测试客户001', '深圳', '赵飞翔', '重点开发客户', NULL, '', '', '', '18020156329', '', '', NULL, '赵飞翔', '', '', '', '', '', '', 0, 1, '2021-04-06 21:33:59', '2021-04-06 21:33:59');
INSERT INTO `t_customer` VALUES (38, 'KH_20210408184654', '阿里爸爸', '深圳', '向勇', '重点开发客户', NULL, '☆☆☆☆☆☆☆☆☆☆☆☆', '深圳', '110@163.com', '15007404365', '121321', 'wwww.alibaba.com', NULL, '向勇', '500000000000000', '100000000000', '中国工商', '8888888888', '0', '0', 0, 1, '2021-04-08 18:46:55', '2021-04-08 18:46:55');

-- ----------------------------
-- Table structure for t_customer_contact
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_contact`;
CREATE TABLE `t_customer_contact`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) NULL DEFAULT NULL,
  `contact_time` datetime(0) NULL DEFAULT NULL,
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `overview` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customer_contact
-- ----------------------------
INSERT INTO `t_customer_contact` VALUES (1, 1, '2015-05-14 05:00:00', '1', '2', NULL, NULL, 1);
INSERT INTO `t_customer_contact` VALUES (2, 1, '2015-05-06 00:00:00', '12', '22', NULL, NULL, 1);
INSERT INTO `t_customer_contact` VALUES (3, 1, '2015-08-22 00:00:00', '珠江路2', '吃饭2', NULL, NULL, 1);
INSERT INTO `t_customer_contact` VALUES (4, 1, '2016-09-01 00:00:00', '112', '233', '2016-09-01 09:53:39', '2016-09-01 09:53:39', 0);
INSERT INTO `t_customer_contact` VALUES (5, 1, '2016-11-22 00:00:00', '师德师风', '阿德的', '2016-11-25 09:38:37', '2016-11-25 09:38:37', 1);

-- ----------------------------
-- Table structure for t_customer_linkman
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_linkman`;
CREATE TABLE `t_customer_linkman`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) NULL DEFAULT NULL,
  `link_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zhiwei` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `office_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  `ceate_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customer_linkman
-- ----------------------------

-- ----------------------------
-- Table structure for t_customer_loss
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_loss`;
CREATE TABLE `t_customer_loss`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_no` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cus_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cus_manager` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_order_time` date NULL DEFAULT NULL,
  `confirm_loss_time` date NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `loss_reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 562 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customer_loss
-- ----------------------------
INSERT INTO `t_customer_loss` VALUES (555, 'KH21321321', '北京大牛科技', 'test', NULL, NULL, 0, NULL, 1, '2021-04-08 20:02:00', '2021-04-08 20:02:00');
INSERT INTO `t_customer_loss` VALUES (556, 'KH20150526073022', '风驰科技', 'test', NULL, NULL, 0, NULL, 1, '2021-04-08 20:02:00', '2021-04-08 20:02:00');
INSERT INTO `t_customer_loss` VALUES (557, 'KH201709181013450', '腾讯', 'test', '2020-09-03', NULL, 0, NULL, 1, '2021-04-08 20:02:00', '2021-04-08 20:02:00');
INSERT INTO `t_customer_loss` VALUES (558, 'KH201709181112739', '阿里巴巴', 'test01', NULL, NULL, 0, NULL, 1, '2021-04-08 20:02:00', '2021-04-08 20:02:00');
INSERT INTO `t_customer_loss` VALUES (559, 'KH20171021105508617', '中国工商银行', 'test', NULL, '2021-04-09', 1, '客户转型', 1, '2021-04-08 20:02:00', '2021-04-09 19:46:54');
INSERT INTO `t_customer_loss` VALUES (560, 'KH20180115104723756', '百度', 'test', NULL, NULL, 1, NULL, 1, '2021-04-08 20:02:00', '2021-04-08 20:02:00');
INSERT INTO `t_customer_loss` VALUES (561, 'KH20180504112003301', '小米科技', 'test', '2018-10-01', NULL, 1, NULL, 1, '2021-04-08 20:02:00', '2021-04-08 20:02:00');

-- ----------------------------
-- Table structure for t_customer_order
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_order`;
CREATE TABLE `t_customer_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) NULL DEFAULT NULL,
  `order_no` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_date` datetime(0) NULL DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customer_order
-- ----------------------------
INSERT INTO `t_customer_order` VALUES (5, 20, '201910021001', '2020-09-03 14:56:10', '上海松江区', 1, '2016-01-29 14:56:15', '2016-11-29 14:56:17', 1);
INSERT INTO `t_customer_order` VALUES (6, 20, '202001022534', '2020-06-16 14:56:26', '杭州市滨江大道', 1, '2016-02-29 14:56:30', '2016-11-29 14:56:32', 1);
INSERT INTO `t_customer_order` VALUES (7, 24, '201911021082', '2018-10-01 17:27:31', '上海浦东', 1, '2019-09-01 17:27:13', '2017-01-01 17:27:21', 1);
INSERT INTO `t_customer_order` VALUES (8, 25, '201909021001', '2019-11-11 10:09:32', '背景海淀', 1, '2019-11-09 10:09:36', '2019-11-09 10:09:39', 1);
INSERT INTO `t_customer_order` VALUES (9, 37, '201909021002', '2021-04-08 18:48:15', '深圳', 1, '2021-04-08 18:48:24', '2021-04-08 18:48:27', 1);
INSERT INTO `t_customer_order` VALUES (10, 38, '201909021003', '2021-04-08 18:48:58', '岳阳', 1, '2021-04-08 18:49:05', '2021-04-08 18:49:07', 1);

-- ----------------------------
-- Table structure for t_customer_reprieve
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_reprieve`;
CREATE TABLE `t_customer_reprieve`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loss_id` int(11) NULL DEFAULT NULL,
  `measure` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customer_reprieve
-- ----------------------------
INSERT INTO `t_customer_reprieve` VALUES (44, 555, '请客户吃饭', 1, '2017-05-25 17:06:05', '2017-09-19 11:49:37');
INSERT INTO `t_customer_reprieve` VALUES (45, 556, '客户请客', 1, '2017-05-25 00:00:00', '2017-09-19 11:49:36');
INSERT INTO `t_customer_reprieve` VALUES (47, 557, '请马云吃顿饭_河马生鲜', 1, '2017-09-19 11:17:04', '2017-09-19 11:49:26');
INSERT INTO `t_customer_reprieve` VALUES (49, 558, '请老马喝喝茶，聊聊天', 1, '2017-10-21 00:00:00', '2017-10-21 00:00:00');
INSERT INTO `t_customer_reprieve` VALUES (50, 559, '请客吃饭', 1, '2017-10-21 18:10:35', '2017-10-21 18:10:35');
INSERT INTO `t_customer_reprieve` VALUES (66, 560, '和客户再次沟通', 1, '2020-11-17 17:26:18', '2020-11-17 17:27:41');
INSERT INTO `t_customer_reprieve` VALUES (67, 561, 'testtest', 1, '2020-11-17 17:51:08', '2020-11-17 18:19:37');
INSERT INTO `t_customer_reprieve` VALUES (68, 555, '测试', 1, '2020-11-17 17:51:19', '2020-11-17 18:19:40');
INSERT INTO `t_customer_reprieve` VALUES (69, 555, '冲冲冲', 0, '2021-04-08 11:23:58', '2021-04-08 11:24:02');
INSERT INTO `t_customer_reprieve` VALUES (70, 555, '22222', 0, '2021-04-09 17:05:13', '2021-04-09 17:05:24');

-- ----------------------------
-- Table structure for t_customer_serve
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_serve`;
CREATE TABLE `t_customer_serve`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serve_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `overview` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `service_request` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_people` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `assigner` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `assign_time` datetime(0) NULL DEFAULT NULL,
  `service_proce` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `service_proce_people` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `service_proce_time` datetime(0) NULL DEFAULT NULL,
  `service_proce_result` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `myd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 92 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customer_serve
-- ----------------------------
INSERT INTO `t_customer_serve` VALUES (74, '6', 'crm 有待改进', '腾讯', 'fw_005', '', 'admin', '42', '2020-02-20 16:32:57', '234234343423432', 'admin', '2020-02-20 18:32:35', '满意', '☆☆☆☆☆', 1, '2020-02-20 20:49:12', '2020-01-18 09:31:53');
INSERT INTO `t_customer_serve` VALUES (75, '9', 'crm 有待改进', '腾讯', 'fw_001', '', 'admin', '10', '2020-01-18 11:01:20', '客服需求已解决 等待反馈', 'admin', '2020-01-18 11:55:23', '满意', '☆☆☆☆☆', 1, '2020-01-18 12:09:00', '2020-01-18 10:20:10');
INSERT INTO `t_customer_serve` VALUES (76, '6', 'this is test...', '腾讯', 'fw_005', 'this is test...', NULL, '42', '2020-02-20 16:33:06', '23423423432', 'admin', '2020-02-20 18:32:46', '满意', '☆☆☆☆', 1, '2020-02-20 20:49:19', '2020-02-20 15:10:50');
INSERT INTO `t_customer_serve` VALUES (82, '6', 'Crm系统系统上线时间?', '腾讯', 'fw_003', '这是服务测试', 'admin', '10', '2020-02-28 11:13:21', 'Crm即将上线', 'admin', '2020-02-28 11:34:32', NULL, NULL, 1, '2020-02-28 11:34:32', '2020-02-28 09:57:18');
INSERT INTO `t_customer_serve` VALUES (83, '6', '了解了解', '百度', 'fw_003', '了解一下', 'admin', '10', '2020-10-26 21:53:05', '服务处理...', 'admin', '2020-11-20 15:40:34', NULL, NULL, 1, '2020-11-20 15:40:34', '2020-10-26 21:52:45');
INSERT INTO `t_customer_serve` VALUES (84, '7', '测试', '腾讯', 'fw_001', '测试', 'admin', '10', '2020-11-19 18:07:06', '服务处理测试...', 'admin', '2020-11-20 15:43:14', '满意', '☆☆☆☆☆', 1, '2020-11-20 16:03:05', '2020-10-26 21:53:33');
INSERT INTO `t_customer_serve` VALUES (85, '6', '111', '腾讯', 'fw_002', '111', 'admin', '42', '2020-11-19 18:08:07', NULL, NULL, NULL, NULL, NULL, 1, '2020-11-19 18:08:07', '2020-10-26 21:54:00');
INSERT INTO `t_customer_serve` VALUES (86, '6', '添加服务测试。。。', '百度', 'fw_001', '添加服务测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '2020-11-19 15:39:14', '2020-11-19 15:39:14');
INSERT INTO `t_customer_serve` VALUES (87, '6', '添加服务测试...', '百度', 'fw_001', '添加服务测试', 'admin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '2020-11-19 15:40:33', '2020-11-19 15:40:32');
INSERT INTO `t_customer_serve` VALUES (88, '7', 'Test。。。', '腾讯', 'fw_002', 'Test', 'admin', '87', '2021-04-12 20:40:05', NULL, NULL, NULL, NULL, NULL, 1, '2021-04-12 20:40:05', '2020-11-19 15:41:08');
INSERT INTO `t_customer_serve` VALUES (89, '6', '测试服务概要', '网易test', 'fw_001', '测试添加服务内容', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '2021-04-12 16:45:56', '2021-04-12 16:45:56');
INSERT INTO `t_customer_serve` VALUES (90, '6', '测试111', '网易test', 'fw_002', '测试111', '向勇', '10', '2021-04-12 20:40:02', NULL, NULL, NULL, NULL, NULL, 1, '2021-04-12 20:40:02', '2021-04-12 16:53:35');
INSERT INTO `t_customer_serve` VALUES (91, '6', '测试333', '网易test', 'fw_005', '测试333', '向勇', '10', '2021-04-12 20:28:30', '测试处理1111', 'admin', '2021-04-12 21:22:12', '满意', '☆☆☆☆☆', 1, '2021-04-12 21:39:54', '2021-04-12 19:26:54');

-- ----------------------------
-- Table structure for t_datadic
-- ----------------------------
DROP TABLE IF EXISTS `t_datadic`;
CREATE TABLE `t_datadic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_dic_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `data_dic_value` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_valid` tinyint(4) NULL DEFAULT 1,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_t_datadic`(`data_dic_value`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_datadic
-- ----------------------------
INSERT INTO `t_datadic` VALUES (1, '客户等级', '普通客户', 1, '2020-02-20 10:04:27', '2020-02-20 10:04:48');
INSERT INTO `t_datadic` VALUES (2, '客户等级', '重点开发客户', 1, '2020-02-20 10:04:30', '2020-02-20 10:04:51');
INSERT INTO `t_datadic` VALUES (3, '客户等级', '大客户', 1, '2020-02-20 10:04:33', '2020-02-20 10:04:53');
INSERT INTO `t_datadic` VALUES (4, '客户等级', '合作伙伴', 1, '2020-02-20 10:04:35', '2020-02-20 10:04:56');
INSERT INTO `t_datadic` VALUES (5, '客户等级', '战略合作伙伴', 1, '2020-02-20 10:04:37', '2020-02-20 10:04:59');
INSERT INTO `t_datadic` VALUES (6, '服务类型', '咨询', 1, '2020-02-20 10:04:40', '2020-02-20 10:05:01');
INSERT INTO `t_datadic` VALUES (7, '服务类型', '建议', 1, '2020-02-20 10:04:43', '2020-02-20 10:05:04');
INSERT INTO `t_datadic` VALUES (8, '服务类型', '投诉', 1, '2020-02-20 10:04:45', '2016-08-24 15:48:46');

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `request_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `exception_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `exception_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `params` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `execute_time` int(11) NULL DEFAULT NULL,
  `create_man` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 432 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_log
-- ----------------------------
INSERT INTO `t_log` VALUES (424, '营销机会-主页展示', 'index', '1', '0:0:0:0:0:0:0:1', '200', '操作成功', '[]', '2020-01-19 09:55:48', 1, 'admin', '\"sale_chance\"');
INSERT INTO `t_log` VALUES (425, '营销管理-多条件查询', 'querySaleChancesByParams', '1', '0:0:0:0:0:0:0:1', '200', '操作成功', '[{\"page\":1,\"rows\":10}]', '2020-01-19 09:55:49', 119, 'admin', '{\"total\":28,\"rows\":[{\"assignMan\":\"admin\",\"assignTime\":1505466691000,\"cgjl\":50,\"chanceSource\":\"360推广\",\"createDate\":1505466310000,\"createMan\":\"shsxt\",\"customerName\":\"风驰科技\",\"description\":\"23432\",\"devResult\":0,\"id\":74,\"isValid\":1,\"linkMan\":\"3423432423\",\"linkPhone\":\"234234324\",\"overview\":\"风驰科技  初创型公司！！！\",\"state\":1,\"updateDate\":1505466691000},{\"assignMan\":\"admin\",\"assignTime\":1505546733000,\"cgjl\":100,\"chanceSource\":\"尚学堂推荐\",\"createDate\":1505546720000,\"createMan\":\",shsxt\",\"customerName\":\"test002\",\"description\":\"324324\",\"devResult\":0,\"id\":75,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"2343242\",\"overview\":\"asdasd\",\"state\":1,\"updateDate\":1505546733000},{\"assignMan\":\"admin\",\"assignTime\":1508481153000,\"cgjl\":90,\"chanceSource\":\"百度\",\"createDate\":1508481153000,\"customerName\":\"李彦宏\",\"description\":\"\",\"devResult\":3,\"id\":81,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"23213\",\"overview\":\"123213\",\"state\":1,\"updateDate\":1508481153000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"官网\",\"createDate\":1515467933000,\"customerName\":\"百度\",\"id\":82,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123123213\",\"updateDate\":1515468116000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"来自百度\",\"createDate\":1515470053000,\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":83,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"23323\",\"updateDate\":1515470053000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"尚学堂官网\",\"createDate\":1515470195000,\"customerName\":\"小马\",\"description\":\"\",\"devResult\":0,\"id\":84,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"2321321\",\"state\":0,\"updateDate\":1515470195000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"尚学堂官网\",\"createDate\":1515470357000,\"createMan\":\"admin\",\"customerName\":\"小马\",\"description\":\"\",\"devResult\":0,\"id\":85,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"123123213\",\"state\":0,\"updateDate\":1515470357000},{\"assignMan\":\"admin\",\"assignTime\":1515653291000,\"cgjl\":95,\"chanceSource\":\"sxt官网\",\"createDate\":1515653245000,\"createMan\":\"admin\",\"customerName\":\"阿里\",\"description\":\"213213\",\"devResult\":0,\"id\":87,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"123213\",\"state\":1,\"updateDate\":1515653291000},{\"assignMan\":\"admin\",\"cgjl\":70,\"chanceSource\":\"官网\",\"createDate\":1529998302000,\"createMan\":\"whsxt\",\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":91,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123456\",\"overview\":\"\",\"state\":0,\"updateDate\":1529998302000},{\"assignMan\":\"admin\",\"assignTime\":1529998586000,\"cgjl\":80,\"chanceSource\":\"\",\"createDate\":1529998586000,\"createMan\":\"whsxt\",\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":92,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123456\",\"overview\":\"\",\"state\":1,\"updateDate\":1529998586000}]}');
INSERT INTO `t_log` VALUES (426, '营销机会-主页展示', 'index', '1', '0:0:0:0:0:0:0:1', '200', '操作成功', '[]', '2020-01-19 09:58:27', 1, 'admin', '\"sale_chance\"');
INSERT INTO `t_log` VALUES (427, '营销管理-多条件查询', 'querySaleChancesByParams', '1', '0:0:0:0:0:0:0:1', '200', '操作成功', '[{\"page\":1,\"rows\":10}]', '2020-01-19 09:58:28', 147, 'admin', '{\"total\":29,\"rows\":[{\"assignMan\":\"admin\",\"assignTime\":1505466691000,\"cgjl\":50,\"chanceSource\":\"360推广\",\"createDate\":1505466310000,\"createMan\":\"shsxt\",\"customerName\":\"风驰科技\",\"description\":\"23432\",\"devResult\":0,\"id\":74,\"isValid\":1,\"linkMan\":\"3423432423\",\"linkPhone\":\"234234324\",\"overview\":\"风驰科技  初创型公司！！！\",\"state\":1,\"updateDate\":1505466691000},{\"assignMan\":\"admin\",\"assignTime\":1505546733000,\"cgjl\":100,\"chanceSource\":\"尚学堂推荐\",\"createDate\":1505546720000,\"createMan\":\",shsxt\",\"customerName\":\"test002\",\"description\":\"324324\",\"devResult\":0,\"id\":75,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"2343242\",\"overview\":\"asdasd\",\"state\":1,\"updateDate\":1505546733000},{\"assignMan\":\"admin\",\"assignTime\":1508481153000,\"cgjl\":90,\"chanceSource\":\"百度\",\"createDate\":1508481153000,\"customerName\":\"李彦宏\",\"description\":\"\",\"devResult\":3,\"id\":81,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"23213\",\"overview\":\"123213\",\"state\":1,\"updateDate\":1508481153000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"官网\",\"createDate\":1515467933000,\"customerName\":\"百度\",\"id\":82,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123123213\",\"updateDate\":1515468116000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"来自百度\",\"createDate\":1515470053000,\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":83,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"23323\",\"updateDate\":1515470053000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"尚学堂官网\",\"createDate\":1515470195000,\"customerName\":\"小马\",\"description\":\"\",\"devResult\":0,\"id\":84,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"2321321\",\"state\":0,\"updateDate\":1515470195000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"尚学堂官网\",\"createDate\":1515470357000,\"createMan\":\"admin\",\"customerName\":\"小马\",\"description\":\"\",\"devResult\":0,\"id\":85,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"123123213\",\"state\":0,\"updateDate\":1515470357000},{\"assignMan\":\"admin\",\"assignTime\":1515653291000,\"cgjl\":95,\"chanceSource\":\"sxt官网\",\"createDate\":1515653245000,\"createMan\":\"admin\",\"customerName\":\"阿里\",\"description\":\"213213\",\"devResult\":0,\"id\":87,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"123213\",\"state\":1,\"updateDate\":1515653291000},{\"assignMan\":\"admin\",\"cgjl\":70,\"chanceSource\":\"官网\",\"createDate\":1529998302000,\"createMan\":\"whsxt\",\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":91,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123456\",\"overview\":\"\",\"state\":0,\"updateDate\":1529998302000},{\"assignMan\":\"admin\",\"assignTime\":1529998586000,\"cgjl\":80,\"chanceSource\":\"\",\"createDate\":1529998586000,\"createMan\":\"whsxt\",\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":92,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123456\",\"overview\":\"\",\"state\":1,\"updateDate\":1529998586000}]}');
INSERT INTO `t_log` VALUES (428, '营销管理-多条件查询', 'querySaleChancesByParams', '1', '0:0:0:0:0:0:0:1', '200', '操作成功', '[{\"customerName\":\"\",\"createMan\":\"\",\"state\":\"\",\"page\":1,\"rows\":10}]', '2020-01-19 09:58:33', 22, 'admin', '{\"total\":29,\"rows\":[{\"assignMan\":\"admin\",\"assignTime\":1505466691000,\"cgjl\":50,\"chanceSource\":\"360推广\",\"createDate\":1505466310000,\"createMan\":\"shsxt\",\"customerName\":\"风驰科技\",\"description\":\"23432\",\"devResult\":0,\"id\":74,\"isValid\":1,\"linkMan\":\"3423432423\",\"linkPhone\":\"234234324\",\"overview\":\"风驰科技  初创型公司！！！\",\"state\":1,\"updateDate\":1505466691000},{\"assignMan\":\"admin\",\"assignTime\":1505546733000,\"cgjl\":100,\"chanceSource\":\"尚学堂推荐\",\"createDate\":1505546720000,\"createMan\":\",shsxt\",\"customerName\":\"test002\",\"description\":\"324324\",\"devResult\":0,\"id\":75,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"2343242\",\"overview\":\"asdasd\",\"state\":1,\"updateDate\":1505546733000},{\"assignMan\":\"admin\",\"assignTime\":1508481153000,\"cgjl\":90,\"chanceSource\":\"百度\",\"createDate\":1508481153000,\"customerName\":\"李彦宏\",\"description\":\"\",\"devResult\":3,\"id\":81,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"23213\",\"overview\":\"123213\",\"state\":1,\"updateDate\":1508481153000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"官网\",\"createDate\":1515467933000,\"customerName\":\"百度\",\"id\":82,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123123213\",\"updateDate\":1515468116000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"来自百度\",\"createDate\":1515470053000,\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":83,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"23323\",\"updateDate\":1515470053000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"尚学堂官网\",\"createDate\":1515470195000,\"customerName\":\"小马\",\"description\":\"\",\"devResult\":0,\"id\":84,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"2321321\",\"state\":0,\"updateDate\":1515470195000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"尚学堂官网\",\"createDate\":1515470357000,\"createMan\":\"admin\",\"customerName\":\"小马\",\"description\":\"\",\"devResult\":0,\"id\":85,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"123123213\",\"state\":0,\"updateDate\":1515470357000},{\"assignMan\":\"admin\",\"assignTime\":1515653291000,\"cgjl\":95,\"chanceSource\":\"sxt官网\",\"createDate\":1515653245000,\"createMan\":\"admin\",\"customerName\":\"阿里\",\"description\":\"213213\",\"devResult\":0,\"id\":87,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"123213\",\"state\":1,\"updateDate\":1515653291000},{\"assignMan\":\"admin\",\"cgjl\":70,\"chanceSource\":\"官网\",\"createDate\":1529998302000,\"createMan\":\"whsxt\",\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":91,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123456\",\"overview\":\"\",\"state\":0,\"updateDate\":1529998302000},{\"assignMan\":\"admin\",\"assignTime\":1529998586000,\"cgjl\":80,\"chanceSource\":\"\",\"createDate\":1529998586000,\"createMan\":\"whsxt\",\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":92,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123456\",\"overview\":\"\",\"state\":1,\"updateDate\":1529998586000}]}');
INSERT INTO `t_log` VALUES (429, '营销管理-添加', 'saveSaleChance', '1', '0:0:0:0:0:0:0:1', '200', '操作成功', '[{\"chanceSource\":\"官网\",\"customerName\":\"百度\",\"cgjl\":80,\"overview\":\"第一次合作  预祝合作愉快\",\"linkMan\":\"马小云\",\"linkPhone\":\"15710218929\",\"description\":\"\",\"createMan\":\"admin\",\"assignMan\":\"\",\"state\":0,\"devResult\":0,\"isValid\":1,\"createDate\":\"Jan 19, 2020 9:58:45 AM\",\"updateDate\":\"Jan 19, 2020 9:58:45 AM\"}]', '2020-01-19 09:58:46', 23, 'admin', '{\"code\":200,\"msg\":\"机会数据添加成功\"}');
INSERT INTO `t_log` VALUES (430, '营销管理-多条件查询', 'querySaleChancesByParams', '1', '0:0:0:0:0:0:0:1', '200', '操作成功', '[{\"customerName\":\"\",\"createMan\":\"\",\"state\":\"\",\"page\":1,\"rows\":10}]', '2020-01-19 09:58:46', 11, 'admin', '{\"total\":30,\"rows\":[{\"assignMan\":\"admin\",\"assignTime\":1505466691000,\"cgjl\":50,\"chanceSource\":\"360推广\",\"createDate\":1505466310000,\"createMan\":\"shsxt\",\"customerName\":\"风驰科技\",\"description\":\"23432\",\"devResult\":0,\"id\":74,\"isValid\":1,\"linkMan\":\"3423432423\",\"linkPhone\":\"234234324\",\"overview\":\"风驰科技  初创型公司！！！\",\"state\":1,\"updateDate\":1505466691000},{\"assignMan\":\"admin\",\"assignTime\":1505546733000,\"cgjl\":100,\"chanceSource\":\"尚学堂推荐\",\"createDate\":1505546720000,\"createMan\":\",shsxt\",\"customerName\":\"test002\",\"description\":\"324324\",\"devResult\":0,\"id\":75,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"2343242\",\"overview\":\"asdasd\",\"state\":1,\"updateDate\":1505546733000},{\"assignMan\":\"admin\",\"assignTime\":1508481153000,\"cgjl\":90,\"chanceSource\":\"百度\",\"createDate\":1508481153000,\"customerName\":\"李彦宏\",\"description\":\"\",\"devResult\":3,\"id\":81,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"23213\",\"overview\":\"123213\",\"state\":1,\"updateDate\":1508481153000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"官网\",\"createDate\":1515467933000,\"customerName\":\"百度\",\"id\":82,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123123213\",\"updateDate\":1515468116000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"来自百度\",\"createDate\":1515470053000,\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":83,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"23323\",\"updateDate\":1515470053000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"尚学堂官网\",\"createDate\":1515470195000,\"customerName\":\"小马\",\"description\":\"\",\"devResult\":0,\"id\":84,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"2321321\",\"state\":0,\"updateDate\":1515470195000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"尚学堂官网\",\"createDate\":1515470357000,\"createMan\":\"admin\",\"customerName\":\"小马\",\"description\":\"\",\"devResult\":0,\"id\":85,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"123123213\",\"state\":0,\"updateDate\":1515470357000},{\"assignMan\":\"admin\",\"assignTime\":1515653291000,\"cgjl\":95,\"chanceSource\":\"sxt官网\",\"createDate\":1515653245000,\"createMan\":\"admin\",\"customerName\":\"阿里\",\"description\":\"213213\",\"devResult\":0,\"id\":87,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"123213\",\"state\":1,\"updateDate\":1515653291000},{\"assignMan\":\"admin\",\"cgjl\":70,\"chanceSource\":\"官网\",\"createDate\":1529998302000,\"createMan\":\"whsxt\",\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":91,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123456\",\"overview\":\"\",\"state\":0,\"updateDate\":1529998302000},{\"assignMan\":\"admin\",\"assignTime\":1529998586000,\"cgjl\":80,\"chanceSource\":\"\",\"createDate\":1529998586000,\"createMan\":\"whsxt\",\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":92,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123456\",\"overview\":\"\",\"state\":1,\"updateDate\":1529998586000}]}');
INSERT INTO `t_log` VALUES (431, '营销管理-多条件查询', 'querySaleChancesByParams', '1', '0:0:0:0:0:0:0:1', '200', '操作成功', '[{\"customerName\":\"\",\"createMan\":\"\",\"state\":\"\",\"page\":1,\"rows\":10}]', '2020-01-19 09:59:52', 16, 'admin', '{\"total\":30,\"rows\":[{\"assignMan\":\"admin\",\"assignTime\":1505466691000,\"cgjl\":50,\"chanceSource\":\"360推广\",\"createDate\":1505466310000,\"createMan\":\"shsxt\",\"customerName\":\"风驰科技\",\"description\":\"23432\",\"devResult\":0,\"id\":74,\"isValid\":1,\"linkMan\":\"3423432423\",\"linkPhone\":\"234234324\",\"overview\":\"风驰科技  初创型公司！！！\",\"state\":1,\"updateDate\":1505466691000},{\"assignMan\":\"admin\",\"assignTime\":1505546733000,\"cgjl\":100,\"chanceSource\":\"尚学堂推荐\",\"createDate\":1505546720000,\"createMan\":\",shsxt\",\"customerName\":\"test002\",\"description\":\"324324\",\"devResult\":0,\"id\":75,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"2343242\",\"overview\":\"asdasd\",\"state\":1,\"updateDate\":1505546733000},{\"assignMan\":\"admin\",\"assignTime\":1508481153000,\"cgjl\":90,\"chanceSource\":\"百度\",\"createDate\":1508481153000,\"customerName\":\"李彦宏\",\"description\":\"\",\"devResult\":3,\"id\":81,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"23213\",\"overview\":\"123213\",\"state\":1,\"updateDate\":1508481153000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"官网\",\"createDate\":1515467933000,\"customerName\":\"百度\",\"id\":82,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123123213\",\"updateDate\":1515468116000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"来自百度\",\"createDate\":1515470053000,\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":83,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"23323\",\"updateDate\":1515470053000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"尚学堂官网\",\"createDate\":1515470195000,\"customerName\":\"小马\",\"description\":\"\",\"devResult\":0,\"id\":84,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"2321321\",\"state\":0,\"updateDate\":1515470195000},{\"assignMan\":\"admin\",\"cgjl\":90,\"chanceSource\":\"尚学堂官网\",\"createDate\":1515470357000,\"createMan\":\"admin\",\"customerName\":\"小马\",\"description\":\"\",\"devResult\":0,\"id\":85,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"123123213\",\"state\":0,\"updateDate\":1515470357000},{\"assignMan\":\"admin\",\"assignTime\":1515653291000,\"cgjl\":95,\"chanceSource\":\"sxt官网\",\"createDate\":1515653245000,\"createMan\":\"admin\",\"customerName\":\"阿里\",\"description\":\"213213\",\"devResult\":0,\"id\":87,\"isValid\":1,\"linkMan\":\"老裴\",\"linkPhone\":\"123213\",\"state\":1,\"updateDate\":1515653291000},{\"assignMan\":\"admin\",\"cgjl\":70,\"chanceSource\":\"官网\",\"createDate\":1529998302000,\"createMan\":\"whsxt\",\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":91,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123456\",\"overview\":\"\",\"state\":0,\"updateDate\":1529998302000},{\"assignMan\":\"admin\",\"assignTime\":1529998586000,\"cgjl\":80,\"chanceSource\":\"\",\"createDate\":1529998586000,\"createMan\":\"whsxt\",\"customerName\":\"百度\",\"description\":\"\",\"devResult\":0,\"id\":92,\"isValid\":1,\"linkMan\":\"李彦宏\",\"linkPhone\":\"123456\",\"overview\":\"\",\"state\":1,\"updateDate\":1529998586000}]}');

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `module_style` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块样式',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `parent_id` int(11) NULL DEFAULT NULL,
  `parent_opt_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade` int(11) NULL DEFAULT NULL COMMENT '等级',
  `opt_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `orders` int(11) NULL DEFAULT NULL,
  `is_valid` tinyint(4) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 174 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_module
-- ----------------------------
INSERT INTO `t_module` VALUES (1, '营销管理', '', '#', -1, NULL, 0, '10', 1, 1, '2017-09-28 00:00:00', '2021-04-04 14:14:59');
INSERT INTO `t_module` VALUES (2, '营销机会管理', '', 'saleChance/index', 1, NULL, 1, '1010', 1, 1, '2017-09-28 00:00:00', '2020-02-17 15:47:26');
INSERT INTO `t_module` VALUES (3, '营销机会管理查询', '', '#', 2, NULL, 2, '101001', 2, 1, '2017-09-28 00:00:00', '2020-02-17 15:47:51');
INSERT INTO `t_module` VALUES (4, '营销机会管理添加', '', '#', 2, NULL, 2, '101002', 2, 1, '2017-09-28 00:00:00', '2017-09-28 00:00:00');
INSERT INTO `t_module` VALUES (5, '营销机会管理删除', '', '#', 2, NULL, 2, '101003', 3, 1, '2017-09-28 00:00:00', '2017-09-28 00:00:00');
INSERT INTO `t_module` VALUES (6, '客户开发计划', '', 'cus_dev_plan/index', 1, NULL, 1, '1020', 2, 1, '2017-09-28 00:00:00', '2017-09-28 00:00:00');
INSERT INTO `t_module` VALUES (7, '查看详情', '', '#', 6, NULL, 2, '102001', 1, 1, '2017-09-28 00:00:00', '2017-09-28 00:00:00');
INSERT INTO `t_module` VALUES (8, '客户管理', '', 'customer/index', -1, NULL, 0, '20', 3, 1, '2017-07-01 00:00:00', '2017-07-01 00:00:00');
INSERT INTO `t_module` VALUES (9, '客户信息管理', '', 'customer/index', 8, NULL, 1, '2010', 1, 1, '2017-09-06 00:00:00', '2017-09-06 00:00:00');
INSERT INTO `t_module` VALUES (10, '创建', '', '#', 9, NULL, 2, '201001', 1, 1, '2017-07-01 00:00:00', '2017-07-01 00:00:00');
INSERT INTO `t_module` VALUES (11, '修改', '', '#', 9, NULL, 2, '201002', 2, 1, '2017-07-01 00:00:00', '2017-07-01 00:00:00');
INSERT INTO `t_module` VALUES (12, '客户流失管理', '', 'customer_loss/index', 8, NULL, 1, '2020', 2, 1, '2017-08-17 00:00:00', '2017-08-17 00:00:00');
INSERT INTO `t_module` VALUES (13, '暂缓流失', '', 'openCustomerReprieve', 12, NULL, 2, '202001', 1, 1, '2017-09-23 00:00:00', '2017-09-23 00:00:00');
INSERT INTO `t_module` VALUES (14, '统计报表', '', '#', -1, NULL, 0, '40', 4, 1, '2017-08-15 00:00:00', '2017-08-15 00:00:00');
INSERT INTO `t_module` VALUES (15, '客户贡献分析', '', 'report/1', 14, NULL, 1, '4010', 1, 1, '2017-08-15 00:00:00', '2017-08-15 00:00:00');
INSERT INTO `t_module` VALUES (16, '服务管理', '', '#', -1, NULL, 0, '30', 3, 1, '2017-08-18 00:00:00', '2017-08-18 00:00:00');
INSERT INTO `t_module` VALUES (17, '基础数据管理', '', '#', -1, NULL, 0, '50', 5, 1, '2017-08-18 00:00:00', '2017-08-18 00:00:00');
INSERT INTO `t_module` VALUES (18, '系统管理', '', '#', -1, NULL, 0, '60', 6, 1, '2017-08-18 00:00:00', '2017-08-18 00:00:00');
INSERT INTO `t_module` VALUES (19, '删除', '', '#', 9, NULL, 2, '201003', 3, 1, '2017-08-18 00:00:00', '2017-08-18 00:00:00');
INSERT INTO `t_module` VALUES (26, '用户管理', '', 'user/index', 18, NULL, 1, '6010', NULL, 1, '2017-10-24 16:54:12', '2017-10-24 16:54:12');
INSERT INTO `t_module` VALUES (27, '角色管理', '', 'role/index', 18, NULL, 1, '6020', NULL, 1, '2018-01-13 11:29:17', '2018-01-13 11:29:19');
INSERT INTO `t_module` VALUES (28, '资源管理', '', 'module/index/1', 18, NULL, 1, '6030', NULL, 1, '2018-01-13 11:29:40', '2018-01-13 11:29:42');
INSERT INTO `t_module` VALUES (34, '服务创建', '', NULL, 16, NULL, 1, '3010', NULL, 1, '2018-01-16 09:21:59', '2018-01-16 09:22:02');
INSERT INTO `t_module` VALUES (35, '服务分配', '', NULL, 16, NULL, 1, '3020', NULL, 1, '2018-01-16 09:22:26', '2018-01-16 09:22:28');
INSERT INTO `t_module` VALUES (36, '服务处理', '', NULL, 16, NULL, 1, '3030', NULL, 1, '2018-01-16 09:22:47', '2018-01-16 09:22:50');
INSERT INTO `t_module` VALUES (37, '服务反馈', '', NULL, 16, NULL, 1, '3040', NULL, 1, '2018-01-16 09:23:11', '2018-01-16 09:23:13');
INSERT INTO `t_module` VALUES (38, '服务归档', '', NULL, 16, NULL, 1, '3050', NULL, 1, '2018-01-16 09:23:37', '2018-01-16 09:23:39');
INSERT INTO `t_module` VALUES (39, '客户构成分析', '', '	\r\nreport/2', 14, NULL, 1, '4020', NULL, 1, '2018-01-16 14:57:24', '2018-01-16 14:57:27');
INSERT INTO `t_module` VALUES (40, '客户服务分析', '', 'sale_chance/index', 14, NULL, 1, '4030', NULL, 1, '2018-01-16 16:14:48', '2018-01-16 16:14:50');
INSERT INTO `t_module` VALUES (44, '营销机会管理修改', '', NULL, 2, NULL, 2, '101004', NULL, 1, '2019-09-25 15:22:12', '2020-01-15 10:43:09');
INSERT INTO `t_module` VALUES (102, '数据字典管理', '', 'sale_chance/xxx', 17, NULL, 1, '5010', NULL, 1, '2019-09-26 11:07:00', '2019-09-26 11:07:00');
INSERT INTO `t_module` VALUES (103, '产品信息查询', '', '#', 17, NULL, 2, '5020', NULL, 1, '2019-09-26 11:13:14', '2019-09-26 11:13:14');
INSERT INTO `t_module` VALUES (109, '客户流失分析', '', 'report/3', 14, NULL, 1, '4060', NULL, 1, '2019-11-09 16:31:58', '2021-04-13 16:48:59');
INSERT INTO `t_module` VALUES (126, '流失管理添加', '', NULL, 12, NULL, 2, '123213', 12323, 1, '2020-02-17 15:25:53', '2020-02-17 15:25:53');
INSERT INTO `t_module` VALUES (130, '用户添加', '', NULL, 26, NULL, 2, '601001', NULL, 1, '2020-02-17 15:55:45', '2020-02-17 15:55:45');
INSERT INTO `t_module` VALUES (131, '用户查询', '', NULL, 26, NULL, 2, '601002', NULL, 1, '2020-02-17 15:56:04', '2020-02-17 15:56:04');
INSERT INTO `t_module` VALUES (132, '用户修改', '', NULL, 26, NULL, 2, '601003', NULL, 1, '2020-02-17 15:56:20', '2020-02-17 15:56:20');
INSERT INTO `t_module` VALUES (133, '用户删除', '', NULL, 26, NULL, 2, '601004', NULL, 1, '2020-02-17 15:56:36', '2020-02-17 15:56:36');
INSERT INTO `t_module` VALUES (134, '角色添加', '', NULL, 27, NULL, 2, '602001', NULL, 1, '2020-02-17 15:56:53', '2020-02-17 15:56:53');
INSERT INTO `t_module` VALUES (135, '角色查询', '', NULL, 27, NULL, 2, '602002', NULL, 1, '2020-02-17 15:57:08', '2020-02-17 15:57:08');
INSERT INTO `t_module` VALUES (136, '角色修改', '', NULL, 27, NULL, 2, '602003', NULL, 1, '2020-02-17 15:57:23', '2020-02-17 15:57:23');
INSERT INTO `t_module` VALUES (137, '角色删除', '', NULL, 27, NULL, 2, '602004', NULL, 1, '2020-02-17 15:57:37', '2020-02-17 15:57:37');
INSERT INTO `t_module` VALUES (138, '资源添加', '', NULL, 28, NULL, 2, '603001', NULL, 1, '2020-02-17 15:57:57', '2020-02-17 15:57:57');
INSERT INTO `t_module` VALUES (139, '资源查询', '', NULL, 28, NULL, 2, '603002', NULL, 1, '2020-02-17 15:58:18', '2020-02-17 15:58:18');
INSERT INTO `t_module` VALUES (140, '资源修改', '', NULL, 28, NULL, 2, '603003', NULL, 1, '2020-02-17 15:58:31', '2020-02-17 15:58:31');
INSERT INTO `t_module` VALUES (141, '资源删除', '', NULL, 28, NULL, 2, '603004', NULL, 1, '2020-02-17 15:58:45', '2020-02-17 15:58:45');
INSERT INTO `t_module` VALUES (142, '字典管理', '', 'data_dic/index', 18, NULL, 1, '6040', NULL, 1, '2020-02-20 21:30:11', '2020-02-20 21:30:53');
INSERT INTO `t_module` VALUES (143, '字典添加', '', NULL, 142, NULL, 2, '604001', NULL, 1, '2020-02-20 21:31:12', '2020-02-20 21:31:12');
INSERT INTO `t_module` VALUES (144, '字典查询', '', NULL, 142, NULL, 2, '604002', NULL, 1, '2020-02-20 21:31:31', '2020-02-20 21:31:31');
INSERT INTO `t_module` VALUES (145, '字典修改', '', NULL, 142, NULL, 2, '604003', NULL, 1, '2020-02-20 21:31:47', '2020-02-20 21:31:47');
INSERT INTO `t_module` VALUES (146, '字典删除', '', NULL, 142, NULL, 2, '604004', NULL, 1, '2020-02-20 21:32:03', '2020-02-20 21:32:03');
INSERT INTO `t_module` VALUES (147, '服务创建查询', '', NULL, 34, NULL, 2, '301001', NULL, 1, '2020-02-20 21:32:39', '2020-02-20 21:34:40');
INSERT INTO `t_module` VALUES (149, '服务分配查询', '', NULL, 35, NULL, 2, '302001', NULL, 1, '2020-02-20 21:34:31', '2020-02-20 21:34:31');
INSERT INTO `t_module` VALUES (150, '服务处理查询', '', NULL, 36, NULL, 2, '303001', NULL, 1, '2020-02-20 21:34:56', '2020-02-20 21:34:56');
INSERT INTO `t_module` VALUES (151, '服务处理', '', NULL, 36, NULL, 2, '303002', NULL, 1, '2020-02-20 21:35:20', '2020-02-20 21:35:20');
INSERT INTO `t_module` VALUES (152, '服务反馈查询', '', NULL, 37, NULL, 2, '304001', NULL, 1, '2020-02-20 21:35:43', '2020-02-20 21:35:43');
INSERT INTO `t_module` VALUES (153, '服务反馈', '', NULL, 37, NULL, 2, '304002', NULL, 1, '2020-02-20 21:35:57', '2020-02-20 21:35:57');
INSERT INTO `t_module` VALUES (154, '测试管理', NULL, 'test/index', 1, NULL, 1, '1030', NULL, 1, '2020-11-13 02:57:06', '2020-11-13 02:57:06');
INSERT INTO `t_module` VALUES (155, '财务管理', NULL, NULL, -1, NULL, 0, '70', NULL, 1, '2020-11-13 02:58:52', '2020-11-13 02:58:52');
INSERT INTO `t_module` VALUES (156, '财务信息管理', NULL, 'aa/index', 155, NULL, 1, '7010', NULL, 1, '2020-11-13 03:00:11', '2020-11-13 03:00:11');
INSERT INTO `t_module` VALUES (157, '财务添加操作', NULL, NULL, 156, NULL, 2, '701001', NULL, 1, '2020-11-13 03:00:51', '2020-11-13 03:00:51');
INSERT INTO `t_module` VALUES (158, '测试管理1', '', NULL, -1, NULL, 0, '100', NULL, 1, '2020-11-13 03:32:21', '2020-11-13 04:26:26');
INSERT INTO `t_module` VALUES (159, '测试管理2', '', NULL, -1, NULL, 0, '90', NULL, 0, '2020-11-13 03:33:38', '2020-11-13 04:53:37');
INSERT INTO `t_module` VALUES (160, '测试子菜单一2', '', 'test001/index', 158, NULL, 1, '10010', NULL, 1, '2020-11-13 03:34:14', '2020-11-13 04:26:49');
INSERT INTO `t_module` VALUES (161, '测试子菜单一001', '', NULL, 160, NULL, 2, '1001001', NULL, 1, '2020-11-13 03:34:34', '2020-11-13 04:27:18');
INSERT INTO `t_module` VALUES (162, '测试子菜单一03', '', NULL, 160, NULL, 2, '801003', NULL, 1, '2020-11-13 03:34:47', '2020-11-13 04:05:44');
INSERT INTO `t_module` VALUES (163, 'test01', '', NULL, -1, NULL, 0, '80', NULL, 1, '2021-04-02 21:17:05', '2021-04-02 21:17:05');
INSERT INTO `t_module` VALUES (164, 'test01_01', '', '/test/index', 163, NULL, 1, '8010', NULL, 1, '2021-04-02 21:17:53', '2021-04-02 21:17:53');
INSERT INTO `t_module` VALUES (165, 'test01_01_01', '', NULL, 164, NULL, 2, '801001', NULL, 0, '2021-04-02 21:18:12', '2021-04-02 21:18:12');
INSERT INTO `t_module` VALUES (166, 'test01_01_02', '', NULL, 164, NULL, 2, '801002', NULL, 0, '2021-04-02 21:18:39', '2021-04-02 21:18:39');
INSERT INTO `t_module` VALUES (167, 'test01_01_01', '', NULL, 164, NULL, 2, '801002', NULL, 0, '2021-04-04 14:44:24', '2021-04-04 14:44:24');
INSERT INTO `t_module` VALUES (168, 'test01_01_02', '', NULL, 164, NULL, 0, '801001', NULL, 0, '2021-04-04 14:44:43', '2021-04-04 14:44:43');
INSERT INTO `t_module` VALUES (169, 'test01_01_02', '', NULL, 164, NULL, 2, '801001', NULL, 0, '2021-04-04 14:46:14', '2021-04-04 14:46:14');
INSERT INTO `t_module` VALUES (170, 'test01_01_02', '', NULL, 164, NULL, 2, '801001', NULL, 0, '2021-04-04 14:50:39', '2021-04-04 14:50:39');
INSERT INTO `t_module` VALUES (171, 'test01_01_01', '', NULL, 164, NULL, 2, '801001', NULL, 1, '2021-04-04 14:51:18', '2021-04-04 14:51:18');
INSERT INTO `t_module` VALUES (172, 'test01_01_02', '', NULL, 164, NULL, 0, '801002', NULL, 0, '2021-04-04 14:51:31', '2021-04-04 14:51:31');
INSERT INTO `t_module` VALUES (173, 'test01_01_02_01', '', '/test/index/text', 172, NULL, 1, '801000202', NULL, 0, '2021-04-04 14:52:05', '2021-04-04 14:52:05');

-- ----------------------------
-- Table structure for t_order_details
-- ----------------------------
DROP TABLE IF EXISTS `t_order_details`;
CREATE TABLE `t_order_details`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NULL DEFAULT NULL,
  `goods_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_num` int(11) NULL DEFAULT NULL,
  `unit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` float NULL DEFAULT NULL,
  `sum` float NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_details
-- ----------------------------
INSERT INTO `t_order_details` VALUES (1, 5, '联想笔记本', 2, '台', 4900, 9800, 1, '2016-11-29 14:59:32', '2016-11-29 14:59:34');
INSERT INTO `t_order_details` VALUES (2, 5, '惠普音响', 4, '台', 200, 800, 1, '2017-03-01 11:32:34', '2017-03-01 11:32:36');
INSERT INTO `t_order_details` VALUES (3, 8, '罗技键盘', 10, '个', 90, 900, 1, '2017-03-01 11:32:39', '2017-03-01 11:32:41');
INSERT INTO `t_order_details` VALUES (4, 6, '艾利鼠标', 20, '个', 20, 400, 1, '2017-03-01 11:32:46', '2017-03-01 11:32:48');
INSERT INTO `t_order_details` VALUES (5, 7, '东芝U盘', 5, '个', 105, 525, 1, '2017-03-01 11:32:51', '2017-03-01 11:32:53');
INSERT INTO `t_order_details` VALUES (6, 7, '充电器', 1, '个', 30, 30, 1, '2017-03-01 11:32:55', '2017-03-01 11:32:57');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `module_id` int(11) NULL DEFAULT NULL COMMENT '模块ID',
  `acl_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8537 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (7248, 3, 8, '20', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7249, 3, 9, '2010', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7250, 3, 10, '201001', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7251, 3, 11, '201002', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7252, 3, 19, '201003', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7253, 3, 12, '2020', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7254, 3, 13, '202001', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7255, 3, 126, '123213', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7256, 3, 14, '40', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7257, 3, 15, '4010', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7258, 3, 39, '4020', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7259, 3, 40, '4030', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7260, 3, 109, '4060', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7261, 3, 16, '30', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7262, 3, 34, '3010', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7263, 3, 147, '301001', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7264, 3, 35, '3020', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7265, 3, 149, '302001', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7266, 3, 36, '3030', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7267, 3, 150, '303001', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7268, 3, 151, '303002', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7269, 3, 37, '3040', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7270, 3, 152, '304001', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7271, 3, 153, '304002', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (7272, 3, 38, '3050', '2021-03-31 21:14:38', '2021-03-31 21:14:38');
INSERT INTO `t_permission` VALUES (8479, 1, 1, '10', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8480, 1, 2, '1010', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8481, 1, 3, '101001', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8482, 1, 4, '101002', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8483, 1, 5, '101003', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8484, 1, 44, '101004', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8485, 1, 6, '1020', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8486, 1, 7, '102001', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8487, 1, 154, '1030', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8488, 1, 8, '20', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8489, 1, 9, '2010', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8490, 1, 10, '201001', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8491, 1, 11, '201002', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8492, 1, 19, '201003', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8493, 1, 12, '2020', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8494, 1, 13, '202001', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8495, 1, 126, '123213', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8496, 1, 14, '40', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8497, 1, 15, '4010', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8498, 1, 39, '4020', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8499, 1, 40, '4030', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8500, 1, 109, '4060', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8501, 1, 16, '30', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8502, 1, 34, '3010', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8503, 1, 147, '301001', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8504, 1, 35, '3020', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8505, 1, 149, '302001', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8506, 1, 36, '3030', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8507, 1, 150, '303001', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8508, 1, 151, '303002', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8509, 1, 37, '3040', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8510, 1, 152, '304001', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8511, 1, 153, '304002', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8512, 1, 38, '3050', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8513, 1, 17, '50', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8514, 1, 102, '5010', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8515, 1, 103, '5020', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8516, 1, 18, '60', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8517, 1, 26, '6010', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8518, 1, 130, '601001', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8519, 1, 131, '601002', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8520, 1, 132, '601003', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8521, 1, 133, '601004', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8522, 1, 27, '6020', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8523, 1, 134, '602001', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8524, 1, 135, '602002', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8525, 1, 136, '602003', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8526, 1, 137, '602004', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8527, 1, 28, '6030', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8528, 1, 138, '603001', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8529, 1, 139, '603002', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8530, 1, 140, '603003', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8531, 1, 141, '603004', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8532, 1, 142, '6040', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8533, 1, 143, '604001', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8534, 1, 144, '604002', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8535, 1, 145, '604003', '2021-04-13 16:45:51', '2021-04-13 16:45:51');
INSERT INTO `t_permission` VALUES (8536, 1, 146, '604004', '2021-04-13 16:45:51', '2021-04-13 16:45:51');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '系统管理员', '系统管理员', '2016-12-01 00:00:00', '2020-02-24 15:53:12', 1);
INSERT INTO `t_role` VALUES (2, '销售', '销售', '2016-12-01 00:00:00', '2020-02-24 15:53:18', 1);
INSERT INTO `t_role` VALUES (3, '客户经理', '客户经理', '2016-12-01 00:00:00', '2020-02-24 15:53:22', 1);
INSERT INTO `t_role` VALUES (14, '技术经理', '研发', '2017-06-30 14:50:24', '2020-02-24 15:53:25', 1);
INSERT INTO `t_role` VALUES (17, '人事', '人事', '2017-10-23 09:15:10', '2020-02-24 15:53:29', 1);
INSERT INTO `t_role` VALUES (18, '测试人员', '测试2', '2020-11-10 14:34:00', '2020-11-10 14:34:00', 1);
INSERT INTO `t_role` VALUES (19, '测试经理', '测试经理', '2020-11-10 14:34:42', '2020-11-10 15:53:03', 0);
INSERT INTO `t_role` VALUES (20, '经理2号', '测试2', '2020-11-10 14:51:04', '2020-11-10 15:50:13', 0);
INSERT INTO `t_role` VALUES (21, '测试角色添加', '失败22', '2021-03-30 18:25:57', '2021-03-30 18:28:49', 0);
INSERT INTO `t_role` VALUES (22, '财务', '财务部门', '2021-03-30 18:36:20', '2021-03-30 18:36:20', 1);

-- ----------------------------
-- Table structure for t_sale_chance
-- ----------------------------
DROP TABLE IF EXISTS `t_sale_chance`;
CREATE TABLE `t_sale_chance`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '营销机会表',
  `chance_source` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机会来源',
  `customer_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cgjl` int(11) NULL DEFAULT NULL,
  `overview` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `link_man` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `link_phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_man` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `assign_man` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `assign_time` datetime(0) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `dev_result` int(11) NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 140 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_sale_chance
-- ----------------------------
INSERT INTO `t_sale_chance` VALUES (97, '官网', '百度', 80, '测试机会数据', '马小云', '15700008929', '测试机会数据', 'admin', '', NULL, 0, 0, 0, '2019-11-05 10:28:41', '2021-03-21 16:47:52');
INSERT INTO `t_sale_chance` VALUES (98, '官网', '阿里云', 50, '测试机会数据', '马小云', '15710218920', '测试机会数据', 'admin', '42', '2029-02-23 16:24:38', 1, 2, 0, '2019-11-05 11:07:48', '2020-02-23 15:02:12');
INSERT INTO `t_sale_chance` VALUES (124, '淘宝', '百度', 70, '测试机会数据1', '李彦宏', '18090261546', '三四十', 'admin', NULL, NULL, 0, 0, 0, '2020-03-12 22:35:44', '2020-03-12 22:35:44');
INSERT INTO `t_sale_chance` VALUES (125, '同时介绍', '张小明', 50, '测试数据2', '加小丁', '18690251463', '三四十', 'admin', '42', '2021-03-21 15:54:32', 1, 1, 0, '2020-03-13 10:22:31', '2021-03-21 15:54:32');
INSERT INTO `t_sale_chance` VALUES (126, '官网', '百度', 20, '测试机会', '马小云', '15710218920', '去去去前期', 'admin', '', NULL, 0, 0, 0, '2020-03-13 10:22:58', '2020-03-13 10:52:47');
INSERT INTO `t_sale_chance` VALUES (127, '同事介绍', '百度', 20, '测试数据3', '马小云', '15710218929', '去去去', 'admin', '10', '2020-03-13 14:57:06', 1, 2, 1, '2020-03-13 14:51:22', '2020-03-13 14:57:06');
INSERT INTO `t_sale_chance` VALUES (128, '同事介绍', '百度', 22, '测试数23', '马小云', '15710218929', '去去去', 'admin', '10', '2020-03-19 20:17:56', 1, 3, 1, '2020-03-19 20:17:56', '2020-03-19 20:17:56');
INSERT INTO `t_sale_chance` VALUES (129, '王者荣耀', '腾讯', 3, '测试数据322', '马小腾', '15898765432', '去去去前期', NULL, '42', '2021-03-21 15:53:39', 1, 1, 0, '2020-11-03 15:54:46', '2021-03-21 15:53:39');
INSERT INTO `t_sale_chance` VALUES (130, '和平精英', '阿里云', 80, '22试数据3', '马小云', '15098765432', '长春村菜擦擦擦错错错', NULL, '87', '2021-03-23 15:26:38', 1, 1, 0, '2020-11-03 15:56:03', '2021-03-23 15:26:38');
INSERT INTO `t_sale_chance` VALUES (131, '广告', '腾讯', 80, '测试', '马小腾', '15876543212', 'Test', 'admin', '85', '2021-03-21 15:54:14', 1, 1, 1, '2020-11-03 17:20:26', '2021-03-21 15:54:14');
INSERT INTO `t_sale_chance` VALUES (132, '官网', '腾讯', 70, '测试', '马小腾', '18876476567', '222', 'admin', '42', '2020-11-04 10:33:33', 1, 1, 1, '2020-11-03 19:54:07', '2020-11-04 10:33:33');
INSERT INTO `t_sale_chance` VALUES (133, '官网', '向勇', 4, '测试数据322', '马化腾', '15710218929', '请求', 'admin', '87', '2021-03-23 15:26:47', 1, 2, 1, '2021-03-18 21:47:35', '2021-03-23 15:26:47');
INSERT INTO `t_sale_chance` VALUES (134, '小米', '测试客户1', 20, '测111试数据3', '雷军', '15710218925', '请求', 'admin', '87', '2021-03-23 15:26:58', 1, 3, 1, '2021-03-18 21:51:19', '2021-03-23 15:26:58');
INSERT INTO `t_sale_chance` VALUES (135, '官网', '向勇1', 2, '测22试数据31', '马化腾', '15710218921', '请求', 'admin', '42', '2021-03-21 16:06:54', 1, 3, 1, '2021-03-18 21:54:50', '2021-03-21 16:06:54');
INSERT INTO `t_sale_chance` VALUES (136, '小米', '向勇33', 3, '测试数据321', '马化腾', '15710218939', '请求', 'admin', '', NULL, 0, 0, 0, '2021-03-18 21:59:58', '2021-03-18 21:59:58');
INSERT INTO `t_sale_chance` VALUES (137, '阿里巴巴', '向小勇', 100, '测试数据', '马小云', '15710218929', '不错', 'admin', '87', '2021-03-23 15:27:06', 1, 0, 1, '2021-03-20 19:11:47', '2021-03-23 15:27:06');
INSERT INTO `t_sale_chance` VALUES (138, '腾讯', '向小小勇', 99, '测试数据', '马化腾', '15710218929', '4444', 'admin', '87', '2021-03-23 15:27:15', 1, 1, 1, '2021-03-20 23:08:32', '2021-03-23 15:27:15');
INSERT INTO `t_sale_chance` VALUES (139, '阿里巴巴', '向小小小勇', 10, '测试修改功能', '马小云', '15310218929', 'aaaaaaa', 'admin', '85', '2021-03-21 16:47:08', 1, 1, 1, '2021-03-21 15:59:01', '2021-03-21 16:47:23');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `true_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (10, 'admin', 'ICy5YqxZB1uWSwcVLSNLcA==', 'admin', '126@126.com', '13327792157', 1, '2016-12-01 12:05:49', '2021-04-13 16:46:18');
INSERT INTO `t_user` VALUES (87, 'xy', 'ICy5YqxZB1uWSwcVLSNLcA==', '向勇', 'xiangy@163.com', '13876545672', 1, '2021-03-20 21:28:42', '2021-04-12 20:16:23');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 248 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (232, 87, 1, '2021-04-12 20:16:23', '2021-04-12 20:16:23');
INSERT INTO `t_user_role` VALUES (233, 87, 2, '2021-04-12 20:16:23', '2021-04-12 20:16:23');
INSERT INTO `t_user_role` VALUES (234, 87, 3, '2021-04-12 20:16:23', '2021-04-12 20:16:23');
INSERT INTO `t_user_role` VALUES (235, 87, 14, '2021-04-12 20:16:23', '2021-04-12 20:16:23');
INSERT INTO `t_user_role` VALUES (236, 87, 17, '2021-04-12 20:16:23', '2021-04-12 20:16:23');
INSERT INTO `t_user_role` VALUES (244, 10, 1, '2021-04-13 16:46:18', '2021-04-13 16:46:18');
INSERT INTO `t_user_role` VALUES (245, 10, 2, '2021-04-13 16:46:18', '2021-04-13 16:46:18');
INSERT INTO `t_user_role` VALUES (246, 10, 3, '2021-04-13 16:46:18', '2021-04-13 16:46:18');
INSERT INTO `t_user_role` VALUES (247, 10, 14, '2021-04-13 16:46:18', '2021-04-13 16:46:18');

SET FOREIGN_KEY_CHECKS = 1;
