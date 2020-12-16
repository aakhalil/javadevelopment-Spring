package com.cybertek.entity;

import com.cybertek.enums.Gender;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "students")
public class Student {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentFirstName")
    private String firstName;

    @Column(name = "studentLastName")
    private String lastName;

    @Column(name = "studentEmail")
    private String email;


    @Transient
    private String city;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Temporal(TemporalType.TIME)
    private Date birthTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDateAndTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
