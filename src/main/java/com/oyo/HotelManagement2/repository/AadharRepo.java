package com.oyo.HotelManagement2.repository;

import com.oyo.HotelManagement2.entity.AadharDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AadharRepo extends JpaRepository<AadharDetails,Integer> {
}
