package com.oyo.HotelManagement2.service;

import com.oyo.HotelManagement2.dto.response.NotificationDataDto;
import com.oyo.HotelManagement2.interfaces.NotificationService;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Primary
@Component
 public class EmailNotificationService implements NotificationService {


    @Autowired
    private JavaMailSender javaMailSender;



    @Override
    @Async
    public void sendNotification(NotificationDataDto notificationdatadto) {
System.out.println("hi email notified");

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(notificationdatadto.getSubject());
        simpleMailMessage.setText(notificationdatadto.getText());
        simpleMailMessage.setTo(notificationdatadto.getUserEMail());
      javaMailSender.send(simpleMailMessage);
    }
}
