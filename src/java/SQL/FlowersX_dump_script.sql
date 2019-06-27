-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: flowerx
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `catalogo`
--

DROP TABLE IF EXISTS `catalogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `catalogo` (
  `idCatalogo` int(5) NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `tiempoDeCultivo` varchar(45) NOT NULL,
  PRIMARY KEY (`idCatalogo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogo`
--

LOCK TABLES `catalogo` WRITE;
/*!40000 ALTER TABLE `catalogo` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `novedad`
--

DROP TABLE IF EXISTS `novedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `novedad` (
  `idNovedad` int(5) NOT NULL AUTO_INCREMENT,
  `descripcion` text NOT NULL,
  `fecha` date NOT NULL,
  `Pedido_idPedido` int(5) NOT NULL,
  `Usuario_id` int(5) NOT NULL,
  PRIMARY KEY (`idNovedad`),
  KEY `fk_Novedad_Pedido1_idx` (`Pedido_idPedido`),
  KEY `fk_Novedad_Usuario1_idx` (`Usuario_id`),
  CONSTRAINT `fk_Novedad_Pedido1` FOREIGN KEY (`Pedido_idPedido`) REFERENCES `pedido` (`idPedido`),
  CONSTRAINT `fk_Novedad_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `novedad`
--

LOCK TABLES `novedad` WRITE;
/*!40000 ALTER TABLE `novedad` DISABLE KEYS */;
/*!40000 ALTER TABLE `novedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordendeproduccion`
--

DROP TABLE IF EXISTS `ordendeproduccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ordendeproduccion` (
  `idOrdenDeProduccion` int(5) NOT NULL AUTO_INCREMENT,
  `descipcionArreglo` text NOT NULL,
  `cantidad` int(10) NOT NULL,
  `estado` text NOT NULL,
  `fechainicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `Pedido_idPedido` int(5) NOT NULL,
  `Usuario_id` int(5) NOT NULL,
  PRIMARY KEY (`idOrdenDeProduccion`),
  KEY `fk_OrdenDeProduccion_Pedido1_idx` (`Pedido_idPedido`),
  KEY `fk_OrdenDeProduccion_Usuario1_idx` (`Usuario_id`),
  CONSTRAINT `fk_OrdenDeProduccion_Pedido1` FOREIGN KEY (`Pedido_idPedido`) REFERENCES `pedido` (`idPedido`),
  CONSTRAINT `fk_OrdenDeProduccion_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordendeproduccion`
--

LOCK TABLES `ordendeproduccion` WRITE;
/*!40000 ALTER TABLE `ordendeproduccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordendeproduccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pago` (
  `idPago` int(5) NOT NULL AUTO_INCREMENT,
  `medioDePago` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `codigoDeSeguridad` varchar(45) NOT NULL,
  `fechaDeVencimiento` date NOT NULL,
  `numeroDeruta` varchar(45) NOT NULL,
  `Novedad_idNovedad` int(5) NOT NULL,
  `Pedido_idPedido` int(5) NOT NULL,
  PRIMARY KEY (`idPago`),
  KEY `fk_Pago_Novedad1_idx` (`Novedad_idNovedad`),
  KEY `fk_Pago_Pedido1_idx` (`Pedido_idPedido`),
  CONSTRAINT `fk_Pago_Novedad1` FOREIGN KEY (`Novedad_idNovedad`) REFERENCES `novedad` (`idNovedad`),
  CONSTRAINT `fk_Pago_Pedido1` FOREIGN KEY (`Pedido_idPedido`) REFERENCES `pedido` (`idPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pedido` (
  `idPedido` int(5) NOT NULL AUTO_INCREMENT,
  `fechaDeCreacion` date NOT NULL,
  `fechaDeEnvio` date NOT NULL,
  `direccionDeEnvio` text NOT NULL,
  `monto` int(10) NOT NULL,
  `Usuario_id` int(5) NOT NULL,
  PRIMARY KEY (`idPedido`),
  KEY `fk_Pedido_Usuario1_idx` (`Usuario_id`),
  CONSTRAINT `fk_Pedido_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `producto` (
  `idProducto` int(5) NOT NULL AUTO_INCREMENT,
  `producto` text NOT NULL,
  `descripcion` text NOT NULL,
  `precio` int(10) NOT NULL,
  `estado` text NOT NULL,
  `OrdenDeProduccion_idOrdenDeProduccion` int(5) NOT NULL,
  `Catalogo_idCatalogo` int(5) NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `fk_Producto_OrdenDeProduccion1_idx` (`OrdenDeProduccion_idOrdenDeProduccion`),
  KEY `fk_Producto_Catalogo1_idx` (`Catalogo_idCatalogo`),
  CONSTRAINT `fk_Producto_Catalogo1` FOREIGN KEY (`Catalogo_idCatalogo`) REFERENCES `catalogo` (`idCatalogo`),
  CONSTRAINT `fk_Producto_OrdenDeProduccion1` FOREIGN KEY (`OrdenDeProduccion_idOrdenDeProduccion`) REFERENCES `ordendeproduccion` (`idOrdenDeProduccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rol` (
  `idRol` int(5) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador'),(2,'Ingeniero de siembra'),(3,'Vendedor'),(4,'Cliente');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `solicitud` (
  `idSolicitud` int(5) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `contenido` text NOT NULL,
  `destinatario` varchar(45) NOT NULL,
  `Pedido_idPedido` int(5) NOT NULL,
  `Usuario_id` int(5) NOT NULL,
  PRIMARY KEY (`idSolicitud`),
  KEY `fk_Solicitud_Pedido1_idx` (`Pedido_idPedido`),
  KEY `fk_Solicitud_Usuario1_idx` (`Usuario_id`),
  CONSTRAINT `fk_Solicitud_Pedido1` FOREIGN KEY (`Pedido_idPedido`) REFERENCES `pedido` (`idPedido`),
  CONSTRAINT `fk_Solicitud_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud`
--

LOCK TABLES `solicitud` WRITE;
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `titular` varchar(45) NOT NULL,
  `razonSocial` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `pais` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `Rol_idRol` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Usuario_Rol_idx` (`Rol_idRol`),
  CONSTRAINT `fk_Usuario_Rol` FOREIGN KEY (`Rol_idRol`) REFERENCES `rol` (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-26 22:01:59


-- Triggers: Tabla usuario

DROP TRIGGER IF EXISTS `T_encriptar_contrasena`;
DELIMITER //
CREATE TRIGGER `T_encriptar_contrasena`
BEFORE CREATE ON usuario FOR EACH ROW
BEGIN
SET new.password := AES_ENCRYPT(new.password, 'flowersx');
END;
//

DROP TRIGGER IF EXISTS `T_desencriptar_contrasena`;
DELIMITER //
CREATE TRIGGER `T_desencriptar_contrasena`
BEFORE UPDATE ON usuario FOR EACH ROW
BEGIN
SET new.password := AES_DECRYPT(new.password, 'flowersx');
END;
//

DROP PROCEDURE IF EXISTS `P_encriptar_password`
DELIMITER //
CREATE PROCEDURE `P_encriptar_password`