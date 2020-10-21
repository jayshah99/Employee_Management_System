package com.example.Employee_Management_System.playground.abastract_factory_pattern;

public enum Category {
    MODERN(1),
    MODERN_A(2);

    final int value;
    Category(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
