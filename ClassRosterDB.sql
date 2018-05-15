CREATE DATABASE ClassRoster;

USE ClassRoster;

CREATE TABLE Student (
StudentId varChar(5) PRIMARY KEY UNIQUE NOT NULL,
FirstName varChar(20) NOT NULL,
LastName varChar(20) NOT NULL,
Cohort varChar(20) NOT NULL
);