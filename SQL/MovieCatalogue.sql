
CREATE DATABASE MovieCatalogue;


CREATE TABLE Movie
(
	MovieID INT NOT NULL auto_increment,
    Title VARCHAR(128) NOT NULL,
    ReleaseDate DATE,
    FOREIGN KEY (GenreID)  REFERENCES Genre(GenreID),
    FOREIGN KEY (DirectorID) REFERENCES Director(DirectorID),
    FOREIGN KEY (RatingID) REFERENCES Rating(RatingID),
	PRIMARY KEY (MovieID)
);

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


-- Actor 
-- ActorID - Primary Key, identity
-- FirstName - Required, extended character set, 30 length
-- LastName - Required, extended character set, 30 length
-- BirthDate - Not Required

-- CastMembers 
-- CastMemberID - Primary Key, identity
-- ActorID - Foreign Key, Actor Table, Required
-- MovieID - Foreign Key, Movie Table, Required
-- Role - Required, extended character set, 50 length

-- Genre 
-- GenreID - Primary Key, identity
-- GenreName - Required, extended character set, 30 length
-- Director 
-- DirectorID - Primary Key, identity
-- FirstName - Required, extended character set, 30 length
-- LastName - Required, extended character set, 30 length
-- BirthDate - Not Required
-- Rating 
-- RatingID - Primary Key, identity
-- RatingName - Required, standard character set, 5 length


-- MovieID - Primary Key, identity
-- GenreID - Foreign Key, Genre Table, Required
-- DirectorID - Foreign Key, Director Table, Not Required
-- RatingID - Foreign Key, Rating Table, Not Required
-- Title - Required, extended character set, 128 length
-- Release Date - Not Required
-- 
-- CREATE TABLE Apprentice 
-- (
--    ApprenticeID INT NOT NULL auto_increment,
--    FirstName VARCHAR(30) NOT NULL,
--    LastName VARCHAR(30) NOT NULL,
--    CohortID INT NOT NULL,
--    PRIMARY KEY(ApprenticeID),
--    FOREIGN KEY(CohortID) REFERENCES Cohort(CohortID)
-- );