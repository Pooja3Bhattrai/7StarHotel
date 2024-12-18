package com.oyo.HotelManagement2.repository;

import com.oyo.HotelManagement2.entity.PriceInventoryDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface PriceRepo extends JpaRepository<PriceInventoryDetails,Integer> {


    // Find inventory details by hotel ID and date
    List<PriceInventoryDetails> findByHotelIdAndDate(Integer hotelId, LocalDate date);

    List<PriceInventoryDetails> findByHotelIdAndRoomIdAndDate(Integer hotelId, Integer roomId, LocalDate date);

    // Custom query to decrease the inventory
    @Transactional
    @Modifying
    @Query("UPDATE PriceInventoryDetails p SET p.qty = p.qty- :quantity WHERE p.hotelId = :hotelId AND p.date = :date AND p.qty >= :quantity")
    int decreaseInventory(Integer hotelId, LocalDate date, int quantity);

    // Custom query to increase the inventory
    @Transactional
    @Modifying
    @Query("UPDATE PriceInventoryDetails p SET p.qty = p.qty+ :quantity WHERE p.hotelId = :hotelId AND p.date = :date")
    int increaseInventory(Integer hotelId, LocalDate date, int quantity);




}
