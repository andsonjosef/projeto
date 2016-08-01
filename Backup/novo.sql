
CREATE DATABASE /*!32312 IF NOT EXISTS*/ `loja` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `loja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluguel` (
  `codAluguel` int(6) NOT NULL AUTO_INCREMENT,
  `codCliente` int(6) NOT NULL,
  `dataLoca` varchar(15) NOT NULL,
  `dataDevo` varchar(15) NOT NULL,
  `funcionario` varchar(20) NOT NULL,
  `preco` float NOT NULL,
  PRIMARY KEY (`codAluguel`),
  UNIQUE KEY `codCliente` (`codCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `aluguel` VALUES (48,93,'14/07/2016','14/08/2016','',333);
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluguellixeira` (
  `codCliente` int(6) NOT NULL,
  `dataLoca` varchar(15) NOT NULL,
  `dataDevo` varchar(15) NOT NULL,
  `preco` float NOT NULL,
  `precoFinal` float NOT NULL,
  `funcionario` varchar(15) NOT NULL,
  `pagamento` varchar(15) NOT NULL,
  `codAluguelLixe` int(6) NOT NULL AUTO_INCREMENT,
  `codAluguel` int(11) NOT NULL,
  PRIMARY KEY (`codAluguelLixe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
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
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `cliente` VALUES ('ANDSON','111.111.111-11','WSDSDS','(88)9999-9999','RUA FREI','QUADRA','PETRO','PE','99',90,0),('DENISE X','908.980.988-99','90989008998','(98)0900-0990','RUA DAS ACASSIS','CENTRO','PAULO AFONSO','BA','90',93,1),('JOSEPH','121.212.121-21','323','(22)2222-2222','DSDDA','ASDSA','PETRO','PE','222',94,0);
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientelixeira` (
  `codigoCliLixeira` int(5) NOT NULL AUTO_INCREMENT,
  `codCliente` int(5) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `CPF` varchar(15) NOT NULL,
  `RG` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `cidade` varchar(20) NOT NULL,
  `bairro` varchar(20) NOT NULL,
  `endereco` varchar(30) NOT NULL,
  `numero` varchar(6) NOT NULL,
  `telefone` varchar(16) NOT NULL,
  `registrado` tinyint(1) NOT NULL,
  PRIMARY KEY (`codigoCliLixeira`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `clientelixeira` VALUES (1,94,'Andson','121.221.122-11','2121','MT','asas','asasa','asas','2211','(88)8888-8888',0),(2,92,'ANDSON','222.222.222-22','232','PE','PETRO','PETRO','RUA','38','(22)2222-2222',0);
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
  PRIMARY KEY (`codFuncionario`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `RG` (`RG`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `funcionario` VALUES (29,'sasss','221.111.111-11','asasa','(11)1111-1111','sasa','asas','asas','sasa','asas','JOÃO','JOÃO');
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
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `listafinal` VALUES (61,92,17,'CALÇA','CALÇA (SKINNY)','M','MASCULINO','ROSA',0,50),(72,93,18,'GRAVATA','CALÇA (SKINNY)','GG','MASCULINO','AMARELO',0,333);
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listafinallixeira` (
  `codListaLixeira` int(6) NOT NULL AUTO_INCREMENT,
  `codCliente` int(6) NOT NULL,
  `codRoupa` int(6) NOT NULL,
  `tipo` varchar(15) NOT NULL,
  `modelo` varchar(15) NOT NULL,
  `tamanho` varchar(15) NOT NULL,
  `genero` varchar(15) NOT NULL,
  `cor` varchar(15) NOT NULL,
  `disponibilidade` varchar(15) NOT NULL,
  `preco` float NOT NULL,
  PRIMARY KEY (`codListaLixeira`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `listafinallixeira` VALUES (1,46,14,'camisa','social','p','feminina','branca','0',100),(2,51,10,'calcinha','preta','a mocada','e so o','file','0',10),(3,53,8,'meia','cano alto','p','masculina','azul','0',12),(4,50,11,'casaco','sem capuz','p','feminino','rosa','0',120),(5,52,2,'casaco','capuz','gg','masculino','preto','0',180),(6,53,13,'camisa','polo','m','feminina','preta','0',80),(7,52,15,'camisa','social','m','masculino','branca','0',100),(8,50,12,'camisa','polo','g','masculino','verde','0',80),(9,50,9,'SAIA','RODADA','4','forro','laranja','0',50),(10,46,13,'camisa','polo','m','feminina','preta','0',80),(11,50,9,'SAIA','RODADA','4','forro','laranja','0',50),(12,46,11,'casaco','sem capuz','p','feminino','rosa','0',120),(13,53,16,'terno','smoke','M','masculino','preto','0',50),(14,53,12,'camisa','polo','g','masculino','verde','0',80),(15,51,15,'camisa','social','m','masculino','branca','0',100),(16,55,8,'meia','cano alto','p','masculina','azul','0',12),(17,49,9,'SAIA','RODADA','4','forro','laranja','1',50),(18,46,16,'terno','smoke','M','masculino','preto','0',50),(19,52,13,'camisa','polo','p','feminina','preta','0',80),(20,55,14,'camisa','social','p','feminina','branca','0',100),(21,53,11,'casaco','sem capuz','p','feminino','rosa','0',120),(22,46,15,'camisa','social','m','masculino','branca','0',100),(23,54,9,'SAIA','RODADA','4','forro','laranja','0',50),(24,50,15,'camisa','social','m','masculino','branca','0',100),(25,53,12,'camisa','polo','g','masculino','verde','0',80),(26,55,11,'casaco','sem capuz','p','feminino','rosa','0',120),(27,51,16,'terno','smoke','M','masculino','preto','0',50),(28,50,12,'camisa','polo','g','masculino','verde','0',80),(29,49,7,'sapato','social','41','masculino','preto','0',100),(30,46,10,'calcinha','preta','a mocada','e so o','file','0',10),(31,50,8,'meia','cano alto','p','masculina','azul','0',12),(32,54,13,'camisa','polo','p','feminina','preta','0',80),(33,49,10,'calcinha','preta','a mocada','e so o','file','0',10),(34,49,10,'calcinha','preta','a mocada','e so o','file','0',10),(35,51,14,'camisa','social','p','feminina','branca','0',100),(36,54,8,'meia','cano alto','p','masculina','azul','0',12),(37,55,7,'sapato','social','41','masculino','preto','0',100),(38,52,16,'terno','smoke','M','masculino','preto','0',50),(39,55,14,'camisa','social','p','feminina','branca','0',100),(40,93,17,'CALÇA','CALÇA (SKINNY)','M','MASCULINO','ROSA','0',50),(41,93,17,'CALÇA','CALÇA (SKINNY)','M','MASCULINO','ROSA','0',50),(42,93,18,'GRAVATA','CALÇA (SKINNY)','GG','MASCULINO','AMARELO','0',333),(43,94,19,'SAPATO','VESTIDO (CURTO)','G','INFANTIL','VERMELHO','0',111),(44,90,17,'CALÇA','CALÇA (SKINNY)','M','MASCULINO','ROSA','0',50),(45,94,19,'SAPATO','VESTIDO (CURTO)','G','INFANTIL','VERMELHO','0',111),(46,93,19,'SAPATO','VESTIDO (CURTO)','G','INFANTIL','VERMELHO','0',111),(47,93,19,'SAPATO','VESTIDO (CURTO)','G','INFANTIL','VERMELHO','0',111),(48,93,17,'CALÇA','CALÇA (SKINNY)','M','MASCULINO','ROSA','0',50),(49,93,18,'GRAVATA','CALÇA (SKINNY)','GG','MASCULINO','AMARELO','0',333),(50,93,17,'CALÇA','CALÇA (SKINNY)','M','MASCULINO','ROSA','0',50);
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `cod_login` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) DEFAULT NULL,
  `senha` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cod_login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_root` (
  `cod_login` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) DEFAULT NULL,
  `senha` varchar(30) DEFAULT NULL,
  `pergunta` varchar(30) NOT NULL,
  `resposta` varchar(30) NOT NULL,
  PRIMARY KEY (`cod_login`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `login_root` VALUES (1,'root','root','root','root');
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagamento` (
  `valorParc1` float DEFAULT NULL,
  `dataVenc1` varchar(13) DEFAULT NULL,
  `status1` varchar(10) DEFAULT NULL,
  `valorPago1` float DEFAULT NULL,
  `dataPago1` varchar(13) DEFAULT NULL,
  `valorParc2` float DEFAULT NULL,
  `dataVenc2` varchar(13) DEFAULT NULL,
  `status2` varchar(15) DEFAULT NULL,
  `valorPago2` float DEFAULT NULL,
  `dataPago2` varchar(13) DEFAULT NULL,
  `cliente` varchar(30) NOT NULL,
  `funcionario` varchar(20) DEFAULT NULL,
  `codCliente` int(6) NOT NULL,
  `preco` float NOT NULL,
  `precofinal` float DEFAULT NULL,
  `precoTotal` float DEFAULT NULL,
  `pagamento` varchar(15) DEFAULT NULL,
  `codPagamento` int(11) NOT NULL AUTO_INCREMENT,
  `codAluguel` int(11) NOT NULL,
  PRIMARY KEY (`codPagamento`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `pagamento` VALUES (100,'14/07/2016','Pago',100,'14/07/2016',0,NULL,NULL,0,NULL,'DENISE X',NULL,93,111,0,100,'À vista',4,44),(25,'14/07/2016','Pago',25,'14/07/2016',25,'14/08/2016','Pago',25,'14/08/2016','DENISE X',NULL,93,0,0,100,'2 vezes',5,45),(150,'14/07/2016','Pago',150,'14/07/2016',150,'14/08/2016','Pago',150,'14/08/2016','DENISE X',NULL,93,0,0,300,'2 vezes',6,46),(50,'14/07/2016','Pago',50,'14/07/2016',150,'14/08/2016','Pendente',0,'Pendente','DENISE X',NULL,93,50,0,50,'À vista',7,47),(300,'14/07/2016','Pago',300,'14/08/2016',150,'14/08/2016','Pendente',0,'Pendente','DENISE X',NULL,93,0,0,300,'À vista',8,48);
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `roupa` VALUES ('CALÇA','CALÇA (SKINNY)','M','MASCULINO','ROSA',0,50,17),('GRAVATA','CALÇA (SKINNY)','GG','MASCULINO','AMARELO',1,333,18),('SAPATO','VESTIDO (CURTO)','G','INFANTIL','VERMELHO',0,111,19);
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roupalixeira` (
  `codRoupaLixe` int(6) NOT NULL AUTO_INCREMENT,
  `codRoupa` int(6) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `tamanho` varchar(20) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `cor` varchar(20) NOT NULL,
  `disponibilidade` tinyint(1) NOT NULL,
  `preco` float NOT NULL,
  PRIMARY KEY (`codRoupaLixe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
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
