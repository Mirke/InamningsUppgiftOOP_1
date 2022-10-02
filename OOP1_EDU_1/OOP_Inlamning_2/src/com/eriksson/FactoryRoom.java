package com.eriksson;

import java.util.ArrayList;

/**
 *  Factory class that makes it easier to make rooms,
 *  used in conjunction with BuildHouse class.
 */
public class FactoryRoom {
    public static Room create(String roomName,
                              String roomOwner,
                              ArrayList<Window> windows,
                              ArrayList<Door> doors) {
        Room room = new Room(roomName, roomOwner);
        windows.forEach(room::addWindow);
        doors.forEach(room::addDoor);
        return room;
    }

    public static Room create(Room room,
                              ArrayList<Window> windows,
                              ArrayList<Door> doors) {
        windows.forEach(room::addWindow);
        doors.forEach(room::addDoor);
        return room;
    }

    public static Room create(Room room,
                              ArrayList<Window> windows,
                              ArrayList<Door> doors,
                              ArrayList<Ceiling> ceilings) {
        windows.forEach(room::addWindow);
        doors.forEach(room::addDoor);
        return room;
    }
    public static Room create(Room room,
                              ArrayList<Window> windows,
                              ArrayList<Door> doors,
                              ArrayList<Ceiling> ceilings,
                              ArrayList<Wall> walls) {
        windows.forEach(room::addWindow);
        doors.forEach(room::addDoor);
        return room;
    }
}
