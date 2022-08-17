package com.example.BackEnd.repository;

import com.example.BackEnd.entity.Role;
import com.example.BackEnd.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Integer> {


    Role findByRoleName(String roleName );
}
