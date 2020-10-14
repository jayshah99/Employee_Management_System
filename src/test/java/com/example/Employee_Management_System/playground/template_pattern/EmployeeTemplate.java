package com.example.Employee_Management_System.playground.template_pattern;

public interface EmployeeTemplate {

    long getMonthlySalary();
    long getLeaveCount();
    long getDeductionPerLeave();

    default long getFinalSalaryForThisMonth() {
        return getMonthlySalary() - getLeaveCount() * getDeductionPerLeave();
    }

}
