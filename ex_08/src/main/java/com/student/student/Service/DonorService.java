package com.student.student.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.student.student.Model.Donor;
import com.student.student.Repository.DonorRepo;

@Service
public class DonorService {
    @Autowired
    public DonorRepo donorRepo;

    public boolean PostData(Donor donor)
    {
        try
        {
            donorRepo.save(donor);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<Donor> getAll()
    {
        return donorRepo.findAll();
    }
    public Donor getById(int id)
    {
        return donorRepo.findById(id).orElse(null);
    }

    public Donor putData(int id,Donor donor)
    {
        if (getById(id) != null)
        {
            return donorRepo.save(donor);
        }
        else{
            return null;
        }
    }

    public void delData(int id)
    {
        donorRepo.deleteById(id);
    }

    public List<Donor> getBySort(String field)
    {
        return donorRepo.findAll(Sort.by(Sort.Direction.ASC, field));
    }
    public List<Donor> getByBetween(int minage,int maxage)
    {
        return donorRepo.findAllByAgeBetween(minage, maxage);
    }
}
