use imdb;

insert into Role (name) values ('Actor');
insert into Role (name) values ('Director');
insert into Role (name) values ('Writer');
insert into Role (name) values ('Producer');
insert into Role (name) values ('Cinematographer');

insert into MoviePersonRole (MovieId, PersonId, RoleId)
	values(1, 0, 2);
    
insert into Person (FirstName, LastName)
	values ('Meryl', 'Streep'),
	('Robert', 'DeNiro'),
    ('Whoopi', 'Goldberg'),
    ('Bruce', 'Willis');
    
select * from Person where FirstName like 'M%';

insert into Movie (title, ReleaseDate) values
	('Sister Act', '1992-03-20'),
    ('Pulp Fiction', '1994-10-14'),
    ('Mamma Mia', '2009-07-14');
    
