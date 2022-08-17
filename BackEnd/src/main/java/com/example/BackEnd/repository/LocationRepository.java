package com.example.BackEnd.repository;


import com.example.BackEnd.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location,Integer> {

    Location findByLocationName(String locationName);
}
