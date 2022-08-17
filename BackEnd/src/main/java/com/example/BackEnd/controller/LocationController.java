package com.example.BackEnd.controller;

import com.example.BackEnd.response.EmployeeResponse;
import com.example.BackEnd.response.LocationResponse;
import com.example.BackEnd.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    @Autowired
    private ILocationService locationService;
    @GetMapping("/locations")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<LocationResponse> getLocations() {
        LocationResponse response = locationService.getLocations();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
