package com.walmart.ddd.rentroom.infrastructure.mapper;

import com.walmart.ddd.rentroom.domain.model.Room;
import com.walmart.ddd.rentroom.infrastructure.model.RoomDTO;

public class RoomMapper {

    private RoomMapper() {

    }
    
    public static RoomDTO parse(Room room) {
        return new RoomDTO(
            room.getRoomId(),
            room.getPeople(), 
            room.getBeds(), 
            room.getPrice(), 
            room.isJacuzzi(), 
            room.isTv(), 
            room.isWifi(),
            RoomTypeMapper.parse(room.getRoomType())
        );
    }

}
