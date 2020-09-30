package com.example.Employee_Management_System.Resources.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesignationRequest {

    @NotNull(message = "Designation cannot be null")
    @NotEmpty(message = "Designation cannot be empty")
    private String designation;

    private Date startDate;

    private Date endDate;

    private boolean current;


}
