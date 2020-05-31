
CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `test`;

-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.19


-- Table structure for table `contact_details`
DROP TABLE IF EXISTS `contact_details`;

CREATE TABLE `contact_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `contact` varchar(255) NOT NULL,
  `status` int NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`contact`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `contact_UNIQUE` (`contact`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




LOCK TABLES `contact_details` WRITE;

INSERT INTO `contact_details` VALUES (22,'abczy','defg','top@gmail.com','00000000001',1,'2020-05-31 16:37:08','2020-05-31 17:27:41'),(23,'Abcd','defg','top1@gmail.com','0000000001',1,'2020-05-31 16:37:44','2020-05-31 16:37:44'),(24,'Abcde','defgh','end@gmail.com','1111111111',1,'2020-05-31 16:40:04','2020-05-31 16:40:04'),(6,'Abc','def',NULL,'1457689437',1,'2020-05-31 16:00:10','2020-05-31 16:00:10'),(7,'Abc','def','abc@gmail.com','1457689468',1,'2020-05-31 16:03:40','2020-05-31 16:03:40'),(3,'John','Smith',NULL,'3456278698',1,'2020-05-31 15:54:58','2020-05-31 15:54:58'),(5,'Akash','Singh',NULL,'7543254687',1,'2020-05-31 15:57:06','2020-05-31 15:57:06'),(15,'Abc','def','abyk@gmail.com','7676757611',1,'2020-05-31 16:23:43','2020-05-31 16:23:43'),(11,'Abc','def','abcd@gmail.com','7676757675',1,'2020-05-31 16:11:57','2020-05-31 16:11:57'),(13,'Abc','def','abcde@gmail.com','7676757689',1,'2020-05-31 16:22:45','2020-05-31 16:22:45'),(14,'Abc','def','abcdef@gmail.com','7676757699',1,'2020-05-31 16:23:12','2020-05-31 16:23:12'),(2,'Niti',NULL,NULL,'8765847567',1,'2020-05-31 15:52:23','2020-05-31 15:52:23'),(18,'Abcd','defg','defgmail.com','8954231670',1,'2020-05-31 16:27:32','2020-05-31 16:27:32'),(16,'Abcd','defg','def@gmail.com','8954231678',1,'2020-05-31 16:26:37','2020-05-31 16:26:37'),(21,'Abcd','defg','defabc@gmail.com','8954231790',1,'2020-05-31 16:28:57','2020-05-31 16:28:57'),(4,'Akash','Gupta',NULL,'8976895412',1,'2020-05-31 15:56:02','2020-05-31 15:56:02'),(1,'Niti','Jain','nitijain2013@gmail.com','9876543219',1,'2020-05-31 15:49:08','2020-05-31 15:49:08');

