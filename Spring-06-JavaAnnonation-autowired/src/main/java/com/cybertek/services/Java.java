package com.cybertek.services;

import com.cybertek.interfaces.Course;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Java implements Course {


    // we can use field injection on the top of the variable
    @Autowired
    private OfficeHours officeHours;
/*
    // we should add annotation @Autowired to inject this Office hours constructor if there is more than one constructor
   @Autowired
    public Java(OfficeHours officeHours) {
       this.officeHours = officeHours;
    }
*/

    // we can you setters injection as well
   /*
   @Autowired
    public void setOfficeHours(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

    */





    @Override
    public void getTeachingHours() {
        System.out.println("teaching hours java "+ (30+ officeHours.getHours()) );
    }



}
