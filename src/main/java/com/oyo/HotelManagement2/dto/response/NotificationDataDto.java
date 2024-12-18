package com.oyo.HotelManagement2.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDataDto {

    String userEMail;
    String phoneNumber;
    String subject;
    String text;
}
