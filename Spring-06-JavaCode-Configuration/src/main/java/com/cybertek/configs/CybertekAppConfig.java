package com.cybertek.configs;


import com.cybertek.interfaces.ExtraSessions;
import com.cybertek.services.Java;
import com.cybertek.services.OfficeHours;
import com.cybertek.services.Selenium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


// in this file we need to have @Configuration and @ComponentScan("com.com.cybertek") top scan the classes in the packages

@Configuration
@ComponentScan("com.cybertek")
@PropertySource("classpath:application.properties")

public class CybertekAppConfig {


 // we add the @Bean at top of methods to creat objects beans from methods without adding @Component of top of classes

 // below Java Object needs the Office hours object that is created with the bottom method

@Bean
public Java java(){
    return new Java(extraSessions());
}

@Bean
public Selenium selenium(){
    return new Selenium();
}
/*
@Bean
public OfficeHours officeHours(){
    return  new OfficeHours();
}
*/

    @Bean
    public ExtraSessions extraSessions(){
        return new OfficeHours();
    }

}
