use Library;

create table Book (
	BookId int primary key auto_increment,
    ISBN varchar(20) null,
    Title varchar(100) not null,
    PublishDate date null
);