package com.example.BackEnd.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table(name="Role")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private int roleId;
    @Column(length=20,nullable = false)
    private String roleName;
    @Column(length=100,nullable=false)
    private String roleDescription;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="role")
    @JsonIgnore
    private Set<Employee> employee;
}
