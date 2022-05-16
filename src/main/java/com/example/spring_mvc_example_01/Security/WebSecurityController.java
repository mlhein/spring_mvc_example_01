package com.example.spring_mvc_example_01.Security;

import javax.servlet.http.HttpServletRequest;

import com.example.spring_mvc_example_01.Error.UserAlreadyExistException;
import com.example.spring_mvc_example_01.User.User;
import com.example.spring_mvc_example_01.User.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebSecurityController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/accessdenied")
    public String accessdenied() {
        return "accessdenied";
    }

    @GetMapping("/register")
    public String registerform(Model model) {
        // User get /register, creates the new User object that will back the
        // registration form, binds it, and returns – pretty straightforward.
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView register(
            @ModelAttribute("user") @Validated User user,
            HttpServletRequest request,
            Errors errors) {

        ModelAndView mav = new ModelAndView();

        try {
            User registerUser = userService.registerNewUser(user);
        } catch (UserAlreadyExistException e) {
            mav.addObject("message", "An account for that username/email already exists.");
            return mav;
        }
        return new ModelAndView("successRegister", "user", user);
    }

}
