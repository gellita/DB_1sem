CREATE TABLE Users (
    id serial PRIMARY KEY ,
    surname VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    patronymic VARCHAR(50),
    birthdate DATE not null ,
    profession VARCHAR(50),
    nationality VARCHAR(50),
    phone_number VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);




