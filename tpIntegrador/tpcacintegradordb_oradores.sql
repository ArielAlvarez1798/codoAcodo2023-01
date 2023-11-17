-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: tpcacintegradordb
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `oradores`
--

DROP TABLE IF EXISTS `oradores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oradores` (
  `id_orador` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(254) NOT NULL DEFAULT '""',
  `apellido` varchar(254) NOT NULL DEFAULT '""',
  `mail` varchar(254) NOT NULL DEFAULT '""',
  `tema` varchar(5000) NOT NULL DEFAULT '""',
  `fecha_alta` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_orador`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oradores`
--

LOCK TABLES `oradores` WRITE;
/*!40000 ALTER TABLE `oradores` DISABLE KEYS */;
INSERT INTO `oradores` VALUES (1,'Alberto','Dominguez','adominguez@gmail.com','La evolucion de la IA','2023-11-16 00:00:00'),(2,'Sandra','Freming','sandra2525@gmail.com','Analisis Calentamiento Global Latinoameria','2023-11-05 00:00:00'),(3,'Marcela','Frias','mfrias@emp.org','Impacto de la IA en la educacion','2023-11-12 00:00:00'),(4,'Pedro','Farinias','fariniaspedro01@hotmail.com','Presentacion nuevos procesadores electronicos','2023-11-07 00:00:00'),(5,'Agustin','Cooper','acooper@hotmail.com','Analisis sistemas de Geolocalizacion','2023-10-07 00:00:00'),(6,'Valentina','Gonzales','vg@pimelat.com','Evolucion de las Pimes en Lat','2023-11-17 00:00:00'),(7,'Emanual','Santos','santosemanuel75@gmail.com','Conceptos Basicos de robotica en la empresa','2023-09-17 00:00:00'),(8,'Susana','Martinblanco','martinblancosusana.lg@logic.com','Modelo de automatizacion en la micro empresa','2023-11-25 00:00:00'),(9,'Victor','Juarez','vjuarez1950@hotmail.com','Hibernate','2023-10-25 00:00:00'),(10,'Alfonsina','Weiskey','awlom@gmail.com','Sistema de reciclado material electronico en las empresas','2023-10-29 00:00:00');
/*!40000 ALTER TABLE `oradores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-17 18:42:00
