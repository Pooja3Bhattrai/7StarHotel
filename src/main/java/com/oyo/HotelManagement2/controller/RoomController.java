package com.oyo.HotelManagement2.controller;


import com.oyo.HotelManagement2.dto.request.RoomRequestDto;
import com.oyo.HotelManagement2.entity.Room;
import com.oyo.HotelManagement2.service.Roomservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/room")
@RestController
public class RoomController {

@Autowired
private Roomservice roomservice;



    @PostMapping("/create")

    public ResponseEntity<String> create(@RequestBody RoomRequestDto requestroomdto){
         roomservice.createRoom(requestroomdto);
return new ResponseEntity<>("Room created successfully", HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public Optional<Room> getById(@PathVariable Integer id){
        return roomservice.getRoomById(id);
    }
    @PutMapping("")
    public ResponseEntity<String> updateRoom(@PathVariable Integer id, @RequestBody RoomRequestDto requestroomdto){
        return roomservice.updateRoom(id,requestroomdto);
    }

    @GetMapping("/roomAvailable{roomAvailable}")

    public ResponseEntity<Object> getRoomAvail(@RequestParam Boolean roomAvailable){
       return  roomservice.getRoomAvail(roomAvailable);

    }
}
