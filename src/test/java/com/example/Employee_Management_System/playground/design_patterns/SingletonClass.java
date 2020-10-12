package com.example.Employee_Management_System.playground.design_patterns;

public class SingletonClass {

    private static SingletonClass singletonClass;

    private SingletonClass() {}

   public static SingletonClass getInstance() {

        if (singletonClass == null) {
            System.out.println("Instantiating object");
            singletonClass = new SingletonClass();
        }

        return singletonClass;
   }
}
