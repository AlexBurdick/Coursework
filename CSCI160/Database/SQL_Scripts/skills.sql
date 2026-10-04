USE classicmodels
DROP TABLE IF EXISTS skills;
CREATE TABLE skills ( 
	skillID				INT PRIMARY KEY AUTO_INCREMENT,
	skillName			VARCHAR(50) NOT NULL,
	skillDescription	TINYTEXT
);

INSERT INTO skills (skillName, skillDescription) VALUES ("Project Management", "Can be trusted to manage large projects");
INSERT INTO skills (skillName, skillDescription) VALUES ("PC Repair", "Can perform basic PC repair, maintenance and config");
INSERT INTO skills (skillName, skillDescription) VALUES ("Network Technician", "Can pull cable and confgure routers");
INSERT INTO skills (skillName, skillDescription) VALUES ("Scrum", "Experience with the SCRUM methodology");
INSERT INTO skills (skillName, skillDescription) VALUES ("CPR", "Able to provide emergency help to coworkers");