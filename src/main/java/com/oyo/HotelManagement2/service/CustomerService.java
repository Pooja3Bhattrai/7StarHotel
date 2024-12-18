package com.oyo.HotelManagement2.service;

import com.oyo.HotelManagement2.entity.AadharDetails;
import com.oyo.HotelManagement2.entity.Customer;
import com.oyo.HotelManagement2.repository.AadharRepo;
import com.oyo.HotelManagement2.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    //adding details in repo
@Autowired
    AadharRepo aadharRepo;

    @Autowired
    CustomerRepo custrepo;

    public boolean addCustomer(Customer customer){
//since addhar table me customerId column showing null so we setCustomer in addhar then we save cusreppo
     AadharDetails aadhar = customer.getAadharKiDetails();//while getting detail so there is null value in customer
     aadhar.setCustomerKaDetail(customer); //then here In adahr table  we putting customerid or details AS a column  whatever


//     aadharRepo.save(aadhar); dont need to add adhar detail in Aadharrepo since cascading using so automatically reflect in adhar by using cascading

     custrepo.save(customer);
     return true;
    }

    public Customer getCustomer(Integer id){
        Optional<Customer> findById = custrepo.findById(id);
        if(findById.isPresent()){
            return findById.get();
        }
        else{
            return null;
        }
    }



    public List<Customer> findByEmail(String email) {

      return custrepo.findByEmail(email);


    }
}
