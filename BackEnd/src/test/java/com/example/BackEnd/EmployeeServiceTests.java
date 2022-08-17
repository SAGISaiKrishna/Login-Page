package com.example.BackEnd;

import com.example.BackEnd.entity.*;
import com.example.BackEnd.repository.*;
import com.example.BackEnd.response.LocationResponse;
import com.example.BackEnd.response.ProductTeamResponse;
import com.example.BackEnd.response.RoleResponse;
import com.example.BackEnd.service.ILocationService;
import com.example.BackEnd.service.IProductTeamService;
import com.example.BackEnd.service.IRoleService;
import com.example.BackEnd.service.implement.EmployeeService;
import com.example.BackEnd.service.implement.LocationService;
import com.example.BackEnd.service.implement.RoleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;


@SpringBootTest
public class EmployeeServiceTests {
    @Autowired
    private EmployeeService service;
    @MockBean
    private EmployeeRepository repository;
    @Autowired
    private ILocationService locationService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IProductTeamService productTeamService;
    List<Location> locations;
    List<Role> roles;
    List<ProductTeam> products;

    @MockBean
    private LocationRepository lRepository;
    @MockBean
    private ProductTeamRepository pRepository;
    @MockBean
    private RoleRepository rRepository;
    @BeforeEach
    public void setUp() {
        locations = new ArrayList<Location>();
        roles=new ArrayList<Role>();
        products=new ArrayList<ProductTeam>();
        Role role=Role.builder().roleId(1).roleName("FullStack").roleDescription("fs").build();
        Role role1=Role.builder().roleId(2).roleName("Backend").roleDescription("be").build();
        roles.add(role);
        roles.add(role1);
        Location location=Location.builder().locationId(1).locationName("Bangalore").locationDescription("bng").build();
        Location location1=Location.builder().locationId(2).locationName("Hyderabad").locationDescription("hyd").build();
        locations.add(location);
        locations.add(location1);

        ProductTeam product=ProductTeam.builder().productId(1).productName("Cargoes").productDescription("car").build();
        ProductTeam product1=ProductTeam.builder().productId(2).productName("Flows").productDescription("flo").build();
        products.add(product);
        products.add(product1);
    }
    @Test
      public void getLocationsTest(){
          Mockito.when(lRepository.findAll()).thenReturn(locations);
          LocationResponse response =locationService.getLocations();
          Assertions.assertThat(response.getLocation()).isEqualTo(locations.stream().map(Location::getLocationName).collect(Collectors.toList()));
      }
    @Test
    public void getRolesTest(){
        Mockito.when(rRepository.findAll()).thenReturn(roles);
        RoleResponse response1 =roleService.getRoles();
        Assertions.assertThat(response1.getRole()).isEqualTo(roles.stream().map(Role::getRoleName).collect(Collectors.toList()));
    }
    @Test
    public void getProductsTest(){
        Mockito.when(pRepository.findAll()).thenReturn(products);
        ProductTeamResponse response2 =productTeamService.getProductTeams();
        Assertions.assertThat(response2.getProductTeam()).isEqualTo(products.stream().map(ProductTeam::getProductName).collect(Collectors.toList()));
    }



}
