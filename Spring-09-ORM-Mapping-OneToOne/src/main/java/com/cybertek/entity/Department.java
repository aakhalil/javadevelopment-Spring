package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "departments")
public class Department extends BaseEntity {

    private String department;
    private String division;

    @OneToOne (mappedBy = "department")
    private Employee employee;


    public Department(String department, String division) {
        this.division = division;
        this.department = department;
    }
}
