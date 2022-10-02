package com.eriksson;

import java.util.Objects;

/**
 * Door sensor that inherit from IDetection,
 * ordinary setter and getters,
 * also location of the sensor.
 */
public class DoorSensor implements IDetection{

    private boolean isDetecting = false;
    private String name = "DoorSensor";
    private String atLocation;

    public DoorSensor() {
    }

    public DoorSensor(String atLocation) {
        this.atLocation = atLocation;
    }

    @Override
    public boolean isDetecting() {
        return isDetecting;
    }

    @Override
    public void setDetect(Boolean bool) {
        isDetecting = bool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoorSensor that = (DoorSensor) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return '\'' + atLocation + '\'' +
                ", is it detecting something = " + ((isDetecting)?"'Yes'":"'No'");
    }
}
