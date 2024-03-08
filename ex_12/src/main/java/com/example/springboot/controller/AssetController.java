package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Asset;
import com.example.springboot.model.Owner;
import com.example.springboot.service.AssetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AssetController {
    public AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping("/assets") // http://localhost:8080/assets
    public ResponseEntity<Asset> postMethodName(@RequestBody Asset asset) {

        if (assetService.saveAsset(asset)) {
            return new ResponseEntity<>(asset, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // {
    //     "id": 1,
    //     "name": "Laptop",
    //     "description": "Dell XPS 15",
    //     "value": 1500,
    //     "owner": {
    //         "id": 1
            
    //     }
    // }
    

    @GetMapping("/assets/{id}") // http://localhost:8080/assets/3
    public ResponseEntity<Asset> getAsset(@PathVariable("id") int id) {
        Asset asset = assetService.getAssetById(id);
        if (asset == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asset, HttpStatus.OK);
    }

    @PutMapping("/assets/{id}") // http://localhost:8080/assets/3
    public ResponseEntity<Asset> putAsset(@PathVariable int id, @RequestBody Asset asset) {
        if (assetService.updateAsset(id, asset) == true) {
            return new ResponseEntity<>(asset, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/assets/{id}") // http://localhost:8080/assets/3
    public ResponseEntity<Asset> deleteAsset(@PathVariable("id") int id) {
        if (assetService.deleteAsset(id) == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/owners") // http://localhost:8080/owners
    public ResponseEntity<Owner> postMethod(@RequestBody Owner owner) {

        if (assetService.saveOwner(owner)) {
            return new ResponseEntity<>(owner, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // {
    //     "id": 3,
    //     "name": "Eva Martinez",
    //     "email": "eva.martinez@example.com",
    //     "address": "321 Pine St"
    // }

    @GetMapping("/owners/{id}") // http://localhost:8080/owners/2
    public ResponseEntity<Owner> getOwner(@PathVariable("id") int id) {
        Owner owner = assetService.getOwnerById(id);
        if (owner == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @PutMapping("/owners/{id}") // http://localhost:8080/owners/2
    public ResponseEntity<Owner> putAsset(@PathVariable int id, @RequestBody Owner owner) {
        if (assetService.updateOwner(id, owner) == true) {
            return new ResponseEntity<>(owner, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/owners/{id}") // http://localhost:8080/owners/2
    public ResponseEntity<Asset> deleteOwner(@PathVariable("id") int id) {
        if (assetService.deleteOwner(id) == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
