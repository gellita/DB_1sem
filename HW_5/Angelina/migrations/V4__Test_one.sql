CREATE TABLE Students (
  student_id SERIAL PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  date_of_birth DATE,
  email VARCHAR(100) UNIQUE,
  address VARCHAR(100),
  department_id INT,
  FOREIGN KEY (department_id) REFERENCES Departments(department_id)
);

CREATE TABLE Departments (
  department_id SERIAL PRIMARY KEY,
  department_name VARCHAR(50) NOT NULL,
  department_location VARCHAR(100),
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP
);
CREATE TABLE Courses (
  course_id SERIAL PRIMARY KEY,
  course_name VARCHAR(100) NOT NULL,
  course_description VARCHAR(255),
  department_id INT,
  instructor_id INT,
  start_date DATE,
  end_date DATE,
  FOREIGN KEY (department_id) REFERENCES Departments(department_id),
  CHECK (start_date < end_date)
);


INSERT INTO Students (first_name, last_name, date_of_birth, email, address, department_id)
VALUES
  ('John', 'Doe', '1990-02-15', 'johndoe@example.com', '123 Main St', 1),
  ('Jane', 'Smith', '1992-07-24', 'janesmith@example.com', '456 Elm St', 2),
  ('David', 'Johnson', '1991-05-10', 'davidjohnson@example.com', '789 Oak St', 1),
  ('Emily', 'Brown', '1993-11-08', 'emilybrown@example.com', '321 Maple Ave', 3),
  ('Michael', 'Davis', '1990-09-17', 'michaeldavis@example.com', '654 Pine Blvd', 2);

INSERT INTO Departments (department_name, department_location)
VALUES
  ('Engineering', 'Building A, 5th Floor'),
  ('Marketing', 'Building B, 2nd Floor'),
  ('Human Resources', 'Building C, 3rd Floor'),
  ('Finance', 'Building D, 1st Floor'),
  ('Operations', 'Building E, 4th Floor');


INSERT INTO Courses (course_name, course_description, department_id, instructor_id, start_date, end_date)
VALUES
  ('Introduction to Programming', 'Learn the basics of programming', 1, 1, '2022-09-01', '2022-12-15'),
  ('Digital Marketing Strategies', 'Explore effective digital marketing strategies', 2, 3, '2022-10-15', '2022-12-30'),
  ('Employee Relations', 'Study principles and best practices in employee relations', 3, 2, '2023-01-10', '2023-04-30'),
  ('Financial Accounting', 'Learn fundamental concepts of financial accounting', 4, 4, '2023-02-01', '2023-05-15'),
  ('Supply Chain Management', 'Explore strategies for effective supply chain management', 5, 5, '2022-11-01', '2023-02-28');

