package com.example.Employee_Management_System.Controller;

import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.model.Salary;
import com.example.Employee_Management_System.Resources.request.SalaryRequest;
import com.example.Employee_Management_System.Service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/salaries")
    public Salary addSalary(@RequestBody SalaryRequest request) {
        return salaryService.addSalary(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/salaries")
    public List<Salary> salaryList() {
        return salaryService.salaryList();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("salaries/{id}")
    public void delete(@PathVariable(value = "id") int id) {
        salaryService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/salaries")
    public Salary update(@RequestBody SalaryRequest request){
        return salaryService.update(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/salaries/{id}")
    public Salary get(@PathVariable("id") int id) {
        return salaryService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("maxSalary")
    public Employee maxSalary(){
        return salaryService.maxSalary();
    }
}

