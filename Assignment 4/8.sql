-- i
-- Find the course id, title, instructor id and name of those instructors who are from Physics department but are teaching a course of CSE department in the year 2020. Arrange results in ascending order of instructor names.
select course_id, title, instructor.ID, name
from teaches
join course using (course_id)
join instructor using (ID)
where instructor.dept_name = 'Physics' and course.dept_name = 'Comp. Sci.' and year = 2020
order by instructor.name asc;

-- ii
-- Add a new course with course_id as cs333 (with suitable values for other attributes) for the CSE department which will have cs303 as a prerequisite
insert into course values ('CS-333', 'Advanced Databases Lab', 'Comp. Sci.', 3);
insert into course values ('CS-303', 'Intro to Databases', 'Comp. Sci.', 6);
insert into prereq values ('CS-333', 'CS-303');

-- iii
-- Update salaries of instructors by 10% if their departments have a budget of more than 90000 rupees.
update instructor
set salary = salary * 1.1
where dept_name in (select dept_name
                    from department
                    where budget > 90000);

-- iv
-- Find CSE department courses (id and title) and number of students taking that course in the year 2009 and semester Fall where the number is greater than 5. Arrange the results in ascending order of course id.
select course_id, title, count(ID) as num_students
from course
join takes using (course_id)
where dept_name = 'Comp. Sci.' and year = 2009 and semester = 'Fall'
group by course_id, title
having num_students > 5
order by course_id asc;