package com.example.BackEnd.service.implement;


import com.example.BackEnd.entity.Employee;
import com.example.BackEnd.entity.Location;
import com.example.BackEnd.repository.LocationRepository;
import com.example.BackEnd.response.EmployeeResponse;
import com.example.BackEnd.response.LocationResponse;
import com.example.BackEnd.service.ILocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LocationService implements ILocationService {
    @Autowired
    private LocationRepository locationRepository;
    public LocationResponse getLocations() {
        List<Location> locationEntities = (List<Location>) locationRepository.findAll();
        List<String> locations = locationEntities.stream().map(Location::getLocationName).collect(Collectors.toList());
        com.example.BackEnd.response.LocationResponse response = new LocationResponse();
        response.setLocation(locations);
        return response;
    }

}
