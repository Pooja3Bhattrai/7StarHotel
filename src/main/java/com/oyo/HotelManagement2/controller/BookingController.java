package com.oyo.HotelManagement2.controller;


import com.oyo.HotelManagement2.dto.request.BookingRequestDto;
import com.oyo.HotelManagement2.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public void createBooking(@RequestBody BookingRequestDto bookingRequestDto){
        bookingService.createBooking(bookingRequestDto);

    }

}
