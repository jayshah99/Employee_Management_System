package com.example.Employee_Management_System.playground.adapter_pattern;

import com.example.Employee_Management_System.Resources.request.EmployeeRequest;

public class AdapterPatternMain {

    public static void main(String[] args) {
        //User A
        IEmpoyeeAdapter adapter = new EmployeeAdapter();
        System.out.println(adapter.createEmployee(new EmployeeRequest()));

        //User B
        IEmpoyeeAdapter adapter2 = new EmployeeAdapter2();
        System.out.println(adapter2.createEmployee(new EmployeeRequest()));


    }
}
