package com.eriksson;

import java.util.ArrayList;

/**
 * SecuritySystem pretty much the glue of all the sensors,
 * siren, installing sensors and helping with simulation.
 */

public class SecuritySystem {
    private ArrayList<IDetection> sensors = new ArrayList<>();
    private ArrayList<Siren> sirens = new ArrayList<>();

    public ArrayList<Keypad> getKeypads() {
        return keypads;
    }

    private ArrayList<Keypad> keypads = new ArrayList<>();

    public ArrayList<Siren> getSirens() {
        return sirens;
    }

    public void addKeypad(Keypad keypad){
        keypads.add(keypad);
    }



    public void addSirens(Siren siren) {
        this.sirens.add(siren);
    }

    public boolean isAlarmOn() {
        return isAlarmOn;
    }

    public void setAlarmOn(boolean alarmOn) {
        isAlarmOn = alarmOn;
    }

    private boolean isAlarmOn = false;

    public IDetection installSensor(Sensor sensor){
        switch (sensor){
            case WINDOW -> {
                WindowSensor windowSensor = new WindowSensor();
                this.sensors.add(windowSensor);
                return windowSensor;
            }
            case DOOR -> {
                DoorSensor doorSensor = new DoorSensor();
                this.sensors.add(doorSensor);
                return doorSensor;
            }
            case WALL -> {
                SecurityCamera securityCamera=new SecurityCamera();
                this.sensors.add(securityCamera);
                return securityCamera;
            }
            case CEILING -> {
                SmokeDetector smokeDetector = new SmokeDetector();
                this.sensors.add(smokeDetector);
                return smokeDetector;
            }
            default -> {
                return null;
            }
        }

    }

    public IDetection installSensor(Sensor sensor,String atLocation){
        switch (sensor){
            case WINDOW -> {
                WindowSensor windowSensor = new WindowSensor(atLocation);
                this.sensors.add(windowSensor);
                return windowSensor;
            }
            case DOOR -> {
                DoorSensor doorSensor = new DoorSensor(atLocation);
                this.sensors.add(doorSensor);
                return doorSensor;
            }
            case WALL -> {
                SecurityCamera securityCamera=new SecurityCamera(atLocation);
                this.sensors.add(securityCamera);
                return securityCamera;
            }
            case CEILING -> {
                SmokeDetector smokeDetector = new SmokeDetector(atLocation);
                this.sensors.add(smokeDetector);
                return smokeDetector;
            }
            default -> {
                return null;
            }
        }

    }

    /**
     * Checks if there is any sensor that is on.
     * @return bool
     */
    public boolean isAnySensorOn(){
        for (int i = 0; i < this.sensors.size(); i++) {
            if(this.sensors.get(i).isDetecting()){
                return true;
            }
        }

        return false;
    }

    /**
     * Used for the movement simulation
     */
    public void trippingSecurityCameras(){
        for (int i = 0; i < this.sensors.size(); i++) {
            if (new SecurityCamera().equals(this.sensors.get(i))){
                this.sensors.get(i).setDetect(true);
            }
        }
        System.out.println(ScenarioBank.scenarioMovement_1());
    }
    /**
     * Used for the burglar simulation
     */
    public void unauthorizedEntry(){
        for (int i = 0; i < this.sensors.size(); i++) {
            if(new WindowSensor().equals(this.sensors.get(i))){
                this.sensors.get(i).setDetect(true);
            } else if(new DoorSensor().equals(this.sensors.get(i))){
                this.sensors.get(i).setDetect(true);
            }
        }
        System.out.println(ScenarioBank.scenarioBreakIn_1());
    }
    /**
     * Used for the fire simulation
     */
    public void fireStarter() {
        for (int i = 0; i < this.sensors.size(); i++) {
            if (new SmokeDetector().equals(this.sensors.get(i))) {
                this.sensors.get(i).setDetect(true);
            }
        }
        System.out.println(ScenarioBank.scenarioFireStarter_1());

    }
}
