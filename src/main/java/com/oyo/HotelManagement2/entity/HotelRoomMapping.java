package com.oyo.HotelManagement2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "hotel_roomMapping")
@Entity
public class HotelRoomMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    @Column(name = "room_id")
    Integer roomId;

    @Column(name = "hotel_id")
    Integer hotelId;

    @Column(name = "total_rooms")
    Integer totalRooms;
}
