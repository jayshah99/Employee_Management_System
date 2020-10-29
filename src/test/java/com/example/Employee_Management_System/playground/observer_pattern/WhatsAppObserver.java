package com.example.Employee_Management_System.playground.observer_pattern;

public class WhatsAppObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println(message);
        System.out.println("Notified all the registered user via Whatsapp");
    }
}
