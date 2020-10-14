package com.example.Employee_Management_System.playground.template_pattern;

public class Developer extends EmployeeTemplate {

    private final Employee employee;
    private final LeaveInformation leaveInformation;

    public Developer(Employee employee, LeaveInformation leaveInformation) {
        this.employee = employee;
        this.leaveInformation = leaveInformation;
    }


    @Override
    public long getSalary() {
        return employee.getSalary();
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
