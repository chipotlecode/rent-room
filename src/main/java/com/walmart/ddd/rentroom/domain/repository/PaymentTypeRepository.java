package com.walmart.ddd.rentroom.domain.repository;

import com.walmart.ddd.rentroom.domain.model.PaymentType;

import org.springframework.data.repository.CrudRepository;

public interface PaymentTypeRepository extends CrudRepository<PaymentType, Short> {
    
}
