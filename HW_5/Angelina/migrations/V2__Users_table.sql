alter table reader rename to users;
alter table users
add column profession varchar(20),
add column nationality varchar(20),
add column phone_number varchar(20),
add column email varchar(20) unique,
add constraint birthday_check check ( birth_date <= now());

