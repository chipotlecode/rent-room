package com.walmart.ddd.rentroom.domain.repository;

import com.walmart.ddd.rentroom.domain.model.RoomType;

import org.springframework.data.repository.CrudRepository;

public interface RoomTypeRepository extends CrudRepository<RoomType, Short> {
    
}
