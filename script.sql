-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: purchasemnmgt
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP DATABASE IF EXISTS `purchasemnmgmt`;
CREATE DATABASE `purchasemnmgmt`;
USE `purchasemnmgmt`;

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dealer`
--

DROP TABLE IF EXISTS `dealer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dealer` (
  `requestId` int(11) NOT NULL,
  `dealerId` int(10) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`dealerId`),
  UNIQUE KEY `requestId_UNIQUE` (`requestId`),
  CONSTRAINT `fk_rid` FOREIGN KEY (`requestId`) REFERENCES `dealer_details` (`requestId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dealer`
--

LOCK TABLES `dealer` WRITE;
/*!40000 ALTER TABLE `dealer` DISABLE KEYS */;
/*!40000 ALTER TABLE `dealer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dealer_details`
--

DROP TABLE IF EXISTS `dealer_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dealer_details` (
  `requestId` int(11) NOT NULL AUTO_INCREMENT,
  `dealerId` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `area` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile` int(10) NOT NULL,
  PRIMARY KEY (`requestId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dealer_details`
--

LOCK TABLES `dealer_details` WRITE;
/*!40000 ALTER TABLE `dealer_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `dealer_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_dealer_details`
--

DROP TABLE IF EXISTS `ex_dealer_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_dealer_details` (
  `dealerId` int(11) NOT NULL,
  `date` date NOT NULL,
  `name` varchar(45) NOT NULL,
  `area` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile` int(10) NOT NULL,
  PRIMARY KEY (`dealerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_dealer_details`
--

LOCK TABLES `ex_dealer_details` WRITE;
/*!40000 ALTER TABLE `ex_dealer_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ex_dealer_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_details` (
  `transactionId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `productId` int(11) DEFAULT NULL,
  `dealerId` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`transactionId`),
  CONSTRAINT `fk_dealer` FOREIGN KEY (`dealerId`) REFERENCES `dealer` (`dealerId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `dealerId` int(10) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `categoryId` int(10) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `image` blob,
  PRIMARY KEY (`productId`),
  CONSTRAINT `fk_cid` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_did` FOREIGN KEY (`dealerId`) REFERENCES `dealer` (`dealerId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile` int(10) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-10 17:41:06
