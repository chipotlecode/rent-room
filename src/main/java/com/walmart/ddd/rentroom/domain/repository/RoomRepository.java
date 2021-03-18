package com.walmart.ddd.rentroom.domain.repository;

import com.walmart.ddd.rentroom.domain.model.Room;

import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Short> {
    
}
