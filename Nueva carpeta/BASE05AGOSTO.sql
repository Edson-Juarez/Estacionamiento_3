-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: estacion
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `checador`
--

DROP TABLE IF EXISTS `checador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checador` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `user` varchar(45) NOT NULL,
  `fecha` date NOT NULL,
  `horaEntrada` time NOT NULL,
  `horaSalida` time DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checador`
--

LOCK TABLES `checador` WRITE;
/*!40000 ALTER TABLE `checador` DISABLE KEYS */;
INSERT INTO `checador` VALUES (59,'JORGE','2022-08-04','09:04:55','09:05:16'),(60,'JORGE','2022-08-04','09:07:07','09:07:38'),(61,'JORGE','2022-08-04','09:09:42','00:00:00'),(62,'JORGE','2022-08-04','09:22:22','09:23:09'),(63,'JORGE','2022-08-04','09:23:47','09:24:10'),(64,'MAROMAS','2022-08-04','09:24:21','09:25:01'),(65,'JORGE','2022-08-04','09:25:07','09:25:22'),(66,'JORGE','2022-08-04','09:27:39','09:27:57'),(67,'JORGE','2022-08-04','09:44:20','09:46:11'),(68,'JORGE','2022-08-04','09:46:43','09:56:34'),(69,'MAROMAS','2022-08-04','09:56:44','10:01:34'),(70,'JORGE','2022-08-04','10:01:43','10:23:22'),(71,'JORGE','2022-08-04','13:06:44','13:07:18'),(72,'JORGE','2022-08-04','16:59:50','17:00:31'),(73,'JORGE','2022-08-04','18:17:49','18:18:20'),(74,'JORGE','2022-08-04','18:24:18','18:46:21'),(75,'MAROMAS','2022-08-04','18:46:29','18:47:08'),(76,'MAROMAS','2022-08-04','18:47:47','18:53:32'),(77,'JORGE','2022-08-04','18:53:39','19:08:37'),(78,'MAROMAS','2022-08-04','19:08:46','19:29:06'),(79,'JORGE','2022-08-05','13:34:32','00:00:00'),(80,'JORGE','2022-08-05','13:40:04','13:42:17'),(81,'JORGE','2022-08-05','13:44:50','13:47:17'),(82,'JORGE','2022-08-05','13:48:19','13:48:34'),(83,'JORGE','2022-08-05','14:03:08','14:03:26'),(84,'JORGE','2022-08-05','14:04:00','14:04:16'),(85,'JORGE','2022-08-05','14:04:57','00:00:00'),(86,'JORGE','2022-08-05','14:08:10','14:09:24'),(87,'JORGE','2022-08-05','14:11:50','14:12:42'),(88,'JORGE','2022-08-05','14:15:54','14:16:16'),(89,'JORGE','2022-08-05','14:17:24','14:17:32'),(90,'JORGE','2022-08-05','14:25:39','14:26:05'),(91,'JORGE','2022-08-05','14:28:17','00:00:00'),(92,'JORGE','2022-08-05','14:29:07','14:29:19'),(93,'JORGE','2022-08-05','14:30:05','00:00:00'),(94,'JORGE','2022-08-05','14:31:18','14:31:31'),(95,'JORGE','2022-08-05','14:34:36','14:36:07'),(96,'JORGE','2022-08-05','14:40:40','14:41:24'),(97,'JORGE','2022-08-05','14:42:17','14:42:27'),(98,'JORGE','2022-08-05','14:43:19','14:43:32'),(99,'JORGE','2022-08-05','14:43:53','14:44:07'),(100,'JORGE','2022-08-05','14:44:45','14:44:52'),(101,'JORGE','2022-08-05','14:45:44','14:45:50'),(102,'JORGE','2022-08-05','14:46:25','14:46:48'),(103,'JORGE','2022-08-05','14:47:15','14:47:31'),(104,'JORGE','2022-08-05','14:47:37','14:48:00'),(105,'JORGE','2022-08-05','14:49:32','14:50:01'),(106,'JORGE','2022-08-05','14:51:19','14:52:06'),(107,'JORGE','2022-08-05','14:55:30','14:55:42'),(108,'JORGE','2022-08-05','14:56:05','14:56:28'),(109,'JORGE','2022-08-05','14:57:05','14:57:18'),(110,'JORGE','2022-08-05','15:01:02','15:01:12'),(111,'JORGE','2022-08-05','15:03:02','15:03:12'),(112,'MAROMAS','2022-08-05','15:03:21','15:03:32'),(113,'JORGE','2022-08-05','15:04:37','15:04:55'),(114,'JORGE','2022-08-05','15:05:58','15:06:08'),(115,'JORGE','2022-08-05','15:06:43','15:07:03'),(116,'JORGE','2022-08-05','15:20:32','15:21:58'),(117,'JORGE','2022-08-05','15:30:22','00:00:00'),(118,'JORGE','2022-08-05','15:36:35','15:37:22'),(119,'JORGE','2022-08-05','15:38:17','15:38:56'),(120,'JORGE','2022-08-05','15:43:23','15:44:03'),(121,'JORGE','2022-08-05','15:50:51','15:51:28'),(122,'JORGE','2022-08-05','16:02:37','16:05:23'),(123,'JORGE','2022-08-05','16:05:41','16:08:09'),(124,'JORGE','2022-08-05','16:13:11','16:13:58'),(125,'JORGE','2022-08-05','16:15:53','16:16:35'),(126,'JORGE','2022-08-05','16:16:59','16:19:34'),(127,'JORGE','2022-08-05','16:20:56','16:21:38'),(128,'JORGE','2022-08-05','16:24:24','16:25:03'),(129,'JORGE','2022-08-05','17:29:55','17:30:52'),(130,'JORGE','2022-08-05','17:34:46','17:35:21'),(131,'JORGE','2022-08-05','17:38:39','17:39:14'),(132,'JORGE','2022-08-05','17:39:45','17:40:18'),(133,'JORGE','2022-08-05','17:42:35','17:43:08'),(134,'JORGE','2022-08-05','17:43:56','17:44:51'),(135,'JORGE','2022-08-05','17:45:26','17:46:13'),(136,'JORGE','2022-08-05','17:49:24','17:50:32'),(137,'JORGE','2022-08-05','17:51:24','17:53:23'),(138,'JORGE','2022-08-05','17:57:57','17:59:19'),(139,'JORGE','2022-08-05','18:01:33','18:01:47'),(140,'JORGE','2022-08-05','18:08:37','18:09:09'),(141,'JORGE','2022-08-05','18:12:08','18:12:41'),(142,'JORGE','2022-08-05','18:16:42','18:28:55'),(143,'JORGE','2022-08-05','18:41:40','18:42:54'),(144,'JORGE','2022-08-05','19:15:43','19:20:42'),(145,'JORGE','2022-08-05','19:22:55','19:24:12'),(146,'JORGE','2022-08-05','19:25:48','19:26:35'),(147,'JORGE','2022-08-05','19:38:01','00:00:00'),(148,'JORGE','2022-08-05','19:40:30','19:41:10'),(149,'JORGE','2022-08-05','19:50:43','19:52:00'),(150,'JORGE','2022-08-05','20:02:33','20:04:07'),(151,'MAROMAS','2022-08-05','20:06:27','20:08:42'),(152,'JORGE','2022-08-05','20:16:39','00:00:00'),(153,'JORGE','2022-08-05','20:20:38','20:21:02'),(154,'JORGE','2022-08-05','20:25:42','20:32:04'),(155,'JORGE','2022-08-05','20:32:10','00:00:00'),(156,'JORGE','2022-08-05','20:35:47','00:00:00'),(157,'JORGE','2022-08-05','20:38:53','20:42:09'),(158,'JORGE','2022-08-05','20:43:14','20:48:33'),(159,'JORGE','2022-08-05','21:07:11','21:19:18'),(160,'JORGE','2022-08-05','22:50:08','22:53:16'),(161,'JORGE','2022-08-05','23:00:34','00:00:00'),(162,'JORGE','2022-08-05','23:04:30','23:05:18'),(163,'JORGE','2022-08-05','23:05:38','23:05:54'),(164,'JORGE','2022-08-05','23:06:43','23:06:54'),(165,'JORGE','2022-08-05','23:08:03','23:08:17'),(166,'JORGE','2022-08-05','23:08:54','23:09:22'),(167,'JORGE','2022-08-05','23:10:28','23:11:37'),(168,'JORGE','2022-08-05','23:14:02','00:00:00'),(169,'JORGE','2022-08-05','23:15:22','23:15:43'),(170,'JORGE','2022-08-05','23:17:19','23:20:48');
/*!40000 ALTER TABLE `checador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taries`
--

DROP TABLE IF EXISTS `taries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taries` (
  `idtarifaEsta` int NOT NULL,
  `auto` double NOT NULL,
  `camioneta` double NOT NULL,
  `moto` double NOT NULL,
  `autoMe` double NOT NULL,
  PRIMARY KEY (`idtarifaEsta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taries`
--

LOCK TABLES `taries` WRITE;
/*!40000 ALTER TABLE `taries` DISABLE KEYS */;
INSERT INTO `taries` VALUES (1,15,20,15,0),(2,70,100,40,85),(3,900,900,900,150);
/*!40000 ALTER TABLE `taries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusaurio` int NOT NULL AUTO_INCREMENT,
  `user` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `rool` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  PRIMARY KEY (`idusaurio`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (17,'maromas','4321','Colaborador','Maromas','Maromas'),(18,'jorge','1234','Administrador','Jorge','Landeta'),(19,'RAUL','1234','Colaborador','RAUL','GARCIA ');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `idfolio` int NOT NULL AUTO_INCREMENT,
  `placas` varchar(7) DEFAULT NULL,
  `color` varchar(40) NOT NULL,
  `marca` varchar(40) NOT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `tipoV` varchar(20) NOT NULL,
  `obser` varchar(50) NOT NULL,
  `importe` double DEFAULT NULL,
  `horaEntrada` datetime NOT NULL,
  `horaSalida` datetime DEFAULT NULL,
  `tipoServicio` varchar(45) NOT NULL,
  PRIMARY KEY (`idfolio`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (1,'PRUEBA1','Blanco','Mercedes','Hatchback','Automovil','NINGUNA',0,'2022-08-05 16:03:54',NULL,'Estacionamiento'),(2,'PRUEBA2','Plata','Jaguar','Otro..','Camioneta','NINGUNA',0,'2022-08-05 16:06:24',NULL,'Estacionamiento'),(3,'PRUEBA3','Mostaza','Desconocida','Otro..','Motocicleta','NINGUNA',0,'2022-08-05 16:07:07',NULL,'Estacionamiento'),(4,'PRUEBA4','PRUEBA','PRUEBA1','Otro..','Automovil','NINGUNA',0,'2022-08-05 16:07:36',NULL,'Estacionamiento'),(5,'PRUEBA5','VERDE LIMÓN','VELOZ','PATITO','Automovil','NINGUNA',15,'2022-08-05 16:16:16','2022-08-05 16:17:02','Estacionamiento'),(6,'NUEVO','Blanco','Toyota','Otro..','Motocicleta','NINGUNA',0,'2022-08-05 16:19:16',NULL,'Estacionamiento'),(7,'PLACAS1','Otro...','Otro...','NUEVO','Motocicleta','NINGUNA',150,'2022-08-05 17:44:37','2022-08-05 23:19:11','Pension por noche'),(8,'PLACAS1',':P','HOLA','NUEVO','Motocicleta','NINGUNA',150,'2022-08-05 17:45:51','2022-08-05 23:19:11','Pension por noche'),(9,'JORGE','mundo','hola','mundo color','Motocicleta','NINGUNA',30,'2022-08-05 17:50:15','2022-08-05 19:23:00','Estacionamiento'),(10,'PLACAS1','Blanco','Nissan','NUEVO','Motocicleta','NINGUNA',150,'2022-08-05 17:51:50','2022-08-05 23:19:11','Pension por noche'),(11,'PLACAS1','Blanco','Nissan','NUEVO','Motocicleta','NINGUNA',150,'2022-08-05 18:08:59','2022-08-05 23:19:11','Pension por noche'),(12,'PLACAS1','Blanco','Nissan','Versa','Motocicleta','NINGUNA',150,'2022-08-05 18:41:57','2022-08-05 23:19:11','Pension por noche'),(13,'PLACAS1','Blanco','Nissan','Versa','Motocicleta','NINGUNA',150,'2022-08-05 18:42:16','2022-08-05 23:19:11','Pension por noche'),(14,'NUEVO8','Plata','KIA','Sorento','Camioneta','NINGUNA',40,'2022-08-05 19:19:35','2022-08-05 19:18:09','Estacionamiento'),(15,'GGGGGG','Blanco','Toyota','Corolla cross','Automovil','HOLA BERE COMO ESTAS,TAQUERO MUCHO',0,'2022-08-05 20:07:15',NULL,'Estacionamiento'),(16,'TLS1293','Azul','Volkswagen','Teramont','Automovil','NINGUNA',15,'2022-08-05 20:27:12','2022-08-05 20:25:45','Estacionamiento'),(17,'XOL1927','Rojo','Jeep','Cherokee','Camioneta','NINGUNA',100,'2022-08-05 20:28:50',NULL,'Lava autos'),(18,'XOL1940','Rojo','Jeep','Cherokee','Camioneta','NINGUNA',100,'2022-08-05 20:32:40',NULL,'Lava autos'),(19,'LLLLLLL','Negro','Mazda','CX-30','Camioneta','NINGUNA',70,'2022-08-05 20:36:13',NULL,'Lava autos'),(20,'CHONA','Beige','BMW','Serie 67','Camioneta','HOLAAAAAAAAAAAAA',85,'2022-08-05 20:39:27',NULL,'Lava autos'),(21,'CHONA','Beige','BMW','Serie 67','Camioneta','HOLAAAAAAAAAAAAA',20,'2022-08-05 20:40:42','2022-08-05 20:40:29','Estacionamiento'),(22,'XM92735','Plata','Mazda','MX-5','Automovil','NINGUNA',15,'2022-08-05 20:43:46','2022-08-05 20:43:16','Estacionamiento'),(23,'TW16203','Verde','Hyundai','NuevoModelo','Camioneta','NINGUNA',20,'2022-08-05 20:44:35','2022-08-05 20:44:08','Estacionamiento'),(24,'NUEVITO','Plata','BMW','nuevoModelo','Automovil','NINGUNA',150,'2022-08-05 22:50:34','2022-08-05 23:18:06','Pension por noche'),(25,'NUEVITO','Plata','BMW','nuevoModelo','Automovil','NINGUNA',150,'2022-08-05 22:51:53','2022-08-05 23:18:06','Pension por noche'),(26,'HOLANUE','Blanco','Mercedes','Hatchback','Camioneta','NINGUNA',0,'2022-08-05 23:11:24',NULL,'Estacionamiento');
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-05 23:25:50
