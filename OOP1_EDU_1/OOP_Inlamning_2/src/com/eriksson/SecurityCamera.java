package com.eriksson;

import java.util.Objects;

/**
 * Security Camera that uses interface IDetection,
 * works kind of like the other sensors.
 */

public class SecurityCamera implements IDetection {

    private String name = "SecurityCamera";

    public String getAtLocation() {
        return atLocation;
    }

    private String atLocation;

    public SecurityCamera() {
        atLocation = "Unknown";
    }

    public SecurityCamera(String locationName) {
        this.atLocation = locationName;
    }

    private boolean isDetecting = false;


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
        SecurityCamera that = (SecurityCamera) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return  '\'' + atLocation + '\'' +
                ", is it detecting something = " + ((isDetecting)?"'Yes'":"'No'");
    }
}
