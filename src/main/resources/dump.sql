-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: telao_cae
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agendamento_pontual`
--

DROP TABLE IF EXISTS `agendamento_pontual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendamento_pontual` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `professor_id` bigint NOT NULL,
  `materia_id` bigint NOT NULL,
  `sala_id` bigint NOT NULL,
  `data` date NOT NULL,
  `horario_inicio` varchar(5) NOT NULL,
  `horario_fim` varchar(45) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_agendamento_professores1_idx` (`professor_id`),
  KEY `fk_agendamento_materias1_idx` (`materia_id`),
  KEY `fk_agendamento_salas1_idx` (`sala_id`),
  CONSTRAINT `fk_agendamento_materias100` FOREIGN KEY (`materia_id`) REFERENCES `materias` (`id`),
  CONSTRAINT `fk_agendamento_professores100` FOREIGN KEY (`professor_id`) REFERENCES `professores` (`id`),
  CONSTRAINT `fk_agendamento_salas100` FOREIGN KEY (`sala_id`) REFERENCES `salas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento_pontual`
--

LOCK TABLES `agendamento_pontual` WRITE;
/*!40000 ALTER TABLE `agendamento_pontual` DISABLE KEYS */;
/*!40000 ALTER TABLE `agendamento_pontual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agendamento_recorrente`
--

DROP TABLE IF EXISTS `agendamento_recorrente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendamento_recorrente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `professor_id` bigint NOT NULL,
  `materia_id` bigint NOT NULL,
  `sala_id` bigint NOT NULL,
  `dia_semana` varchar(20) NOT NULL,
  `horario_inicio` time NOT NULL,
  `horario_fim` time NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_agendamento_professores1_idx` (`professor_id`),
  KEY `fk_agendamento_materias1_idx` (`materia_id`),
  KEY `fk_agendamento_salas1_idx` (`sala_id`),
  CONSTRAINT `fk_agendamento_materias10` FOREIGN KEY (`materia_id`) REFERENCES `materias` (`id`),
  CONSTRAINT `fk_agendamento_professores10` FOREIGN KEY (`professor_id`) REFERENCES `professores` (`id`),
  CONSTRAINT `fk_agendamento_salas10` FOREIGN KEY (`sala_id`) REFERENCES `salas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento_recorrente`
--

LOCK TABLES `agendamento_recorrente` WRITE;
/*!40000 ALTER TABLE `agendamento_recorrente` DISABLE KEYS */;
INSERT INTO `agendamento_recorrente` VALUES (4,2,2,2,'SEGUNDA','19:00:00','22:00:00','2024-09-29 09:45:23','2024-09-29 09:45:23',NULL),(5,2,2,2,'TERCA','19:00:00','22:00:00','2024-09-29 10:19:43','2024-09-29 10:19:43',NULL);
/*!40000 ALTER TABLE `agendamento_recorrente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blocos`
--

DROP TABLE IF EXISTS `blocos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blocos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blocos`
--

LOCK TABLES `blocos` WRITE;
/*!40000 ALTER TABLE `blocos` DISABLE KEYS */;
INSERT INTO `blocos` VALUES (1,'Informática'),(2,'Física'),(3,'Mecânica'),(4,'Edificações');
/*!40000 ALTER TABLE `blocos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `sigla` varchar(45) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (7,'Técnico em Manutenção e Suporte em Informática','MSI','2024-09-26 20:17:02','2024-09-26 20:17:02',NULL),(8,'Introdução Programação','IP2','2024-09-26 20:18:15','2024-09-26 20:36:00',NULL),(9,'Técnico em Manutenção e Suporte em Informática','MSI','2024-09-29 11:02:36','2024-09-29 11:02:36',NULL);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materias`
--

DROP TABLE IF EXISTS `materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materias` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `curso_id` bigint NOT NULL,
  `nome` varchar(45) NOT NULL,
  `sigla` varchar(45) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_materias_cursos_idx` (`curso_id`),
  CONSTRAINT `fk_materias_cursos` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias`
--

LOCK TABLES `materias` WRITE;
/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
INSERT INTO `materias` VALUES (1,7,'Introdução Programação','IP2','2024-09-26 20:34:59','2024-09-26 20:36:21',NULL),(2,7,'Introdução Programação','IP','2024-09-26 20:37:06','2024-09-26 20:37:06',NULL);
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professores`
--

DROP TABLE IF EXISTS `professores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professores` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professores`
--

LOCK TABLES `professores` WRITE;
/*!40000 ALTER TABLE `professores` DISABLE KEYS */;
INSERT INTO `professores` VALUES (2,'Gerson','2024-09-26 21:25:40','2024-09-26 21:25:40',NULL);
/*!40000 ALTER TABLE `professores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salas`
--

DROP TABLE IF EXISTS `salas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` text,
  `qtd_computadores` int DEFAULT NULL,
  `qtd_alunos` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  `bloco_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_salas_blocos1_idx` (`bloco_id`),
  CONSTRAINT `fk_salas_blocos1` FOREIGN KEY (`bloco_id`) REFERENCES `blocos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salas`
--

LOCK TABLES `salas` WRITE;
/*!40000 ALTER TABLE `salas` DISABLE KEYS */;
INSERT INTO `salas` VALUES (2,'Auditorio Informatica','',0,50,'2024-09-26 21:25:55','2024-09-26 21:25:55',NULL,1),(3,'Lab A','Laboratório de Informática A - A304',18,27,'2024-09-29 22:45:52','2024-09-29 22:45:52',NULL,1),(4,'Lab B','Laboratório de Informática B - A305',20,25,'2024-09-29 22:45:53','2024-09-29 22:45:53',NULL,1),(5,'Lab C','Laboratório de Informática C - A310',20,35,'2024-09-29 22:45:55','2024-09-29 22:45:55',NULL,1),(6,'Lab D','Laboratório de Informática D - A311',20,35,'2024-09-29 22:45:57','2024-09-29 22:45:57',NULL,1),(7,'Lab E','Laboratório de Informática E - A312',20,38,'2024-09-29 22:45:59','2024-09-29 22:45:59',NULL,1),(8,'Lab 40','Sala 506',0,45,'2024-09-29 22:46:01','2024-09-29 22:46:01',NULL,1),(9,'Lab Hardware','Laboratório de Hardware',0,20,'2024-09-29 22:46:06','2024-09-29 22:46:06',NULL,1),(10,'A321','Sala de Aula II',0,34,'2024-09-29 22:46:15','2024-09-29 22:46:15',NULL,1),(11,'A322','Sala A 322, com 7 cadeiras canhota',0,30,'2024-09-29 22:46:18','2024-09-29 22:46:18',NULL,1),(12,'A329','Sala de Aula',NULL,NULL,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,1),(13,'PIBID',NULL,NULL,NULL,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,2),(14,'Lab IOT','Laboratório de IOT',NULL,36,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,1),(15,'Auditório Bloco Indústria','Auditório Bloco Indústria, sala 401',NULL,50,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,3),(16,'Lab Pneumática e Hidráulica','Laboratório Pneumática e Hidráulica, sala 402',NULL,NULL,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,3),(17,'Lab Controle e Automação','Laboratório Controle e Automação, sala 403',NULL,NULL,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,3),(18,'Lab Eletrônica','Laboratório de Eletrônica, sala 404',NULL,NULL,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,3),(19,'Metrologia','Sala 408',NULL,28,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,3),(20,'Máquinas Elétricas','Sala 409',NULL,43,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,3),(21,'Sala 430','Sala 430',NULL,41,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,3),(22,'Sala 432 - Piso Inferior da Mecânica','Sala 432',NULL,NULL,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,3),(23,'Lab Física - 509','Sala 509, com 4 carteiras universitárias azuis',NULL,17,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,2),(24,'Lab de Solos','Sala 510',NULL,NULL,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,4),(25,'Pranchetário','Sala 515',NULL,NULL,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,4),(26,'Sala 516','Sala 516',NULL,41,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,4),(27,'Topografia','Sala 517',NULL,40,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,4),(28,'Canteiro',NULL,NULL,NULL,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,4),(29,'Lab de Práticas Corporais','Laboratório de Práticas Corporais',NULL,40,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,4),(30,'Sala 102','Sala 102',NULL,35,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,4),(31,'Sala 103','Sala 103',NULL,42,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,4),(32,'Sala 104','Sala 104',NULL,36,'2024-09-30 01:59:17','2024-09-30 01:59:17',NULL,4);
/*!40000 ALTER TABLE `salas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `login` text NOT NULL,
  `password` text NOT NULL,
  `role` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Thomas','thomas.nishiduka@gmail.com','$2a$10$5Vml91iQ1n4A20EVIIWR3Oad.tvdsOF.8m/NXFh6tJeCXs0tpiTj.','ADMIN'),(2,'Thomas','thomas.nishiduka@gmail.com.br','$2a$10$iea4qk0BaZvFJtq94cKK0eEYdi.yVmPFbM5z5hdylKxEzGUzgSmkG','ADMIN');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'telao_cae'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-04 17:45:01
