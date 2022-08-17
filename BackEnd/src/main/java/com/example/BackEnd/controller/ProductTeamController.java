package com.example.BackEnd.controller;

import com.example.BackEnd.response.LocationResponse;
import com.example.BackEnd.response.ProductTeamResponse;
import com.example.BackEnd.service.ILocationService;
import com.example.BackEnd.service.IProductTeamService;
import com.example.BackEnd.service.implement.ProductTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductTeamController {
    @Autowired
    private IProductTeamService productTeamService;
    @GetMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ProductTeamResponse> getProductTeams() {
        ProductTeamResponse response = productTeamService.getProductTeams();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
