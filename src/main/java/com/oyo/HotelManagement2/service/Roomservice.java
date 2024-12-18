package com.oyo.HotelManagement2.service;


import com.oyo.HotelManagement2.dto.request.RoomRequestDto;
import com.oyo.HotelManagement2.dto.response.RoomResponseDto;
import com.oyo.HotelManagement2.entity.Hotel;
import com.oyo.HotelManagement2.entity.Room;
import com.oyo.HotelManagement2.repository.HotelRepository;
import com.oyo.HotelManagement2.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Roomservice {

    @Autowired
    private RoomRepository roomRepository;
@Autowired
private HotelRepository hotelRepository;


    public ResponseEntity<String> createRoom(RoomRequestDto roomdto){
        Room room = convert(roomdto);
         roomRepository.save(room);
         try{
  return new ResponseEntity<>("success hogya ji", HttpStatus.OK);

    }
         catch(Exception e){
e.printStackTrace();
return new ResponseEntity<>("failed",HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

//public Room getRoomById(Integer id){
//        Room room = roomRepository.getReferenceById(id);
//        return room;
//}

    public Room convert(RoomRequestDto roomdto){
        Room room = new Room();
        room.setRoomType(roomdto.getRoomType());
        room.setRoomCapacity(roomdto.getRoomCapacity());
        room.setRoomAvailable(roomdto.getRoomAvailable());
        room.setAmenities(roomdto.getAmenities());




return room;
    }

   public RoomResponseDto roomToresponseDto(Room room){
   return RoomResponseDto.builder()
           .roomType(room.getRoomType())
           .roomCapacity(room.getRoomCapacity())
           .roomAvailable(room.getRoomAvailable())
           .amenities(room.getAmenities())

           .build();



   }

   public ResponseEntity<Object> getRoomAvail(  Boolean roomAvailable){
       List<Room> avail = roomRepository.findByroomAvailable(roomAvailable);

       if(avail.isEmpty()){
      return  new ResponseEntity<>("No room available",HttpStatus.OK);
       }

       else{
           return new ResponseEntity<>(avail, HttpStatus.OK);
       }

    }



    public ResponseEntity<String> updateRoom(Integer id,RoomRequestDto roomRequestDto){

        Room room = roomRepository.findById(id).orElse(null);
        if(room!=null){
            room.setRoomAvailable(roomRequestDto.getRoomAvailable());
            room.setRoomType(roomRequestDto.getRoomType());
            room.setRoomCapacity(roomRequestDto.getRoomCapacity());
            room.setAmenities(roomRequestDto.getAmenities());
            return new ResponseEntity<>("Room updated successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Room not found", HttpStatus.NOT_FOUND);
        }
    }
   public Optional<Room> getRoomById(Integer id){
        return roomRepository.findById(id);
   }

}
