SELECT *
FROM departments;

SELECT *
From employees;

SELECT *
FROM regions;

SELECT  employee_id, first_name, department
FROM employees;

SELECT *
FROM  employees
WHERE department= 'Sports';

select * FROM employees
where department LIKE '%nit%' ;

SELECT *
From employees
where salary<100000;

SELECT *
FROM employees
where department= 'Clothing'
AND  salary<100000
And region_id >2 ;

SELECT *
FROM employees
where department ='Clothing'
OR salary>90000;

SELECT *
FROM employees
where salary<40000
AND ( department='Clothing'
Or department ='Pharmacy');

SELECT *
From employees
where NOT department <>'Sports';

SELECT *
FROM employees
where email IS NOT NULL;


SELECT *
FROM employees
where department='Sports'
Or department='First Aid'
or department ='Toys'
or department='Garden';

SELECT *
FROM employees
where department In ('Sports', 'First Aid');

SELECT *
FROM employees
where  salary between 10000 And 200000;

SELECT first_name, email
From employees
WHERE gender='F'
and department='Tools'
And salary>110000;


SELECT  first_name, email, hire_date
FROM  employees
where  salary>165000
Or (department='Sports' AND  gender='M');


SELECT *
FROM  employees
ORDER BY  employee_id DESC ;

SELECT *
FROM  employees
ORDER BY  employee_id ;

SELECT  Distinct  department
From employees;

SELECT  Distinct  department
From employees
FETCH  FIRST 3 ROWS  ONLY ;


SELECT  salary as yearly_salary
From employees;

--Write a query that displays the name and ages of the top 4 oldest students.
SELECT *
FROM students
ORDER BY age DESC
FETCH FIRST 4 ROWS ONLY;

SELECT *
FROM  students

WHERE  age<=20
    AND (student_no BETWEEN 3 and 5 Or student_no=7)
   OR (age>20 And student_no>=4)
ORDER BY age;


SELECT upper(first_name) First_Name, lower(department ) As Department
FROM  employees;

SELECT  length(first_name)
From employees;

SELECT 'Hello There';

SELECT  trim( '       hello there     ');
SELECT  length(  Trim( ' helloe     ' ));

SELECT first_name || ' ' || last_name as fuck_face
From  employees;

SELECT (salary>140000)
From employees;

SELECT (salary>14000) as hight_paid
From employees
ORDER BY salary desc ;


SELECT  department, (department LIKE '%oth')
FROM  employees;


SELECT 'This is test data' test_data;

SELECT *
FROM  employees
where  first_name= 'John';

-- substring

SELECT  substring('this is test data' FROM 1 FOR 6) as test_data;

SELECT  substring('this is test data' FROM  9 ) as test_tata;

SELECT  department,replace(department,'Clothing', 'Clothes')
FROM  departments;

SELECT  Min(salary)
from employees;

SELECT  Max(salary)
from employees;

SELECT  avg(salary)
from employees;

select round(avg(salary))
from employees;

select count (employee_id)
from employees;

SELECT count (email)
from employees;


SELECT  Sum (salary)
from employees
where  department='Clothing';

--Write a query that returns all of the records and columns from the professors table
--but shortens the department names to only the first three characters in upper case

SELECT  last_name, upper(substring(department,1,3)) as department , hire_date, salary
FROM professors;

--Write a query that returns the highest and lowest salary from the professsors table exlucing the professor named

SELECT  Max( salary) as max_salary , Min (salary) as min_salary
from professors
where last_name != 'Nilson';



SELECT COUNT(*), department
FROM  employees
GROUP BY  department;

SELECT  Sum(salary) as total_salary_by_Department, department
From employees
GROUP BY department
ORDER BY department;

SELECT  Min(salary), Max (salary), round(avg(salary)), Count (*) as total_number_employees, department
From employees
GROUP BY department
ORDER BY department;
-- to make them start alphabaticlly--



SELECT sum (salary) as total_salary, department
From employees
where region_id in (4,5,7)
group by department;

SELECT  department, Count (*)
From employees
GROUP BY department
order by department;

-- we use "having" after grouping instead of "where"
SELECT  department, Count (*)
From employees
GROUP BY department
having count(*)<36
order by department;

--show all unique domain and number of employees

SELECT count(*), substring(email,position('@' in email)+1) email_domain
from employees
where email is not null
GROUP BY email_domain
order by email_domain;


Select d.department
From employees e ,departments d;


SELECT department
FROM departments;


SELECT *
From employees
WHERE department not in (SELECT department  FROM departments);

SELECT *
from (Select * from employees where salary>150000) a;

Select * from employees where salary>150000;


SELECT *
from employees
where department in (select department from departments where division='Electronics')
order by department;


SELECT *
from employees
where department  in (select department from departments where region_id in ('4', '7'));



SELECT *
from employees
where region_id in (select region_id from regions where country in ('Asia', 'Canada'));

--First name where work in ASIA or CANADA  and how much less making from the highest employee in the company
select e.first_name, ((select Max (salary) from employees )- e.salary) as salary_differnce
from employees e
where region_id in (select region_id from regions where country in ('Asia', 'Canada'))

--Write a query that returns all of those employees that work in the kids division AND
--the dates at which those employees were hired is greater than all of the hire_dates of employees
--who work in the maintenance department

Select *
from employees
where department =any (select department from departments where division='Kids') ---ANY
and hire_date > All (select hire_date from departments where division= 'Maintenance')   -----ALL

--Write a query that returns the names of those students that are taking the courses Physics and US History

select  *
from students;

select *
from student_enrollment;


select *
from courses;

--Write a query that returns the names of those students that are taking the courses Physics and US History
SELECT s.student_name , c.course_title
from students s, courses c
where student_no in (select student_no from student_enrollment where course_no in (select  course_no from  courses where course_title in ('Physics', 'US History')));

SELECT student_name
FROM students
WHERE student_no IN(SELECT student_no FROM student_enrollment
                    WHERE course_no IN(SELECT course_no FROM courses
                                       WHERE course_title IN('Physics','US History')));

SELECT first_name, last_name, salary,
CASE
When salary<10000 Then 'Under Paid'
When salary>10000 Then 'Over Paid'
Else 'Unpaid'
end as catagory
from employees;


SELECT catagory, count(*)
From (SELECT first_name, last_name, salary,
             CASE
                 When salary<10000 Then 'Under Paid'
                 When salary>10000 Then 'Over Paid'
                 Else 'Unpaid'
                 end as catagory
    from employees) a
group by catagory;

SELECT  * FROM regions;
SELECT * from employees;

SELECT first_name, country, department
from employees e, regions r
where r.region_id= e.region_id;


SELECT first_name, email, division, d.department
FROM employees e, departments d, regions r
where e.department = d.department
And r.region_id= e.region_id;


SELECT  first_name, country
From employees e INNER JOIN  regions r
    on e.region_id = r.region_id;

SELECT  first_name, email, division
from employees e inner join departments d
    on e.department = d.department
where email is not null;


SELECT first_name, email, division, country
from employees e inner join departments d on e.department = d.department
inner join regions r on e.region_id = r.region_id
where email is not null;


Select distinct  department from employees; ---31
select distinct  department from departments;  -----24


SELECT distinct e.department, d.department
from employees e right join departments d on e.department = d.department;

SELECT  department from employees
union
select department from departments;







