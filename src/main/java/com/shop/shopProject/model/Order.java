package com.shop.shopProject.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;


//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private String user;


//    @JsonManagedReference
//    @OneToMany(mappedBy = "pk.order")
//    @Valid
//    private List orderProducts = new ArrayList<>();

//    @Transient
//    public Double getTotalOrderPrice() {
//        double sum = 0D;
//        List orderProducts = getOrderProducts();
//        for (OrderProduct op : orderProducts) {
//            sum += op.getTotalPrice();
//        }
//        return sum;
//    }


    private String firstname;

    private String lastname;

    private String city;

    private String region;

    private String address;

    private String telephone;

    private String email;

    private String information;

    private Date date;

    private Integer quantity;

//    private int quantity;
//
//    public void  increaseQuantity() {
//        this.quantity++;
//    }
//
//    public void  decreaseQuantity() {
//        if(this.quantity>1) {
//            this.quantity--;
//        }
//    }

    public Order(String firstname, String lastname, String city, String region, String address, String telephone, String email, String information, Date date, Integer quantity) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.region = region;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.information = information;
        this.date = date;
        this.quantity = quantity;

    }

    public Order() {
    }

}
