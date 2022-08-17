package com.example.BackEnd.service.implement;
import com.example.BackEnd.entity.Address;
import com.example.BackEnd.entity.Employee;
import com.example.BackEnd.entity.User;
import com.example.BackEnd.repository.EmployeeRepository;
import com.example.BackEnd.repository.LocationRepository;
import com.example.BackEnd.repository.ProductTeamRepository;
import com.example.BackEnd.repository.RoleRepository;
import com.example.BackEnd.request.EmployeeRequest;
import com.example.BackEnd.request.UserRequest;
import com.example.BackEnd.response.EmployeeNameResponse;
import com.example.BackEnd.response.EmployeeResponse;
import com.example.BackEnd.response.UserResponse;
import com.example.BackEnd.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeService implements IEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ProductTeamRepository productTeamRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Override
    public void saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setFirstname(employeeRequest.getFirstname());
        employee.setLastname(employeeRequest.getLastname());
        employee.setEmployeeEmail(employeeRequest.getEmployeeEmail());
        employee.setRole(roleRepository.findByRoleName(employeeRequest.getRole().getRoleName()));
        employee.setProductTeam(productTeamRepository.findByProductName(employeeRequest.getProductTeam().getProductName()));
        employee.setLocation(locationRepository.findByLocationName(employeeRequest.getLocation().getLocationName()));
        Address address = new Address();
        address.setLane1(employeeRequest.getAddress().getLane1());
        address.setLane2(employeeRequest.getAddress().getLane2());
        address.setStreet(employeeRequest.getAddress().getStreet());
        address.setCity(employeeRequest.getAddress().getCity());
        address.setState(employeeRequest.getAddress().getState());
        address.setPinCode(employeeRequest.getAddress().getPinCode());
        address.setEmployee(employee);
        employee.setAddress(address);
        employee.setActive(employeeRequest.getActive());
        employeeRepository.save(employee);

    }
//employeeRequest.getEmpId(),employeeRequest.getFirstname(),employeeRequest.getLastname(), employeeRequest.getEmployeeEmail(),employeeRequest.getActive(),employeeRequest.getAddress().getLane1(),
//                employeeRequest.getAddress().getLane2(),employeeRequest.getAddress().getStreet(),employeeRequest.getAddress().getCity(),
//                employeeRequest.getAddress().getState(),employeeRequest.getAddress().getPinCode(),employeeRequest.getRole().getRoleId(),
//                employeeRequest.getLocation().getLocationId(),employeeRequest.getProductTeam().getProductId()
    public EmployeeNameResponse getEmployees() {
        List<Employee> employeeEntities = (List<Employee>) employeeRepository.findAll();
        List<String> employees = employeeEntities.stream().map(Employee::getFirstname).collect(Collectors.toList());
        EmployeeNameResponse response = new EmployeeNameResponse();
        response.setEmployee(employees);
        return response;
    }
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employee = (List<Employee>) employeeRepository.findAll();
        List<EmployeeResponse> response = new ArrayList<>();
        employee.forEach(emp -> {
            EmployeeResponse res=new EmployeeResponse(emp.getEmpId(),emp.getFirstname(),emp.getLastname(), emp.getEmployeeEmail(), emp.getAddress(),emp.getLocation(),emp.getProductTeam(),emp.getRole(),emp.getActive());
            response.add(res);
        });
        return response;
    }
    @Override
    public void updateEmployee(EmployeeRequest employeeRequest) {
        Employee employee= employeeRepository.findById(employeeRequest.getEmpId()).get();
        employee.setFirstname(employeeRequest.getFirstname());
        employee.setLastname(employeeRequest.getLastname());
        employee.setEmployeeEmail(employeeRequest.getEmployeeEmail());
        employee.setRole(roleRepository.findByRoleName(employeeRequest.getRole().getRoleName()));
        employee.setProductTeam(productTeamRepository.findByProductName(employeeRequest.getProductTeam().getProductName()));
        employee.setLocation(locationRepository.findByLocationName(employeeRequest.getLocation().getLocationName()));
        employee.getAddress().setLane1(employeeRequest.getAddress().getLane1());
        employee.getAddress().setLane2(employeeRequest.getAddress().getLane2());
        employee.getAddress().setStreet(employeeRequest.getAddress().getStreet());
        employee.getAddress().setCity(employeeRequest.getAddress().getCity());
        employee.getAddress().setState(employeeRequest.getAddress().getState());
        employee.getAddress().setPinCode(employeeRequest.getAddress().getPinCode());
        employee.getAddress().setEmployee(employee);
        employee.setActive(employeeRequest.getActive());
        employeeRepository.save(employee);
    }
    @Override
    public EmployeeNameResponse deleteEmployee(int id){
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.deleteById(id);
        EmployeeNameResponse employeeResponse = new EmployeeNameResponse();
        List<String> employees = new ArrayList<>();
        employees.add(employee.getFirstname());
        employeeResponse.setEmployee(employees);
        return employeeResponse;
    }
    @Override
    public EmployeeResponse getEmployee(int id){
        Employee emp = employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse = new EmployeeResponse(emp.getEmpId(),emp.getFirstname(),emp.getLastname(), emp.getEmployeeEmail(), emp.getAddress(),emp.getLocation(),emp.getProductTeam(),emp.getRole(),emp.getActive());
        return employeeResponse;

    }
}
