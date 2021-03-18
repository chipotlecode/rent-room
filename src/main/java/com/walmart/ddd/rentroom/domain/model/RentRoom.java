package com.walmart.ddd.rentroom.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "RENT_ROOM")
@Data
public class RentRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentId;

    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;

    @ManyToOne
    private Room room;

    @ManyToOne
    private RentType rentType;

    @ManyToOne
    private PaymentType paymentType;

    @ManyToOne
    private Person person;

    public RentRoom() {
    }

    public RentRoom(Date checkInDate, Date checkOutDate, double totalPrice, Room room, RentType rentType,
            PaymentType paymentType, Person person) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.room = room;
        this.rentType = rentType;
        this.paymentType = paymentType;
        this.person = person;
    }
    
}
