package com.eriksson;

/**
 * Used for getting sound from when the alarm is on.
 */
public class Siren {
    private boolean isOn = false;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Siren() {
        name = "Unknown";
    }

    public Siren(String name) {
        this.name = name;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public String toString() {
        return (isOn) ? "wailing LOUDLY!" : "silent.";
    }
}
