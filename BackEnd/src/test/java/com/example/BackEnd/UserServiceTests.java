package com.example.BackEnd;


import com.example.BackEnd.entity.User;
import com.example.BackEnd.repository.EmployeeRepository;
import com.example.BackEnd.repository.UserRepository;
import com.example.BackEnd.request.UserRequest;
import com.example.BackEnd.service.IUserService;
import com.example.BackEnd.service.implement.EmployeeService;
import com.example.BackEnd.service.implement.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTests {

    @MockBean
    private UserRepository repository;
    @Autowired
    private IUserService userService;
    List<User> userList;


    @BeforeEach
    public void setUp() {
        userList = new ArrayList<>();
        User user=User.builder().userId(1).username("SaiKrishna666999").password("sai777").userEmail("saikrishna666999@gmail.com").build();
        User user1=User.builder().userId(2).username("SaiKrishna6699").password("sai777").userEmail("saikrishna6699@gmail.com").build();
        userList.add(user);
        userList.add(user1);
    }

    @Test
    public void saveUserTest() throws  Exception{
        UserRequest userRequest = UserRequest.builder().username("SaiKrishna666999").password("sai777").userEmail("saikrishna666999@gmail.com").build();
        User user=User.builder().userId(1).username("SaiKrishna666999").password("sai777").userEmail("saikrishna666999@gmail.com").build();
        Mockito.when(repository.save(any())).thenReturn(user);

        Assertions.assertThat(userService.saveUser(userRequest).getUserId()).isGreaterThan(0);
    }
    @Test
    public void getUsersTest() {
     Mockito.when(repository.findAll()).thenReturn(userList);
        Assertions.assertThat(userService.getUsers()).isEqualTo(userList.stream().map(User::getUsername).collect(Collectors.toList()));
    }

//    @Test
////    @Order(3)
////    @Rollback(value = false)
//    public void updateUserTest(){
//        User user=repository.findByUsername("SaiKrishna666999");
//        user.setUserEmail("saiKrishna96@gmail.com");
//        User userUpdated=repository.save(user);
//        Assertions.assertThat(userUpdated.getUserEmail()).isEqualTo("saiKrishna96@gmail.com");
//    }


}
