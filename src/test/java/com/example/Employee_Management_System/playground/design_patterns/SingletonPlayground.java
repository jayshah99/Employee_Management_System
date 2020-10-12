package com.example.Employee_Management_System.playground.design_patterns;

/*
1. only going to have 1 single instance
2. we can create multiple objects
 */
public class SingletonPlayground {

    public static void main(String[] args) {
        //showHashcodeSample();

        /*
        Singleton class have issue in multi threaded environment
        How we can fix this ?
        1. make the static method in the singleton class synchronized
         */

        singletonWithThread("singletonClass1");
        singletonWithThread("singletonClass2");
        singletonWithThread("singletonClass3");
    }

    public static void singletonWithThread(String threadName) {
        Thread thread = new Thread(() -> {
            SingletonClass singletonClass = SingletonClass.getInstance();
            System.out.println("\nHashcode of" +
                    " Thread: " + Thread.currentThread().getName() +
                    " ==> " + singletonClass.hashCode());
        }, threadName);
        thread.start();
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
