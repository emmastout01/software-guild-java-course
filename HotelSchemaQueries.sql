-- Write a query that returns all the rooms reserved for a particular customer.
SELECT COUNT(*) as TotalRooms
FROM RoomInReservation rir
INNER JOIN Reservation r on rir.ReservationId = r.Id
INNER JOIN Customer c on c.Id = r.CustomerId
WHERE c.Id = 1;


-- Write a query that returns all the rooms available for a date range.
-- Something's wrong here. I can't figure out how to get the date range.
SELECT COUNT(*) as AllRoomsAvailable
FROM Room rm
INNER JOIN RoomInReservation rir on rm.Id = rir.RoomId
INNER JOIN Reservation r on rir.ReservationId = r.Id
WHERE r.CheckInDate > '2018-01-26'
AND r.CheckOutDate < '2018-06-03'
HAVING COUNT(rir.ReservationId) = 0;





-- COUNT(o.OrderID) AS TotalOrders
-- FROM Orders o 
-- INNER JOIN Order_Details od ON o.OrderID = od.OrderID        
-- INNER JOIN Customers c ON o.CustomerID = c.CustomerID
-- GROUP BY Country
-- ORDER BY TotalSales DESC;