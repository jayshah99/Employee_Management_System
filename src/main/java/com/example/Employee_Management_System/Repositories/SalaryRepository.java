package com.example.Employee_Management_System.Repositories;

import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary,Integer> {

    @Query(value = "select * from cbnits1.salary where salary = (select max(salary) from cbnits1.salary)", nativeQuery = true)
    List<Salary> maxSalary();
}
