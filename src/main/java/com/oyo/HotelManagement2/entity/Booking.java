package com.oyo.HotelManagement2.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oyo.HotelManagement2.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import jakarta.persistence.Id;


import java.time.LocalDate;



@Table(name = "bookings")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   Integer id;

@Column(name = "hotel_id")
Integer hotelId;

@Column(name = "room_id")
Integer roomId;



@Column(name = "booking_amt")
Integer BookingAmt;


@Column(name = "check_in_date",nullable = false)
LocalDate checkInDate;


@Column(name = "check_out_date", nullable = false)
LocalDate checOutDate;

@Column(name = "noOfGuest", nullable = false)
Integer numberOfGuest;


@Column(name = "status")
String status;


@ManyToOne
@JoinColumn(name = "customer_id", nullable = false)

//customer As a foreign key in  booking table
Customer customer;
}
