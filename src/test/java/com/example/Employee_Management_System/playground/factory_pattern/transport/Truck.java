package com.example.Employee_Management_System.playground.factory_pattern.transport;

public class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("Deliver on: " + Truck.class.getSimpleName());
        System.out.println("delivered");
    }
}
