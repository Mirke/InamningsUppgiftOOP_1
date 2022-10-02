package com.eriksson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BuildHouse is a builder class that uses class factories to build the stage for the house and security system.
 */
public class BuildHouse {
    /**
     * buildDefault is used to build the default setup for the house and all security parts.
     *
     * @param house
     * @param security
     */
    public static void buildDefault(House house, SecuritySystem security) {

        Room garden = FactoryRoom.create(
                new Room("Garden"),
                new ArrayList<>(),
                new ArrayList<>(List.of(new OrdinaryDoor())),
                new ArrayList<>(),
                new ArrayList<>(List.of(new Wall(security.installSensor(Sensor.WALL, "Garden"))))
        );

        Room hallway = FactoryRoom.create(
                new Room("Hallway"),
                new ArrayList<>(List.of(new Window(security.installSensor(Sensor.WINDOW, "Hallway")))),
                new ArrayList<>(List.of(new EntryDoor(garden, security.installSensor(Sensor.DOOR, "Hallway")))),
                new ArrayList<>(List.of(new Ceiling(security.installSensor(Sensor.CEILING, "Hallway")))),
                new ArrayList<>(List.of(new Wall(security.installSensor(Sensor.WALL, "Hallway")))
                ));

        Room livingRoom = FactoryRoom.create(
                new Room("LivingRoom"),
                new ArrayList<>(Arrays.asList(new Window(security.installSensor(Sensor.WINDOW, "LivingRoom")), new Window(security.installSensor(Sensor.WINDOW, "LivingRoom")))),
                new ArrayList<>(List.of(new OrdinaryDoor(garden))),
                new ArrayList<>(List.of(new Ceiling(security.installSensor(Sensor.CEILING, "LivingRoom")))),
                new ArrayList<>(List.of(new Wall(security.installSensor(Sensor.WALL, "LivingRoom")))
                ));

        Room erlichRoom = FactoryRoom.create(
                new Room("Bedroom_1", "Erlich"),
                new ArrayList<>(Arrays.asList(new Window(security.installSensor(Sensor.WINDOW, "Erlich's Bedroom")), new Window(security.installSensor(Sensor.WINDOW, "Erlich's Bedroom")))),
                new ArrayList<>(List.of(new OrdinaryDoor(hallway)))
        );

        Room jianRoom = FactoryRoom.create(
                new Room("Bedroom_2", "Jian"),
                new ArrayList<>(List.of(new Window(security.installSensor(Sensor.WINDOW, "Jian's Bedroom")))),
                new ArrayList<>(List.of(new OrdinaryDoor(hallway)))
        );

        Room richardRoom = FactoryRoom.create(
                new Room("Bedroom_3", "Richard"),
                new ArrayList<>(List.of(new Window(security.installSensor(Sensor.WINDOW, "Richard's Bedroom")))),
                new ArrayList<>(List.of(new OrdinaryDoor(livingRoom)))
        );

        Room bertramRoom = FactoryRoom.create(
                new Room("Bedroom_4", "Bertram"),
                new ArrayList<>(Arrays.asList(new Window(security.installSensor(Sensor.WINDOW, "Bertram's Bedroom")), new Window(security.installSensor(Sensor.WINDOW, "Bertram's Bedroom")))),
                new ArrayList<>(List.of(new OrdinaryDoor(livingRoom)))
        );

        Room dineshRoom = FactoryRoom.create(
                new Room("Bedroom_5", "Dinesh"),
                new ArrayList<>(List.of(new Window(security.installSensor(Sensor.WINDOW, "Dinesh's Bedroom")))),
                new ArrayList<>(List.of(new OrdinaryDoor(hallway)))
        );

        Room garageRoom = FactoryRoom.create(
                new Room("Garage", "Jared", security, new SprinklerSystem()),
                new ArrayList<>(List.of(new Window(security.installSensor(Sensor.WINDOW, "Garage")))),
                new ArrayList<>(Arrays.asList(new OrdinaryDoor(hallway), new GarageDoor(garden, security.installSensor(Sensor.DOOR, "Garage")))
                ));


        Room kitchen = FactoryRoom.create(
                new Room("Kitchen"),
                new ArrayList<>(List.of(new Window(security.installSensor(Sensor.WINDOW, "Kitchen")))),
                new ArrayList<>(),
                new ArrayList<>(List.of(new Ceiling(security.installSensor(Sensor.CEILING, "Kitchen"))))
        );

        garageRoom.getSprinklerSystem().installSprinklers(hallway);
        garageRoom.getSprinklerSystem().installSprinklers(kitchen);
        garageRoom.getSprinklerSystem().installSprinklers(livingRoom);

        house.addRoom(erlichRoom.getName(), erlichRoom);
        house.addRoom(jianRoom.getName(), jianRoom);
        house.addRoom(richardRoom.getName(), richardRoom);
        house.addRoom(bertramRoom.getName(), bertramRoom);
        house.addRoom(dineshRoom.getName(), dineshRoom);
        house.addRoom(garageRoom.getName(), garageRoom);
        house.addRoom(livingRoom.getName(), livingRoom);
        house.addRoom(hallway.getName(), hallway);
        house.addRoom(garden.getName(), garden);
        house.addRoom(kitchen.getName(), kitchen);
    }
}
