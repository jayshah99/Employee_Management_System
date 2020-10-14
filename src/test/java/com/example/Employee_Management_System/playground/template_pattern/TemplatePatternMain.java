package com.example.Employee_Management_System.playground.template_pattern;

public class TemplatePatternMain {

    public static void main(String[] args) {

        /**
         * When we say Employee
         * 1. Manger
         *      a. Rahul - 2 leaves
         *      b. Abhishek - 3 leaves
         * 2. HR
         *      a. Priyanka - 5 leaves
         * 3. Developer
         *      a. Jay - 0 leaves
         *      b. Prashant - 1 leave
         * 4. Project Manger
         *      a. RahulP - 2 leaves
         *      b. Sid - 3 leaves
         *
         * i want to calculate the each month salary
         *
         * for each leave 10rs will deduct
         */

        Manager manager = new Manager(
                new Employee("Rahul", "manager", 2000),
                new LeaveInformation(2, 1)
        );

        System.out.println("manger final salary: " + manager.getFinalSalaryForThisMonth());

        HR hr = new HR(
                new Employee("priyanka", "hr", 200),
                new LeaveInformation(5, 10)
        );
        System.out.println("hr final salary: " + hr.getFinalSalaryForThisMonth());

        Developer developer = new Developer(
                new Employee("Jay", "developer", 200000),
                new LeaveInformation(0, 100)
        );
        System.out.println("developer final salary: " + developer.getFinalSalaryForThisMonth());


    }
}
