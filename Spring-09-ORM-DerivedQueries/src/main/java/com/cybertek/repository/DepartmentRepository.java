package com.cybertek.repository;

import com.cybertek.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    // dispaly all dep in furniture

       List<Department> findByDepartment(String department);

    // display all dep in health division

    List <Department> findByDivision ( String division);


    // display all dep in health division

    List <Department> findByDivisionIs ( String division);

    // display all dep in health division

    List <Department> findByDivisionEquals ( String division);


    // display all department wurg divison name ends with "ics"

    List<Department> findByDivisionEndsWith (String pattern);

    // display top 3 departmnets with divion name include "hea" without duplicates

    List<Department> findDistinctTop3ByDivisionContaining (String pattern);





















}
