package com.oyo.HotelManagement2.controller;

import com.oyo.HotelManagement2.dto.request.HotelRequestdto;
import com.oyo.HotelManagement2.dto.response.HotelResponsedto;
import com.oyo.HotelManagement2.exception.HotelNotFoundException;

import com.oyo.HotelManagement2.service.Hotelservice;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//jaxson api json to java object

@RequestMapping("/hotel")
@RestController
public class HotelController {

@Autowired
    Hotelservice hotelservice;

    @PostMapping("/create")
    public ResponseEntity<Boolean> createHotel(@RequestBody HotelRequestdto hotelRequestDto) {
        Boolean success = hotelservice.createHotel(hotelRequestDto);


        return new ResponseEntity<>(success, HttpStatus.CREATED);

    }



    @GetMapping("/")
    public ResponseEntity<HotelResponsedto> getHotelDetails(@RequestParam Integer hotelId) throws HotelNotFoundException {

        try {
            HotelResponsedto hotelResponseDto = hotelservice.getHotelDetails(hotelId);

            return new ResponseEntity<>(hotelResponseDto, HttpStatus.OK);

        } catch (RuntimeException e) {

            HotelResponsedto hotelResponseDto = new HotelResponsedto();
            hotelResponseDto.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(hotelResponseDto, HttpStatus.BAD_REQUEST);

        }


    }


}
