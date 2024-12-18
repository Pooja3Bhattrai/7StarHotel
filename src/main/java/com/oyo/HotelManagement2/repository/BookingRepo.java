package com.oyo.HotelManagement2.repository;

import com.oyo.HotelManagement2.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Integer> {


}
