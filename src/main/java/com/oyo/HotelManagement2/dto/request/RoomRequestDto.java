package com.oyo.HotelManagement2.dto.request;


import lombok.*;

import java.util.List;

@Getter
@Setter

public class RoomRequestDto {
    private String roomType;
    private Integer roomCapacity;
    private Boolean roomAvailable;
    private String amenities;

}
