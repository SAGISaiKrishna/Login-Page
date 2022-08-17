package com.example.BackEnd.request;

import com.example.BackEnd.entity.Address;
import com.example.BackEnd.entity.Location;
import com.example.BackEnd.entity.ProductTeam;
import com.example.BackEnd.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class EmployeeRequest implements Serializable{
    private int empId;
    private String firstname;
    private String lastname;
    private String employeeEmail;
    private Address address;
    private Location location;
    private ProductTeam productTeam;
    private Role role;
    private String active;
}
