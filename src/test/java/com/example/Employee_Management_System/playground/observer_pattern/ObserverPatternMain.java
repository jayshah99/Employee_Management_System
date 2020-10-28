package com.example.Employee_Management_System.playground.observer_pattern;

public class ObserverPatternMain {

    public static void main(String[] args) {

        ProductRegistration productRegistration = new ProductRegistration();

        productRegistration.register(new EmailObserver());
        productRegistration.register(new SmsObserver());

        WhatsAppObserver observer = new WhatsAppObserver();
        productRegistration.register(observer);

        productRegistration.notifyObservers();

        System.out.println();
        System.out.println();
        productRegistration.unregister(observer);
        productRegistration.notifyObservers();

    }
}
