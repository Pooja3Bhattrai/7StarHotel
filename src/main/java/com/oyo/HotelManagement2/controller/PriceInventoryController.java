package com.oyo.HotelManagement2.controller;

import com.oyo.HotelManagement2.dto.request.PriceRequestDto;
import com.oyo.HotelManagement2.dto.response.PriceInventoryResponseDto;
import com.oyo.HotelManagement2.service.PriceInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/price")
public class PriceInventoryController {


    @Autowired
    private PriceInventoryService priceInventoryService;


    public List<PriceInventoryResponseDto> getPriceAndInvetoryForHotel(@RequestParam("hotelId") Integer hotelId,  @RequestParam("checkin") LocalDate checkin ) {


        return priceInventoryService.getPriceAndInvetoryForHotel(hotelId, checkin  );

    }
    @PostMapping("/add")

    public String addOrUpdatePrice(@RequestBody PriceRequestDto priceredto)
    {
        return priceInventoryService.addOrUpdatePrice(priceredto);
    }
}
