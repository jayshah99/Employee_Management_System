package com.example.Employee_Management_System.playground.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class ProductRegistration implements Subject {


    private List<Observer> observers;

    public ProductRegistration() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update("Product available!"));
    }
}
