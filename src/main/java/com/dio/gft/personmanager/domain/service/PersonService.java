package com.dio.gft.personmanager.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import com.dio.gft.personmanager.api.dto.request.PersonDTO;
import com.dio.gft.personmanager.api.exception.PersonNotFoundException;
import com.dio.gft.personmanager.core.config.mapper.PersonMapper;
import com.dio.gft.personmanager.domain.model.Person;
import com.dio.gft.personmanager.domain.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public Person createPerson(PersonDTO personDTO) {
        
        return personRepository.save(personMapper.toModel(personDTO));
    }

    public List<PersonDTO> listAll() {
        List<Person> people = personRepository.findAll();
        return people.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }


    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = findPersonOrFail(id);

        return personMapper.toDTO(person);
    }

 
    public void delete(Long id) throws PersonNotFoundException {
        try {
            personRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new PersonNotFoundException(id);
        }
    }


    private Person findPersonOrFail(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                    .orElseThrow(() -> new PersonNotFoundException(id));
    }
    
    public Person update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        findPersonOrFail(id);

        System.out.println("\n\n------");
        System.out.println(personDTO.toString());
        System.out.println("\n\n------");

        Person updatedPerson = personMapper.toModel(personDTO);
        System.out.println("\n\n------");
        System.out.println(updatedPerson.toString());
        System.out.println("\n\n------");

        Person savedPerson = personRepository.save(updatedPerson);

        return savedPerson;
    }

}
