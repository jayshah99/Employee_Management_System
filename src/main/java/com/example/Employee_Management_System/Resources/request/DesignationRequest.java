package com.example.Employee_Management_System.Resources.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesignationRequest {

    @NotNull(message = "Designation cannot be null")
    private String designation;

    @NotNull(message = "Salary cannot be null")
    private int salary;


    private Date start_date;

    private Date end_date;

    private boolean current;

    private int empid;

}
