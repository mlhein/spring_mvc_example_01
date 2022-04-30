package com.example.spring_mvc_example_01.Home;

import com.example.spring_mvc_example_01.User.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("loggedin", homeService.isLoggedIn(user));
        return "index";
    }

    @GetMapping("/person")
    public String person(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("persons", homeService.getAllPerson());
        model.addAttribute("user", user);
        return "person";
    }

}
