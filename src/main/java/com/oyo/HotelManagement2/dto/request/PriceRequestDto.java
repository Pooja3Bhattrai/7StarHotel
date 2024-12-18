package com.oyo.HotelManagement2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequestDto {

    Integer hotelId;
    Integer roomId;
    Integer price;
    Integer qty;
Boolean isSoldOut;
    LocalDate date;
}
