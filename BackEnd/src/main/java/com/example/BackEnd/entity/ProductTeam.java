package com.example.BackEnd.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table(name="product_team")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductTeam {
    @Id
    @GeneratedValue
    private int productId;
    @Column(nullable=false,length=15)
    private String productName;
    @Column(nullable = false,length=100)
    private String productDescription;
    @OneToMany(cascade=CascadeType.ALL,mappedBy="productTeam")
    @JsonIgnore
    private Set<Employee> employee;
}
