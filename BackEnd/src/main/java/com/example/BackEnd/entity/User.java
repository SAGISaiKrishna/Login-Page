package com.example.BackEnd.entity;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import lombok.*;

import javax.persistence.*;
@Table(name="User")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    private int userId;
    @Column(unique = true,nullable = false,length=20)
    private String username;
    @Column(nullable = false)
    @Size(min=8,max=20)
    private String password;
    @Column(unique = true,nullable = false)
    @Email()
    private String userEmail;

}
