package com.example.BackEnd.service;

import com.example.BackEnd.entity.User;
import com.example.BackEnd.request.UserRequest;
import com.example.BackEnd.response.UserNameResponse;
import com.example.BackEnd.response.UserResponse;

import java.util.List;

public interface IUserService {
         List<String> getUsers();

    UserResponse compareUser(UserRequest userRequest) throws Exception;

    UserResponse saveUser(UserRequest userRequest) throws Exception;
    UserResponse updateUser(UserRequest userRequest);



}
