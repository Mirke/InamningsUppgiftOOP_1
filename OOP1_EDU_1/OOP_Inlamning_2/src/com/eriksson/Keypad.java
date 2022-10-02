package com.eriksson;

public class Keypad extends SecuritySystem{
    // TODO: 2022-09-27
    private SecuritySystem securitySystem;
    private Room atLocation;
    private String name;

    public String getName() {
        return name;
    }

    public Keypad() {
    }

    public Keypad(String name) {
        this.name = name;
    }

    public void activateAlarm() {
        securitySystem.setAlarmOn(true);
    }

    public void deactivateAlarm(){
        securitySystem.setAlarmOn(false);
    }

    public Room getAtLocation() {
        return atLocation;
    }

    public void setAtLocation(Room atLocation) {
        this.atLocation = atLocation;
    }
}
