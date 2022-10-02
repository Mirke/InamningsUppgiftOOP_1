package com.eriksson;

/**
 * Ceiling that you can add security sensor too.
 */
public class Ceiling {

    private final IDetection securitySensor;

    public Ceiling(IDetection securitySensor) {
        this.securitySensor = securitySensor;
    }

    @Override
    public String toString() {
        return "Ceiling{" +
                "securitySensor=" + securitySensor +
                '}';
    }
}
