package com.oyo.HotelManagement2.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "roomType")
     String roomType;

@Column(name = "roomCapacity",nullable = false)
Integer roomCapacity;


    @Column(name = "roomAvailable")
     Boolean roomAvailable;

    @Column(name = "amenities")
String amenities;


@ManyToMany(mappedBy = "rooms")
@JsonIgnore //to avoid jackson recursion infinite,mean Room me hotel ki details naa aaye
 List<Hotel> hotels = new ArrayList<>();

}
