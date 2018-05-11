use Hotel;

use Hotel;

alter table Reservation 
add column CustomerId INT,
add column PromotionCodeId int,
ADD CONSTRAINT fk_Reservation_CustomerId
FOREIGN KEY (CustomerId) REFERENCES Customer(Id),
add constraint fk_Reservation_PromotionCodeId
foreign key (PromotionCodeId) references PromotionCode(Id);

alter table RoomPrice
add column RoomId INT,
ADD CONSTRAINT fk_RoomPrice_RoomId
FOREIGN KEY (RoomId) REFERENCES Room(Id);

alter table RoomInReservation
add column RoomId INT,
add column ReservationId int,
ADD CONSTRAINT fk_RoomInReservation_RoomId
FOREIGN KEY (RoomId) REFERENCES Room(Id),
ADD CONSTRAINT fk_RoomInReservation_ReservationId
FOREIGN KEY (ReservationId) REFERENCES Reservation(Id);

alter table guest 
add column RoomInReservationId integer, 
add constraint fk_guest_RoomInReservationId
foreign key (RoomInReservationId) references RoomInReservation(id);

alter table AddOnForRoom
add column RoomInReservationId integer, 
add constraint fk_AddOnForRoom_RoomInReservationId
foreign key (RoomInReservationId) references RoomInReservation(id);

alter table AddOnForRoom
add column AddOnId integer,
add constraint fk_AddOnForRoom_AddOnId
foreign key (AddOnId) references AddOn(Id);

alter table RoomAmenity
add column RoomId integer,
add constraint fk_RoomAmenity_RoomId
FOREIGN KEY (RoomId) references Room(Id),
add column AmenityId integer,
add constraint fk_RoomAmenity_AmenityId
foreign key (AmenityId) references Amenity(Id);

alter table BillingDetails
add constraint fk_BillingDetails_ReservationId
foreign key (ReservationId) references Reservation(Id);

