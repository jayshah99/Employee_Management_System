package com.example.Employee_Management_System.Resources.request;

import com.example.Employee_Management_System.Resources.model.Designation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeRequest {

    @NotNull(message = "Name cannot be null")
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
    private String phone_number;

    private List<Designation> designation;
}
