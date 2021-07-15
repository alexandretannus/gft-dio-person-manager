package com.dio.gft.personmanager.domain.service;

import com.dio.gft.personmanager.domain.model.Person;
import com.dio.gft.personmanager.domain.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

}
