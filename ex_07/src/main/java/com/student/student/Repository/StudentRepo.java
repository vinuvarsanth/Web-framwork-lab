package com.student.student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.student.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{

    @Query("SELECT s FROM Student s WHERE s.Age BETWEEN ?1 AND ?2")
    public List<Student> findAllByAgeBetween(int age1,int age2);
}
