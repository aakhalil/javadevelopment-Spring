package com.cybertek.configs;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// in this file we need to have @Configuration and @ComponentScan("com.cybertek") top scan the classes in the packages

@Configuration
@ComponentScan("com.cybertek")
public class CybertekAppConfig {


}
