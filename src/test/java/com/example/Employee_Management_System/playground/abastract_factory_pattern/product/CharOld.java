package com.example.Employee_Management_System.playground.abastract_factory_pattern.product;

public class CharOld implements Chair {

    @Override
    public void sit() {
        System.out.println(CharOld.class.getSimpleName() + " is called");
    }
}
