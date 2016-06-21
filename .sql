
CREATE DATABASE /*!32312 IF NOT EXISTS*/ `loja` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `loja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluguel` (
  `codAluguel` int(6) NOT NULL AUTO_INCREMENT,
  `codCliente` int(6) NOT NULL,
  `dataLoca` varchar(15) NOT NULL,
  `dataDevo` varchar(15) NOT NULL,
  `preco` float NOT NULL,
  `precoFinal` float NOT NULL,
  `funcionario` varchar(20) NOT NULL,
  `pagamento` varchar(15) NOT NULL,
  PRIMARY KEY (`codAluguel`),
  UNIQUE KEY `codCliente` (`codCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `aluguel` VALUES (3,55,'20/06/2016','25/06/2016',62,70,'joaopedro','2 vezes');
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `aluguellixeira` VALUES (46,'11/11/1111','22/22/2222',180,150,'123','À vista',1,2),(51,'__/__/____','11/11/1111',60,111,'aabb','À vista',2,4),(53,'11/11/1111','22/22/2222',12,222,'123','À vista',3,3),(50,'12/33/3111','11/11/1111',220,200,'123','À vista',4,1),(52,'11/11/1111','11/11/1111',180,222,'123','À vista',5,5),(53,'11/11/1111','11/11/1111',80,222,'123','À vista',6,6),(52,'11/11/1111','22/22/2222',220,222,'123','À vista',7,7),(50,'11/11/1111','11/11/1111',80,111,'aabb','À vista',8,8),(50,'11/11/1111','11/11/1111',130,111,'aabb','  À vista',9,8),(46,'11/11/1111','22/22/2222',80,222,'123','À vista',10,9),(50,'11/11/1111','11/11/1111',130,111,'','  À vista',11,10),(46,'11/11/1111','22/22/2222',200,111,'','  À vista',12,11),(53,'20/06/2016','25/06/2016',50,50,'','À vista',13,1),(53,'20/06/2016','27/05/2016',230,200,'','  À vista',14,2),(51,'20/06/2016','20/08/2016',110,100,'root','À vista',15,4);
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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `cliente` VALUES ('Andson','123.444.555-66','234433','(87)9922-3322','rua','centro','petro','pern','88',46,0),('junior','123.555.599-00','22323232','(87)9992-2323','rua frei domingos','quadra 02','petrolandia','pernambuco','48',47,0),('fulano','222.222.222-22','sdsds','(22)2222-2222','rua tal','aquele la','pa','bh','22',49,0),('coisinha','333.333.333-33','2121','(11)1111-1111','rua tal','op','recife','pe','22',50,0),('joao','111.000.111-00','12123','(22)1111-1111','rua','centro','petrolandia','pernambuco','33',51,0),('airton','222.333.222-33','212121','(12)1212-1212','rua qualquer','btn','paulo afonso','bahia','666',52,0),('davi','111.000.001-11','224433','(12)1212-1212','avenida','centro','paulo afonso','bahia','333',53,0),('Jean michel','999.999.999-99','555555555','(75)3282-3220',' rua kkkkkk','centro','Paulo afonso','bahia','88',54,0),('DENISE XAVIER ','898.899.889-89','989809809890098','(54)5454-5454','RUA OSVALDO CRUZ,','CENTRO','PAULO AFONSO','BA','41',55,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `clientelixeira` VALUES (1,48,'andsonj13','123.232.323-33','3232','pern','petro','centro','rua','31','(32)3999-1111',0),(2,25,'joseph','232.344.423-23','sdsdsd','sdssds','sdsdsd','ssdsd','sdss','323','(23)2323-23232',0);
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
INSERT INTO `funcionario` VALUES (29,'sasss','221.111.111-11','asasa','(11)1111-1111','sasa','asas','asas','sasa','asas','joaopedro','root');
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `listafinal` VALUES (10,49,9,'SAIA','RODADA','4','forro','laranja',0,500),(11,49,9,'SAIA','RODADA','4','forro','laranja',0,500),(16,55,9,'SAIA','RODADA','4','forro','laranja',0,50),(17,55,8,'meia','cano alto','p','masculina','azul',0,12);
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `listafinallixeira` VALUES (1,46,14,'camisa','social','p','feminina','branca','0',100),(2,51,10,'calcinha','preta','a mocada','e so o','file','0',10),(3,53,8,'meia','cano alto','p','masculina','azul','0',12),(4,50,11,'casaco','sem capuz','p','feminino','rosa','0',120),(5,52,2,'casaco','capuz','gg','masculino','preto','0',180),(6,53,13,'camisa','polo','m','feminina','preta','0',80),(7,52,15,'camisa','social','m','masculino','branca','0',100),(8,50,12,'camisa','polo','g','masculino','verde','0',80),(9,50,9,'SAIA','RODADA','4','forro','laranja','0',50),(10,46,13,'camisa','polo','m','feminina','preta','0',80),(11,50,9,'SAIA','RODADA','4','forro','laranja','0',50),(12,46,11,'casaco','sem capuz','p','feminino','rosa','0',120),(13,53,16,'terno','smoke','M','masculino','preto','0',50),(14,53,12,'camisa','polo','g','masculino','verde','0',80),(15,51,15,'camisa','social','m','masculino','branca','0',100);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `roupa` VALUES ('casaco','capuz','gg','masculino','preto',0,180,2),('sapato','social','41','masculino','preto',0,100,7),('meia','cano alto','p','masculina','azul',1,12,8),('SAIA','RODADA','4','forro','laranja',1,50,9),('calcinha','preta','a mocada','e so o','file',0,10,10),('casaco','sem capuz','p','feminino','rosa',0,120,11),('camisa','polo','g','masculino','verde',0,80,12),('camisa','polo','p','feminina','preta',0,80,13),('camisa','social','p','feminina','branca',0,100,14),('camisa','social','m','masculino','branca',0,100,15),('terno','smoke','M','masculino','preto',0,50,16);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `roupalixeira` VALUES (1,4,'cal?ºa','jeans','asdas','assd','asdas',0,22);
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
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
