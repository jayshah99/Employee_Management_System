package com.example.Employee_Management_System.Resources.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryRequest {

    @Min(value = 1, message = "Salary should be more than 0")
    private int salary;

    private Date startDate;

    private Date endDate;

    private boolean current;


}