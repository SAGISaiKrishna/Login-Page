package com.example.BackEnd.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class UserRequest implements Serializable {

    private int userId;
    private String username;
    private String password;
    private String userEmail;
}