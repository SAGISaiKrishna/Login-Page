package com.example.BackEnd.request;
import com.example.BackEnd.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class LocationRequest implements Serializable{

    private int locationId;
    private String locationName;
    private String locationDescription;

}
