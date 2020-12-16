package com.cybertek;


import com.cybertek.config.CybertekApConfig;
import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CybertekApp {

    public static void main(String[] args) {

       ApplicationContext container = new AnnotationConfigApplicationContext(CybertekApConfig.class);

       Course course= container.getBean("java", Course.class);

       course.getTeachingHours();

       ((AnnotationConfigApplicationContext)container).close();
        course.getTeachingHours();
        course.getTeachingHours();






    }
}
