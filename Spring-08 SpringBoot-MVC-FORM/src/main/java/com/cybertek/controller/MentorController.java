package com.cybertek.controller;

import com.cybertek.model.Mentor;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping ("/mentor")
public class MentorController {

  // write method
    @GetMapping("/register")
    public  String showForm( Model model){

        model.addAttribute("mentor", new Mentor());

        List<String> batchList = Arrays.asList("B1","B2","B3","B4","B5","B6","B7","B8","B9","B10","B11","B12");
        model.addAttribute("batchList",batchList);


        return "mentor/mentor-register";
    }

    // below method is to submit the form to new page
    @PostMapping("/confirm")
    public String  submitForm(@ModelAttribute ("mentor") Mentor NewObject ){

        System.out.println( NewObject.toString());
        return "mentor/mentor-confirmation";
    }

}
