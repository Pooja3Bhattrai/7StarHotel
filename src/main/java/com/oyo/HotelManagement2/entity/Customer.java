package com.oyo.HotelManagement2.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "phoneNumber")
    String phoneNumber;

//it is showing adhardetails id in table in order to remove that we use joincolumn
    @OneToOne (mappedBy = "customerKaDetail",cascade = CascadeType.ALL)
   AadharDetails aadharKiDetails;


  @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Booking> booking = new ArrayList<>();

}
//why we @joincolumn using??
// //why we use? it gives 2 column IDS like adhar and customer in customer table so in order to
//// avoid that we use, here In customer table we are only keeping single column of ID