DROP DATABASE IF EXISTS creature_demo;
CREATE DATABASE creature_demo;
USE creature_demo;

DROP TABLE IF EXISTS creature;
CREATE TABLE creature (
	creatureId          INTEGER      PRIMARY KEY,
	creatureName        VARCHAR(30),
	creatureType        VARCHAR(20),
	creatureResideTown  VARCHAR(20)
)ENGINE=InnoDB;
