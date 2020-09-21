package com.example.Employee_Management_System.Resources.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Salary {

    @GeneratedValue
    @Id
    @Column
    private int id;

    @Column
    private int salary;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private boolean current;

    @Column
    private int numberOfChange;

    public Salary(int salary, Date startDate, Date endDate, boolean current, int numberOfChange) {
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.current = current;
        this.numberOfChange = numberOfChange;
    }
}
