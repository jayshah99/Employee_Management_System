package com.example.Employee_Management_System.playground.builder_pattern;

import java.util.Date;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class BuilderPatternMain {

    public static void main(String[] args) {

        //exampleOfChainOfMethods();
        Employee employee1 = new Employee(1, "Rahul", "Software Developer", new Date());

        /*Employee employee2 = new Employee();
        employee2.setDesignation("Software developer");
        employee2.setId(2);

        employee2.setDesignation("Software Engineer");*/


        Employee employee = new Employee.EmployeeBuilder()
                .id(1)
                .designation("adw")
                .build();

        Employee employee2 = Employee.builder()
                .id(1)
                .designation("qwdwe")
                .build();


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
