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
  `info` varchar(300) DEFAULT NULL COMMENT '校区描述',
  `position` varchar(255) DEFAULT NULL COMMENT '校区位置',
  `organ_id` int(11) DEFAULT NULL COMMENT '所属组织id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `campus` */

insert  into `campus`(`id`,`name`,`info`,`position`,`organ_id`) values 
(1,'速达驾校','速达驾校速达驾校速达驾校','金鸡岭',2);

/*Table structure for table `coach` */

DROP TABLE IF EXISTS `coach`;

CREATE TABLE `coach` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `job_num` varchar(100) DEFAULT NULL COMMENT '工号',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `campus_id` int(100) DEFAULT NULL COMMENT '所属校区id',
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `coach` */

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `type_id` int(11) DEFAULT NULL COMMENT '类型',
  `info` varchar(256) DEFAULT NULL COMMENT '简介',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最新更新时间',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `news` */

/*Table structure for table `news_type` */

DROP TABLE IF EXISTS `news_type`;

CREATE TABLE `news_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) DEFAULT NULL COMMENT '新闻类型',
  `info` varchar(300) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `news_type` */

/*Table structure for table `source` */

DROP TABLE IF EXISTS `source`;

CREATE TABLE `source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `source_name` varchar(255) CHARACTER SET latin1 DEFAULT NULL COMMENT '资源名称',
  `campus_id` int(11) DEFAULT NULL COMMENT '校区id',
  `source_position` varchar(255) DEFAULT NULL COMMENT '资源位置',
  `source_value` float DEFAULT NULL COMMENT '资源价格',
  `total` int(11) DEFAULT NULL COMMENT '资源数量',
  `status` int(11) DEFAULT NULL COMMENT '资源使用状态0-未使用1-正在使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `source` */

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `job_num` varchar(100) DEFAULT NULL COMMENT '工号',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `role` varchar(50) NOT NULL COMMENT '角色',
  `campus_id` int(11) DEFAULT NULL COMMENT '校区id',
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `staff` */

insert  into `staff`(`id`,`job_num`,`name`,`password`,`role`,`campus_id`,`phone`,`email`,`create_time`,`update_time`) values 
(1,'1700301235','admin','123456','admin',NULL,'13800138000','admin@happymmall.com','2016-11-06 16:56:45','2019-04-08 13:53:24'),
(13,'1700301221','geely',NULL,'教练',NULL,'13800138000','geely@happymmall.com','2016-11-19 22:19:25','2016-11-19 22:19:25'),
(17,'1700301625','rosen',NULL,'教练',NULL,'13800138000','rosen1@happymmall.com','2017-03-17 10:51:33','2019-04-08 13:55:42'),
(21,'1700300215','sooner',NULL,'教练',NULL,'13800138000','test06@happymmall.com','2017-04-13 21:26:22','2019-04-08 13:55:52'),
(22,'1600300818','zj',NULL,'rc000006',NULL,NULL,NULL,'2019-04-08 12:22:23','2019-04-08 12:22:23'),
(23,'1700301224','ymh',NULL,'rc000006',NULL,NULL,NULL,'2019-04-08 12:35:28','2019-04-08 12:35:28'),
(24,'1700301632','xsy',NULL,'rc000006',NULL,'13800138000',NULL,'2019-04-08 13:54:42','2019-04-08 13:54:42'),
(26,'1700301836','xtm',NULL,'rc000006',NULL,'13800138000',NULL,'2019-04-08 16:50:56','2019-04-08 16:50:56');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '学员姓名',
  `sex` varchar(10) DEFAULT NULL COMMENT '学员性别',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话号码',
  `idcard` varchar(30) DEFAULT NULL COMMENT '学员身份证',
  `campus_id` int(11) DEFAULT NULL COMMENT '所属校园id',
  `coach_id` int(11) DEFAULT NULL COMMENT '所属教练id',
  `status` int(11) DEFAULT NULL COMMENT '学员是否拿到驾照',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`name`,`sex`,`phone`,`idcard`,`campus_id`,`coach_id`,`status`) values 
