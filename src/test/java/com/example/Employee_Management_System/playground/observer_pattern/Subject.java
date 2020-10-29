package com.example.Employee_Management_System.playground.observer_pattern;

public interface Subject {

    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
}
