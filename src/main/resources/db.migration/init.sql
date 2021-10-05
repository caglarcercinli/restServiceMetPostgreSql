create database employees;
 create table employees (
    id serial primary key,
    first_name Varchar(50),
    last_name varchar(50),
    email varchar(50));
insert into employees(first_name,last_name,email)
values ('john','white','john@mail.com');