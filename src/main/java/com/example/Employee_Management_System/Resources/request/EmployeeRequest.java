package com.example.Employee_Management_System.Resources.request;

import com.example.Employee_Management_System.Resources.model.Designation;
import com.example.Employee_Management_System.Resources.model.Salary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;


import javax.validation.constraints.Min;
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
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Age cannot be null")
    @Min(value = 17, message = "Age should be equal or more than 18")
    private int age;

    @NotNull(message = "Address cannot be null")
    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @NotNull(message = "Gender cannot be null")
    @NotEmpty(message = "Gender cannot be empty")
    private String gender;

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotNull(message = "Phone number cannot be null")
    @NotEmpty(message = "Phone number cannot be empty")
//    @UniqueElements(message = "Phone number already exist")
    private String phoneNumber;

    @NotNull(message = "There should be true or false in currently working column")
    //@NotEmpty(message = "There should be true or false in currently working column")
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
