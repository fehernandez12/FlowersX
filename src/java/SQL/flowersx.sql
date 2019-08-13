-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-07-2019 a las 15:48:27
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `flowersx`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `novedad`
--

CREATE TABLE `novedad` (
  `idNovedad` int(5) NOT NULL,
  `descripcion` text NOT NULL,
  `fecha` date NOT NULL,
  `Pedido_idPedido` int(5) NOT NULL,
  `Usuario_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenproduccion`
--

CREATE TABLE `ordenproduccion` (
  `idOrdenProduccion` int(5) NOT NULL,
  `fechainicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `Pedido_idPedido` int(5) NOT NULL,
  `Usuario_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `idPago` int(5) NOT NULL,
  `medioDePago` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `codigoDeSeguridad` varchar(45) NOT NULL,
  `fechaDeVencimiento` date NOT NULL,
  `numeroDeruta` varchar(45) NOT NULL,
  `Novedad_idNovedad` int(5) NOT NULL,
  `Pedido_idPedido` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `idPedido` int(5) NOT NULL,
  `descipcionArreglo` text NOT NULL,
  `cantidad` int(10) NOT NULL,
  `fechaDeCreacion` date NOT NULL,
  `fechaDeEntrega` date NOT NULL,
  `direccionDeEnvio` text NOT NULL,
  `monto` int(10) NOT NULL,
  `Usuario_id` int(5) NOT NULL,
  `producto_idProducto` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

CREATE TABLE `permisos` (
  `idpermisos` int(5) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `nombre_en` varchar(45) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `icon` varchar(45) DEFAULT NULL,
  `permiso_padre` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `permisos`
--

INSERT INTO `permisos` (`idpermisos`, `nombre`, `nombre_en`, `url`, `icon`, `permiso_padre`) VALUES
(1, 'Usuarios', 'Users', NULL, NULL, NULL),
(2, 'Solicitudes', 'Requests', NULL, NULL, NULL),
(3, 'Producción', 'Production', NULL, NULL, NULL),
(4, 'Catálogo', 'Catalog', NULL, NULL, NULL),
(5, 'Crear Usuario', 'Create user', 'Admin/crear-usuario.xhtml', 'x', 1),
(6, 'Gestionar Usuarios', 'Manage users', 'Admin/gestionar-usuarios.xhtml', 'x', 1),
(7, 'Crear Solicitud', 'Create request', 'Admin/crear-solicitud.xhtml', 'x', 2),
(8, 'Gestionar Solicitudes', 'Manage requests', 'Admin/gestionar-solicitudes.xhtml', 'x', 2),
(9, 'Consultar órdenes de producción', 'Search production orders', 'Admin/gestionar-ordenProduccion-admin.xhtml', 'x', 3),
(10, 'Crear Novedad', 'Create novelty', 'Admin/crear-novedad.xhtml', 'x', 3),
(11, 'Gestionar Novedades', 'Manage novelties', 'Admin/gestionar-novedades.xhtml', 'x', 3),
(12, 'Crear item de catálogo', 'Create catalog item', 'Admin/crear-catalogo.xhtml', 'x', 4),
(13, 'Gestionar Catálogo', 'Manage catalog', 'Admin/gestionar-catalogo.xhtml', 'x', 4),
(14, 'Nueva orden de producción', 'Create production order', 'Ingeniero/crear-ordenProduccion.xhtml', 'x', 3),
(15, 'Gestionar órdenes de producción', 'Manage production orders', 'Ingeniero/gestionar-ordenProduccion.xhtml', 'x', 3),
(16, 'Consultar pedidos', 'Search sales orders', 'Ingeniero/gestionar-pedido-ingeniero.xhtml', 'x', 3),
(17, 'Ventas', 'Sales', '', '', NULL),
(18, 'Nuevo pedido', 'New sales order', 'Vendedor/crear-pedido-vendedor.xhtml', 'x', 17),
(19, 'Consultar pedidos', 'Search sales orders', 'Vendedor/gestionar-pedido-vendedor.xhtml', 'x', 17),
(20, 'Pagos', 'Payments', NULL, NULL, NULL),
(21, 'Registrar método de pago', 'Add payment method', 'Cliente/crear-pago.xhtml', 'x', 20),
(22, 'Gestionar métodos de pago', 'Manage payment methods', 'Cliente/gestionar-pago.xhtml', 'x', 20),
(23, 'Comprar', 'Buy', NULL, NULL, NULL),
(24, 'Nuevo pedido', 'New order', 'Cliente/crear-pedido.xhtml', 'x', 23),
(25, 'Consultar pedidos', 'Search orders', 'Cliente/gestionar-pedido.xhtml', 'x', 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(5) NOT NULL,
  `nombreProducto` varchar(45) NOT NULL,
  `estado` text NOT NULL,
  `foto` text NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `tiempoDeCultivo` varchar(45) NOT NULL,
  `existencias` int(10) NOT NULL,
  `precio` int(10) NOT NULL,
  `OrdenProduccion_idOrdenProduccion` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` int(5) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `nombre`, `name`) VALUES
(1, 'Administrador', 'Administrator'),
(2, 'Supervisor de siembra', 'Seeds Supervisor'),
(3, 'Ingeniero de siembra', 'Planting Engineer'),
(4, 'Vendedor', 'Seller'),
(5, 'Cliente', 'Customer');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol_has_permisos`
--

CREATE TABLE `rol_has_permisos` (
  `Rol_idRol` int(5) NOT NULL,
  `permisos_idpermisos` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol_has_permisos`
--

INSERT INTO `rol_has_permisos` (`Rol_idRol`, `permisos_idpermisos`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(2, 2),
(2, 3),
(2, 7),
(2, 8),
(2, 9),
(2, 10),
(2, 11),
(3, 3),
(3, 14),
(3, 15),
(3, 16),
(4, 17),
(4, 18),
(4, 19),
(5, 20),
(5, 21),
(5, 22),
(5, 23),
(5, 24),
(5, 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

CREATE TABLE `solicitud` (
  `idSolicitud` int(5) NOT NULL,
  `fecha` date NOT NULL,
  `destinatario` varchar(45) NOT NULL,
  `Pedido_idPedido` int(5) NOT NULL,
  `Usuario_id` int(5) NOT NULL,
  `soporte1` text NOT NULL,
  `soporte2` text,
  `soporte3` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(5) NOT NULL,
  `titular` varchar(45) NOT NULL,
  `razonSocial` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `pais` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `estado` int(11) NOT NULL,
  `Rol_idRol` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `titular`, `razonSocial`, `email`, `pais`, `ciudad`, `password`, `estado`, `Rol_idRol`) VALUES
(1, 'Felipe Hernández', 'FlowersX', 'feehernandezba@gmail.com', 'Colombia', 'Bogotá D.C.', '123456789', 1, 1),
(2, 'Juan Pablo Rodríguez', 'FlowersX', 'jprodriguez744@misena.edu.co', 'Colombia', 'Bogotá D.C.', '123456789', 1, 1),
(3, 'Jerson Chitán', 'FlowersX', 'jachitan@misena.edu.co', 'Colombia', 'Bogotá D.C.', '123456789', 1, 1),
(4, 'Shirley Bernal', 'Walmart Inc.', 'shirley@walmart.com', 'Estados Unidos', 'New York', '123456789', 1, 5),
(5, 'José Barrios', 'FlowersX', 'josebarrios1@gmail.com', 'Colombia', 'Bogotá', '123456789', 1, 2),
(6, 'Santiago Ruiz', 'Target Inc.', 'sruiz98@target.com', 'Estados Unidos', 'New York', '123456789', 1, 5),
(7, 'Santiago Reyes', 'FlowersX', 'sreyes98@gmail.com', 'Colombia', 'FlowersX', '123456789', 1, 4),
(8, 'Jimmy Pulido', 'FlowersX', 'japulido98@gmail.com', 'Colombia', 'Bogotá D.C.', '123456789', 2, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `novedad`
--
ALTER TABLE `novedad`
  ADD PRIMARY KEY (`idNovedad`),
  ADD KEY `fk_Novedad_Pedido1_idx` (`Pedido_idPedido`),
  ADD KEY `fk_Novedad_Usuario1_idx` (`Usuario_id`);

--
-- Indices de la tabla `ordenproduccion`
--
ALTER TABLE `ordenproduccion`
  ADD PRIMARY KEY (`idOrdenProduccion`),
  ADD KEY `fk_OrdenDeProduccion_Pedido1_idx` (`Pedido_idPedido`),
  ADD KEY `fk_OrdenDeProduccion_Usuario1_idx` (`Usuario_id`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`idPago`),
  ADD KEY `fk_Pago_Novedad1_idx` (`Novedad_idNovedad`),
  ADD KEY `fk_Pago_Pedido1_idx` (`Pedido_idPedido`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `fk_Pedido_Usuario1_idx` (`Usuario_id`),
  ADD KEY `fk_pedido_producto1_idx` (`producto_idProducto`);

--
-- Indices de la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD PRIMARY KEY (`idpermisos`),
  ADD KEY `fk_permiso_padre` (`permiso_padre`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `fk_Producto_OrdenDeProduccion1_idx` (`OrdenProduccion_idOrdenProduccion`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `rol_has_permisos`
--
ALTER TABLE `rol_has_permisos`
  ADD PRIMARY KEY (`Rol_idRol`,`permisos_idpermisos`),
  ADD KEY `fk_Rol_has_permisos_permisos1_idx` (`permisos_idpermisos`),
  ADD KEY `fk_Rol_has_permisos_Rol1_idx` (`Rol_idRol`);

--
-- Indices de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD PRIMARY KEY (`idSolicitud`),
  ADD KEY `fk_Solicitud_Pedido1_idx` (`Pedido_idPedido`),
  ADD KEY `fk_Solicitud_Usuario1_idx` (`Usuario_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Usuario_Rol1_idx` (`Rol_idRol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `novedad`
--
ALTER TABLE `novedad`
  MODIFY `idNovedad` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ordenproduccion`
--
ALTER TABLE `ordenproduccion`
  MODIFY `idOrdenProduccion` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `idPago` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idPedido` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idRol` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  MODIFY `idSolicitud` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `novedad`
--
ALTER TABLE `novedad`
  ADD CONSTRAINT `fk_Novedad_Pedido1` FOREIGN KEY (`Pedido_idPedido`) REFERENCES `pedido` (`idPedido`),
  ADD CONSTRAINT `fk_Novedad_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `ordenproduccion`
--
ALTER TABLE `ordenproduccion`
  ADD CONSTRAINT `fk_OrdenDeProduccion_Pedido1` FOREIGN KEY (`Pedido_idPedido`) REFERENCES `pedido` (`idPedido`),
  ADD CONSTRAINT `fk_OrdenDeProduccion_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `fk_Pago_Novedad1` FOREIGN KEY (`Novedad_idNovedad`) REFERENCES `novedad` (`idNovedad`),
  ADD CONSTRAINT `fk_Pago_Pedido1` FOREIGN KEY (`Pedido_idPedido`) REFERENCES `pedido` (`idPedido`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_Pedido_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `fk_pedido_producto1` FOREIGN KEY (`producto_idProducto`) REFERENCES `producto` (`idProducto`);

--
-- Filtros para la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD CONSTRAINT `fk_permiso_padre` FOREIGN KEY (`permiso_padre`) REFERENCES `permisos` (`idpermisos`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_Producto_OrdenDeProduccion1` FOREIGN KEY (`OrdenProduccion_idOrdenProduccion`) REFERENCES `ordenproduccion` (`idOrdenProduccion`);

--
-- Filtros para la tabla `rol_has_permisos`
--
ALTER TABLE `rol_has_permisos`
  ADD CONSTRAINT `fk_Rol_has_permisos_Rol1` FOREIGN KEY (`Rol_idRol`) REFERENCES `rol` (`idRol`),
  ADD CONSTRAINT `fk_Rol_has_permisos_permisos1` FOREIGN KEY (`permisos_idpermisos`) REFERENCES `permisos` (`idpermisos`);

--
-- Filtros para la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD CONSTRAINT `fk_Solicitud_Pedido1` FOREIGN KEY (`Pedido_idPedido`) REFERENCES `pedido` (`idPedido`),
  ADD CONSTRAINT `fk_Solicitud_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_Usuario_Rol1` FOREIGN KEY (`Rol_idRol`) REFERENCES `rol` (`idRol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;