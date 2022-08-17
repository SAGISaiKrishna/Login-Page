package com.example.BackEnd.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Table(name="address")
@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue
    private int addressId;
    @Column(length=20)
    private String lane1;
    @Column(length=20)
    private String lane2;
    @Column(length=20)
    private String street;
    @Column(nullable = false,length=15)
    private String city;
    @Column(nullable = false,length=15)
    private String state;
    @Column(nullable = false,length=10)
    private int pinCode;
    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Employee employee;

}