(1,'ccc','男','123456','123456',1,2,1),
(2,'bbb','女','12345','12345',1,1,0);

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(255) DEFAULT NULL COMMENT '科目名称',
  `price` float DEFAULT NULL COMMENT '报考初始价格',
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
  `status` int(11) DEFAULT NULL COMMENT '考生是否通过这个科目0-未通过1-已通过',
  `count` int(11) DEFAULT NULL COMMENT '考试次数',
  `position` varchar(100) DEFAULT NULL COMMENT '考试位置',
  `price` float DEFAULT NULL COMMENT '该学员考试对应的价格',
  `start_time` datetime DEFAULT NULL COMMENT '开考时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `subject_student` */

insert  into `subject_student`(`id`,`subject_id`,`student_id`,`status`,`count`,`position`,`price`,`start_time`,`end_time`) values 
(1,1,2,0,1,'0',230,'2019-05-16 21:20:03','2019-05-22 20:44:36'),
(2,2,2,0,1,'aa',460,'2019-05-10 19:39:17',NULL),
(5,NULL,NULL,1,NULL,'2',NULL,'2019-05-15 21:45:11',NULL),
(6,NULL,1,1,NULL,'2',NULL,'2019-05-09 10:07:32',NULL),
(7,2,1,1,NULL,'2',NULL,'2019-05-24 10:07:32',NULL),
(8,2,1,1,NULL,'2',NULL,'2019-05-16 17:47:01',NULL),
(9,2,1,1,NULL,'2',NULL,'2019-05-21 17:47:01',NULL);

/*Table structure for table `vehicle` */

DROP TABLE IF EXISTS `vehicle`;

CREATE TABLE `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '车辆名称',
  `price` int(11) DEFAULT NULL COMMENT '车辆价格',
  `compus_id` int(11) DEFAULT NULL COMMENT '所属校区id',
  `coach_id` int(11) DEFAULT NULL COMMENT '教练id',
  `status` int(11) DEFAULT NULL COMMENT '车辆状态0-无法使用1-可以使用2-正在维修',
  `purchase_time` datetime DEFAULT NULL COMMENT '购买时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vehicle` */

/*Table structure for table `student_exam` */

DROP TABLE IF EXISTS `student_exam`;

/*!50001 DROP VIEW IF EXISTS `student_exam` */;
/*!50001 DROP TABLE IF EXISTS `student_exam` */;

/*!50001 CREATE TABLE  `student_exam`(
 `id` int(11) ,
 `student_name` varchar(100) ,
 `phone` varchar(50) ,
 `campus_name` varchar(100) ,
 `subject_name` varchar(255) ,
 `student_id` int(11) ,
 `subject_id` int(11) ,
 `count` int(11) ,
 `status` int(11) ,
 `position` varchar(100) ,
 `price` float ,
 `start_time` datetime ,
 `end_time` datetime 
)*/;

/*View structure for view student_exam */

/*!50001 DROP TABLE IF EXISTS `student_exam` */;
/*!50001 DROP VIEW IF EXISTS `student_exam` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `student_exam` AS (select `ss`.`id` AS `id`,`st`.`name` AS `student_name`,`st`.`phone` AS `phone`,`ca`.`name` AS `campus_name`,`su`.`subject_name` AS `subject_name`,`ss`.`student_id` AS `student_id`,`ss`.`subject_id` AS `subject_id`,`ss`.`count` AS `count`,`ss`.`status` AS `status`,`ss`.`position` AS `position`,`ss`.`price` AS `price`,`ss`.`start_time` AS `start_time`,`ss`.`end_time` AS `end_time` from (((`student` `st` join `campus` `ca`) join `subject` `su`) join `subject_student` `ss`) where ((`ss`.`student_id` = `st`.`id`) and (`ss`.`subject_id` = `su`.`id`) and (`st`.`campus_id` = `ca`.`id`))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
