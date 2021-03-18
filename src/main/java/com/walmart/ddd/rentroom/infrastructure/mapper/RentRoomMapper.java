package com.walmart.ddd.rentroom.infrastructure.mapper;

import com.walmart.ddd.rentroom.domain.model.RentRoom;
import com.walmart.ddd.rentroom.infrastructure.model.RentRoomDTO;

public class RentRoomMapper {

    private RentRoomMapper() {

    }
    
    public static RentRoomDTO parse(RentRoom rentRoom) {
        return new RentRoomDTO(
            rentRoom.getRentId(),
            rentRoom.getCheckInDate(), 
            rentRoom.getCheckOutDate(), 
            rentRoom.getTotalPrice(), 
            RoomMapper.parse(rentRoom.getRoom()), 
            RentTypeMapper.parse(rentRoom.getRentType()), 
            PaymentTypeMapper.parse(rentRoom.getPaymentType()),
            PersonMapper.parse(rentRoom.getPerson())
        );
    }

}
