package com.example.Employee_Management_System.playground.abastract_factory_pattern.product;

public class ChairModern implements Chair {

    @Override
    public void sit() {
        System.out.println(ChairModern.class.getSimpleName() + " is called");
    }
}
