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

import com.student.student.Model.Donor;
import com.student.student.Service.DonorService;

@RestController
public class ApiController {
    @Autowired
    public DonorService donorService;

    @PostMapping("/") // http://localhost:8080/
    public Donor postStudent(@RequestBody Donor donor) {
        donorService.PostData(donor);
        return donor;
    }

    @PutMapping("/put/{id}") // http://localhost:8080/put/5
    public Donor putStudent(@RequestBody Donor donor, @PathVariable int id) {
        return donorService.putData(id, donor);
    }

    @GetMapping("/get") // http://localhost:8080/get
    public List<Donor> getAll() {
        return donorService.getAll();
    }

    @GetMapping("/get/id/{id}") // http://localhost:8080/get/id/5
    public Donor getById(@PathVariable int id) {
        return donorService.getById(id);
    }

    @DeleteMapping("/del/{id}") // http://localhost:8080/del/1
    public void deleteById(@PathVariable int id) {
        donorService.delData(id);
    }

    @GetMapping("/get/field/{field}") // http://localhost:8080/get/field/id
    public List<Donor> getBySort(@PathVariable String field) {
        return donorService.getBySort(field);
    }

    @GetMapping("/get/{min}/{max}") // http://localhost:8080/get/25/30
    public List<Donor> getByBetween(@PathVariable int min, @PathVariable int max) {
        return donorService.getByBetween(min, max);
    }
}
