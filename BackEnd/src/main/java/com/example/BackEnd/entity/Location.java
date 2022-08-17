package com.example.BackEnd.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="Location")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue
    private int locationId;
    @Column(nullable=false,length=15)
    private String locationName;
    @Column(nullable = false,length=100)
    private String locationDescription;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="location")
    @JsonIgnore
    private Set<Employee> employee;
}
