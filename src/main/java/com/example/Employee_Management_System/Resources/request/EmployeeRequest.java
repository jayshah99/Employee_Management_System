package com.example.Employee_Management_System.Resources.request;

import com.example.Employee_Management_System.Resources.model.Designation;
import com.example.Employee_Management_System.Resources.model.Salary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeRequest {

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name can not be empty")
    private String name;

    @NotNull(message = "Age cannot be null")
    private int age;

    @NotNull(message = "Address cannot be null")
    private String address;

    @NotNull(message = "Gender cannot be null")
    private String gender;

    @NotNull(message = "Email cannot be null")
    private String email;

    @NotNull(message = "Phone number cannot be null")
    private String phoneNumber;

    @NotNull(message = "There should be true or false in currently working column")
    private boolean currentlyWorking;

    private List<Designation> designation;

    private List<Salary> salary;

    public List<Designation> getDesignation() {
        if (designation == null)
            return Collections.emptyList();
        return designation;
    }

    public List<Salary> getSalary() {
        if (salary == null)
            return Collections.emptyList();
        return salary;
    }
}
