-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.21-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para smarthome
CREATE DATABASE IF NOT EXISTS `smarthome` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `smarthome`;

-- Volcando estructura para tabla smarthome.consolidado_mes
CREATE TABLE IF NOT EXISTS `consolidado_mes` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `numMes` int(11) NOT NULL DEFAULT '0',
  `Anio` varchar(50) NOT NULL DEFAULT '0',
  `MontoTotal` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla smarthome.consolidado_mes: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `consolidado_mes` DISABLE KEYS */;
INSERT INTO `consolidado_mes` (`pk_id`, `numMes`, `Anio`, `MontoTotal`) VALUES
	(2, 1, '2017', 1700.00),
	(3, 4, '2017', 1700.00);
/*!40000 ALTER TABLE `consolidado_mes` ENABLE KEYS */;

-- Volcando estructura para tabla smarthome.grupo
CREATE TABLE IF NOT EXISTS `grupo` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `descripcion` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla smarthome.grupo: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` (`pk_id`, `nombre`, `descripcion`) VALUES
	(1, 'admin', 'Administrador del sistema'),
	(2, 'miembro_familia', '');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;

-- Volcando estructura para tabla smarthome.grupo_usuario
CREATE TABLE IF NOT EXISTS `grupo_usuario` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_usuario` int(11) NOT NULL DEFAULT '0',
  `fk_grupo` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pk_id`),
  KEY `FK__usuario` (`fk_usuario`),
  KEY `FK__grupo` (`fk_grupo`),
  CONSTRAINT `FK__grupo` FOREIGN KEY (`fk_grupo`) REFERENCES `grupo` (`pk_id`),
  CONSTRAINT `FK__usuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla smarthome.grupo_usuario: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `grupo_usuario` DISABLE KEYS */;
INSERT INTO `grupo_usuario` (`pk_id`, `fk_usuario`, `fk_grupo`) VALUES
	(1, 2, 1),
	(3, 2, 2);
/*!40000 ALTER TABLE `grupo_usuario` ENABLE KEYS */;

-- Volcando estructura para tabla smarthome.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `ape_pat` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla smarthome.persona: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`pk_id`, `ape_pat`) VALUES
	(1, 'ZAVALETA'),
	(2, 'CAMPOS'),
	(3, 'ZAVALETA'),
	(4, 'JARA'),
	(5, 'DIAS'),
	(6, 'ZAVALETA'),
	(7, 'LOPEZ'),
	(8, 'CAMPOS');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

-- Volcando estructura para tabla smarthome.recibo
CREATE TABLE IF NOT EXISTS `recibo` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_servicio` int(11) NOT NULL DEFAULT '0',
  `Monto` decimal(10,2) NOT NULL DEFAULT '0.00',
  `NumMes` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pk_id`),
  KEY `FK_recibo_servicio` (`fk_servicio`),
  CONSTRAINT `FK_recibo_servicio` FOREIGN KEY (`fk_servicio`) REFERENCES `servicio` (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla smarthome.recibo: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `recibo` DISABLE KEYS */;
INSERT INTO `recibo` (`pk_id`, `fk_servicio`, `Monto`, `NumMes`) VALUES
	(1, 1, 100.00, 1),
	(2, 1, 120.00, 2),
	(3, 1, 115.25, 3),
	(4, 2, 200.00, 1),
	(5, 2, 500.00, 2),
	(6, 2, 400.00, 3),
	(7, 3, 1500.00, 1),
	(8, 1, 200.00, 1),
	(9, 1, 5000.00, 4),
	(10, 3, 1700.00, 4);
/*!40000 ALTER TABLE `recibo` ENABLE KEYS */;

-- Volcando estructura para tabla smarthome.servicio
CREATE TABLE IF NOT EXISTS `servicio` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_tipo_servicio` int(11) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `fecCreacion` datetime DEFAULT NULL,
  `estado` int(1) DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  KEY `FK__tipo_servicio` (`fk_tipo_servicio`),
  CONSTRAINT `FK__tipo_servicio` FOREIGN KEY (`fk_tipo_servicio`) REFERENCES `tipo_servicio` (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla smarthome.servicio: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` (`pk_id`, `fk_tipo_servicio`, `descripcion`, `fecCreacion`, `estado`) VALUES
	(1, 2, 'AGUA POTABLE', '2017-04-11 17:47:28', 1),
	(2, 2, 'ELECTRICIDAD', '2017-04-11 17:47:28', 1),
	(3, 1, 'TV DIGITAL', '2017-04-11 17:47:28', 1),
	(4, 1, '21 SETPTIEMBRE', '2017-09-21 21:16:05', 1),
	(5, 2, '121', '2017-09-21 21:18:54', 1),
	(6, 1, '2222', '2017-09-21 21:37:09', 1);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;

-- Volcando estructura para tabla smarthome.tipo_servicio
CREATE TABLE IF NOT EXISTS `tipo_servicio` (
  `pk_id` int(11) NOT NULL,
  `descripcion` char(50) DEFAULT NULL,
  `estado` int(1) DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla smarthome.tipo_servicio: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_servicio` DISABLE KEYS */;
INSERT INTO `tipo_servicio` (`pk_id`, `descripcion`, `estado`) VALUES
	(1, 'USO BASICO', 1),
	(2, 'SERVICIOS GENERALES', 1);
/*!40000 ALTER TABLE `tipo_servicio` ENABLE KEYS */;

-- Volcando estructura para tabla smarthome.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL DEFAULT '0',
  `clave` varchar(200) NOT NULL DEFAULT '0',
  `nombres` varchar(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla smarthome.usuario: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`pk_id`, `username`, `clave`, `nombres`) VALUES
	(1, 'sysadmin', '123456', 'administrador del sistema'),
	(2, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Daniel');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para vista smarthome.vista_usuarios
-- Creando tabla temporal para superar errores de dependencia de VIEW
CREATE TABLE `vista_usuarios` (
	`username` VARCHAR(25) NOT NULL COLLATE 'utf8_general_ci',
	`clave` VARCHAR(200) NOT NULL COLLATE 'utf8_general_ci',
	`perfil` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci'
) ENGINE=MyISAM;

-- Volcando estructura para disparador smarthome.inserta_usuario
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `inserta_usuario` BEFORE INSERT ON `usuario` FOR EACH ROW begin
set new.clave = SHA2(new.clave,256);
end//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador smarthome.recibo_after_insert
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `recibo_after_insert` AFTER INSERT ON `recibo` FOR EACH ROW BEGIN
declare montoInsertando_ decimal(10,2);
declare mes_insertar tinyint;

set montoInsertando_ = new.Monto;
set mes_insertar = new.NumMes;

update consolidado_mes set consolidado_mes.MontoTotal=consolidado_mes.MontoTotal+montoInsertando_ where consolidado_mes.pk_id>0 and consolidado_mes.numMes=mes_insertar;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para vista smarthome.vista_usuarios
-- Eliminando tabla temporal y crear estructura final de VIEW
DROP TABLE IF EXISTS `vista_usuarios`;
CREATE ALGORITHM=UNDEFINED  VIEW `vista_usuarios` AS select u.username,u.clave,g.nombre as perfil 
from usuario u inner join grupo_usuario gu on
gu.fk_usuario=u.pk_id inner join grupo g on gu.fk_grupo=g.pk_id ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
