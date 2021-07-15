package com.dio.gft.personmanager.domain.repository;

import com.dio.gft.personmanager.domain.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
