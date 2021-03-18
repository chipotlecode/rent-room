package com.walmart.ddd.rentroom.infrastructure.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class RentRoomDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long rentId;
    
    private Date checkInDate;

    private Date checkOutDate;

    private double totalPrice;
    private RoomDTO room;
    private RentTypeDTO rentType;
    private PaymentTypeDTO paymentType;
    private PersonDTO person;

    public RentRoomDTO(Long rentId, Date checkInDate, Date checkOutDate, double totalPrice, RoomDTO room,
            RentTypeDTO rentType, PaymentTypeDTO paymentType, PersonDTO person) {
        this.rentId = rentId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.room = room;
        this.rentType = rentType;
        this.paymentType = paymentType;
        this.person = person;
    }

}
