USE imdb;

create table Movie (
	MovieId int auto_increment primary key,
    Title varchar(120)
);

insert into Movie (Title) values ("Homeward Bound: The Incredible Journey");


select * from Movie;

create table Person (
	PersonId int auto_increment primary key,
    FirstName varchar(30) not null,
    LastName varchar(30) not null
);

create table Role (
	RoleId int auto_increment primary key,
    Name varchar(30) not null
);

create table MoviePersonRole (
	MovieId int not null,
    PersonId int not null,
    RoleId int not null,
    primary key(MovieId, PersonId, RoleId)
);
-- 
-- Here, we're saying that there can't be the same person with the same role in the same movie. These have to be unique.

alter table MoviePersonRole
add constraint fk_MoviePersonRole_MovieId
foreign key (MovieId)references Movie(MovieId);

-- creating a named foreign key that's linking the movie id with the moviepersonrole table

alter table MoviePersonRole
add column Salary decimal(10, 2) null;

select * from Movie;

alter table Movie 
add column ReleaseDate date;