package com.example.Employee_Management_System.playground.factory_pattern;

import com.example.Employee_Management_System.playground.factory_pattern.transport.Transport;

public class FactoryPatterMain {

    public static void main(String[] args) {

        Transport transport = TransportFactory.getTransport(TransportBy.AIR);
        deliverTheProduct(transport);
    }

    public static void deliverTheProduct(Transport transport) {
        transport.deliver();
    }
}
