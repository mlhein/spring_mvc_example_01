package com.example.spring_mvc_example_01.Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("persons",  homeService.getAllPerson());
        return "index";
    }

}
