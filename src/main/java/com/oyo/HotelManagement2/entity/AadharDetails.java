package com.oyo.HotelManagement2.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "aadhar_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class AadharDetails {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


@Column(name = "dob",nullable = false)
 String dob;

@Column(name = "url",nullable = false)
String url;


@OneToOne  //Adhar table me customer id in order to avoid that
@JoinColumn  //we want join column in adhar table as custId , join column works with mapped by so opposite side me comes
@JsonIgnore  //to avoid jackson recursion, addhar details me , we dont need customerkidetails
Customer customerKaDetail;
}

//jacson recursion infinite errore happens when bidirectional mapping