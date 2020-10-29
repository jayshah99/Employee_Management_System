package com.example.Employee_Management_System.playground.command_pattern;

public class FanOnCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Fan is ON");
    }
}
