package com.example.spring_mvc_example_01.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
// Specify what to do when user do a requests ['get', 'post', ...]
// Thymeleaf default a resources/templates/*.html
public class PersonController {

    @Autowired
    // Connect to business logic
    PersonService personService;

    @GetMapping("/addperson")
    public String index_of_addperson() {
        // Return the template named 'addperson'
        return "addperson";
    }

    @PostMapping("/addperson")
    public String action_of_addperson(@ModelAttribute Person person, Model model) {
        // Business logic to create a person into JPA repo.
        personService.CreatePerson(person);
        // Redirect to index or previous page.
        return "redirect:/person";
    }
}
