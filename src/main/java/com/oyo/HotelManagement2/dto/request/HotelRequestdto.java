package com.oyo.HotelManagement2.dto.request;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class HotelRequestdto {


    private String hotelName;
    private String hotelAddress;
    private String phoneNo;
    private Boolean status;
}
