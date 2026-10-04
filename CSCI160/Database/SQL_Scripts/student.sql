
DROP DATABASE IF EXISTS student; -- conditionally drop database
CREATE DATABASE student;
USE student;

CREATE TABLE Student (
    StudentID 		INT PRIMARY KEY AUTO_INCREMENT, 
    FirstName 		VARCHAR(50),
    LastName 		VARCHAR(50), 
    DateOfBirth 	DATE,
    EnrollmentDate DATE 
);

CREATE TABLE Course (
    CourseID 		INT AUTO_INCREMENT PRIMARY KEY,
    CourseName 	VARCHAR(100),
    Department 	VARCHAR(50), 
    Credits 			INT
);

INSERT INTO Student (FirstName, LastName, DateOfBirth, EnrollmentDate)
VALUES ('John', 'Doe', '2000-05-15', '2018-09-01');
INSERT INTO Student (FirstName, LastName, DateOfBirth, EnrollmentDate)
VALUES ('Jane', 'Smith', '1999-11-22', '2017-09-01');
INSERT INTO Student (FirstName, LastName, DateOfBirth, EnrollmentDate)
VALUES ('Robert', 'Johnson', '2001-01-30', '2019-09-01');
INSERT INTO Student (FirstName, LastName, DateOfBirth, EnrollmentDate)
VALUES ('Emily', 'Davis', '2002-07-19', '2020-09-01');
INSERT INTO Student (FirstName, LastName, DateOfBirth, EnrollmentDate)
VALUES ( 'Michael', 'Wilson', '1998-03-05', '2016-09-01');
INSERT INTO Student (FirstName, LastName, DateOfBirth, EnrollmentDate)
VALUES ('Sarah', 'Miller', '2000-12-14', '2018-09-01');
INSERT INTO Student (FirstName, LastName, DateOfBirth, EnrollmentDate)
VALUES ('David', 'Martinez', '1997-06-25', '2015-09-01');
INSERT INTO Student (FirstName, LastName, DateOfBirth, EnrollmentDate)
VALUES ('Sophia', 'Garcia', '2001-10-10', '2019-09-01');
INSERT INTO Student (FirstName, LastName, DateOfBirth, EnrollmentDate)
VALUES ('James', 'Brown', '1999-04-17', '2017-09-01');
INSERT INTO Student (FirstName, LastName, DateOfBirth, EnrollmentDate)
VALUES ('Olivia', 'Anderson', '2003-08-02', '2021-09-01');

-- COURSE INSERTS

INSERT INTO Course (CourseName, Department, Credits)
VALUES ('Introduction to Computer Science', 'Computer Science', 4);
INSERT INTO Course (CourseName, Department, Credits)
VALUES ('Calculus I', 'Mathematics', 3);
INSERT INTO Course (CourseName, Department, Credits)
VALUES ('General Chemistry', 'Chemistry', 4);
INSERT INTO Course (CourseName, Department, Credits)
VALUES ('Physics I', 'Physics', 4);
INSERT INTO Course (CourseName, Department, Credits)
VALUES ('World History', 'History', 3);
INSERT INTO Course (CourseName, Department, Credits)
VALUES ('Introduction to Psychology', 'Psychology', 3);
INSERT INTO Course (CourseName, Department, Credits)
VALUES ('Data Structures', 'Computer Science', 4);
INSERT INTO Course (CourseName, Department, Credits)
VALUES ('Microeconomics', 'Economics', 3);
INSERT INTO Course (CourseName, Department, Credits)
VALUES ('Art History', 'Art', 3);
INSERT INTO Course (CourseName, Department, Credits)
VALUES ('Environmental Science', 'Environmental Studies', 4);


