/*
	Get the Company Name, Order Date, and each order details 
	Product name for USA customers only.
*/

USE Northwind;

SELECT CompanyName, OrderDate, ProductName
from Customers c 
inner join Orders o on o.CustomerID = c.CustomerID
inner join Order_Details od on od.OrderID = o.OrderID
inner join Products p on p.ProductID = od.ProductID
where c.Country = "USA";

