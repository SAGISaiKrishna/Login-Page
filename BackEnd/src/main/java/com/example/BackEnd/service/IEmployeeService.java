package com.example.BackEnd.service;

import com.example.BackEnd.request.EmployeeRequest;
import com.example.BackEnd.response.EmployeeNameResponse;
import com.example.BackEnd.response.EmployeeResponse;
import com.example.BackEnd.response.UserResponse;

import java.util.List;

public interface IEmployeeService {
    void saveEmployee(EmployeeRequest employeeRequest);

    EmployeeNameResponse getEmployees();

    EmployeeResponse getEmployee(int id);

    List<EmployeeResponse> getAllEmployees();

    void updateEmployee(EmployeeRequest employeeRequest);

    EmployeeNameResponse deleteEmployee(int employeeRequest);
}
