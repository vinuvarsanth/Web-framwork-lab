package com.student.student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.student.Model.Student;
import com.student.student.Service.StudentService;

@RestController
public class ApiController {
    @Autowired
    public StudentService studentService;

    @PostMapping("/") // http://localhost:8080/
    public Student postStudent(@RequestBody Student student)
    {
        studentService.PostData(student);
        return student;
    }

    @PutMapping("/put/{id}") // http://localhost:8080/put/1
    public Student putStudent(@RequestBody Student student,@PathVariable int id)
    {
        return studentService.putData(id, student);
    }

    @GetMapping("/get") // http://localhost:8080/get
    public List<Student> getAll()
    {
        return studentService.getAll();
    }
    @GetMapping("/get/id/{id}") // http://localhost:8080/get/id/4
    public Student getById(@PathVariable int id)
    {
        return studentService.getById(id);
    }
    @DeleteMapping("/del/{id}") // http://localhost:8080/del/4
    public void deleteById(@PathVariable int id)
    {
        studentService.delData(id);
    }

    @GetMapping("/get/field/{field}") // http://localhost:8080/get/field/id
    public List<Student> getBySort(@PathVariable String field)
    {
        return studentService.getBySort(field);
    }

    @GetMapping("/get/{min}/{max}") // http://localhost:8080/get/24/30
    public List<Student> getByBetween(@PathVariable int min,@PathVariable int max)
    {
        return studentService.getByBetween(min, max);
    }
}
