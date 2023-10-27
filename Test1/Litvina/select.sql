
SELECT department_id, COUNT(*) AS total_students
FROM Students
GROUP BY department_id;

SELECT * FROM Students
WHERE last_name LIKE 'D%'
ORDER BY first_name ASC;

