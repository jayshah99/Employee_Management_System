package com.example.Employee_Management_System.Repositories;

import com.example.Employee_Management_System.Resources.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByName(String name);
}
