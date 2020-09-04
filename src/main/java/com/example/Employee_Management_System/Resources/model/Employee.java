package com.example.Employee_Management_System.Resources.model;

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
    private String phone_number;

    @OneToMany(targetEntity = Project.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "empid", referencedColumnName = "id")
    private List<Project> project;

    @OneToMany(targetEntity = Designation.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "empid", referencedColumnName = "id")
    private List<Designation> designation;

//    public Employee(String name, int age, String address, String gender, String email, String phone_number, List<Project> project, List<Designation> designation) {
//        this.name = name;
//        this.age = age;
//        this.address = address;
//        this.gender = gender;
//        this.email = email;
//        this.phone_number = phone_number;
//        this.project = project;
//        this.designation = designation;
//    }


}
