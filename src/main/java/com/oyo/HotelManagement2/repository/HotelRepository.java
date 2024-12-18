package com.oyo.HotelManagement2.repository;

import com.oyo.HotelManagement2.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    Hotel findById(int hotelId);
}


//jparepository is a  spring data interface for generic crud operations on a repository for the specific type. It provides several methods out of the box for interaction with the database.
// and  @Repository annotation is a marker for any class that fulfills the role of a repository (also known as Data Access Object or DAO).
//  The repository is responsible for handling the data access logic and interacting with the database.

//Hibernate is a popular Java-based ORM (Object-Relational Mapping) framework that simplifies the interaction between Java objects and relational databases. It provides a way to map Java objects to database tables and vice versa, allowing developers to work with databases using Java code.
//The Hibernate framework provides a set of APIs and tools for performing database operations, such as creating, reading, updating, and deleting data, as well as managing database transactions and caching.
//Hibernate is commonly used in Java applications that require data persistence and object-relational mapping. It offers a flexible and powerful solution for handling database interactions and facilitating the development of database-driven applications.