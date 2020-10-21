package com.example.Employee_Management_System.playground.adapter_pattern;


import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.request.EmployeeRequest;

public class EmployeeAdapter implements IEmpoyeeAdapter {

    @Override
    public Employee createEmployee(EmployeeRequest request) {

        return new Employee(
                request.getName(),
                request.getAddress(),
                request.getAge(),
                request.getGender(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.isCurrentlyWorking(),
                request.getDesignation(),
                request.getSalary()
        );
    }
}
