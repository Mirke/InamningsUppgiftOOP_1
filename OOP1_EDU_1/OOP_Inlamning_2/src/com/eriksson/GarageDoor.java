package com.eriksson;

/**
 * Door type with security.
 */
public class GarageDoor extends Door {

    private IDetection doorSensor;
    public GarageDoor() {

    }

    public GarageDoor(Room leadingToRoom){
        super(leadingToRoom);
    }

    public GarageDoor(Room leadingToRoom, IDetection doorSensor) {
        super.setToRoom(leadingToRoom);
        this.doorSensor = doorSensor;
    }

    @Override
    public String toString() {
        return "GarageDoor{" +
                "doorDetector=" + doorSensor +
                ", isOpen=" + isOpen +
                '}';
    }
}
