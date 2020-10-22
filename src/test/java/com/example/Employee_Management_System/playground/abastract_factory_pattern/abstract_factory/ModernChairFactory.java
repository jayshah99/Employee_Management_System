package com.example.Employee_Management_System.playground.abastract_factory_pattern.abstract_factory;

import com.example.Employee_Management_System.playground.abastract_factory_pattern.Category;
import com.example.Employee_Management_System.playground.abastract_factory_pattern.product.Chair;
import com.example.Employee_Management_System.playground.abastract_factory_pattern.product.ChairModern;
import com.example.Employee_Management_System.playground.abastract_factory_pattern.product.ChairModernA;

public class ModernChairFactory implements ChairFactory {

    private final Category category;

    public ModernChairFactory(Category category) {
        this.category = category;
    }

    @Override
    public Chair getChair() {
        switch (category) {
            case MODERN:
                return new ChairModern();
            case MODERN_A:
                return new ChairModernA();
            default:
                throw new IllegalArgumentException(String.format("Unknown category: %s", category.name()));
        }
    }
}
