-- MySQL dump 10.13  Distrib 5.6.21, for Win32 (x86)
--
-- Host: localhost    Database: loja
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Current Database: `loja`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `loja` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `loja`;

--
-- Table structure for table `aluguel`
--

DROP TABLE IF EXISTS `aluguel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluguel` (
  `codAluguel` int(6) NOT NULL AUTO_INCREMENT,
  `codCliente` int(6) NOT NULL,
  `dataLoca` varchar(15) NOT NULL,
  `dataDevo` varchar(15) NOT NULL,
  `preco` float NOT NULL,
  `precoFinal` float NOT NULL,
  PRIMARY KEY (`codAluguel`),
  UNIQUE KEY `codCliente` (`codCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluguel`
--

LOCK TABLES `aluguel` WRITE;
/*!40000 ALTER TABLE `aluguel` DISABLE KEYS */;
INSERT INTO `aluguel` VALUES (10,48,'12','21',32,11);
/*!40000 ALTER TABLE `aluguel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `nome` varchar(30) NOT NULL,
  `CPF` varchar(30) NOT NULL,
  `RG` varchar(30) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `endereco` varchar(30) NOT NULL,
  `bairro` varchar(30) NOT NULL,
  `cidade` varchar(20) NOT NULL,
  `estado` varchar(15) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `codCliente` int(4) NOT NULL AUTO_INCREMENT,
  `registrado` tinyint(1) NOT NULL,
  PRIMARY KEY (`codCliente`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `RG` (`RG`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('joseph','232.344.423-23','sdsdsd','(23)2323-23232','sdss','ssdsd','sdsdsd','sdssds','323',25,0),('Andson','123.444.555-66','234433','(87)9922-3322','rua','centro','petro','pern','88',46,0),('junior','123.555.599-00','22323232','(87)9992-2323','rua frei domingos','quadra 02','petrolandia','pernambuco','48',47,0),('andsonj13','123.232.323-33','3232','(32)3999-1111','rua','centro','petro','pern','31',48,1),('fulano','222.222.222-22','sdsds','(22)2222-2222','rua tal','aquele la','pa','bh','22',49,0),('coisinha','333.333.333-33','2121','(11)1111-1111','rua tal','op','recife','pe','22',50,0);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `codFuncionario` int(3) NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) NOT NULL,
  `CPF` varchar(15) NOT NULL,
  `RG` varchar(20) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `estado` varchar(15) NOT NULL,
  `cidade` varchar(20) NOT NULL,
  `bairro` varchar(20) NOT NULL,
  `numero` varchar(6) NOT NULL,
  `endereco` varchar(30) NOT NULL,
  `login` varchar(30) NOT NULL,
  `senha` varchar(30) NOT NULL,
  `registrado` tinyint(1) NOT NULL,
  PRIMARY KEY (`codFuncionario`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (23,'andson','111.111.111-11','aaa','(22)2222-2222','aaa','aaa','aa','aa','aa','aj','aj',0);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista`
--

DROP TABLE IF EXISTS `lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista` (
  `codLista` int(6) NOT NULL AUTO_INCREMENT,
  `codCliente` int(4) NOT NULL,
  `codRoupa` int(4) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `tamanho` varchar(10) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `cor` varchar(20) NOT NULL,
  `disponibilidade` tinyint(1) NOT NULL,
  `preco` float NOT NULL,
  PRIMARY KEY (`codLista`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista`
--

LOCK TABLES `lista` WRITE;
/*!40000 ALTER TABLE `lista` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listafinal`
--

DROP TABLE IF EXISTS `listafinal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listafinal` (
  `codLista` int(6) NOT NULL AUTO_INCREMENT,
  `codCliente` int(6) NOT NULL,
  `codRoupa` int(6) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `tamanho` varchar(20) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `cor` varchar(20) NOT NULL,
  `disponibilidade` tinyint(1) NOT NULL,
  `preco` float NOT NULL,
  PRIMARY KEY (`codLista`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listafinal`
--

LOCK TABLES `listafinal` WRITE;
/*!40000 ALTER TABLE `listafinal` DISABLE KEYS */;
INSERT INTO `listafinal` VALUES (15,25,2,'casaco','capuz','gg','masculino','preto',0,12),(16,25,9,'SAIA','RODADA','4','forro','laranja',0,500),(23,48,4,'calça','jeans','asdas','assd','asdas',0,22),(24,48,10,'calcinha','preta','é só o','a moçada','filé',0,10);
/*!40000 ALTER TABLE `listafinal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `cod_login` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) DEFAULT NULL,
  `senha` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cod_login`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'and','and'),(2,'123','123'),(3,'aj013','aj013');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_root`
--

DROP TABLE IF EXISTS `login_root`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_root` (
  `cod_login` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) DEFAULT NULL,
  `senha` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cod_login`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_root`
--

LOCK TABLES `login_root` WRITE;
/*!40000 ALTER TABLE `login_root` DISABLE KEYS */;
INSERT INTO `login_root` VALUES (1,'root','root');
/*!40000 ALTER TABLE `login_root` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roupa`
--

DROP TABLE IF EXISTS `roupa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roupa` (
  `tipo` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `tamanho` varchar(10) NOT NULL,
  `genero` varchar(10) NOT NULL,
  `cor` varchar(10) NOT NULL,
  `disponibilidade` tinyint(1) NOT NULL,
  `preco` float NOT NULL,
  `codRoupa` int(4) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`codRoupa`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roupa`
--

LOCK TABLES `roupa` WRITE;
/*!40000 ALTER TABLE `roupa` DISABLE KEYS */;
INSERT INTO `roupa` VALUES ('casaco','capuz','gg','masculino','preto',0,12,2),('calça','jeans','asdas','assd','asdas',1,22,4),('sapato','social','sdsds','dsdsd','sdsds',0,2121,7),('meia','cano alto','p','masculina','azul',0,12,8),('SAIA','RODADA','4','forro','laranja',0,500,9),('calcinha','preta','é só o','a moçada','filé',1,10,10);
/*!40000 ALTER TABLE `roupa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roupasele`
--

DROP TABLE IF EXISTS `roupasele`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roupasele` (
  `codRoupaSele` int(6) NOT NULL AUTO_INCREMENT,
  `codRoupa` int(5) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `tamanho` varchar(20) NOT NULL,
  `genero` varchar(15) NOT NULL,
  `cor` varchar(15) NOT NULL,
  `disponibilidade` tinyint(1) NOT NULL,
  `preco` float NOT NULL,
  PRIMARY KEY (`codRoupaSele`),
  UNIQUE KEY `codRoupa` (`codRoupa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roupasele`
--

LOCK TABLES `roupasele` WRITE;
/*!40000 ALTER TABLE `roupasele` DISABLE KEYS */;
/*!40000 ALTER TABLE `roupasele` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-13  9:55:07
