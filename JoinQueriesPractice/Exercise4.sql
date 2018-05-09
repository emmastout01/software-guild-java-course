/*
	Write a query to show every combination of employee and location.
*/

USE SWCCorp;

SELECT * 
from Employee
cross join Location;