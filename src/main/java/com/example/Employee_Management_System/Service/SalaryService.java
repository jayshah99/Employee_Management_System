package com.example.Employee_Management_System.Service;

import com.example.Employee_Management_System.Repositories.EmployeeRepository;
import com.example.Employee_Management_System.Repositories.SalaryRepository;
import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.model.Salary;
import com.example.Employee_Management_System.Resources.request.SalaryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {
    @Autowired
    SalaryRepository salaryRepository;
    @Autowired
    EmployeeRepository employeeRepository;


    public Salary addSalary(SalaryRequest request) {

        Salary salary = new Salary(
                request.getSalary(),
                request.getStartDate(),
                request.getEndDate(),
                request.isCurrent(),
                request.getNumberOfChanges()
        );
        return salaryRepository.save(salary);
    }

    public List<Salary> salaryList() {
        return salaryRepository.findAll();
    }

    public void delete(int id) {
        salaryRepository.deleteById(id);
    }

    public Salary update(SalaryRequest request) {
        return addSalary(request);
    }


    public Salary getById(int id){
        return salaryRepository.findById(id).get();
    }

    public Employee maxSalary() {
        Salary salary = salaryRepository.maxSalary();
        return employeeRepository.findById(salary.getEmpid()).get();
    }
}

