package com.shop.shopProject.DTO;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class orderDTO {


    private Integer id;

    private String firstname;

    private String lastname;

    private String city;

    private String region;

    private String address;

    private String telephone;

    private String email;

    private String information;




}
