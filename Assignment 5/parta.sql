use university;

-- SELECT dept_name, num_students, COUNT(dept_name) AS num_instructors FROM (SELECT dept_name, COUNT(dept_name) AS num_students FROM department NATURAL JOIN student GROUP BY dept_name) AS tab NATURAL JOIN instructor GROUP BY dept_name;

select room_number
from classroom
left join section using (building, room_number)
where building = 'Watson' and capacity > 30
and room_number not in
(select room_number
from classroom
left join section using (building, room_number)
where building = 'Watson' and capacity > 30 and semester = 'Fall' and year = 2022);