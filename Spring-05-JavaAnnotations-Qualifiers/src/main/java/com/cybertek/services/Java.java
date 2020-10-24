package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

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
