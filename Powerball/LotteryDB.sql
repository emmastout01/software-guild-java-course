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
PickType varChar(20) NOT NULL DEFAULT "QuickPick",
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



INSERT INTO Ticket (FirstName, LastName, Email, State, 
                NumberOne, NumberTwo, NumberThree, NumberFour, NumberFive, 
				PowerballNumber ) 
                VALUES ("Hello", "World", "test@tsg.com", "MN", 1, 2, 3, 4, 5, 6);
SELECT LAST_INSERT_ID();

SELECT * FROM Ticket;

SET SQL_SAFE_UPDATES = 0;
UPDATE Ticket SET TicketStatus = "active";
SET SQL_SAFE_UPDATES = 1;

SELECT * FROM Ticket WHERE
                ("" = "" or TicketId LIKE "")
                AND ("" = "Emma" or FirstName LIKE "Emma")
                AND ("" = "" or LastName LIKE "")
                AND ("" = "" or Email LIKE "")
                AND ("" = "" or State LIKE "")
                AND ("" = "" or TicketStatus LIKE "")
                AND ("" = "" or PickType LIKE "");