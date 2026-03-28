package com.example.BackEnd.controller;

import com.example.BackEnd.response.ProductTeamResponse;
import com.example.BackEnd.response.RoleResponse;
import com.example.BackEnd.service.IProductTeamService;
import com.example.BackEnd.service.IRoleService;
import com.example.BackEnd.service.implement.ProductTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @GetMapping("/roles")
    @CrossOrigin(origins = "*")
    public ResponseEntity<RoleResponse> getRoles() {
        RoleResponse response = roleService.getRoles();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
