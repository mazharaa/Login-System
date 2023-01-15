create database loginsystem;

use loginsystem;

create table `users` (
`id` INT not null auto_increment,
`username` VARCHAR(45) not null,
`password` VARCHAR(45) not null,
`enabled` INT not null,
primary key (`id`)
);

create table `authorities` (
`id` INT not null auto_increment,
`username` VARCHAR(45) not null,
`authority` VARCHAR(45) not null,
primary key (`id`)
);

insert ignore into `users`  values (null, 'happy', '12345', '1');
insert ignore into `authorities`  values (null, 'happy', 'write');

create table `customer` (
`id` INT not null auto_increment,
`email` VARCHAR(45) not null,
`pwd` VARCHAR(200) not null,
`role` VARCHAR(200) not null,
primary key (`id`)
);

insert into `customer` (`email`, `pwd`, `role`)
values ('johndoe@example.com', '12345', 'admin');
