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
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private boolean current;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JsonIgnoreProperties("designation")
//   @JoinColumn(name = "empid", nullable = false)
//    private Employee employee;

    public Designation(String designation, int salary, Date startDate, Date endDate, boolean current) {
        this.designation = designation;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.current = current;
    }

}
