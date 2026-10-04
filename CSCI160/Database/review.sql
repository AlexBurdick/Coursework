DROP DATABASE IF EXISTS students;
CREATE DATABASE students;
USE students;


-- the college wants to start a mentor program
-- where students can mentor other students
CREATE TABLE student (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    first_name  VARCHAR(50),
    last_name   VARCHAR(50),
    gpa         DECIMAL(3, 2)
);

INSERT INTO student (first_name, last_name, gpa) VALUES ('John', 'Doe',         3.5);
INSERT INTO student (first_name, last_name, gpa) VALUES ('Jane', 'Smith',       3.8);
INSERT INTO student (first_name, last_name, gpa) VALUES ('Michael', 'Brown',    3.2);
INSERT INTO student (first_name, last_name, gpa) VALUES ('Emily', 'Johnson',    3.9);
INSERT INTO student (first_name, last_name, gpa) VALUES ('Chris', 'Lee',        2.7);
INSERT INTO student (first_name, last_name, gpa) VALUES ('Anna', 'Martinez',    3.6);
INSERT INTO student (first_name, last_name, gpa) VALUES ('David', 'Garcia',     3.4);
INSERT INTO student (first_name, last_name, gpa) VALUES ('Laura', 'Wilson',     3.7);
INSERT INTO student (first_name, last_name, gpa) VALUES ('Robert', 'Taylor',    2.9);
INSERT INTO student (first_name, last_name, gpa) VALUES ('Sarah', 'Anderson',   3.1);

-- student clubs
-- students can participate in multiple clubs
-- a club requires a student to be president
-- a club requires a faculty advisor
CREATE TABLE club (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    club_name   VARCHAR(100),
    descrip     TEXT
);

INSERT INTO club (club_name, descrip) VALUES ('Science Club', 'A club for students interested in science and technology.');
INSERT INTO club (club_name, descrip) VALUES ('Literature Society', 'A group dedicated to reading, discussing, and writing literature.');
INSERT INTO club (club_name, descrip) VALUES ('Art Club', 'A club for students to express their creativity through various forms of art.');
INSERT INTO club (club_name, descrip) VALUES ('Sports Club', 'An organization that promotes sports activities and competitions.');
INSERT INTO club (club_name, descrip) VALUES ('Music Club', 'A community for students to explore music, play instruments, and sing.');

-- table for faculty members
CREATE TABLE faculty (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    first_name  VARCHAR(50),
    last_name   VARCHAR(50),
    title       VARCHAR(100)
);

INSERT INTO faculty (first_name, last_name, title) VALUES ('John', 'Doe', 'Professor of Mathematics');
INSERT INTO faculty (first_name, last_name, title) VALUES ('Jane', 'Smith', 'Associate Professor of Biology');
INSERT INTO faculty (first_name, last_name, title) VALUES ('Michael', 'Johnson', 'Assistant Professor of History');
INSERT INTO faculty (first_name, last_name, title) VALUES ('Emily', 'Davis', 'Professor of Chemistry');
INSERT INTO faculty (first_name, last_name, title) VALUES ('Chris', 'Garcia', 'Lecturer in Computer Science');
INSERT INTO faculty (first_name, last_name, title) VALUES ('Anna', 'Martinez', 'Visiting Scholar in Literature');
INSERT INTO faculty (first_name, last_name, title) VALUES ('David', 'Wilson', 'Professor of Physics');
INSERT INTO faculty (first_name, last_name, title) VALUES ('Laura', 'Anderson', 'Senior Lecturer in Art History');
INSERT INTO faculty (first_name, last_name, title) VALUES ('Robert', 'Taylor', 'Associate Professor of Psychology');
INSERT INTO faculty (first_name, last_name, title) VALUES ('Sarah', 'Thomas', 'Assistant Professor of Sociology');


-- faculty committees
-- faculty are expected to participate in multiuple committees
-- a committee requires a faculty member to serve as chair
CREATE TABLE committee (
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    com_name            VARCHAR(100),
    task                TEXT,
    date_established    DATE
);

INSERT INTO committee (com_name, task, date_established) VALUES ('Safety Committee', 'Develop policies to ensure campus safety and emergency preparedness.', '2023-05-14');
INSERT INTO committee (com_name, task, date_established) VALUES ('Diversity and Inclusion Committee', 'Promote diversity and inclusion initiatives within the institution.', '2022-11-30');
INSERT INTO committee (com_name, task, date_established) VALUES ('Technology Committee', 'Evaluate and recommend new technologies for classroom and administrative use.', '2021-09-18');
INSERT INTO committee (com_name, task, date_established) VALUES ('Alumni Relations Committee', 'Enhance engagement with alumni and foster connections.', '2022-04-20');
INSERT INTO committee (com_name, task, date_established) VALUES ('Environmental Sustainability Committee', 'Develop and implement sustainability initiatives on campus.', '2023-01-25');

-- scholastic departments
-- a faculty member serves as department chair
-- other faculty members are only part of one department
-- a faculty member's supervisor is their department chair
CREATE TABLE department (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    dept_name   VARCHAR(100),
    descrip     TEXT
);

INSERT INTO department (dept_name, descrip) VALUES ('Computer Science', 'Department focused on computer science education and research.');
INSERT INTO department (dept_name, descrip) VALUES ('Biology', 'Department dedicated to the study of living organisms and life processes.');
INSERT INTO department (dept_name, descrip) VALUES ('Mathematics', 'Department specializing in the study of mathematical theories and applications.');
INSERT INTO department (dept_name, descrip) VALUES ('History', 'Department that explores historical events, cultures, and societies.');
INSERT INTO department (dept_name, descrip) VALUES ('Psychology', 'Department that studies the mind and behavior of individuals and groups.');


-- After all relationships have been established and data has been added, write queries for the following

-- What is the most popular club?
-- Who is the president of the Science Club
-- Show the roster for the Environmental Sustainability Committee
-- Who is faculty member John Doe's supervisor
-- Who is student John Doe's mentor