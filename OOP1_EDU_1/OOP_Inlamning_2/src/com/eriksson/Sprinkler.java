package com.eriksson;

public class Sprinkler {
    // TODO: 2022-09-27
    private SprinklerSystem sprinklerSystem;
    private Room atLocation;
    private boolean isOn = false;

    public Sprinkler(){}

    public Sprinkler(Room atLocation,SprinklerSystem sprinklerSystem){
        this.atLocation = atLocation;
        this.sprinklerSystem = sprinklerSystem;
    }

    public void sprinklersOn() {
        isOn = true;
    }

    public void sprinklersOff() {
        isOn = false;
    }

    public Room getAtLocation() {
        return atLocation;
    }

    public void setAtLocation(Room atLocation) {
        this.atLocation = atLocation;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public String toString() {
        return "Sprinkler is " +
                " it on? " + ((isOn) ? "'Yes'": "'No'");
    }
}
