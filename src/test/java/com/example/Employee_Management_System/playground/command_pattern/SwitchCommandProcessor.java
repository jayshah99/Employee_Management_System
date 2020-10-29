package com.example.Employee_Management_System.playground.command_pattern;

public class SwitchCommandProcessor {

    private final Command command;

    public SwitchCommandProcessor(Command command) {
        this.command = command;
    }

    public void process() {
        command.execute();
    }
}
