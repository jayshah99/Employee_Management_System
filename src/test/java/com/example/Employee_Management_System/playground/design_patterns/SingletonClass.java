package com.example.Employee_Management_System.playground.design_patterns;

public class SingletonClass {

    private static SingletonClass singletonClass;

    private SingletonClass() {}

   public static SingletonClass getInstance() {

       System.out.println("SingletonClass Thread name: " + Thread.currentThread().getName());

       //Double check locking
       if (singletonClass == null) { // may be 2 or more thread trying to access singletonClass simoultaenously
           synchronized (SingletonClass.class) {
               if (singletonClass == null) {
                   System.out.println("Instantiating object");
                   singletonClass = new SingletonClass();
               }
           }
       }

        return singletonClass;
   }
}
