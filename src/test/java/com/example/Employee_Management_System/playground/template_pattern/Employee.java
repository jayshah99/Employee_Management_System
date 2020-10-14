package com.example.Employee_Management_System.playground.template_pattern;

//An Entity from DB
public class Employee {

    private String name;
    private String designation;
    private long salary;

    public Employee(String name, String designation, long salary) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public long getSalary() {
        return salary;
    }
}
