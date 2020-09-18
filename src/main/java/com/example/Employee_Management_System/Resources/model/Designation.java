package com.example.Employee_Management_System.Resources.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

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
    private Date start_date;
    @Column
    private Date end_date;
    @Column
    private boolean current;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JsonIgnoreProperties("designation")
//   @JoinColumn(name = "empid", nullable = false)
//    private Employee employee;

    public Designation(String designation, int salary, Date start_date, Date end_date, boolean current) {
        this.designation = designation;
        this.salary = salary;
        this.start_date = start_date;
        this.end_date = end_date;
        this.current = current;
    }

}
