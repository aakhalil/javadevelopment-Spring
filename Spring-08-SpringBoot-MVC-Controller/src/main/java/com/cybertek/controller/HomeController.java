package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@Controller

public class HomeController {

    @RequestMapping("/")
    public String getRequestMapping(){

        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ozzy")
    public String getRequestMapping2(){

        return "home";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/ozzy")
    public String getRequestMapping3(){

        return "home";
    }

    // we can do just get mapping instead of all the annotation above @RequestMapping(method = RequestMethod.POST, value = "/ozzy")
    @GetMapping("/spring")
    public String getMappingEx(){
        return  "home";
    }

    @PostMapping("/spring)")
    public String postMappingEx2(){
        return "home";
    }


    @GetMapping ("/home/{name}")
    public String pathVariableEx(@PathVariable("name") String name){
        System.out.println("name is "+ name);
        return "home";


              }

// 2 parameters
              @GetMapping ("/home/{name}/{email}")
              public String pathVariableEx2(@PathVariable ("name") String name , @PathVariable("email") String email){
                  System.out.println("name is: " + name);
                  System.out.println("email is: "+ email);

        return  "home";
            }




// http://localhost:8080/home/course?course=spring
    @GetMapping ("home/course")
    public String requestParamEx (@RequestParam("course") String course){

        System.out.println(" name is: "+  course);
        return "home";
    }


    // http://localhost:8080/course

    @GetMapping (value = "home/course2")
    public String requestParam2 (@RequestParam(value="course2", required = false, defaultValue = "Cybertek") String name){
        System.out.println("name is : "+ name);
        return  "home";

    }






}
