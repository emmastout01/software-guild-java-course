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
Cost decimal
);


create table RoomInReservation (
Id	integer primary key auto_increment not null
);

create table PromotionCode (
Id	integer primary key auto_increment not null,
StartDate date not null,
EndDate date not null,
PercentOff decimal,
DollarsOff decimal 
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
Cost decimal not null,
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

drop table BillingDetails;

create table BillingDetails (
ReservationId	integer primary key auto_increment not null,
TaxRate decimal not null
);

