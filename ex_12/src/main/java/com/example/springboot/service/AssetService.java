package com.example.springboot.service;

import org.springframework.stereotype.Service;

import com.example.springboot.model.Asset;
import com.example.springboot.model.Owner;
import com.example.springboot.repository.AssetRepository;
import com.example.springboot.repository.OwnerRepository;

@Service
public class AssetService {
    private AssetRepository assetRepository;
    private OwnerRepository ownerRepository;
    public AssetService(AssetRepository assetRepository,OwnerRepository ownerRepository)
    {
        this.assetRepository = assetRepository;
        this.ownerRepository = ownerRepository;
    }
    public boolean saveAsset(Asset asset)
    {
        try
        {
            assetRepository.save(asset);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean updateAsset(int id,Asset asset)
    {
        if(getAssetById(id)==null)
        {
            return false;
        }
        try{
            assetRepository.save(asset);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteAsset(int id)
    {
        if(getAssetById(id)==null)
        {
            return false;
        }
        assetRepository.deleteById(id);
        return true;
        
    }
    public Asset getAssetById(int id)
    {
        return assetRepository.findById(id).orElse(null);
    }



    
    public boolean saveOwner(Owner owner)
    {
        try
        {
            ownerRepository.save(owner);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean updateOwner(int id,Owner owner)
    {
        if(getOwnerById(id)==null)
        {
            return false;
        }
        try{
            ownerRepository.save(owner);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteOwner(int id)
    {
        if(getOwnerById(id)==null)
        {
            return false;
        }
        ownerRepository.deleteById(id);
        return true;
        
    }
    public Owner getOwnerById(int id)
    {
        return ownerRepository.findById(id).orElse(null);
    }
    
}
