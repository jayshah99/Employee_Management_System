package com.example.Employee_Management_System.playground.factory_pattern.transport;

public class AeroPlane implements Transport {

    @Override
    public void deliver() {
        System.out.println("Deliver on: " + AeroPlane.class.getSimpleName());
        System.out.println("delivered");
    }
}
