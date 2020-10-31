package com.example.Employee_Management_System.playground.command_pattern;

public class CommandPatternMain {

    public static void main(String[] args) {

        processElectricalSwitches(new SwitchCommandProcessor(new FanOnCommand()));
        processElectricalSwitches(new SwitchCommandProcessor(new LightOffCommand(new Light())));
    }

    private static void processElectricalSwitches(SwitchCommandProcessor processor) {
        processor.process();
    }

}
