package com.example.Employee_Management_System.Service;

import com.example.Employee_Management_System.Repositories.EmployeeRepository;
import com.example.Employee_Management_System.Repositories.SalaryRepository;
import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.model.Salary;
import com.example.Employee_Management_System.Resources.request.SalaryRequest;
import com.example.Employee_Management_System.util.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                request.isCurrent()
        );
        return salaryRepository.save(salary);
    }

    public List<Salary> salaryList() {
        return salaryRepository.findAll();
    }

    public List<Salary> findPaginated(int from, int size) {

        Pageable paging = PageRequest.of(from, size);
        Page<Salary> pagedResult = salaryRepository.findAll(paging);

        return pagedResult.toList();
    }

    public void delete(int id) {
        salaryRepository.deleteById(id);
    }

    public Salary update(SalaryRequest request) {
        return addSalary(request);
    }


    public Salary getById(int id) {
        return salaryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Salary not found by id: %s", id)));
    }

    public List<Employee> maxSalary() {
        List<Salary> salaries = salaryRepository.maxSalary();
        List<Integer> empId = new ArrayList<Integer>();

        for (Salary salary : salaries) {
           empId.add(salary.getEmpid());
        }
        return employeeRepository.findByIdIn(empId);
    }
}

