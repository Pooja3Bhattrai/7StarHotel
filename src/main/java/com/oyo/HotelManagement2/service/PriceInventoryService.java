package com.oyo.HotelManagement2.service;


import com.oyo.HotelManagement2.dto.request.PriceRequestDto;
import com.oyo.HotelManagement2.dto.response.PriceInventoryResponseDto;
import com.oyo.HotelManagement2.entity.Hotel;
import com.oyo.HotelManagement2.entity.PriceInventoryDetails;

import com.oyo.HotelManagement2.repository.PriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Component
public class PriceInventoryService {

    @Autowired
    private PriceRepo pricerepo;

//    /**
//     * Updates the inventory by decreasing the available rooms for the given hotel and date.
//     *
//     * @param hotelId  the ID of the hotel
//     * @param date     the date for which inventory needs to be updated
//     * @param quantity the number of rooms to decrease
//     */




    public void updateInventory(PriceRequestDto priceRequestDto, boolean isBookingCreated) {
        if (priceRequestDto.getQty() == null || priceRequestDto.getQty() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        if (isBookingCreated) {
            // Decrease inventory when a booking is created
            int rowsUpdated = pricerepo.decreaseInventory(
                    priceRequestDto.getHotelId(),
                    priceRequestDto.getDate(),
                    priceRequestDto.getQty()
            );

            if (rowsUpdated == 0) {
                throw new IllegalArgumentException("Insufficient inventory for hotelId: "
                        + priceRequestDto.getHotelId() + " on date: " + priceRequestDto.getDate());
            }
        } else {
            // Increase inventory when a booking is canceled
            pricerepo.increaseInventory(
                    priceRequestDto.getHotelId(),
                    priceRequestDto.getDate(),
                    priceRequestDto.getQty()
            );
        }
    }


    public List<PriceInventoryResponseDto> getAvailableHotelsByMinPrice(List<Hotel> hotelList, LocalDate checkin) {
        // Implementation not provided
        return null;
    }

    public List<PriceInventoryResponseDto> getPriceAndInvetoryForHotel(Integer hotelId, LocalDate checkin) {
        List<PriceInventoryResponseDto> priceInventoryResponseDtoList = new ArrayList<>();
        List<PriceInventoryDetails> priceInventoryDetails = pricerepo.findByHotelIdAndDate(hotelId, checkin);
        for (PriceInventoryDetails priceInventoryDetail : priceInventoryDetails) {
            PriceInventoryResponseDto responseDto = convertpriceInventoryDetailsToPriceInventoryResponseDto(priceInventoryDetail);
            priceInventoryResponseDtoList.add(responseDto);
        }
        return priceInventoryResponseDtoList;
    }



    private PriceInventoryResponseDto convertpriceInventoryDetailsToPriceInventoryResponseDto(PriceInventoryDetails priceInventoryDetail) {
        Boolean isSoldOut = isHotelSoldOut(priceInventoryDetail.getQty());
        return PriceInventoryResponseDto.builder()
                .isSoldOut(isSoldOut)
                .price(priceInventoryDetail.getPrice())
                .date(priceInventoryDetail.getDate())
                .build();
    }


    private Boolean isHotelSoldOut(Integer availableRooms) {
        return availableRooms <= 0;
    }



    public String addOrUpdatePrice(PriceRequestDto priceRequestDto) {
        // Check if a record already exists for the given hotel, room, and date
        PriceInventoryDetails existingDetails = pricerepo
                .findByHotelIdAndRoomIdAndDate(priceRequestDto.getHotelId(), priceRequestDto.getRoomId(), priceRequestDto.getDate())
                .stream()
                .findFirst()
                .orElse(null);

        if (existingDetails != null) {
            // Update existing record
            existingDetails.setPrice(priceRequestDto.getPrice());
            existingDetails.setQty(existingDetails.getQty()+ priceRequestDto.getQty());
            return "updated";
        } else {
            // Create a new record
            existingDetails = new PriceInventoryDetails();
            existingDetails.setHotelId(priceRequestDto.getHotelId());
            existingDetails.setRoomId(priceRequestDto.getRoomId());
            existingDetails.setPrice(priceRequestDto.getPrice());
            existingDetails.setQty(priceRequestDto.getQty());
            existingDetails.setDate(priceRequestDto.getDate());
            existingDetails.setStatus("ACTIVE");

        }

        // Save the updated or new entity to the database
        PriceInventoryDetails savedDetails = pricerepo.save(existingDetails);

        // Convert to response DTO and return
        return "added";
    }


}

