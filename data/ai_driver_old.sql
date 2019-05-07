/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.25 : Database - ai_drive
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ai_drive` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ai_drive`;

/*Table structure for table `campus` */

DROP TABLE IF EXISTS `campus`;

CREATE TABLE `campus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '校区名称',
  `position` varchar(255) DEFAULT NULL COMMENT '校区位置',
  `organ_id` int(11) DEFAULT NULL COMMENT '所属组织id',
  `coach_sum` int(11) DEFAULT NULL COMMENT '校区教练人数',
  `student_sum` int(11) DEFAULT NULL COMMENT '校区学员人数',
  `vehicle_sum` int(11) DEFAULT NULL COMMENT '校区车辆总数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `campus` */

/*Table structure for table `coach` */

DROP TABLE IF EXISTS `coach`;

CREATE TABLE `coach` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `job_id` varchar(100) DEFAULT NULL COMMENT '工号',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `campus_id` int(100) DEFAULT NULL COMMENT '所属校区id',
  `organ_id` int(100) DEFAULT NULL COMMENT '所属组织id',
  `vehicle_id` int(11) DEFAULT NULL COMMENT '教练用车id',
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `coach` */

/*Table structure for table `exam` */

DROP TABLE IF EXISTS `exam`;

CREATE TABLE `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '考试名称',
  `subject_id` int(11) DEFAULT NULL COMMENT '对应科目id',
  `subscribe` varchar(255) DEFAULT NULL COMMENT '描述',
  `position` varchar(255) DEFAULT NULL COMMENT '考试地点',
  `start_time` datetime DEFAULT NULL COMMENT '考试开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '考试终止时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `exam` */

insert  into `exam`(`id`,`name`,`subject_id`,`subscribe`,`position`,`start_time`,`end_time`) values 
(1,'java考试',1,'其中考试',NULL,'2019-02-14 18:07:52','2019-02-14 18:07:54'),
(2,'linux考试',2,'期末考试',NULL,'2019-02-14 19:47:31','2019-02-14 19:47:28'),
(3,'考试名称',3,'描述',NULL,'2019-02-15 15:39:11','2019-02-15 15:39:13');

/*Table structure for table `organ` */

DROP TABLE IF EXISTS `organ`;

CREATE TABLE `organ` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organ_name` varchar(255) DEFAULT NULL COMMENT '组织名称',
  `position` varchar(255) DEFAULT NULL COMMENT '组织位置',
  `number` int(11) DEFAULT NULL COMMENT '组织当前人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `organ` */

/*Table structure for table `organ_source` */

DROP TABLE IF EXISTS `organ_source`;

CREATE TABLE `organ_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `oragn_id` int(11) DEFAULT NULL COMMENT '组织id',
  `source_id` int(11) DEFAULT NULL COMMENT '资源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `organ_source` */

/*Table structure for table `source` */

DROP TABLE IF EXISTS `source`;

CREATE TABLE `source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `source_name` varchar(255) CHARACTER SET latin1 DEFAULT NULL COMMENT '资源名称',
  `source_position` varchar(255) DEFAULT NULL COMMENT '资源位置',
  `source_value` float DEFAULT NULL COMMENT '资源价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `source` */

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `job_id` varchar(100) DEFAULT NULL COMMENT '工号',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `role` varchar(50) NOT NULL COMMENT '角色',
  `organ_id` int(100) DEFAULT NULL COMMENT '所属组织id',
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `staff` */

insert  into `staff`(`id`,`job_id`,`name`,`password`,`role`,`organ_id`,`phone`,`email`,`create_time`,`update_time`) values 
(1,'1700301235','admin','123456','admin',1,'13800138000','admin@happymmall.com','2016-11-06 16:56:45','2019-04-08 13:53:24'),
(13,'1700301221','geely',NULL,'教练',1,'13800138000','geely@happymmall.com','2016-11-19 22:19:25','2016-11-19 22:19:25'),
(17,'1700301625','rosen',NULL,'教练',2,'13800138000','rosen1@happymmall.com','2017-03-17 10:51:33','2019-04-08 13:55:42'),
(21,'1700300215','sooner',NULL,'教练',2,'13800138000','test06@happymmall.com','2017-04-13 21:26:22','2019-04-08 13:55:52'),
(22,'1600300818','zj',NULL,'rc000006',3,NULL,NULL,'2019-04-08 12:22:23','2019-04-08 12:22:23'),
(23,'1700301224','ymh',NULL,'rc000006',5,NULL,NULL,'2019-04-08 12:35:28','2019-04-08 12:35:28'),
(24,'1700301632','xsy',NULL,'rc000006',6,'13800138000',NULL,'2019-04-08 13:54:42','2019-04-08 13:54:42'),
(26,'1700301836','xtm',NULL,'rc000006',2,'13800138000',NULL,'2019-04-08 16:50:56','2019-04-08 16:50:56');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '学员姓名',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话号码',
  `sex` varchar(10) DEFAULT NULL COMMENT '学员性别',
  `campus_id` int(11) DEFAULT NULL COMMENT '所属校园id',
  `coach_id` int(11) DEFAULT NULL COMMENT '所属教练id',
  `status` int(11) DEFAULT NULL COMMENT '学员是否拿到驾照',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(255) DEFAULT NULL COMMENT '科目名称',
  `price` float DEFAULT NULL COMMENT '报考价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `subject` */

insert  into `subject`(`id`,`subject_name`,`price`) values 
(1,'科目一',100),
(2,'科目二',500),
(3,'科目三',620),
(4,'科目四',200);

/*Table structure for table `subject_student` */

DROP TABLE IF EXISTS `subject_student`;

CREATE TABLE `subject_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) DEFAULT NULL COMMENT '科目id',
  `student_id` int(11) DEFAULT NULL COMMENT '考生',
  `exam_id` int(11) DEFAULT NULL COMMENT '这个科目对应的将要考试的考试id(已考则设为-1)',
  `status` int(11) DEFAULT NULL COMMENT '考生是否通过这个科目0-未通过1-已通过',
  `count` int(11) DEFAULT NULL COMMENT '考试次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `subject_student` */

/*Table structure for table `vehicle` */

DROP TABLE IF EXISTS `vehicle`;

CREATE TABLE `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '车辆名称',
  `price` int(11) DEFAULT NULL COMMENT '车辆价格',
  `compus_id` int(11) DEFAULT NULL COMMENT '所属校区id',
  `status` int(11) DEFAULT NULL COMMENT '车辆状态0-无法使用1-可以使用2-正在维修',
  `purchase_time` datetime DEFAULT NULL COMMENT '购买时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vehicle` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
