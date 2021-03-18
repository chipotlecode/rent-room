package com.walmart.ddd.rentroom.infrastructure.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class PaymentTypeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Short paymentTypeId;
    private String name;
    
    public PaymentTypeDTO() {
        
    }
    
    public PaymentTypeDTO(Short paymentTypeId, String name) {
        this.paymentTypeId = paymentTypeId;
        this.name = name;
    }
}
