#SpringBoot

V1.0 SpringBoot+Mybatis+Redis(二级缓存)

V1.1 Mybatis多数库支持 
创建 表 user

CREATE TABLE `user` (
  `id` int(11) DEFAULT NULL,
  `user_name` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
);


CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` int(11) DEFAULT NULL,
  `city_name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

转自：http://www.th7.cn/db/mysql/201704/235724.shtml