Use CarDealership;

INSERT into ContactMessage (Name, Email, Phone, Message) 
VALUES
('Marta Smith', 'marta@email.com', '345-234-6421', "I'm interested in shopping for a new car."),
('Emma Anderson', 'emma@email.com', '', "I'm looking for a used Honda Fit, preferably 2014 or newer."),
('Zack Fisher', '', '434-3334', 'Looking for a new Toyota, please let me know when you have some in stock.'),
('Connor MacKenzie', 'connor@email.com', '', "I would like to speak to a salesperson about purchasing the 2018 Ford Focus.");

insert into Make (Make) 
values
('Ford'),
('Honda'),
('Toyota');

insert into Model (MakeId, Model)
values 
(1, 'Anglia'),
(1, 'Focus'),
(2, 'Fit'),
(2, 'Odyssey'),
(2, 'Accord'),
(3, 'Prius'),
(3, 'Yaris'),
(3, 'Corolla');

insert into User (FirstName, LastName, Email, `Password`, Role)
values
('Curly', 'Smith', 'curly@cars.com', 'myPassword1', 'Sales'),
('Larry', 'Smith', 'larry@cars.com', 'myPassword2', 'Sales'),
('Moe', 'Smith', 'moe@cars.com', 'myPassword3', 'Admin');

insert into Vehicle (VIN, MakeId, ModelId, Color, `Type`, BodyStyle, Transmission, Interior, `Year`, MSRP, SalePrice, Mileage, Description, Photo, Featured, Sold)
values
('V39485843e92921', 2, 3, 'Yello', 'Used', 'Car', 'Automatic', 'Black', 2013, 14558, 11589, 12000, 'Yellow Honda Fit, great condition. No accident record. Like new! Small dent on one side.', 'image.jpg', true, false),
('V39485843332921', 2, 3, 'Blue', 'Used', 'Car', 'Automatic', 'Black', 2016, 14557, 13589, 30000, 'Blue Honda Fit, very good condition. Last owner took excellent care of the car. Small scratch on the passenger door.', 'image.jpg', true, false),
('L39343e84392921', 3, 7, 'Silver', 'Used', 'Car', 'Manual', 'Beige', 2009, 15555, 5589, 71600, 'Silver Toyota Yaris, drives like new! One accident on record.', 'image.jpg', true, false),
('V39485843e92921', 1, 1, 'Yello', 'New', 'Car', 'Automatic', 'Black', 2019, 14558, 11589, 400, 'Yellow Ford Anglia, great condition. No accident record. Like new! Small dent on one side.', 'image.jpg', true, false),
('V35465843332921', 2, 4, 'Blue', 'New', 'Van', 'Automatic', 'Black', 2019, 14557, 6589, 0, 'Blue Honda Odyssey very good condition. Last owner took excellent care of the car. Small scratch on the passenger door.', 'image.jpg', true, false),
('V39480394200399', 3, 8, 'Silver', 'New', 'Car', 'Manual', 'Beige', 2019, 15555, 5589, 0, 'Silver Toyota Corolla, drives like new! One accident on record.', 'image.jpg', true, false);


insert into Purchase (Name, Phone, Email, Street1, Street2, State, City, ZipCode, PurchaseDate, PurchaseType, UserId, VehicleId, PurchasePrice)
values
('Emma', '345-234-2222', 'emma@email.com', '123 fake street', 'apartment 1', 'MN', 'St. Paul', '55432', CURDATE(), 'Dealer Finance', 1, 1, 23000),
('Marta', '345-234-2222', 'marta@email.com', '123 lake street', 'apartment 2', 'MN', 'St. Paul', '55432', CURDATE(), 'Dealer Finance', 2, 2, 24000),
('Emma', '345-234-2222', 'emma@email.com', '123 rake street', 'apartment 3', 'MN', 'Duluth', '56789', CURDATE(), 'Cash', 1, 3, 25000);

insert into Special (Title, Description)
values
('Sale on Hondas', 'Save $200 instantly when you buy a Honda! Sale ends this Sunday. Hurry in and get a Honda today!'),
('Memorial Day Savings', 'Save up to 20% on cars this Memorial Day weekend!'),
('Summer sale', "We're celebrating the start to summer with a big sale! Come in quick and save big. Cars are up to $1000 off sale price!");

SELECT * from ContactMessage;

SELECT * from Vehicle;

SELECT * from Purchase;

--                 
