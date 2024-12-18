package com.oyo.HotelManagement2.repository;

import com.oyo.HotelManagement2.entity.HotelRoomMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRoomRepository extends JpaRepository<HotelRoomMapping,Integer> {

    Optional<HotelRoomMapping> findByHotelIdAndRoomId(Integer hotelId,Integer roomId);
}
