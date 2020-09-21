package com.example.Employee_Management_System.Resources.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryRequest {

    @NotNull(message = "Salary cannot be null")
    private int salary;

    private Date startDate;

    private Date endDate;

    private boolean current;

    private int numberOfChanges;

}