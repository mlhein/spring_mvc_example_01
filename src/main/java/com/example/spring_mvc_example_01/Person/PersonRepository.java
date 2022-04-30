package com.example.spring_mvc_example_01.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    // Use default CrudRepository functions only.

}