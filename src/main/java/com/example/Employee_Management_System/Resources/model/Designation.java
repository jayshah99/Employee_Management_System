package com.example.Employee_Management_System.Resources.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Designation {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String designation;
    @Column
    private int salary;
    @Column
    private String start_date;
    @Column
    private String end_date;
    @Column
    private boolean current;
    @Column
    private int empid;

    public Designation(String designation, int salary, String start_date, String end_date, boolean current, int empid) {
        this.designation = designation;
        this.salary = salary;
        this.start_date = start_date;
        this.end_date = end_date;
        this.current = current;
        this.empid = empid;
    }
}
