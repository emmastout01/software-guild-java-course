drop database if exists Hotel;

create database Hotel;

use Hotel;

create table Reservation (

Id	integer primary key auto_increment not null,
CheckInDate	date	not null  ,
CheckOutDate	date	 not null

);

create table Customer (
Id	integer primary key auto_increment not null,
FirstName varchar(30),
LastName varchar(30),
PhoneNumber varchar(20),
Email varchar(60)
);

create table Room (
Id	integer primary key auto_increment not null,
RoomNumber integer not null,
Floor integer not null,
OccupancyLimit integer not null,
Type varchar(30) not null
);

create table RoomPrice (
Id	integer primary key auto_increment not null,
CostStartDate date not null,
CostEndDate date not null,
Cost decimal(6, 2)
);

create table RoomInReservation (
Id	integer primary key auto_increment not null
);

create table PromotionCode (
Id	integer primary key auto_increment not null,
StartDate date not null,
EndDate date not null,
PercentOff decimal(3, 1),
DollarsOff decimal (5, 2)
);

create table Guest (
Id	integer primary key auto_increment not null,
FirstName varchar(30) not null,
LastName varchar(30) not null,
Age integer not null
);

create table AddOnForRoom (
Id	integer primary key auto_increment not null,
DatePurchased date not null
);


create table AddOn (
Id	integer primary key auto_increment not null,
Description varchar(50) not null,
Cost decimal(5, 2) not null,
CostStartDate date not null,
CostEndDate date not null
);


create table RoomAmenity (
Id	integer primary key auto_increment not null
);

create table Amenity (
Id	integer primary key auto_increment not null,
Description varchar(20) not null
);

create table BillingDetails (
ReservationId	integer primary key auto_increment not null,
TaxRate decimal(6, 2) not null
);

alter table Reservation 
add column CustomerId INT not null,
add column PromotionCodeId int,
ADD CONSTRAINT fk_Reservation_CustomerId
FOREIGN KEY (CustomerId) REFERENCES Customer(Id),
add constraint fk_Reservation_PromotionCodeId
foreign key (PromotionCodeId) references PromotionCode(Id);

alter table RoomPrice
add column RoomId INT not null,
ADD CONSTRAINT fk_RoomPrice_RoomId
FOREIGN KEY (RoomId) REFERENCES Room(Id);

alter table RoomInReservation
add column RoomId INT not null,
add column ReservationId int not null,
ADD CONSTRAINT fk_RoomInReservation_RoomId
FOREIGN KEY (RoomId) REFERENCES Room(Id),
ADD CONSTRAINT fk_RoomInReservation_ReservationId
FOREIGN KEY (ReservationId) REFERENCES Reservation(Id);

alter table guest 
add column RoomInReservationId integer not null, 
add constraint fk_guest_RoomInReservationId
foreign key (RoomInReservationId) references RoomInReservation(id);

alter table AddOnForRoom
add column RoomInReservationId integer not null, 
add constraint fk_AddOnForRoom_RoomInReservationId
foreign key (RoomInReservationId) references RoomInReservation(id),
add column AddOnId integer not null,
add constraint fk_AddOnForRoom_AddOnId
foreign key (AddOnId) references AddOn(Id);

alter table RoomAmenity
add column RoomId integer not null,
add constraint fk_RoomAmenity_RoomId
FOREIGN KEY (RoomId) references Room(Id),
add column AmenityId integer not null,
add constraint fk_RoomAmenity_AmenityId
foreign key (AmenityId) references Amenity(Id);

alter table BillingDetails
add constraint fk_BillingDetails_ReservationId
foreign key (ReservationId) references Reservation(Id);

