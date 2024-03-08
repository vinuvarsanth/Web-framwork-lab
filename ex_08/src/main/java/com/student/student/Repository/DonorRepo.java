package com.student.student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.student.Model.Donor;

@Repository
public interface DonorRepo extends JpaRepository<Donor,Integer>{

    @Query("SELECT d FROM Donor d WHERE d.Age BETWEEN ?1 AND ?2")
    public List<Donor> findAllByAgeBetween(int age1,int age2);
}
