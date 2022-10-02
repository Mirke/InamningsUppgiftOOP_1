package com.eriksson;

/**
 * Door type that has security option.
 */
public class EntryDoor extends Door{

    private IDetection doorSensor;

    public EntryDoor() {
    }


    public EntryDoor(IDetection doorSensor) {
        this.doorSensor = doorSensor;
    }
    public EntryDoor(Room leadingToRoom, IDetection doorSensor) {
        this.doorSensor = doorSensor;
        this.setToRoom(leadingToRoom);
    }

    @Override
    public String toString() {
        return "EntryDoor{" +
                "doorDetector=" + doorSensor +
                ", isOpen=" + isOpen +
                '}';
    }
}
