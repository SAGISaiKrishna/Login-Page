package com.example.BackEnd.service.implement;
import com.example.BackEnd.entity.User;
import com.example.BackEnd.repository.UserRepository;
import com.example.BackEnd.request.UserRequest;
import com.example.BackEnd.response.UserNameResponse;
import com.example.BackEnd.response.UserResponse;
import com.example.BackEnd.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<String> getUsers() {
        List<User> userEntities = (List<User>) userRepository.findAll();
        List<String> users = userEntities.stream().map(User::getUsername).collect(Collectors.toList());
//        UserNameResponse response = new UserNameResponse();
//        response.setUser(users);
//        return response;
        return users;
    }
    @Override
    public UserResponse compareUser(UserRequest userRequest) throws Exception{
     String userName=userRequest.getUsername();
     String password=userRequest.getPassword();
     if(!userName.isEmpty()&& !password.isEmpty()) {
         User user= userRepository.findByUsername(userRequest.getUsername());
         if(user==null)
             throw new Exception("Username is Invalid");
         if(password.equals(user.getPassword())){
             return new UserResponse(userRequest.getUserId(),userRequest.getUsername(),userRequest.getUserEmail(),userRequest.getPassword());}
         else throw new Exception(("Password is invalid"));
     }
     else
     {
         throw new Exception("value cannot be empty");
     }
    }
    @Override
    public UserResponse saveUser(UserRequest userRequest) throws Exception {
        User user = new User();
        String tempUserName=userRequest.getUsername();
        if(tempUserName.equals(userRepository.findByUsername(userRequest.getUsername())))
            throw new Exception("Username is already taken");
        else{
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setUserEmail(userRequest.getUserEmail());
        user = userRepository.save(user);}
        return new UserResponse(user.getUserId(),user.getUsername(),user.getUserEmail(),user.getPassword());
    }
    @Override
    public UserResponse updateUser(UserRequest userRequest) {
        User user= userRepository.findByUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setUserEmail(userRequest.getUserEmail());
        user=userRepository.save(user);
        return new UserResponse(user.getUserId(),user.getUsername(),user.getUserEmail(),user.getPassword());
    }





}
