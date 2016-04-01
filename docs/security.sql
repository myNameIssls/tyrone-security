/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 5.6.18-enterprise-commercial-advanced : Database - security
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`security` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `security`;

/*Table structure for table `security_menu` */

DROP TABLE IF EXISTS `security_menu`;

CREATE TABLE `security_menu` (
  `ID` varchar(36) NOT NULL COMMENT '编号，主键',
  `MENU_NAME` varchar(36) NOT NULL COMMENT '菜单名称',
  `MENU_PID` varchar(36) NOT NULL COMMENT '父菜单',
  `MENU_URL` varchar(36) DEFAULT NULL COMMENT '菜单URL',
  `MENU_LEVEL` varchar(36) NOT NULL COMMENT '菜单级别',
  `MENU_ORDERBY` varchar(36) NOT NULL COMMENT '菜单排序',
  `AVAILABLE` char(1) NOT NULL DEFAULT '0' COMMENT '是否可用【0:可用 1:不可用】',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `security_menu` */

/*Table structure for table `security_permission` */

DROP TABLE IF EXISTS `security_permission`;

CREATE TABLE `security_permission` (
  `ID` varchar(36) NOT NULL COMMENT '编号，主键',
  `PERMISSION_NAME` varchar(36) NOT NULL COMMENT '权限名称',
  `PERMISSION_CODE` varchar(36) NOT NULL COMMENT '权限编码',
  `AVAILABLE` char(1) NOT NULL DEFAULT '0' COMMENT '是否可用【0:可用 1:不可用】',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_SECURITY_PERMISSION_PERMISSION_CODE` (`PERMISSION_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `security_permission` */

insert  into `security_permission`(`ID`,`PERMISSION_NAME`,`PERMISSION_CODE`,`AVAILABLE`) values ('1','用户列表','SECURITYUSER:LIST','0');

/*Table structure for table `security_role` */

DROP TABLE IF EXISTS `security_role`;

CREATE TABLE `security_role` (
  `ID` varchar(36) NOT NULL COMMENT '主键',
  `ROLE_NAME` varchar(20) NOT NULL COMMENT '角色名称',
  `ROLE_CODE` varchar(20) NOT NULL COMMENT '角色编码',
  `ROLE_GROUP` char(1) NOT NULL COMMENT '角色组',
  `AVAILABLE` char(1) NOT NULL COMMENT '是否可用',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_SECURITY_ROLE_ROLE_CODE` (`ROLE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `security_role` */

insert  into `security_role`(`ID`,`ROLE_NAME`,`ROLE_CODE`,`ROLE_GROUP`,`AVAILABLE`) values ('1','管理员','admin','0','0');

/*Table structure for table `security_role_menu` */

DROP TABLE IF EXISTS `security_role_menu`;

CREATE TABLE `security_role_menu` (
  `ID` varchar(36) NOT NULL COMMENT '编号，主键',
  `ROLE_ID` varchar(36) DEFAULT NULL COMMENT '角色编号，外键',
  `MENU_ID` varchar(36) DEFAULT NULL COMMENT '菜单编号，外键',
  PRIMARY KEY (`ID`),
  KEY `FK_SECURITY_ROLE_MENU_ROLE_ID` (`ROLE_ID`),
  KEY `FK_SECURITY_ROLE_MENU_MENU_ID` (`MENU_ID`),
  CONSTRAINT `FK_SECURITY_ROLE_MENU_MENU_ID` FOREIGN KEY (`MENU_ID`) REFERENCES `security_menu` (`ID`),
  CONSTRAINT `FK_SECURITY_ROLE_MENU_ROLE_ID` FOREIGN KEY (`ROLE_ID`) REFERENCES `security_role` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `security_role_menu` */

/*Table structure for table `security_role_permission` */

DROP TABLE IF EXISTS `security_role_permission`;

CREATE TABLE `security_role_permission` (
  `ID` varchar(36) NOT NULL COMMENT '编号，主键',
  `ROLE_ID` varchar(36) NOT NULL COMMENT '角色编号，外键',
  `PERMISSION_ID` varchar(36) NOT NULL COMMENT '权限编号，外键',
  PRIMARY KEY (`ID`),
  KEY `FK_SECURITY_ROLE_PERMISSION_ROLE_ID` (`ROLE_ID`),
  KEY `FK_SECURITY_ROLE_PERMISSION_PERMISSION_ID` (`PERMISSION_ID`),
  CONSTRAINT `FK_SECURITY_ROLE_PERMISSION_PERMISSION_ID` FOREIGN KEY (`PERMISSION_ID`) REFERENCES `security_permission` (`ID`),
  CONSTRAINT `FK_SECURITY_ROLE_PERMISSION_ROLE_ID` FOREIGN KEY (`ROLE_ID`) REFERENCES `security_role` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `security_role_permission` */

insert  into `security_role_permission`(`ID`,`ROLE_ID`,`PERMISSION_ID`) values ('1','1','1');

/*Table structure for table `security_user` */

DROP TABLE IF EXISTS `security_user`;

CREATE TABLE `security_user` (
  `USER_ID` varchar(36) NOT NULL COMMENT '主键',
  `USER_NAME` varchar(50) NOT NULL COMMENT '登录名称',
  `PASSWORD` varchar(32) NOT NULL COMMENT '登录密码',
  `SALT` varchar(36) NOT NULL,
  `LOCKED` char(1) NOT NULL DEFAULT '0' COMMENT '是否锁定【0:示锁定 1:锁定】',
  `EMP_ID` varchar(36) NOT NULL COMMENT '员工外键',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `UK_SECURITY_USER_USER_NAME` (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `security_user` */

insert  into `security_user`(`USER_ID`,`USER_NAME`,`PASSWORD`,`SALT`,`LOCKED`,`EMP_ID`) values ('1','admin','admin','admin','0','1'),('2','administrator','admin','admin','0','0');

/*Table structure for table `security_user_role` */

DROP TABLE IF EXISTS `security_user_role`;

CREATE TABLE `security_user_role` (
  `ID` varchar(36) NOT NULL COMMENT '编号，主键',
  `USER_ID` varchar(36) NOT NULL COMMENT '用户编号，外键',
  `ROLE_ID` varchar(36) NOT NULL COMMENT '角色编号，外键',
  PRIMARY KEY (`ID`),
  KEY `FK_SECURITY_USER_ROLE_USER_ID` (`USER_ID`),
  KEY `FK_SECURITY_USER_ROLE_ROLE_ID` (`ROLE_ID`),
  CONSTRAINT `FK_SECURITY_USER_ROLE_ROLE_ID` FOREIGN KEY (`ROLE_ID`) REFERENCES `security_role` (`ID`),
  CONSTRAINT `FK_SECURITY_USER_ROLE_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `security_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `security_user_role` */

insert  into `security_user_role`(`ID`,`USER_ID`,`ROLE_ID`) values ('1','1','1');

/*Table structure for table `sys_dict` */

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `ID` varchar(36) NOT NULL COMMENT '编号，主键',
  `DICT_TYPE_KEY` char(3) NOT NULL COMMENT '字典类型key',
  `DICT_TYPE_VALUE` varchar(50) NOT NULL COMMENT '字典类型值',
  `DICT_KEY` char(6) NOT NULL COMMENT '字典key',
  `DICT_VALUE` varchar(50) NOT NULL COMMENT '字典值',
  `DICT_ORDER_BY` int(11) DEFAULT NULL COMMENT '排序',
  `AVILABLE` char(1) DEFAULT NULL COMMENT '是否可用【0:可用 1:不可用】',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`ID`,`DICT_TYPE_KEY`,`DICT_TYPE_VALUE`,`DICT_KEY`,`DICT_VALUE`,`DICT_ORDER_BY`,`AVILABLE`) values ('1','001','角色组类型','001001','借款人服务部角色',0,'0'),('2','001','角色组类型','001002','数据管理部角色',1,'0'),('3','001','角色组类型','001002','风险控制部',2,'0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
