package com.eriksson;

public class Main {

    public static void main(String[] args) {

        House erlichHouse = new House();
        SecuritySystem security = new SecuritySystem();

        security.addSirens(new Siren("Siren 1"));
        security.addSirens(new Siren("Siren 2"));
        security.addKeypad(new Keypad("Keypad 1"));
        security.addKeypad(new Keypad("Keypad 2"));

        BuildHouse.buildDefault(erlichHouse, security);

        //System.out.println(erlichHouse);

        Terminal t = new Terminal(security, erlichHouse.getRoom("Garage").getSprinklerSystem());

        t.menu();
    }
}