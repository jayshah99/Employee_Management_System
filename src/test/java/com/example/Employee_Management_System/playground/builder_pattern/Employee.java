package com.example.Employee_Management_System.playground.builder_pattern;

import java.util.Date;

public class Employee {

    private int id;
    private String name;
    private String designation;
    private Date joniDate;

    public Employee(int id, String name, String designation, Date joniDate) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.joniDate = joniDate;
    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {

        private int id;
        private String name;
        private String designation;
        private Date joniDate;

        public EmployeeBuilder id(int id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder designation(String designation) {
            this.designation = designation;
            return this;
        }

        public EmployeeBuilder joniDate(Date joniDate) {
            this.joniDate = joniDate;
            return this;
        }

        public Employee build() {
            return new Employee(id, name, designation, joniDate);
        }
    }
}
