-- Write a query that returns all the rooms reserved for a particular customer.
SELECT COUNT(*) as TotalRooms
FROM RoomInReservation rir
INNER JOIN Reservation r on rir.ReservationId = r.Id
INNER JOIN Customer c on c.Id = r.CustomerId
WHERE c.Id = 1;


-- Write a query that returns all the rooms available for a date range.
SELECT *
FROM Room rm
WHERE type = 'Queen'
AND Id NOT IN (
SELECT rm.Id FROM Room rm
INNER JOIN RoomInReservation rir on rm.Id = rir.RoomId
INNER JOIN Reservation r on rir.ReservationId = r.Id
WHERE r.CheckInDate > '2018-04-26'
AND r.CheckOutDate < '2018-05-03');

-- Write a query that returns a list of promotion codes, and the #times used.
SELECT CodeName, COUNT(r.PromotionCodeId) as NumTimesUsed
FROM PromotionCode pc
INNER JOIN Reservation r on pc.Id = r.PromotionCodeId
GROUP BY CodeName;


