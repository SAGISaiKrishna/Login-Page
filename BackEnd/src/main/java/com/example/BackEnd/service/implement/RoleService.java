package com.example.BackEnd.service.implement;

import com.example.BackEnd.entity.ProductTeam;
import com.example.BackEnd.entity.Role;
import com.example.BackEnd.repository.ProductTeamRepository;
import com.example.BackEnd.repository.RoleRepository;
import com.example.BackEnd.response.ProductTeamResponse;
import com.example.BackEnd.response.RoleResponse;
import com.example.BackEnd.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    public RoleResponse getRoles() {
        List<Role> roleEntities = (List<Role>) roleRepository.findAll();
        List<String> roles = roleEntities.stream().map(Role::getRoleName).collect(Collectors.toList());
        com.example.BackEnd.response.RoleResponse response = new RoleResponse();
        response.setRole(roles);
        return response;
    }
}
