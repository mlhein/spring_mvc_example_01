package com.example.spring_mvc_example_01.Home;

import java.util.ArrayList;
import java.util.List;

import com.example.spring_mvc_example_01.Person.Person;
import com.example.spring_mvc_example_01.Person.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    public List<Person> getAllPerson(){

        List<Person> listPerson = new ArrayList<>();

        personRepository.findAll().forEach(listPerson::add);

        return listPerson; 

    }
}
