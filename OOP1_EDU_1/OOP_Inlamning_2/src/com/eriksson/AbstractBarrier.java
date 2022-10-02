package com.eriksson;


/**
 * Interface for Doors and Windows
 */
public abstract class AbstractBarrier {

    /**
     * Normally the barrier is closed, aka. it is not open.
     */
    boolean isOpen = false;

    /**
     * For opening the door.
     */
    abstract void open();

    /**
     * For closing the door.
     */
    abstract void close();

}
