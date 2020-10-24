package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Java implements Course {

    @Value("JD1") // hard code value
    private String batch ;

    @Value("${instructor}")
    private String instructor;

    @Value("${days}")
    private String [] days;



    @Override
    public String toString() {
        return "Java{" +
                "batch='" + batch + '\'' +
                ", instructor='" + instructor + '\'' +
                ", days=" + Arrays.toString(days) +
                '}';
    }

    // @Autowired
   // @Qualifier("officeHours") // injection qualifier in the field
    private ExtraSessions extraSessions;



   // @Autowired
    // using @Qualifier inside the constructor
    public Java(@Qualifier("mockInterviewHours") ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("weekly hours: " + (30  + extraSessions.getHours()));
    }
}
