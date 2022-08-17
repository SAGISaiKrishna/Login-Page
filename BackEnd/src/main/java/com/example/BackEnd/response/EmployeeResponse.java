package com.example.BackEnd.response;

import com.example.BackEnd.entity.*;
import com.example.BackEnd.request.LocationRequest;
import com.example.BackEnd.request.ProductTeamRequest;
import com.example.BackEnd.request.RoleRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeResponse {
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
