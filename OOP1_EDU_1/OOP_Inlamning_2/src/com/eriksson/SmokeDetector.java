package com.eriksson;

import java.util.Objects;

/**
 * Sensor in case of a fire, works like other sensors.
 */
public class SmokeDetector implements IDetection{
    // TODO: 2022-09-27
    private boolean isDetecting = false;
    private String name = "SmokeDetector";
    private String atLocation;

    public SmokeDetector() {
    }

    public SmokeDetector(String atLocation) {
        this.atLocation = atLocation;
    }

    @Override
    public boolean isDetecting() {
        return isDetecting;
    }

    @Override
    public void setDetect(Boolean bool) {
        isDetecting=bool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmokeDetector that = (SmokeDetector) o;
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
