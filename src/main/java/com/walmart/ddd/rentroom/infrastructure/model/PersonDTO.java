package com.walmart.ddd.rentroom.infrastructure.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class PersonDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long personId;
    private String firstName;
    private String lastName;
    private String email;
    private String rfc;

    public PersonDTO() {
        
    }

    public PersonDTO(Long personId, String firstName, String lastName, String email, String rfc) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rfc = rfc;
    }

}
