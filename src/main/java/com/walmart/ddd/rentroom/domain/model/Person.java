package com.walmart.ddd.rentroom.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PERSON")
@Data
public class Person implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    private String firstName;
    private String lastName;
    
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String rfc;

    public Person() {
        
    }

    public Person(Long personId, String firstName, String lastName, String email, String rfc) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rfc = rfc;
    }

}
