use Hotel;

insert into Customer 
(FirstName, LastName, PhoneNumber, Email) 
values ('Albert', 'Einstein', '651-200-0000', 'albert@einstein.com'),
('Arthur', 'Moore', '404-300-0000', 'arthur@moore.com'),
('Simon', 'Schuster', '631-540-0000', 'simon@schuster.com'),
('Elizabeth', 'Hurley', '541-256-0000', 'elizabeth@hurley.com'),
('Monica', 'Geller', '621-205-0000', 'monica@geller.com');

insert into PromotionCode
(StartDate, EndDate, PercentOff, DollarsOff)
values ('2017-03-08', '2019-12-31', 10, null),
('2019-03-08', '2019-12-31', 5, null),
('2012-03-08', '2017-12-31', null, 50),
('2017-03-08', '2019-12-31', null, 100);


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

