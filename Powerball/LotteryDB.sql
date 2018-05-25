drop database Tickets;

create database Powerball;

USE  Powerball;
DROP DATABASE Powerball;

CREATE DATABASE Powerball;

USE Powerball;


CREATE TABLE Ticket (
TicketId int PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
FirstName varChar(20) NOT NULL,
LastName varChar(20) NOT NULL,
Email varChar(40) NOT NULL,
State varChar(5) NOT NULL,
TicketStatus varChar(15) NOT NULL DEFAULT "active",
PurchaseTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
NumberOne int NOT NULL,
NumberTwo int NOT NULL,
NumberThree int NOT NULL,
NumberFour int NOT NULL,
NumberFive int NOT NULL,
PowerballNumber int NOT NULL

);

CREATE TABLE Powerball (
DrawTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
NumberOne int NOT NULL,
NumberTwo int NOT NULL,
NumberThree int NOT NULL,
NumberFour int NOT NULL,
NumberFive int NOT NULL,
PowerballNumber int NOT NULL
);

SELECT * FROM Ticket;