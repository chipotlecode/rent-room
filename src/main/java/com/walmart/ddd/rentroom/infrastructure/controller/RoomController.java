package com.walmart.ddd.rentroom.infrastructure.controller;

import com.walmart.ddd.rentroom.infrastructure.model.RoomDTO;
import com.walmart.ddd.rentroom.infrastructure.service.RoomService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDTO> findById(@PathVariable("roomId") Short roomId) {
        return new ResponseEntity<>(
            roomService.findRoomById(roomId),
            HttpStatus.OK
        );
    }

}
