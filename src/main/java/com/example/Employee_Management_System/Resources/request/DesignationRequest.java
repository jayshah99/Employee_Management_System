package com.example.Employee_Management_System.Resources.request;

import com.example.Employee_Management_System.Resources.model.Employee;
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

    private Date startDate;

    private Date endDate;

    private boolean current;

}
