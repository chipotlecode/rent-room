package com.walmart.ddd.rentroom.infrastructure.service;

import com.walmart.ddd.rentroom.domain.repository.RoomRepository;
import com.walmart.ddd.rentroom.infrastructure.exception.NotFoundException;
import com.walmart.ddd.rentroom.infrastructure.mapper.RoomMapper;
import com.walmart.ddd.rentroom.infrastructure.model.RoomDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;

    public RoomDTO findRoomById(Short roomId) {
        return roomRepository.findById(roomId)
            .map(RoomMapper :: parse)
            .orElseThrow(() -> new NotFoundException(
                String.format("Room with ID[%s] not found", roomId)
            ));
    }

}
