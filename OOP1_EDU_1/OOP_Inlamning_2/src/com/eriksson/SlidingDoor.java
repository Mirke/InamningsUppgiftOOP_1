package com.eriksson;

/**
 * Sliding door works like the ordinary door.
 */
public class SlidingDoor extends OrdinaryDoor{
    public SlidingDoor() {
    }

    public SlidingDoor(Room leadingToRoom) {
        super(leadingToRoom);
    }
}
