package com.cybertek.controller;

import com.cybertek.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// go to this local host : http://localhost:8080/student/welcome

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String homePage (Model model){

       model.addAttribute("name","Ashraf");
       model.addAttribute("course", "MVC");

       String subject = "CollectionS";
       model.addAttribute("subject",subject);


       int studentID = new Random().nextInt(1000);
       model.addAttribute("id", studentID);


        List <Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        numbers.add(20);
        numbers.add(40);
        numbers.add(70);
        numbers.add(900);

        model.addAttribute("numbers" ,numbers);

        //print your birthday

       LocalDate birthday = LocalDate.now().minusYears(42);
       model.addAttribute("birthday",birthday);


        Student student = new Student(1, "Mike", "Smith");
        model.addAttribute("student", student);


        return "student/welcome";
    }

    // here we are going to another page register
    @GetMapping ("/register")
    public String homePage2(){
        return "student/register";

    }

}
