package com.oyo.HotelManagement2.service;

import com.oyo.HotelManagement2.dto.response.NotificationDataDto;
import com.oyo.HotelManagement2.interfaces.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppNotificationService implements NotificationService {



    @Override
    public void sendNotification(NotificationDataDto notificationdatadto) {
System.out.println("hi whats app");
    }
}
