package com.example.Employee_Management_System.Resources.request;

import com.example.Employee_Management_System.Resources.model.Designation;
import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeRequest {

    private String name;

    private int age;

    private String address;

    private String gender;

    private String email;

    private String phone_number;

    private List<Project> project;

    private List<Designation> designation;
}
