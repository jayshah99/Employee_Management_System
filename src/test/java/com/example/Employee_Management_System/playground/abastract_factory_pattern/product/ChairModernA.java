package com.example.Employee_Management_System.playground.abastract_factory_pattern.product;

public class ChairModernA implements Chair {
    @Override
    public void sit() {
        System.out.println(ChairModernA.class.getSimpleName() + " is called");
    }
}
