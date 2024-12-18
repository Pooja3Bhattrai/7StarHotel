package com.oyo.HotelManagement2.controller;


import com.oyo.HotelManagement2.entity.Customer;
import com.oyo.HotelManagement2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer")
@RestController

public class CustomerController {

    @Autowired
    CustomerService customerservice;

    @PostMapping("/add")
    public Boolean add(@RequestBody Customer customer) {
        return customerservice.addCustomer(customer);

    }
@GetMapping("/{customerId}")

    public Customer getCustomer(@PathVariable Integer customerId){
        return customerservice.getCustomer(customerId);
}



    @GetMapping("/getByEmail")
    public List<Customer> getCustomerByEmail(@RequestParam("email") String email)
    {

        return customerservice.findByEmail(email);



    }
}