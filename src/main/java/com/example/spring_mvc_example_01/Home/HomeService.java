package com.example.spring_mvc_example_01.Home;

import java.util.ArrayList;
import java.util.List;

import com.example.spring_mvc_example_01.Person.Person;
import com.example.spring_mvc_example_01.Person.PersonRepository;
import com.example.spring_mvc_example_01.User.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    public List<Person> getAllPerson() {

        List<Person> listPerson = new ArrayList<>();

        personRepository.findAll().forEach(listPerson::add);

        return listPerson;
    }

    public boolean isLoggedIn() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getName() != null)
            return true;
        return false;
    }

    public boolean isLoggedIn(User user) {
        if (user != null)
            return true;
        return false;
    }

}
