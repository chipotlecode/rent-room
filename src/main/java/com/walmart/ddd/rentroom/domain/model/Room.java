package com.walmart.ddd.rentroom.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ROOM")
@Data
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short roomId;

    private Short people;
    private short beds;
    private double price;
    private boolean jacuzzi;
    private boolean tv;
    private boolean wifi;
    
    @ManyToOne
    private RoomType roomType;
    
}
