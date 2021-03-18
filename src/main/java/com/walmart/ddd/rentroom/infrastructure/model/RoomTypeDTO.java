package com.walmart.ddd.rentroom.infrastructure.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class RoomTypeDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Short roomTypeId;
    private String name;
    
    public RoomTypeDTO() {
    }

    public RoomTypeDTO(Short roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public RoomTypeDTO(Short roomTypeId, String name) {
        this.roomTypeId = roomTypeId;
        this.name = name;
    }

}
