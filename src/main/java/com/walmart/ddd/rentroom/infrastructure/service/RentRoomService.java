package com.walmart.ddd.rentroom.infrastructure.service;

import java.util.Date;
import java.util.Optional;

import com.walmart.ddd.rentroom.domain.model.PaymentType;
import com.walmart.ddd.rentroom.domain.model.Person;
import com.walmart.ddd.rentroom.domain.model.RentRoom;
import com.walmart.ddd.rentroom.domain.model.RentType;
import com.walmart.ddd.rentroom.domain.model.Room;
import com.walmart.ddd.rentroom.domain.repository.PaymentTypeRepository;
import com.walmart.ddd.rentroom.domain.repository.PersonRepository;
import com.walmart.ddd.rentroom.domain.repository.RentRoomRepository;
import com.walmart.ddd.rentroom.domain.repository.RentTypeRepository;
import com.walmart.ddd.rentroom.domain.repository.RoomRepository;
import com.walmart.ddd.rentroom.infrastructure.exception.ApiException;
import com.walmart.ddd.rentroom.infrastructure.exception.NotFoundException;
import com.walmart.ddd.rentroom.infrastructure.helper.RentRoomHelper;
import com.walmart.ddd.rentroom.infrastructure.mapper.PersonMapper;
import com.walmart.ddd.rentroom.infrastructure.mapper.RentRoomMapper;
import com.walmart.ddd.rentroom.infrastructure.model.PersonDTO;
import com.walmart.ddd.rentroom.infrastructure.model.RentRoomDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentRoomService {
    
    private final RentRoomRepository rentRoomRepository;
    private final RoomRepository roomRepository;
    private final RentTypeRepository rentTypeRepository;
    private final PaymentTypeRepository paymentTypeRepository;
    private final PersonRepository personRepository;

    public RentRoomService(RentRoomRepository rentRoomRepository, RoomRepository roomRepository,
            RentTypeRepository rentTypeRepository, PaymentTypeRepository paymentTypeRepository,
            PersonRepository personRepository) {
        this.rentRoomRepository = rentRoomRepository;
        this.roomRepository = roomRepository;
        this.rentTypeRepository = rentTypeRepository;
        this.paymentTypeRepository = paymentTypeRepository;
        this.personRepository = personRepository;
    }

    public RentRoomDTO getRentRoom(Long rentRoomId) {
        return rentRoomRepository.findById(rentRoomId)
            .map(RentRoomMapper :: parse)
            .orElseThrow(() -> new NotFoundException(
                String.format("Rent Room with ID[%s] doesn't exist", rentRoomId)
            ));
    }

    @Transactional(readOnly = false)
    public RentRoomDTO save(RentRoomDTO rentRoomDto) {
        checkIsRoomAvailable(rentRoomDto.getRoom().getRoomId(), rentRoomDto.getCheckInDate(), rentRoomDto.getCheckOutDate());

        RentRoom newRentRoom = createRentRoom(rentRoomDto);

        rentRoomRepository.save(newRentRoom);

        if(newRentRoom.getRentId() == null) {
            throw new ApiException("It wasn't possible to save the Rent Room, please try again");
        }
        
        return RentRoomMapper.parse(newRentRoom);
    }

    private void checkIsRoomAvailable(Short roomId, Date checkInDate, Date checkOutDate) {
        Optional<RentRoom> rentRoom = rentRoomRepository.findByRoomAndCheckInDateOrCheckOutDate(roomId, checkInDate, checkOutDate);

        if(rentRoom.isPresent()) {
            throw new ApiException(
                String.format("Room [%s] is not available from [%s] to [%s]", roomId, checkInDate, checkOutDate)
            );
        }            
    }

    private RentRoom createRentRoom(RentRoomDTO rentRoomDto) {
        Room room = findRoom(rentRoomDto.getRoom().getRoomId());
        RentType rentType = findRentType(rentRoomDto.getRentType().getRentTypeId());
        PaymentType paymentType = findPaymentType(rentRoomDto.getPaymentType().getPaymentTypeId());
        Person person = findPerson(rentRoomDto.getPerson());
        
        double totalPrice = RentRoomHelper.getTotalPrice(
            room.getPrice(),
            rentRoomDto.getCheckInDate(),
            rentRoomDto.getCheckOutDate()
        );

        return new RentRoom(
            rentRoomDto.getCheckInDate(),
            rentRoomDto.getCheckOutDate(),
            totalPrice,
            room,
            rentType,
            paymentType,
            person
        );
    }

    private Room findRoom(Short roomId) {
        return roomRepository.findById(roomId)
            .orElseThrow(() -> new ApiException(
                String.format("The fucking Room[%s] doesn't exist", roomId)
            ));
    }

    private RentType findRentType(Short rentTypeId) {
        return rentTypeRepository.findById(rentTypeId)
            .orElseThrow(() -> new ApiException(
                String.format("The fucking Rent Type[%s] doesn't exist", rentTypeId)
            ));
    }

    private PaymentType findPaymentType(Short paymentTypeId) {
        return paymentTypeRepository.findById(paymentTypeId)
            .orElseThrow(() -> new ApiException(
                String.format("The fucking Payment Type[%s] doesn't exist", paymentTypeId)
            ));
    }

    private Person findPerson(PersonDTO personDto) {
        // First It searches by Email
        return personRepository.findByEmail(personDto.getEmail()).orElseGet(() -> 
            // If the person is not registered by email, it searches by rfc
            personRepository.findByRfc(personDto.getRfc()).orElseGet(() -> {
                // If the person is not registered, it registers a new entry
                Person newPerson = PersonMapper.parse(personDto);
        
                return personRepository.save(newPerson);        
            })
        );
    }

}
