package com.oyo.HotelManagement2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "price_inventory")
@Entity
public class PriceInventoryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "hotel_id")
    Integer hotelId;

    @Column(name = "room_id")   //uss particular room id se kitne total through id we know type of room then roomavailable is considered total kitne hai uss hotel me
    Integer roomId;

    @Column(name = "price")
    Integer price;
@Column(name = "qty")
Integer qty;

@Column(name = "isSoldOut")
Boolean isSoldOut;
    @Column(name = "status")
   String status;

    @Column(name="date")
    LocalDate date;
}
