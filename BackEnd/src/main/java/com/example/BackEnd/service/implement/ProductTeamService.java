package com.example.BackEnd.service.implement;

import com.example.BackEnd.entity.Location;
import com.example.BackEnd.entity.ProductTeam;
import com.example.BackEnd.repository.LocationRepository;
import com.example.BackEnd.repository.ProductTeamRepository;
import com.example.BackEnd.response.LocationResponse;
import com.example.BackEnd.response.ProductTeamResponse;
import com.example.BackEnd.service.IProductTeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductTeamService implements IProductTeamService {

    @Autowired
    private ProductTeamRepository productTeamRepository;
    public ProductTeamResponse getProductTeams() {
        List<ProductTeam> productTeamEntities = (List<ProductTeam>) productTeamRepository.findAll();
        List<String> productTeams = productTeamEntities.stream().map(ProductTeam::getProductName).collect(Collectors.toList());
        com.example.BackEnd.response.ProductTeamResponse response = new ProductTeamResponse();
        response.setProductTeam(productTeams);
        return response;
    }

}
