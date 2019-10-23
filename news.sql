/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.5.60 : Database - news
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`news` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `news`;

/*Table structure for table `tbl_content` */

DROP TABLE IF EXISTS `tbl_content`;

CREATE TABLE `tbl_content` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` char(50) DEFAULT NULL,
  `content` char(50) DEFAULT NULL,
  `datetime` char(50) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  `author` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6iu35u1dua0e5089uwlu7jpla` (`u_id`),
  CONSTRAINT `FK6iu35u1dua0e5089uwlu7jpla` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_content` */

insert  into `tbl_content`(`id`,`title`,`content`,`datetime`,`u_id`,`author`) values (1,'跳蚤市场！！','大卖大卖大卖大卖大卖大卖大卖大卖111','2019-09-11',1,'admin'),(2,'迎新快讯！！','好多学弟学妹啊啊啊啊啊！！！！','2019-9-3',1,'admin'),(3,'开学啦！！','新学期新气象，大家加油读书啊！！222','2019-09-11',2,'Tom'),(5,'马云新名片12个身份','9月10日，教师节当天，是马云正式卸任阿里巴巴集团董事局主席的日子。这位叱咤... 详细>>','2019-9-11',1,'admin'),(6,'迪士尼变无人乐园','最近有游客去了一趟香港迪士尼乐园，发现园区里的游客加起来都不到百人，偌大的乐... 详细>>','2019-9-11',1,'admin'),(7,'高校新校区无围墙','校长王树国说，希望校园没有围墙不只物理上的无围墙，更希望学术无围墙，能和社会... 详细>>','2019-9-11',1,'admin'),(8,'aaaa','请qqqq','2019-09-10',1,'admin'),(9,'911事件十八周年',' 美国宾夕法尼亚州,民众参加在93号航班纪念园举行的911恐怖袭击事件十八周年纪念活动','2019-9-11',2,'Tom'),(10,'教师节的最新相关信息','9月10日下午,河南农业大学庆祝第35个教师节表彰大会在文化路校区大礼堂第一报告厅举行','2019-09-10',2,'Tom');

/*Table structure for table `tbl_user` */

DROP TABLE IF EXISTS `tbl_user`;

CREATE TABLE `tbl_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `datetime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_user` */

insert  into `tbl_user`(`id`,`username`,`password`,`datetime`) values (1,'admin','12345','2019-09-11'),(2,'Tom','1234','2018-1-10');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
