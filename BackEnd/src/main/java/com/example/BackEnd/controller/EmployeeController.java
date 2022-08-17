package com.example.BackEnd.controller;


import com.example.BackEnd.request.EmployeeRequest;
import com.example.BackEnd.response.EmployeeNameResponse;
import com.example.BackEnd.response.EmployeeResponse;
import com.example.BackEnd.service.IEmployeeService;
import com.example.BackEnd.service.implement.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @PostMapping(value = "/employees/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public void saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
         employeeService.saveEmployee(employeeRequest);
    }
    @GetMapping("/employees")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        List<EmployeeResponse> response = employeeService.getAllEmployees();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/employ/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable("id") int id) {
        EmployeeResponse response = employeeService.getEmployee(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/employee")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<EmployeeNameResponse> getEmployees(){
        EmployeeNameResponse response= employeeService.getEmployees();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping(value= "/employees/edit")
    @CrossOrigin(origins = "http://localhost:4200")
    public void updateEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.updateEmployee(employeeRequest);
    }
    @DeleteMapping(value = "/employees/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<EmployeeNameResponse> deleteEmployee(@PathVariable("id") int id) {
        EmployeeNameResponse response = employeeService.deleteEmployee(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
