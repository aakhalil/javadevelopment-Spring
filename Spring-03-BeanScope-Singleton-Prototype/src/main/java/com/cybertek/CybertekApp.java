package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {

    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

       // Course course = new Java(); // not good becasue we can use Spring beans
        //we dont need to cast down , we use the method below ( "java" , Course.class)

       Course course1=  container.getBean("java",Course.class);

       Course course2= container.getBean("java", Course.class);

        System.out.println("Pointing to the same object:" + (course1 == course2));

        System.out.println("Memory Location for the course1:" + course1);

        System.out.println("Memory Location for the course1:" + course2);


        /*
        Pointing to the same object:false
Memory Location for the course1:com.com.cybertek.services.Java@7e6f74c
Memory Location for the course1:com.com.cybertek.services.Java@dd05255
         */










    }
}
