package com.example.Employee_Management_System.Repositories;

import com.example.Employee_Management_System.Resources.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

//    @Query("select e from Employee e where e.name = ?1")
        @Query("select e from Employee e where e.name like %:keyword%")
      List<Employee> findByName( @Param("keyword") String name);


}
