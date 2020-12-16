package com.cybertek.controller;

import com.cybertek.enums.Gender;
import com.cybertek.model.Mentor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//go to page  http://localhost:8080/mentor/list

@Component
@RequestMapping ("/mentor")
public class MentorController {

    @GetMapping("/list")
    public  String showTable(Model model){

        List<Mentor> mentorList = new ArrayList<>();

        mentorList.add(new Mentor("Mike" , "Smith" ,65,  Gender.MALE));
        mentorList.add(new Mentor("Pla" , "Sumer" ,45,  Gender.FEMALE));
        mentorList.add(new Mentor("sika" , "Jeen" ,22,  Gender.NA));
        mentorList.add(new Mentor("james" , "sweet" ,14,  Gender.NA));

        model.addAttribute("instructors", mentorList);

        return  "mentor/mentor-list";

    }


}
