package com.dio.gft.personmanager.api.controller;

import javax.validation.Valid;

import com.dio.gft.personmanager.api.dto.request.PersonDTO;
import com.dio.gft.personmanager.domain.model.Person;
import com.dio.gft.personmanager.domain.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    
    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Person save(@Valid @RequestBody PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }
}
