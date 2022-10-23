drop table if exists users;

create table users (
    password varchar,
    date_of_birth date,
    name varchar,
    country varchar,
    sex varchar,
    data_processing boolean
);
