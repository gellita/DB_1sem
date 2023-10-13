
create table publishing_house (
                                  id serial primary key,
                                  name varchar(30),
                                  city varchar(30)
);
create table library(
                          id serial primary key,
                          name varchar(30),
                          adress varchar(30)
);
create table reader(
                       id serial primary key,
                       first_name varchar(30),
                       last_name varchar(30),
                       patronymic varchar(30),
                       birth_date date
);
create table book (
                      id serial primary key,
                      name varchar(30),
                      author varchar(30),
                      publishing_year integer,
                      publisher_id integer,
                      take boolean,
                      foreign key(publisher_id) references publishing_house(id)

);
create table take_book(
                          reader_id integer,
                          book_id integer,
                          take_date date,
                          return_date date,
                          foreign key (reader_id) references reader(id),
                          foreign key (book_id) references book(id)

)