package com.walmart.ddd.rentroom.infrastructure.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class RoomDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Short roomId;

    private Short people;
    private short beds;
    private double price;
    private boolean jacuzzi;
    private boolean tv;
    private boolean wifi;
    private RoomTypeDTO roomType;
    
    public RoomDTO() {
    }

    public RoomDTO(Short people, short beds, double price, boolean jacuzzi, boolean tv, boolean wifi,
            RoomTypeDTO roomType) {
        this.people = people;
        this.beds = beds;
        this.price = price;
        this.jacuzzi = jacuzzi;
        this.tv = tv;
        this.wifi = wifi;
        this.roomType = roomType;
    }

    public RoomDTO(Short roomId, Short people, short beds, double price, boolean jacuzzi, boolean tv, boolean wifi,
            RoomTypeDTO roomType) {
        this.roomId = roomId;
        this.people = people;
        this.beds = beds;
        this.price = price;
        this.jacuzzi = jacuzzi;
        this.tv = tv;
        this.wifi = wifi;
        this.roomType = roomType;
    }

}
