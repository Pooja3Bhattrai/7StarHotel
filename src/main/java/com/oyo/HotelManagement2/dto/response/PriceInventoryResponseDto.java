package com.oyo.HotelManagement2.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Builder
public class PriceInventoryResponseDto {


    Integer hotelId;


    Integer roomId;


    Boolean  isSoldOut;


    Integer price;
    Integer roomAvailable;
    LocalDate date;

    String status;
}
