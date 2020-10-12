package com.example.Employee_Management_System.playground.design_patterns;
/*
1. only going to have 1 single instance
2. we can create multiple objects
 */
public class SingletonPlayground {

    public static void main(String[] args) {
        //showHashcodeSample();

        /*
        Lazy object instantiation of singleton class
        - it will create an object for the first time on demand
         */

        SingletonClass singletonClass1 = SingletonClass.getInstance();
        SingletonClass singletonClass2 = SingletonClass.getInstance();
        SingletonClass singletonClass3 = singletonClass1;

        System.out.println("Hashcode of singletonClass1:" + singletonClass1.hashCode());
        System.out.println("Hashcode of singletonClass2:" + singletonClass2.hashCode());
        System.out.println("Hashcode of singletonClass3:" + singletonClass3.hashCode());
    }

    private static void showHashcodeSample() {
        SingletonPlayground singletonPlayground1 = new SingletonPlayground();
        SingletonPlayground singletonPlayground2 = new SingletonPlayground();
        SingletonPlayground singletonPlayground3 = singletonPlayground1;

        System.out.println("Hashcode of singletonPlayground1: " + singletonPlayground1.hashCode());
        System.out.println("Hashcode of singletonPlayground2: " + singletonPlayground2.hashCode());
        System.out.println("Hashcode of singletonPlayground3: " + singletonPlayground3.hashCode());
    }
}
