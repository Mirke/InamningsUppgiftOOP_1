package com.eriksson;

import java.util.Objects;

/**
 * Window sensor that implements IDetection interface,
 * used for windows to sense if there is a break in.
 */
public class WindowSensor implements IDetection{

    private boolean isDetecting = false;
    private String name = "WindowSensor";
    private String atLocation;

    public WindowSensor() {
    }

    public WindowSensor(String atLocation) {
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
    public String toString() {
        return '\'' + atLocation + '\'' +
                ", is it detecting something = " + ((isDetecting)?"'Yes'":"'No'");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WindowSensor that = (WindowSensor) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
