package com.oyo.HotelManagement2.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.oyo.HotelManagement2.entity.Room;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor

public class HotelResponsedto {

    String errorMessage;
    String hotelName;
    String hotelAddress;
    String phoneNo;

    List<Room> rooms;

}
