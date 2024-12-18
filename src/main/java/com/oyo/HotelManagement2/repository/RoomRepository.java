package com.oyo.HotelManagement2.repository;

import com.oyo.HotelManagement2.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {

 public List<Room> findByroomAvailable(Boolean roomAvailable);

}
