package com.example.BackEnd.request;
import com.example.BackEnd.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class RoleRequest implements Serializable{

    private int roleId;
    private String roleName;
    private String roleDescription;

}
