package com.example.Employee_Management_System.playground.template_pattern;

public class LeaveInformation {

    private final int leaveCount;
    private final int deductionPerLeave;

    public LeaveInformation(int leaveCount, int deductionPerLeave) {
        this.leaveCount = leaveCount;
        this.deductionPerLeave = deductionPerLeave;
    }

    public int getLeaveCount() {
        return leaveCount;
    }

    public int getDeductionPerLeave() {
        return deductionPerLeave;
    }
}
