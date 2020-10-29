package com.example.Employee_Management_System.playground.factory_pattern;

import com.example.Employee_Management_System.playground.factory_pattern.transport.AeroPlane;
import com.example.Employee_Management_System.playground.factory_pattern.transport.Ship;
import com.example.Employee_Management_System.playground.factory_pattern.transport.Transport;
import com.example.Employee_Management_System.playground.factory_pattern.transport.Truck;

public interface TransportFactory {

    static Transport getTransport(TransportBy transportBy) {
        switch (transportBy) {
            case ROAD:
                return new Truck();
            case SEA:
                return new Ship();
            case AIR:
                return new AeroPlane();
            default:
                throw new IllegalArgumentException(String.format("We do not transport by: %s", transportBy.name()));
        }
    }
}
