package com.example.Employee_Management_System.playground.observer_pattern;

public class EmailObserver implements Observer {

    /**
     * 1. get subscribed user based on email from DB
     * 2. Code to send an email to all those user
     * @param message
     */

    @Override
    public void update(String message) {
        System.out.println(message);
        System.out.println("Notified all the registered user via email");
    }
}
