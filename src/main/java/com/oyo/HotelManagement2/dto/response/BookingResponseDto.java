package com.oyo.HotelManagement2.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDto {

    Integer BookingId;
Boolean isSoldOut;
    String status;
}
