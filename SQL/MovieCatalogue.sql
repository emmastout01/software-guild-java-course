
CREATE DATABASE MovieCatalogue;

use MovieCatalogue;

CREATE TABLE Genre
(
	GenreID INT NOT NULL auto_increment,
    GenreName VARCHAR(30) NOT NULL,
    PRIMARY KEY(GenreID)
);

CREATE TABLE Director
(
	DirectorID INT NOT NULL auto_increment,
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    Birthdate DATE,
    PRIMARY KEY(DirectorID)
);

CREATE TABLE Rating
(
	RatingID INT NOT NULL auto_increment,
    RatingName VARCHAR(5) NOT NULL,
    PRIMARY KEY(RatingID)
);


CREATE TABLE Actor
(
	ActorID INT NOT NULL auto_increment,
	FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    Birthdate DATE,
    PRIMARY KEY(ActorID)
);

CREATE TABLE Movie
(
	MovieID INT NOT NULL auto_increment primary key,
    Title VARCHAR(128) NOT NULL,
    ReleaseDate DATE,
    GenreID int not null,
    RatingID int null,
    DirectorID int null
);

CREATE TABLE CastMembers
(
	CastMemberID INT NOT NULL auto_increment,
	MovieID int not null,
    ActorID int not null,
    Role VARCHAR(30) NOT NULL,
    PRIMARY KEY(CastMemberID)
);

alter table CastMembers
add constraint fk_Movie_MovieID
foreign key(MovieID) references Movie(MovieID);

alter table CastMembers
add constraint fk_Actor_ActorID
foreign key(ActorID) references Actor(ActorID);

ALTER TABLE Movie 
ADD CONSTRAINT fk_Genre_GenreID
FOREIGN KEY (GenreID) references Genre(GenreID);


ALTER TABLE Movie 
ADD CONSTRAINT fk_Director_DirectorID
FOREIGN KEY (DirectorID) references Director(DirectorID);


ALTER TABLE Movie 
ADD CONSTRAINT fk_Rating_RatingID
FOREIGN KEY (RatingID) references Rating(RatingID);
