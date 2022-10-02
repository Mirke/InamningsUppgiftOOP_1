package com.eriksson;

/**
 * Door that inherits from AbstractBarrier,
 * door can have sensor on and show where it leads.
 */
public class Door extends AbstractBarrier{

    private Room toRoom;
    private IDetection doorSensor;

    public Door() {
    }

    public Door(Room leadingToRoom){
        toRoom = leadingToRoom;
    }

    public Door(IDetection doorSensor) {
        this.doorSensor = doorSensor;
    }

    public Room getToRoom() {
        return toRoom;
    }

    public void setToRoom(Room toRoom) {
        this.toRoom = toRoom;
    }

    @Override
    void open() {
        this.isOpen = true;
    }

    @Override
    void close() {
        this.isOpen = false;
    }

    @Override
    public String toString() {
        return "Door{" +
                "doorDetector=" + doorSensor +
                ", isOpen=" + isOpen +
                '}';
    }
}
