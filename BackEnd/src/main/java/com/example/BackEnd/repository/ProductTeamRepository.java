package com.example.BackEnd.repository;

import com.example.BackEnd.entity.ProductTeam;
import org.springframework.data.repository.CrudRepository;

public interface ProductTeamRepository extends CrudRepository<ProductTeam,Integer> {

    ProductTeam findByProductName(String productName);
}
