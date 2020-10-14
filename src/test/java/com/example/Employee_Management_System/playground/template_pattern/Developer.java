package com.example.Employee_Management_System.playground.template_pattern;

public class Developer extends Employee implements EmployeeTemplate {

    private final LeaveInformation leaveInformation;

    public Developer(String name, String designation, long salary, LeaveInformation leaveInformation) {
        super(name, designation, salary);
        this.leaveInformation = leaveInformation;
    }

    @Override
    public long getMonthlySalary() {
        return getSalary();
    }

    @Override
    public long getLeaveCount() {
        return leaveInformation.getLeaveCount();
    }

    @Override
    public long getDeductionPerLeave() {
        return leaveInformation.getDeductionPerLeave();
    }
}
