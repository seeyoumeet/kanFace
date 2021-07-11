/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : rlsbkq

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2021-02-20 19:41:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for SMSRecord
-- ----------------------------
DROP TABLE IF EXISTS `SMSRecord`;
CREATE TABLE `SMSRecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of SMSRecord
-- ----------------------------
INSERT INTO `SMSRecord` VALUES ('1', '15828123456', 'xtDD', '2021-05-03 00:05:28');
INSERT INTO `SMSRecord` VALUES ('2', '15828123456', '5949', '2021-05-03 00:05:28');
INSERT INTO `SMSRecord` VALUES ('3', '13588888888', '3727', '2021-05-03 00:05:28');
INSERT INTO `SMSRecord` VALUES ('4', '13888888888', '4303', '2021-05-03 00:05:28');
INSERT INTO `SMSRecord` VALUES ('5', '15828123456', '3728', '2021-05-03 00:05:28');
INSERT INTO `SMSRecord` VALUES ('6', '13888888888', '3867', '2021-05-03 00:05:28');
INSERT INTO `SMSRecord` VALUES ('7', '13888888888', '5236', '2021-05-03 00:05:28');

-- ----------------------------
-- Table structure for CourseDetail
-- ----------------------------
DROP TABLE IF EXISTS `CourseDetail`;
CREATE TABLE `CourseDetail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '题目',
  `content` longtext COMMENT '简介',
  `sys_user` bigint(255) DEFAULT NULL COMMENT '所属任课老师',
  `xs` int(255) DEFAULT NULL COMMENT '学时',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='课程信息';

-- ----------------------------
-- Records of CourseDetail
-- ----------------------------
INSERT INTO `CourseDetail` VALUES ('1', '3213', '21321', '3', '1');
INSERT INTO `CourseDetail` VALUES ('2', '3421312', '321312', '3', '321');
INSERT INTO `CourseDetail` VALUES ('3', '语文课程', '语文课程语文课程语文课程语文课程语文课程', '4', '12');
INSERT INTO `CourseDetail` VALUES ('4', '李老师的课程', '看范德萨发', '4', '12');

-- ----------------------------
-- Table structure for AttendanceRecord
-- ----------------------------
DROP TABLE IF EXISTS `AttendanceRecord`;
CREATE TABLE `AttendanceRecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CourseDetail` bigint(255) DEFAULT NULL COMMENT '课程',
  `time` datetime DEFAULT NULL COMMENT '上课时间',
  `ssls` int(255) DEFAULT NULL COMMENT '所属老师',
  `bkhxs` int(255) DEFAULT NULL COMMENT '被考核学生',
  `skkqzt` tinyint(255) DEFAULT '0' COMMENT '上课考勤状态',
  `xkkqzt` tinyint(255) DEFAULT NULL COMMENT '下课考勤状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='考勤记录';

