package com.example.Employee_Management_System.playground.template_pattern;

public abstract class EmployeeTemplate {

    public abstract long getSalary();
    public abstract long getLeaveCount();
    public abstract long getDeductionPerLeave();

    public long getFinalSalaryForThisMonth() {
        return getSalary() - getLeaveCount() * getDeductionPerLeave();
    }

}
