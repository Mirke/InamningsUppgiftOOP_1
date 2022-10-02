package com.eriksson;

import java.util.WeakHashMap;

/**
 * House that contains rooms,
 * testing out WeakHashMap
 */
public class House {
    private WeakHashMap<String, Room> rooms = new WeakHashMap();

    public void addRoom(String name,Room room) {
        rooms.put(name,room);
    }

    public Room getRoom(String name){
      return rooms.get(name);
    }

    @Override
    public String toString() {
        return "House{" +
                "rooms=" + rooms +
                '}';
    }
}
