package com.oyo.HotelManagement2.service;

import com.oyo.HotelManagement2.entity.HotelRoomMapping;
import com.oyo.HotelManagement2.repository.HotelRepository;
import com.oyo.HotelManagement2.repository.HotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class HotelRoomMappService {

    @Autowired
    HotelRoomRepository hotelRoomRepository;

    public void addHotelRoomMapping(Integer hotelId, Integer roomId, Integer totalRooms) {
        // Validate data
        if (hotelId == null || roomId == null || totalRooms <= 0) {
            throw new IllegalArgumentException("Hotel ID, Room ID, and Total Rooms must be valid.");
        }

        // Check if a mapping already exists
        Optional<HotelRoomMapping> existingMapping = hotelRoomRepository
                .findByHotelIdAndRoomId(hotelId,roomId);

        if (existingMapping.isPresent()) {
            // Update total rooms
            HotelRoomMapping mapping = existingMapping.get();
            mapping.setTotalRooms(mapping.getTotalRooms() + totalRooms);
            hotelRoomRepository.save(mapping);
        } else {
            // Create a new mapping
            HotelRoomMapping newMapping = new HotelRoomMapping();
            newMapping.setHotelId(hotelId);
            newMapping.setRoomId(roomId);
            newMapping.setTotalRooms(totalRooms);
            hotelRoomRepository.save(newMapping);
        }
    }

}
