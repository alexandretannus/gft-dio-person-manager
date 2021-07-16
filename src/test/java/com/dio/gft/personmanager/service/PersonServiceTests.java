package com.dio.gft.personmanager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static com.dio.gft.personmanager.utils.PersonUtils.createFakeDTO;
import static com.dio.gft.personmanager.utils.PersonUtils.createFakeEntity;

import com.dio.gft.personmanager.api.dto.request.PersonDTO;
import com.dio.gft.personmanager.core.config.mapper.PersonMapper;
import com.dio.gft.personmanager.domain.model.Person;
import com.dio.gft.personmanager.domain.repository.PersonRepository;
import com.dio.gft.personmanager.domain.service.PersonService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTests {
    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        //when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        Person savedPerson = personService.createPerson(personDTO);
        assertEquals(expectedSavedPerson, savedPerson);
    }
}
