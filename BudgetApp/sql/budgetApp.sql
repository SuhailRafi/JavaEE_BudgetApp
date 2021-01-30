create database budgetapp;
use budgetapp;
create table user(
	email varchar(200),
    name varchar(200),
    password varchar(200),
    primary key (email)
);

create table user_Expense(
	id int auto_increment,
    amount double,
    description varchar(500),
    email varchar(200),
    primary key (id),
    foreign key (email) references user(email)
);
create table user_income(
	id int auto_increment,
    amount double,
    description varchar(500),
    email varchar(200),
    primary key (id),
    foreign key (email) references user(email)
);

