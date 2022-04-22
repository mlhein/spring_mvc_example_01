package com.example.spring_mvc_example_01.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// All business logics should be defined in @Service annotation
public class PersonService {

    // Access to JPA repo
    @Autowired
    PersonRepository personRepository;

    // Create a person and add to JPA repo
    public void CreatePerson(Person person){
        personRepository.save(person);
    }
    
}
