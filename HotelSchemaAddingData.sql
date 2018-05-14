use Hotel;

insert into Customer 
(FirstName, LastName, PhoneNumber, Email) 
values ('Albert', 'Einstein', '651-200-0000', 'albert@einstein.com'),
('Arthur', 'Moore', '404-300-0000', 'arthur@moore.com'),
('Simon', 'Schuster', '631-540-0000', 'simon@schuster.com'),
('Elizabeth', 'Hurley', '541-256-0000', 'elizabeth@hurley.com'),
('Monica', 'Geller', '621-205-0000', 'monica@geller.com');

insert into PromotionCode
(CodeName, StartDate, EndDate, PercentOff, DollarsOff)
values ('Loyalty Program', '2017-03-08', '2019-12-31', 10, null),
('Star Trek Convention', '2019-03-08', '2019-12-31', 5, null),
('Wedding Block', '2012-03-08', '2017-12-31', null, 50),
('Giveaway Coupon', '2017-03-08', '2019-12-31', null, 100);


insert into Reservation
(CheckInDate, CheckOutDate, CustomerId, PromotionCodeId)
values ('2018-05-01', '2018-05-04', 2, 3),
('2017-05-01', '2017-06-04', 1, null),
('2008-02-21', '2008-03-04', 4, null),
('2019-06-21', '2019-06-24', 2, 1),
('2019-01-14', '2019-01-24', 2, 2),
('2018-11-01', '2018-11-06', 4, 4),
('2020-12-31', '2021-01-04', 5, null),
('2018-04-21', '2018-04-25', 3, null),
('2018-05-01', '2018-05-04', 3, 3),
('2018-04-01', '2018-04-04', 1, 4);

insert into Amenity
(Description)
values ('Minifridge'),
('Ocean view'),
('Pool view'),
('Jacuzzi');

insert into Room 
(RoomNumber, Floor, OccupancyLimit, Type)
values (1, 1, 4, 'Double'),
(2, 1, 6, 'Queen'),
(3, 1, 4, 'Double'),
(4, 1, 2, 'King');

insert into RoomAmenity
(RoomId, AmenityId)
values (1, 2),
(3, 1),
(4, 2),
(3, 3);

insert into RoomInReservation
(RoomId, ReservationId)
values (4, 9),
(3, 9),
(2, 9),
(4, 6),
(2, 1),
(4, 2),
(3, 3),
(2, 4), 
(1, 5), 
(1, 7),
(2, 7),
(2, 8),
(1, 10);

insert into Guest
(FirstName, LastName, Age, RoomInReservationId)
values ('Michael', 'Jackson', 50, 3),
('JK', 'Rowling', 42, 7),
('Linus', 'Pauling', 80, 2),
('LL', 'Bean', 28, 4),
('Cecily', 'Strong', 30, 9),
('Captain', 'Hook', 48, 3);

insert into RoomPrice
(RoomId, CostStartDate, CostEndDate, Cost)
values
(1, '2017-08-01', '2019-07-31', 300.99),
(1, '2019-08-01', '2021-07-31', 300.99),
(2, '2017-08-01', '2019-07-31', 300.99),
(2, '2019-08-01', '2021-07-31', 300.99),
(3, '2017-08-01', '2019-07-31', 300.99),
(3, '2019-08-01', '2021-07-31', 300.99),
(4, '2017-08-01', '2019-07-31', 300.99),
(4, '2019-08-01', '2021-07-31', 300.99);

insert into AddOn
(Description, Cost, CostStartDate, CostEndDate)
values 
('Movie', 19.99, '2017-08-01', '2019-07-31'),
('Room Service', 12.99,  '2017-08-01', '2019-07-31'),
('Massage', 69.99,  '2017-08-01', '2019-07-31');

insert into AddOnForRoom
(RoomInReservationId, AddOnId, DatePurchased)
values
(1, 3, '2018-03-26'),
(1, 2, '2018-04-16'),
(4, 1, '2018-05-12'),
(6, 3, '2018-05-23');














