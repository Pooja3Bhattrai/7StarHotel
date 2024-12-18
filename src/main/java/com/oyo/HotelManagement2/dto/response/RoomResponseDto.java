package com.oyo.HotelManagement2.dto.response;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDto {


    private Integer room_id;

    private String roomType;

    private Integer roomCapacity;

    private Boolean roomAvailable;

    private String amenities;

}
