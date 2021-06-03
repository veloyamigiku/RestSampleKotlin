create table logger2(
    id int primary key auto_increment,
    longitude float not null,
    latitude float not null,
    altitude float not null,
    gpstime datetime not null
);
