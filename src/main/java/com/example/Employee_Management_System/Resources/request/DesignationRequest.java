package com.example.Employee_Management_System.Resources.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesignationRequest {

    @NotNull(message = "Designation cannot be null")
    private String designation;

    @NotNull(message = "Salary cannot be null")
    private int salary;

    private String start_date;

    private String end_date;

    private boolean current;

    private int empid;

}
