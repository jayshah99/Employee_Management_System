package com.example.Employee_Management_System.playground.factory_pattern.transport;

public class Ship implements Transport {

    @Override
    public void deliver() {
        System.out.println("Deliver on: " + Ship.class.getSimpleName());
        System.out.println("delivered");
    }
}
