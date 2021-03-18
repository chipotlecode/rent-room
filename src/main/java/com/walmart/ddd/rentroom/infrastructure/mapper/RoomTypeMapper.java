package com.walmart.ddd.rentroom.infrastructure.mapper;

import com.walmart.ddd.rentroom.domain.model.RoomType;
import com.walmart.ddd.rentroom.infrastructure.model.RoomTypeDTO;

public class RoomTypeMapper {
    
    private RoomTypeMapper() {
        
    }

    public static RoomTypeDTO parse(RoomType roomType) {
        return new RoomTypeDTO(
            roomType.getRoomTypeId(),
            roomType.getName()
        );
    }

}
