package com.example.Employee_Management_System.Resources.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Employee {
    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String address;

    @Column
    private String gender;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private boolean currentlyWorking;

    @OneToMany(targetEntity = Designation.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "empid", referencedColumnName = "id")
//    @JsonIgnoreProperties("employee")
//    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Designation> designation;

    @OneToMany(targetEntity = Salary.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "empid", referencedColumnName = "id")
    private List<Salary> salary;

    public Employee(String name, String address,int age, String gender, String email, String phoneNumber,boolean currentlyWorking,List<Designation> designation, List<Salary> salary) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.currentlyWorking=currentlyWorking;
        this.designation = designation;
        this.salary=salary;
    }


}
