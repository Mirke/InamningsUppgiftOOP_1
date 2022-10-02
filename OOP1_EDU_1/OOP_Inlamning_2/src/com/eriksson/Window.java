package com.eriksson;

/**
 * Window that inherit from abstract barrier,
 * can have security on it too.
 */
public class Window extends AbstractBarrier{

    private final IDetection windowSensor;


    public Window(IDetection windowSensor) {
        this.windowSensor = windowSensor;
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
        return "Window{" +
                "windowDetector=" + windowSensor +
                ", isOpen=" + isOpen +
                '}';
    }
}
