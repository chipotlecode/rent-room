package com.walmart.ddd.rentroom.domain.repository;

import com.walmart.ddd.rentroom.domain.model.RentType;

import org.springframework.data.repository.CrudRepository;

public interface RentTypeRepository extends CrudRepository<RentType, Short> {
    
}
