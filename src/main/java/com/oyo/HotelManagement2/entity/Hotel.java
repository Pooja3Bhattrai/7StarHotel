package com.oyo.HotelManagement2.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotel")
public class Hotel{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer id;



@Column(name = "hotelName")
@JsonProperty("hotelName")
String hotelName;

@Column(name = "hotelAddress")
@JsonProperty("hotelAddress")
    String hotelAddress;

@Column(name = "phoneNo")
@JsonProperty("phoneNo")
String phoneNo;



    @JoinTable(
            name = "hotel_roomMapping",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    @ManyToMany
List<Room> rooms = new ArrayList<>();
}
