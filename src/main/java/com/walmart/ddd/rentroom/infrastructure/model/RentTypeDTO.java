package com.walmart.ddd.rentroom.infrastructure.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class RentTypeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Short rentTypeId;
    private String name;

    public RentTypeDTO() {
        
    }

    public RentTypeDTO(Short rentTypeId, String name) {
        this.rentTypeId = rentTypeId;
        this.name = name;
    }

}
