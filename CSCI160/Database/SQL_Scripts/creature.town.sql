
USE creature_demo;

DROP TABLE IF EXISTS town;
CREATE TABLE town (
	townId          INT,		-- primary key can be noted here or listed below
	townName        VARCHAR(20),
	State           VARCHAR(20),
	Country         VARCHAR(20),
	townNickname    VARCHAR(80),
	townMotto       VARCHAR(80),

	-- table constraints
	PRIMARY KEY (townID)
)ENGINE=InnoDB;

-- The NULL values below mean that the creatures DO NOT HAVE values for these fields
 INSERT INTO town VALUES (1, 'Philadelphia', 'PA', 'United States', 'Philly', 'Let brotherly love endure');
 INSERT INTO town VALUES (2, 'Anoka', 'MN', 'United States', 'Halloween Capital of the world', NULL);
 INSERT INTO town VALUES (3, 'Blue Earth', 'MN', 'United States', 'Beyond the Valley of the Jolly Green Giant', 'Earth so rich the city grows!');
 INSERT INTO town VALUES (4, 'Bemidji', 'MN', 'United States', 'B-town', 'The first city on the Mississippi');
 INSERT INTO town VALUES (5, 'Duluth', 'MN', 'United States', 'Zenith City', NULL);
 INSERT INTO town VALUES (6, 'Greenville', 'MS', 'United States', 'The Heart & Soul of the Delta', 'The Best Food, Shopping, & Entertainment In The South');
 INSERT INTO town VALUES (7, 'Tokyo', 'Kanto', 'Japan', NULL, NULL);
 INSERT INTO town VALUES (8, 'Asgard', NULL, NULL, 'Home of Odin''s vault', 'Where magic and science are one in the same');
 INSERT INTO town VALUES (9, 'The City', NULL, NULL, NULL, 'Americas most crime-ridden city');

-- COPY and modify creature CREATE TABLE statement here

-- COPY and modify creature INSERT INTO statements here