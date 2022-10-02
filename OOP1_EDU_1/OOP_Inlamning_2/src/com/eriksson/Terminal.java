package com.eriksson;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The Terminal is the GUI to control the security
 * and to simulate fire, burglary and movement.
 */

public class Terminal {
    private SecuritySystem securitySystem;
    private SprinklerSystem sprinklerSystem;
    private Timer timer;
    protected boolean isCountingDown = false;

    public Terminal(SecuritySystem securitySystem) {
        this.securitySystem = securitySystem;
    }

    public Terminal(SecuritySystem securitySystem, SprinklerSystem sprinklerSystem) {
        this.securitySystem = securitySystem;
        this.sprinklerSystem = sprinklerSystem;
    }

    public SecuritySystem getSecuritySystem() {
        return securitySystem;
    }

    public void setSecuritySystem(SecuritySystem securitySystem) {
        this.securitySystem = securitySystem;
    }

    /**
     * First GUI menu for user.
     */
    public void menu() {
        String introduction = "Welcome to 'Silicon Valley' alarm system, ";
        String introductionAlternatives = "Please choose a security option: ";
        String activateAlarm = "| 1. Activate Alarm | ";
        String deactivateAlarm = "| 1. Deactivate Alarm | ";
        String cancelAlarm = "2. Cancel Alarm | ";
        String restoreAlarm = "2. Restore Alarm | ";
        String simulate = "3. Simulate disaster | ";
        String statusAlarm = "4. Status | ";
        String exitTerminal = "5. Exit terminal | ";
        boolean iterate = true;

        System.out.println(introduction);

        while (iterate) {
            System.out.println();
            System.out.println(introductionAlternatives);
            System.out.print((securitySystem.isAlarmOn()) ? deactivateAlarm : activateAlarm);
            System.out.print((isCountingDown) ? cancelAlarm : restoreAlarm);
            System.out.print(simulate);
            System.out.print(statusAlarm);
            System.out.println(exitTerminal);
            try {
                switch (input()) {
                    case 1 -> {
                        activateDeactivateAlarm();
                    }
                    case 2 -> {
                        cancelRestoreAlarm();
                    }
                    case 3 -> {
                        simulateAlarm();
                    }
                    case 4 -> {
                        getSystemStatus();
                    }
                    case 5 -> {
                        iterate = exit();
                    }
                }
            } catch (InputMismatchException ime) {
                System.out.println(ime + ": Not a number, please insert a number.");

            }
        }

    }

    private void getSystemStatus() {
        System.out.print("Alarm is "+ ((securitySystem.isAlarmOn()) ? "'ON' " : "'OFF' "));
        System.out.println("and sirens are both "+ securitySystem.getSirens().get(0).toString());
        System.out.println("The sprinklers are " + ((sprinklerSystem.getSprinklers().get(0).isOn())?"ON": "OFF"));

    }

    /**
     * Second GUI choices for the user.
     */
    private void simulateAlarm() {
        // TODO: 2022-09-27
        String selectSimulation = "Please choose which simulation you want to run: ";
        String waitingUserInput = "Please insert answer: ";
        String selectSimulateFire = "";
        String selectSimulateBurglar = "";
        String selectSimulateMovement = "";
        String exitTerminal = "Going back to first alternatives";


        boolean iterate2 = true;

        while (iterate2) {
            System.out.println();
            System.out.print("| 1. Simulate Fire | ");
            System.out.print("2. Simulate Burglary | ");
            System.out.print("3. Simulate Movement | ");
            System.out.println("4. Go back | ");

            try {
                switch (input()) {
                    case 1 -> {
                        System.out.println(selectSimulateFire);
                        simulateFire();
                    }
                    case 2 -> {
                        System.out.println(selectSimulateBurglar);
                        simulateBurglary();
                    }
                    case 3 -> {
                        System.out.println(selectSimulateMovement);
                        simulateMovement();
                    }
                    case 4 -> {
                        iterate2 = exit(exitTerminal);
                    }
                }

            } catch (InputMismatchException ime) {
                System.out.println(ime + ": Not a number, please insert a number.");
            }

        }

    }

