package com.eriksson;

/**
 * Room part that can hold security sensor.
 */
public class Wall {
    private IDetection securitySensor;

    public Wall() {
    }

    public Wall(IDetection securitySensor) {
        this.securitySensor = securitySensor;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "securitySensor=" + securitySensor +
                '}';
    }
}
