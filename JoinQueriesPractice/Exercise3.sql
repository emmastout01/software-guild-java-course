/*
	Get all the order information for any order where Chai was sold.
*/

USE Northwind;

SELECT * 
FROM Order_Details od
INNER JOIN Products p ON p.ProductID = od.ProductID
WHERE p.ProductName = 'Chai';
