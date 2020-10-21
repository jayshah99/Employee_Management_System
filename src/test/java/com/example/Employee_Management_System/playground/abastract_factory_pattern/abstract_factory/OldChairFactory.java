package com.example.Employee_Management_System.playground.abastract_factory_pattern.abstract_factory;

import com.example.Employee_Management_System.playground.abastract_factory_pattern.product.Chair;
import com.example.Employee_Management_System.playground.abastract_factory_pattern.product.CharOld;

public class OldChairFactory implements ChairFactory {
    @Override
    public Chair getChair() {
        return new CharOld();
    }
}
