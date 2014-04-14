Spring Hibernate-Maven app

This is a simple CRUD Appliciation consists of spring hibernate integration using NO xml configuration files.

Steps to run the app
=========================================================

1) Run the below query in db 

DROP TABLE IF EXISTS `USER`;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) 

2) Update the properties file and change the db name

3) Run the app from : http://localhost:portnumber/springhibxml/

=========================================================
