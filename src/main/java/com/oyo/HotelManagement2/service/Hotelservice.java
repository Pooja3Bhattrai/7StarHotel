package com.oyo.HotelManagement2.service;


import com.oyo.HotelManagement2.dto.request.HotelRequestdto;
import com.oyo.HotelManagement2.dto.response.HotelResponsedto;
import com.oyo.HotelManagement2.entity.Hotel;
import com.oyo.HotelManagement2.exception.HotelNotFoundException;
import com.oyo.HotelManagement2.repository.HotelRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class Hotelservice {

    @Autowired
    HotelRepository hotelRepository;



    public Boolean createHotel(HotelRequestdto requestdto) {


        Hotel hotel = convertrequesdtoHotel(requestdto);

        hotelRepository.save(hotel);


        return true;
    }


    public HotelResponsedto getHotelDetails(Integer hotelId) throws HotelNotFoundException {

        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        if (!hotel.isPresent()) {
            throw new HotelNotFoundException("Hotel is not present");
        }
        return  hotelToResponseDto(hotel.get());

    }

    public Hotel convertrequesdtoHotel(HotelRequestdto requestdto) {
        Hotel hotel = new Hotel();

    hotel.setHotelName(requestdto.getHotelName());
    hotel.setHotelAddress(requestdto.getHotelAddress());
hotel.setPhoneNo(requestdto.getPhoneNo());

        System.out.println("Hotel Name: " + hotel.getHotelName());
        System.out.println("Hotel Address: " + hotel.getHotelAddress());
        System.out.println("Phone No: " + hotel.getPhoneNo());
        return hotel;


    }
//if valid reques is not correct so we put exception handling



   public HotelResponsedto hotelToResponseDto(Hotel hotel) {

        return HotelResponsedto.builder()
                .hotelName(hotel.getHotelName())
                .hotelAddress(hotel.getHotelAddress())
                .rooms(hotel.getRooms()).build();
    }
//
//       HotelResponsedto hotelresdto = new HotelResponsedto();
//
//      hotelresdto.setHotel_name(hotel.getHotel_name());
//
//        hotelresdto.setHotel_address(hotel.getHotel_address());
//        hotelresdto.setContact(hotel.getContact());




}



// DTOs (Data Transfer Objects) are used to:
// 1. Decouple the API layer from internal domain models
// 2. Control what data is exposed to clients
// 3. Validate and format incoming data before processing
// 4. Reduce unnecessary data transfer
// 5. Version API changes without affecting the domain model