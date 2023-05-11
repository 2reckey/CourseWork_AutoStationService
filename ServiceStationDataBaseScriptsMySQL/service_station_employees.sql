-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: service_station
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(50) NOT NULL,
  `employee_position` varchar(50) NOT NULL,
  `employee_phone` varchar(45) NOT NULL,
  `employee_email` varchar(50) NOT NULL,
  `employee_address` varchar(200) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Федоров Дмитрий Александрович','Директор','8-999-444-44-44','fedorov@mail.ru','г. Москва, ул. Ленинская, д.6'),(2,'Иванов Иван Иванович','Старший механик','8-999-999-99-99','ivanov@mail.ru','г. Москва, ул. Красная, д.1'),(3,'Петров Петр Петрович','Инженер-конструктор','8-999-888-88-88','petrov@mail.ru','г. Москва, ул. Ленина, д.2'),(4,'Сидорова Анна Ивановна','Бухгалтер','8-999-777-77-77','sidorova@mail.ru','г. Москва, ул. Советская, д.3'),(5,'Кузнецов Александр Игоревич','Программист','8-999-666-66-66','kuznetsov@mail.ru','г. Москва, ул. Гагарина, д.4'),(6,'Григорьева Екатерина Владимировна','Руководитель отдела продаж','8-999-555-55-55','grigoreva@mail.ru','г. Москва, ул. Пушкина, д.5'),(7,'Макарова Анна Алексеевна','Механик','8-999-333-33-33','makarova@mail.ru','г. Москва, ул. Строителей, д.7'),(8,'Никитин Алексей Викторович','Механик','8-999-222-22-22','nikitin@mail.ru','г. Москва, ул. Комсомольская, д.8'),(9,'Смирнова Ольга Николаевна','Менеджер по закупкам','8-999-111-11-11','smirnova@mail.ru','г. Москва, ул. Ленина, д.9'),(10,'Козлов Владислав Игоревич','Механик','8-999-000-00-00','kozlov@mail.ru','г. Москва, ул. Маяковского, д.10');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-11 10:21:23
