package com.walmart.ddd.rentroom.infrastructure.mapper;

import com.walmart.ddd.rentroom.domain.model.Person;
import com.walmart.ddd.rentroom.infrastructure.model.PersonDTO;

public class PersonMapper {
    
    private PersonMapper() {

    }

    public static PersonDTO parse(Person person) {
        return new PersonDTO(
            person.getPersonId(), 
            person.getFirstName(),
            person.getLastName(),
            person.getEmail(),
            person.getRfc()
        );
    }

    public static Person parse(PersonDTO personDto) {
        return new Person(
            personDto.getPersonId(), 
            personDto.getFirstName(),
            personDto.getLastName(),
            personDto.getEmail(),
            personDto.getRfc()
        );
    }

}