    /**
     * Simulation for movement.
     */
    private void simulateMovement() {
        System.out.print("Is there movement?");
        System.out.println((this.securitySystem.isAnySensorOn()) ? "'Yes'" : "'No'");
        this.securitySystem.trippingSecurityCameras();
        System.out.print("Is there movement now?");
        System.out.println((this.securitySystem.isAnySensorOn()) ? "'Yes'" : "'No'");
        if (this.securitySystem.isAlarmOn()) {
            securitySystem.getSirens().get(0).setOn(true);
            securitySystem.getSirens().get(1).setOn(true);
            System.out.println("Alarm is ON, " +  securitySystem.getSirens().get(0).toString());
        } else {
            System.out.println("Alarm is OFF, "+  securitySystem.getSirens().get(0).toString());
        }
    }
    /**
     * Simulation for burglary.
     */
    private void simulateBurglary() {
        System.out.print("Is any important door open");
        System.out.println((this.securitySystem.isAnySensorOn()) ? "'Yes'" : "'No'");
        this.securitySystem.unauthorizedEntry();
        System.out.println("Is there a window breakage?");
        System.out.println((this.securitySystem.isAnySensorOn()) ? "'Yes'" : "'No'");
        if (this.securitySystem.isAlarmOn()) {
            securitySystem.getSirens().get(0).setOn(true);
            securitySystem.getSirens().get(1).setOn(true);
            System.out.println("Alarm is ON, " +  securitySystem.getSirens().get(0).toString());
        } else {
            System.out.println("Alarm is OFF, "+  securitySystem.getSirens().get(0).toString());
        }

    }
    /**
     * Simulation for fire.
     */
    private void simulateFire() {
        // TODO: 2022-09-27
        System.out.print("Is there any fire? ");
        System.out.println((this.securitySystem.isAnySensorOn()) ? "'Yes'" : "'No'");
        this.securitySystem.fireStarter();
        System.out.print("Is there any fire now?");
        System.out.println((this.securitySystem.isAnySensorOn()) ? "'Yes'" : "'No'");
        if (this.securitySystem.isAlarmOn()) {
            securitySystem.getSirens().get(0).setOn(true);
            securitySystem.getSirens().get(1).setOn(true);
            System.out.println("Alarm is ON, " +  securitySystem.getSirens().get(0).toString());
        } else {
            System.out.println("Alarm is OFF, "+  securitySystem.getSirens().get(0).toString());
        }
        sprinklerSystem.getSprinklers().forEach(sprinkler -> {
            sprinkler.sprinklersOn();
            System.out.println(sprinkler);
        });
    }

    /**
     * Used for canceling and restoring the alarm.
     */
    private void cancelRestoreAlarm() {
        // TODO: 2022-09-27
        if (isCountingDown) {
            System.out.println("Alarm is canceled, will not activate!");
            isCountingDown = false;
        } else {
            securitySystem.getSirens().forEach(siren -> {
                if (siren.isOn()) {
                    siren.setOn(false);
                    System.out.println("Restoring the sirens.");
                } else {
                    System.out.println(siren.getName() + " is OFF");

                }
            });
        }

        sprinklerSystem.getSprinklers().forEach(sprinkler -> {
            sprinkler.sprinklersOff();
            System.out.println(sprinkler);
        });
    }

    /**
     * Used for activation and deactivation.
     */
    private void activateDeactivateAlarm() {
        // TODO: 2022-09-27
        if (this.securitySystem.isAlarmOn()) {
            System.out.println("Deactivating alarm!");
            this.securitySystem.setAlarmOn(false);
        } else {
            System.out.println("5 Seconds until activation of alarm!");
            countingDown();
        }
    }


    private boolean exit() {
        System.out.println("Thank you for using 'Silicon Valley' Alarm system,\nHave a good day!");
        return false;
    }

    private boolean exit(String text) {
        System.out.println(text);
        return false;
    }

    private Integer input() throws InputMismatchException {
        Scanner scan = new Scanner(System.in);
        String waitingUserInput = "Please insert answer: ";
        System.out.print(waitingUserInput);
        return scan.nextInt();
    }
    /**
     * Inner class used for timer schedule.
     */
    class timerTask extends TimerTask {

        @Override
        public void run() {
            if (isCountingDown) {
                System.out.println("Alarm is activated!");
                isCountingDown = false;
                securitySystem.setAlarmOn(true);
            } else {
                System.out.println("Alarm was canceled!");
            }
            timer.cancel();

        }
    }

    /**
     * Counts down so user can cancel the activation for alarm.
     */
    private void countingDown() {
        timer = new Timer();
        isCountingDown = true;
        timer.schedule(new timerTask(), 5000);
    }

}
