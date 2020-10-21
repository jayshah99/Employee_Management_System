package com.example.Employee_Management_System.playground.adapter_pattern;

import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.request.EmployeeRequest;

public interface IEmpoyeeAdapter {

    Employee createEmployee(EmployeeRequest request);
}
