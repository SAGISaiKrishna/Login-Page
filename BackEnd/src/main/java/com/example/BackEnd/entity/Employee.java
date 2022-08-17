package com.example.BackEnd.entity;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Table(name="Employee")
@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue
    private int empId;
    @Column(length=20,nullable=false,unique = true)
    private String firstname;
    @Column(length=20,nullable=false,unique = true)
    private String lastname;
    @Email()
    @Column(nullable = false,unique = true)
    private String employeeEmail;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "addressId")
     private Address address;
//    As stated in the JPA specification under section 2.9, it's a good practice to mark the many-to-one side as the owning side.

    @ManyToOne
    @JoinColumn(name = "location_id",referencedColumnName = "locationId")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "productId")
    private ProductTeam productTeam;

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "roleId")
    private Role role;

    @Column(nullable=false)
    private String active;
}
