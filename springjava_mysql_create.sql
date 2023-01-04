

CREATE DATABASE IF NOT EXISTS `spring5` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `spring5`;

CREATE TABLE `personas` (
	`nombre` varchar(25) NOT NULL,
	`apellidos` varchar(25) NOT NULL,
	`edad` INT NOT NULL
);

CREATE TABLE `examenes` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`asignatura` varchar(25) NOT NULL AUTO_INCREMENT,
	`nombre_persona` varchar(25) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `examenes` ADD CONSTRAINT `examenes_fk0` FOREIGN KEY (`nombre_persona`) REFERENCES `personas`(`nombre`);



