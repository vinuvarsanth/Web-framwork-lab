package com.student.student.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.student.student.Model.Student;
import com.student.student.Repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    public StudentRepo studentRepo;

    public boolean PostData(Student student)
    {
        try
        {
            studentRepo.save(student);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<Student> getAll()
    {
        return studentRepo.findAll();
    }
    public Student getById(int id)
    {
        return studentRepo.findById(id).orElse(null);
    }

    public Student putData(int id,Student student)
    {
        if (getById(id) != null)
        {
            return studentRepo.save(student);
        }
        else{
            return null;
        }
    }

    public void delData(int id)
    {
        studentRepo.deleteById(id);
    }

    public List<Student> getBySort(String field)
    {
        return studentRepo.findAll(Sort.by(Sort.Direction.ASC, field));
    }
    public List<Student> getByBetween(int minage,int maxage)
    {
        return studentRepo.findAllByAgeBetween(minage, maxage);
    }
}
