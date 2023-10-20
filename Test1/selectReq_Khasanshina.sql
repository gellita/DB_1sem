SELECT * FROM StudentsOfTheTest;
SELECT * FROM CoursesOfTheTest ORDER BY start_date DESC;
SELECT course_id, COUNT(*) AS registration_count
FROM RegistrationsOfTheTest
GROUP BY course_id;