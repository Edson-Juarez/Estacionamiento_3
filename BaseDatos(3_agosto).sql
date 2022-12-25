-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: estacion
-- ------------------------------------------------------
-- Server version	8.0.30

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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checador`
--

LOCK TABLES `checador` WRITE;
/*!40000 ALTER TABLE `checador` DISABLE KEYS */;
INSERT INTO `checador` VALUES (26,'JORGE','2022-08-03','01:21:00','01:21:08'),(27,'LEONARDO','2022-08-03','01:21:00','01:22:05'),(28,'JORGE','2022-08-03','01:22:00','01:23:01'),(29,'LEONARDO','2022-08-03','01:23:00','01:23:46'),(30,'JORGE','2022-08-03','01:26:30','01:27:02'),(31,'LEONARDO','2022-08-03','01:27:38','01:27:47');
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
  `autoMe` int NOT NULL,
  PRIMARY KEY (`idtarifaEsta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taries`
--

LOCK TABLES `taries` WRITE;
/*!40000 ALTER TABLE `taries` DISABLE KEYS */;
INSERT INTO `taries` VALUES (1,15,20,15,0),(2,70,100,40,85),(3,700,700,700,150);
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (17,'leonardo','1234','Colaborador','Leonardo','Montes'),(18,'jorge','1234','Administrador','Jorge','Landeta');
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
  `color` varchar(10) NOT NULL,
  `marca` varchar(40) NOT NULL,
  `tipoV` varchar(20) NOT NULL,
  `obser` varchar(50) NOT NULL,
  `importe` double DEFAULT NULL,
  `horaEntrada` datetime NOT NULL,
  `horaSalida` datetime DEFAULT NULL,
  `tipoServicio` varchar(45) NOT NULL,
  PRIMARY KEY (`idfolio`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (1,'JUANITO','Plata','Toyota','Automovil','NINGUNA',100,'2022-08-01 13:46:41','2022-08-01 15:18:22','Estacionamiento'),(2,'PEDRO','Amarillo','KIA','Automovil','RAYON',0,'2022-08-01 14:55:38',NULL,'Estacionamiento'),(3,'PEDRO','Amarillo','KIA','Automovil','RAYONCITO',0,'2022-08-01 14:55:55',NULL,'Estacionamiento'),(4,'PATITO','Negro','KIA','Camioneta','NINGUNA',720,'2022-08-01 15:27:08','2022-08-01 15:27:42','Estacionamiento'),(5,'PATITO','Negro','KIA','Camioneta','NINGUNA',700,'2022-08-01 15:27:26',NULL,'Pension'),(6,'PLAQUIT','Negro','Hyundai','Automovil','NINGUNA',700,'2022-08-01 17:31:44',NULL,'Pension'),(7,'PLAQUIT','Negro','Hyundai','Automovil','NINGUNA',70,'2022-08-01 17:32:37',NULL,'Lava autos'),(8,'PLAQUIT','Blanco','Nissan','Automovil','NINGUNA',85,'2022-08-01 17:33:47','2022-08-01 17:33:57','Estacionamiento y lava autos'),(9,'BERECIT','Blanco','Nissan','Camioneta','NINGUNA',150,'2022-08-02 01:41:09','2022-08-02 01:41:14','Pension por noche'),(10,'ASDFGHJ','Negro','Toyota','Automovil','NINGUNA',15,'2022-08-02 02:02:52','2022-08-02 02:03:50','Estacionamiento'),(11,'ASDFGHJ','Blanco','Nissan','Automovil','NINGUNA',15,'2022-08-02 02:03:45','2022-08-02 02:03:50','Estacionamiento'),(12,'OTROOOO','WINDA','KIPO','Camioneta','NINGUNA',20,'2022-08-02 02:04:35','2022-08-02 02:04:37','Estacionamiento'),(13,'ASDDFDF','cafe','jpo','Camioneta','NINGUNA',20,'2022-08-02 08:29:22','2022-08-02 08:29:28','Estacionamiento'),(14,'MMMMMMM','Azul','Otro...','Camioneta','NINGUNA',20,'2022-08-02 08:33:06','2022-08-02 08:33:11','Estacionamiento'),(15,'1234567','ROSA','Toyota','Automovil','NINGUNA',15,'2022-08-02 09:20:37','2022-08-02 09:20:40','Estacionamiento');
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

-- Dump completed on 2022-08-03  1:29:24
