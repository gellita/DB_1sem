CREATE TABLE StudentsOfTheTest (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birthdate DATE,
    gender VARCHAR(10),
    email VARCHAR(100) UNIQUE
);
CREATE TABLE CoursesOfTheTest (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    instructor VARCHAR(100),
    start_date DATE,
    end_date DATE,
    capacity INT,
    UNIQUE (course_name)
);
CREATE TABLE RegistrationsOfTheTest (
    registration_id INT PRIMARY KEY,
    student_id INT,
    course_id INT,
    registration_date TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES StudentsOfTheTest(student_id),
    FOREIGN KEY (course_id) REFERENCES CoursesOfTheTest(course_id)
);
INSERT INTO StudentsOfTheTest (student_id, first_name, last_name, birthdate, gender, email)
VALUES
    (1, 'Иван', 'Иванов', '1995-03-15', 'Мужской', 'ivan.ivanov@gmail.com'),
    (2, 'Мария', 'Петрова', '1998-07-20', 'Женский', 'maria.petrova@gmail.com'),
    (3, 'Алексей', 'Смирнов', '1997-11-10', 'Мужской', 'aleksey.smirnov@gmail.com'),
    (4, 'Екатерина', 'Сергеева', '1996-04-25', 'Женский', 'ekaterina.sergeeva@gmail.com'),
    (5, 'Павел', 'Козлов', '1999-09-05', 'Мужской', 'pavel.kozlov@gmail.com');
INSERT INTO CoursesOfTheTest (course_id, course_name, instructor, start_date, end_date, capacity)
VALUES
    (1, 'Математика', 'Иванова А.А.', '2023-01-10', '2023-03-20', 30),
    (2, 'Физика', 'Петров В.И.', '2023-02-15', '2023-04-25', 25),
    (3, 'История', 'Смирнов И.П.', '2023-01-20', '2023-03-30', 40),
    (4, 'Химия', 'Сергеева О.В.', '2023-02-05', '2023-04-15', 35),
    (5, 'Английский язык', 'Козлова Е.М.', '2023-01-25', '2023-04-05', 50);
INSERT INTO RegistrationsOfTheTest (registration_id, student_id, course_id, registration_date)
VALUES
    (1, 1, 1, '2023-01-05 10:30:00'),
    (2, 2, 3, '2023-02-12 14:45:00'),
    (3, 3, 2, '2023-01-18 09:15:00'),
    (4, 4, 4, '2023-03-01 11:20:00'),
    (5, 5, 5, '2023-02-24 16:10:00');