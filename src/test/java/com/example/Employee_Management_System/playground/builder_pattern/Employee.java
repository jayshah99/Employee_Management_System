package com.example.Employee_Management_System.playground.builder_pattern;

import lombok.Builder;

import java.util.Date;

@Builder
public class Employee {

    private int id;
    private String name;
    private String designation;
    private Date joniDate;
}
