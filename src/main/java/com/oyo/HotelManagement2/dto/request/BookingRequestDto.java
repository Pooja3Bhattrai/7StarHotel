package com.oyo.HotelManagement2.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class BookingRequestDto {


    Integer hotelId;

    Integer roomId;

    LocalDate checkin;

    LocalDate checkout;
    Integer customerId;

    Integer numberOfGuest;
    Integer bookingAmount;
}
