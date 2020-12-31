package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer> {

    // display all employees with email address "   "

    List<Employee> findByEmail (String email);

    // display all eployeess with first name " " and last name  " " nad a;l employee with email adress " "

    List <Employee> findByFirstNameAndLastNameOrEmail (String firstName, String lastName , String email);

    // display all employees that first name is not " "

    List <Employee> findByFirstNameIsNot (String firstName);


    // display all employees with last name starts with something

    List <Employee> findByLastNameStartingWith (String pattern);

    // dipslay all employees with salary higher than " "

    List <Employee> findBySalaryGreaterThan (Integer salary);

    List <Employee> findBySalaryLessThanEqual (Integer salary);

    // display all employees that have been hired between this " " and " "

    List <Employee>findByHireDateAfterAndHireDateBefore (LocalDate hireDate1, LocalDate hireDate2);

    // dipslay all employees where salary gretaer ad equla to " "

    List <Employee>findBySalaryGreaterThanEqualOrderBySalaryDesc (Integer salary);


    // display top uniq 3 employees that making more than ""

    List<Employee>findDistinctTop3BySalaryLessThan (Integer salary);

    // display all employees with null email address

    List <Employee>findByEmailIsNull (String email );
















}
