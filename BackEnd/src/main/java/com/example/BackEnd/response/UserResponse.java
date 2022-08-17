package com.example.BackEnd.response;

import com.example.BackEnd.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int userId;
    private String username;
    private String password;
    private String userEmail;
}