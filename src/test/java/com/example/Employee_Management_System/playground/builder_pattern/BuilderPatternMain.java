package com.example.Employee_Management_System.playground.builder_pattern;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class BuilderPatternMain {

    public static void main(String[] args) {

        //exampleOfChainOfMethods();
    }

    private static void exampleOfChainOfMethods() {
        //Chain of method. it also represents the steps we are gonna follow to get expected outcome
        OptionalDouble average = IntStream.range(1, 5)
                .filter(num -> num % 2 == 0) //2, 4
                .average();

        if (average.isPresent())
            System.out.println(average.getAsDouble());
    }
}