-- ----------------------------
-- Records of AttendanceRecord
-- ----------------------------
INSERT INTO `AttendanceRecord` VALUES ('9', '2', '2021-02-20 00:05:28', '3', '2', '1', '1');
INSERT INTO `AttendanceRecord` VALUES ('10', '3', '2021-02-20 00:05:28', '4', '2', '0', '0');
INSERT INTO `AttendanceRecord` VALUES ('11', '3', '2021-02-20 00:05:28', '4', '2', '1', '1');
INSERT INTO `AttendanceRecord` VALUES ('12', '3', '2021-02-20 00:05:28', '4', '2', '0', '0');
INSERT INTO `AttendanceRecord` VALUES ('13', '3', '2021-02-20 19:24:05', '4', '6', '0', '0');
INSERT INTO `AttendanceRecord` VALUES ('14', '4', '2021-02-20 19:40:10', '4', '6', '0', '0');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('2', '0', '学生管理', 'sys/user.html', null, '1', 'fa fa-user', '1');
INSERT INTO `sys_menu` VALUES ('3', '0', '角色管理', 'sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '0', '菜单管理', 'sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('76', '0', '系统参数管理', 'admin/SysArgs.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('77', '76', 'z', null, 'SysArgs:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('78', '76', 'x', null, 'SysArgs:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('79', '0', '通知公告', 'admin/Notice.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('80', '79', 'z', null, 'Notice:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('81', '79', 'x', null, 'Notice:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('82', '79', 's', null, 'zgg:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('83', '79', 'k', null, null, '2', null, '0');
INSERT INTO `sys_menu` VALUES ('84', '0', '学生请假', 'admin/StudentLeave.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('85', '0', '开始请假', 'admin/StudentLeave_xs.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('86', '0', '教师管理', 'admin/user_js.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('87', '0', '请假结果查看', 'admin/StudentLeave_xsjg.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('88', '0', '请假信息审核', 'admin/StudentLeave.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('89', '0', '审核请假', 'admin/StudentLeave-gly.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('90', '0', '查看请假', 'admin/StudentLeave-glyck.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('91', '0', '课程信息管理', 'admin/CourseDetail.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('92', '91', 'z', null, 'CourseDetail:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('93', '91', 'x', null, 'CourseDetail:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('94', '91', 's', null, 'CourseDetail:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('95', '0', '课程信息查看', 'admin/CourseDetail-xsck.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('96', '0', '查看老师发布的课程信息', 'admin/CourseDetail-glyck.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('97', '0', '选择课程', 'admin/CourseDetail-xsxz.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('98', '0', '查看课程的选课学生', 'admin/ChooseCourse.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('99', '0', '查看选择我的课程的学生', 'admin/ChooseCourse-ls.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('100', '0', '开始考勤', 'admin/AttendanceRecord-kskq.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('101', '0', '查看考勤记录', 'admin/AttendanceRecord.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('102', '101', 'x', null, 'AttendanceRecord:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('103', '101', 'k', null, null, '2', null, '0');
INSERT INTO `sys_menu` VALUES ('104', '0', '查看我的考勤记录', 'admin/AttendanceRecord-xs.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('105', '0', '修改考勤', 'admin/AttendanceRecord-xg.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('106', '0', '考勤统计', 'admin/kqtj.html', null, '1', null, '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '学生', null, '1', '2021-05-03 00:05:28');
INSERT INTO `sys_role` VALUES ('2', '系统管理员', null, '-1', '2021-05-03 00:05:28');
INSERT INTO `sys_role` VALUES ('3', '教师', null, '1', '2021-05-03 00:05:28');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=297 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('243', '1', '79');
INSERT INTO `sys_role_menu` VALUES ('244', '1', '83');
INSERT INTO `sys_role_menu` VALUES ('245', '1', '85');
INSERT INTO `sys_role_menu` VALUES ('246', '1', '87');
INSERT INTO `sys_role_menu` VALUES ('247', '1', '95');
INSERT INTO `sys_role_menu` VALUES ('248', '1', '97');
INSERT INTO `sys_role_menu` VALUES ('249', '1', '104');
INSERT INTO `sys_role_menu` VALUES ('263', '3', '79');
INSERT INTO `sys_role_menu` VALUES ('264', '3', '83');
INSERT INTO `sys_role_menu` VALUES ('265', '3', '88');
INSERT INTO `sys_role_menu` VALUES ('266', '3', '91');
INSERT INTO `sys_role_menu` VALUES ('267', '3', '92');
INSERT INTO `sys_role_menu` VALUES ('268', '3', '93');
INSERT INTO `sys_role_menu` VALUES ('269', '3', '94');
INSERT INTO `sys_role_menu` VALUES ('270', '3', '99');
INSERT INTO `sys_role_menu` VALUES ('271', '3', '100');
INSERT INTO `sys_role_menu` VALUES ('272', '3', '101');
INSERT INTO `sys_role_menu` VALUES ('273', '3', '102');
INSERT INTO `sys_role_menu` VALUES ('274', '3', '103');
INSERT INTO `sys_role_menu` VALUES ('275', '3', '105');
INSERT INTO `sys_role_menu` VALUES ('276', '3', '106');
INSERT INTO `sys_role_menu` VALUES ('277', '2', '76');
INSERT INTO `sys_role_menu` VALUES ('278', '2', '77');
INSERT INTO `sys_role_menu` VALUES ('279', '2', '78');
INSERT INTO `sys_role_menu` VALUES ('280', '2', '79');
INSERT INTO `sys_role_menu` VALUES ('281', '2', '80');
INSERT INTO `sys_role_menu` VALUES ('282', '2', '81');
INSERT INTO `sys_role_menu` VALUES ('283', '2', '82');
INSERT INTO `sys_role_menu` VALUES ('284', '2', '83');
INSERT INTO `sys_role_menu` VALUES ('285', '2', '86');
INSERT INTO `sys_role_menu` VALUES ('286', '2', '89');
INSERT INTO `sys_role_menu` VALUES ('287', '2', '90');
INSERT INTO `sys_role_menu` VALUES ('288', '2', '96');
INSERT INTO `sys_role_menu` VALUES ('289', '2', '98');
INSERT INTO `sys_role_menu` VALUES ('290', '2', '101');
INSERT INTO `sys_role_menu` VALUES ('291', '2', '103');
INSERT INTO `sys_role_menu` VALUES ('292', '2', '2');
INSERT INTO `sys_role_menu` VALUES ('293', '2', '15');
INSERT INTO `sys_role_menu` VALUES ('294', '2', '16');
INSERT INTO `sys_role_menu` VALUES ('295', '2', '17');
INSERT INTO `sys_role_menu` VALUES ('296', '2', '18');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `type` varchar(255) DEFAULT NULL,
  `img` varchar(500) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('-1', 'admin', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'root@renren.io', '321321', '1', null, '2021-05-03 00:05:28', null, null);
INSERT INTO `sys_user` VALUES ('1', 'admin1', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'admin@admin.com', '13612345678', '1', null, '2021-05-03 00:05:28', null, null);
INSERT INTO `sys_user` VALUES ('2', '学生', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', null, '15828123456', '1', null, '2021-05-0300:05:28', '1', '/cdn//cdn/60055cdd-2633-4a65-8812-e6a082f0402e.png');
INSERT INTO `sys_user` VALUES ('3', '教师', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', '123123', '15828682771', '1', '1', '2021-05-03 00:05:28', '3', '/cdn//cdn/7b060a41-cdbb-4015-a0c7-961e2aff6dc4.jpg');
INSERT INTO `sys_user` VALUES ('4', '李老师', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', '123123', '13888888888', '1', '-1', '2021-05-03 00:05:28', '3', '/cdn//cdn/b821c836-d25e-40a5-ba76-be7aa4c6e43d.jpg');
INSERT INTO `sys_user` VALUES ('5', '学生1', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', '123123', '13588888888', '1', '-1', '2021-05-03 00:05:28', '1', '/cdn//cdn/15c17545-7915-4671-84b7-dd33a3163b6e.png');
INSERT INTO `sys_user` VALUES ('6', '黎明', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', null, '13223232323', '1', '-1', '2021-05-03 19:20:18', '1', '/cdn//cdn/f5c653ab-7d3f-4d2e-89a1-8346240b049b.png');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('6', '8', '1');
INSERT INTO `sys_user_role` VALUES ('7', '-1', '2');
INSERT INTO `sys_user_role` VALUES ('11', '3', '3');
INSERT INTO `sys_user_role` VALUES ('18', '5', '1');
INSERT INTO `sys_user_role` VALUES ('19', '2', '1');
INSERT INTO `sys_user_role` VALUES ('22', '4', '3');
INSERT INTO `sys_user_role` VALUES ('23', '6', '1');

-- ----------------------------
-- Table structure for Notice
-- ----------------------------
DROP TABLE IF EXISTS `Notice`;
CREATE TABLE `Notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '通知标题',
  `content` varchar(255) DEFAULT NULL COMMENT '通知标题',
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='通知公告';

-- ----------------------------
-- Records of Notice
-- ----------------------------
INSERT INTO `Notice` VALUES ('1', '2321', '3213213', '2021-05-03 00:05:28');
INSERT INTO `Notice` VALUES ('2', 'dsadasd', 'sadas ', '2021-05-03 00:05:28');
INSERT INTO `Notice` VALUES ('3', '发布通知公告', '发布通知公告发布通知公告发布通知公告发布通知公告发布通知公告', '2021-02-20 00:05:28');
INSERT INTO `Notice` VALUES ('4', '关于2月份开学的通知', '的说法', '2021-02-20 19:38:41');

-- ----------------------------
-- Table structure for StudentLeave
-- ----------------------------
DROP TABLE IF EXISTS `StudentLeave`;
CREATE TABLE `StudentLeave` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_user` bigint(255) DEFAULT NULL COMMENT '请假学生',
  `qjlx` varchar(255) DEFAULT NULL COMMENT '请假类型',
  `begin_time` datetime DEFAULT NULL COMMENT '请假开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '请假结束时间',
  `days` int(255) DEFAULT NULL COMMENT '请假天数',
  `content` longtext COMMENT '请假原因',
  `lssp` tinyint(255) DEFAULT NULL COMMENT '老师审批',
  `glysp` tinyint(255) DEFAULT NULL COMMENT '管理员审批',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='学生请假';

-- ----------------------------
-- Records of StudentLeave
-- ----------------------------
INSERT INTO `StudentLeave` VALUES ('2', '2', '3123', '2021-05-03 00:05:28', '2021-05-03 00:05:28', '11', '312312', '1', '1');
INSERT INTO `StudentLeave` VALUES ('3', '2', '事假', '2021-05-03 00:05:28', '2021-05-03 00:05:28', '3', '事假事假事假事假事假事假', '1', '0');
INSERT INTO `StudentLeave` VALUES ('4', '2', '病假', '2021-05-03 00:05:28', '2021-05-03 00:05:28', '10', '病假病假病假病假病假', '1', '1');
INSERT INTO `StudentLeave` VALUES ('5', '6', '病假', '2021-05-03 19:39:30', '2021-05-03 19:39:31', '2', '321321', '1', '0');

-- ----------------------------
-- Table structure for SysArgs
-- ----------------------------
DROP TABLE IF EXISTS `SysArgs`;
CREATE TABLE `SysArgs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '参数名称',
  `code` varchar(255) DEFAULT NULL COMMENT '参数代码',
  `value` varchar(255) DEFAULT NULL COMMENT '参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='系统参数管理';

-- ----------------------------
-- Records of SysArgs
-- ----------------------------
INSERT INTO `SysArgs` VALUES ('1', '人脸识别对比值', 'face_value', '80');

-- ----------------------------
-- Table structure for ChooseCourse
-- ----------------------------
DROP TABLE IF EXISTS `ChooseCourse`;
CREATE TABLE `ChooseCourse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CourseDetail` bigint(255) DEFAULT NULL COMMENT '课程',
  `sys_user` bigint(255) DEFAULT NULL COMMENT '学生',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='选择课程';

-- ----------------------------
-- Records of ChooseCourse
-- ----------------------------
INSERT INTO `ChooseCourse` VALUES ('1', '2', '2');
INSERT INTO `ChooseCourse` VALUES ('2', '1', '2');
INSERT INTO `ChooseCourse` VALUES ('3', '3', '2');
INSERT INTO `ChooseCourse` VALUES ('4', '3', '6');
INSERT INTO `ChooseCourse` VALUES ('5', '4', '6');
