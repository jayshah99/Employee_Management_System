package com.example.Employee_Management_System.Repositories;

import com.example.Employee_Management_System.Resources.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select e from Employee e where e.name like %:keyword%")
    List<Employee> findByName(@Param("keyword") String name);

    //To check whether the email entered is already present or not
    boolean existsEmployeeByEmail(String email);

    //To check whether the phone number entered is already present or not
    boolean existsEmployeeByPhoneNumber(String phoneNumber);

    @Query(value = "select * from employee where (email=?1 or phone_number=?2) and id <>?3", nativeQuery = true)
    List<Employee> findByEmailOrPhoneNumberAndNotEqualsId(String email, String phone, int id);

    List<Employee> findByIdIn(List<Integer> empId);
}
