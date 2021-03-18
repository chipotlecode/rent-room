package com.walmart.ddd.rentroom.infrastructure.controller;

import com.walmart.ddd.rentroom.infrastructure.model.RentRoomDTO;
import com.walmart.ddd.rentroom.infrastructure.service.RentRoomService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/rent")
public class RentRoomController {
    
    private final RentRoomService rentRoomService;
    
    public RentRoomController(RentRoomService rentRoomService) {
        this.rentRoomService = rentRoomService;
    }

    @PostMapping
    public ResponseEntity<RentRoomDTO> rentRoom(@RequestBody RentRoomDTO rentRoomDTO) {
        return new ResponseEntity<>(
            rentRoomService.save(rentRoomDTO),
            HttpStatus.CREATED
        );
    }

    @GetMapping("/{rentRoomId}")
    public ResponseEntity<RentRoomDTO> getRentRoom(@PathVariable("rentRoomId") Long rentRoomId) {
        return new ResponseEntity<>(
            rentRoomService.getRentRoom(rentRoomId),
            HttpStatus.OK
        );
    }    

}
