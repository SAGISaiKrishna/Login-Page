package com.example.BackEnd.controller;

import com.example.BackEnd.entity.User;
import com.example.BackEnd.request.UserRequest;
import com.example.BackEnd.response.UserNameResponse;
import com.example.BackEnd.response.UserResponse;
import com.example.BackEnd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<String>> getUsers(){
        List<String> response=userService.getUsers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping(value = "/user")
    @CrossOrigin(origins = "*")
    public ResponseEntity<UserResponse> compareUser(@RequestBody UserRequest userRequest) throws Exception {
        UserResponse response = userService.compareUser(userRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PostMapping(value = "/users")
    @CrossOrigin(origins = "*")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest) throws Exception {
        UserResponse response = userService.saveUser(userRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest) {
        UserResponse response = userService.updateUser(userRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }







}
