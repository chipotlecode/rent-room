package com.walmart.ddd.rentroom.domain.repository;

import java.util.Optional;

import com.walmart.ddd.rentroom.domain.model.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    
    public Optional<Person> findByEmail(String email);

    public Optional<Person> findByRfc(String rfc);

}
