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
    private String phone_number;

    @OneToMany(targetEntity = Designation.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "empid", referencedColumnName = "id")
//    @JsonIgnoreProperties("employee")
//    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Designation> designation;

    public Employee(String name, String address,int age, String gender, String email, String phone_number,List<Designation> designation) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.phone_number = phone_number;
        this.designation = designation;
    }


}
