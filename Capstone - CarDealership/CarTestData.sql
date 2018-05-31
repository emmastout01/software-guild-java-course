Use CarDealership;

INSERT into ContactMessage (Name, Email, Phone, Message) 
VALUES
('Marta', 'marta@email.com', '345-234-6421', 'hello marta'),
('Emma', 'emma@email.com', '', 'hello emma'),
('Zark', '', '434-3334', 'hello zack'),
('Connor', 'connor@email.com', '', 'hello connor');

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

insert into Vehicle (VIN, MakeId, ModelId, Color, `Type`, BodyStyle, Transmission, Interior, `Year`, MSRP, SalePrice, Mileage, Description, Photo, Featured)
values
('V39485843e92921', 1, 1, 'Red', 'New', 'Car', 'Automatic', 'Black', 2013, 24558, 21589, 12000, 'Great red car', 'image.jpg', true),
('V39485843332921', 2, 1, 'Yellow', 'Used', 'Car', 'Automatic', 'Black', 2016, 24557, 14589, 30000, 'Great yellow car', 'image.jpg', true),
('L39343e84392921', 3, 2, 'Blue', 'Used', 'SUV', 'Manual', 'Beige', 2009, 22555, 20589, 71600, 'Great blue car', 'image.jpg', false);


insert into Purchase (Name, Phone, Email, Street1, Street2, State, City, ZipCode, PurchaseDate, PurchaseType, UserId, VehicleId, PurchasePrice)
values
('Emma', '345-234-2222', 'emma@email.com', '123 fake street', 'apartment 1', 'MN', 'St. Paul', '55432', CURDATE(), 'Dealer Finance', 1, 1, 23000),
('Marta', '345-234-2222', 'marta@email.com', '123 lake street', 'apartment 2', 'MN', 'St. Paul', '55432', CURDATE(), 'Dealer Finance', 2, 2, 24000),
('Emma', '345-234-2222', 'emma@email.com', '123 rake street', 'apartment 3', 'MN', 'Duluth', '56789', CURDATE(), 'Cash', 1, 3, 25000);

insert into Special (Title, Description)
values
('Great deal', 'We have a great deal'),
('Memorial day sale', 'All cars 70% off!');

SELECT * from User;

SELECT * FROM Vehicle v
Inner join Model mo on v.ModelId = mo.ModelId
Inner join Make ma on v.MakeId = ma.MakeId
WHERE
                ("" = "" or ma.Make LIKE "")
                AND ("" = "" or mo.Model LIKE "")
                AND ("" = "" or `Year` LIKE "")
                AND ("" = "" or `Year` > "")
                AND ("" = "" or `Year` < "")
                AND ("" = "" or SalePrice > "")
                AND ("" = "" or SalePrice < "")
                ORDER BY MSRP DESC LIMIT 2;
                
