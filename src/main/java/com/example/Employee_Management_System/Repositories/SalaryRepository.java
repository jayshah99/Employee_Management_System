package com.example.Employee_Management_System.Repositories;

import com.example.Employee_Management_System.Resources.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary,Integer> {
}
