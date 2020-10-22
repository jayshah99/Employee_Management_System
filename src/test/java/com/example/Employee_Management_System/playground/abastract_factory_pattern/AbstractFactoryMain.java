package com.example.Employee_Management_System.playground.abastract_factory_pattern;

import com.example.Employee_Management_System.playground.abastract_factory_pattern.abstract_factory.ModernChairFactory;
import com.example.Employee_Management_System.playground.abastract_factory_pattern.abstract_factory.OldChairFactory;
import com.example.Employee_Management_System.playground.abastract_factory_pattern.product.Chair;

public class AbstractFactoryMain {

    public static void main(String[] args) {

        Chair chairB = new ModernChairFactory(Category.MODERN_A).getChair();
        Chair charA = new OldChairFactory().getChair();

        whatItCanDoWhenWeSit(chairB);
        whatItCanDoWhenWeSit(charA);
    }

    private static void whatItCanDoWhenWeSit(Chair chair) {
        chair.sit();
    }
}
