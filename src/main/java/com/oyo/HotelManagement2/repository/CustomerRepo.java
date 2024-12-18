package com.oyo.HotelManagement2.repository;

import com.oyo.HotelManagement2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepo  extends JpaRepository<Customer,Integer> {


    //     @Query(value = "select c from Customer c where c.email =:email",nativeQuery = false)

    List<Customer> findByEmail (String email);

//    findByAgeGreaterThanAndLessThan(Integer age1 ,Integer age2);
}
