package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset,Integer>{
    
}
