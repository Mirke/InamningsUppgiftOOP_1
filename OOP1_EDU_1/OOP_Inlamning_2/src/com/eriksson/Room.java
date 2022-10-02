package com.eriksson;

import java.util.ArrayList;

/**
 *  Rooms for the house, it can have multiple parts that security equipment can be mounted to.
 */
public class Room {

    private String name;
    private String owner;
    private ArrayList<Window> windows = new ArrayList<>();
    private ArrayList<Door> doors = new ArrayList<>();
    private ArrayList<Wall> walls=new ArrayList<>();
    private ArrayList<Ceiling> ceilings= new ArrayList<>();

    private SecuritySystem securitySystem  = null;
    private SprinklerSystem sprinklerSystem = null;

    public SprinklerSystem getSprinklerSystem() {
        return sprinklerSystem;
    }

    public void setSprinklerSystem(SprinklerSystem sprinklerSystem) {
        this.sprinklerSystem = sprinklerSystem;
    }

    public Room() {
    }

    public Room(String name){
       this(name,"noOwner");
    }

    public Room(String name, String owner){
        this.name = name;
        this.owner = owner;
    }

    public Room(String name, String owner, SecuritySystem securitySystem){
        this.name = name;
        this.owner = owner;
        this.securitySystem = securitySystem;
    }

    public Room(String name, String owner, SecuritySystem securitySystem, SprinklerSystem sprinklerSystem){
        this.name = name;
        this.owner = owner;
        this.securitySystem = securitySystem;
        this.sprinklerSystem = sprinklerSystem;
    }


    public String getName() {
        return name;
    }

    public void addWindow(Window window){
        this.windows.add(window);
    }

    public void addDoor(Door door){
        this.doors.add(door);
    }

    public void addWall(Wall wall){this.walls.add(wall);}

    public void addCeiling(Ceiling ceiling){this.ceilings.add(ceiling);}

    public void setSecuritySystem(SecuritySystem securitySystem) {
        this.securitySystem = securitySystem;
    }

    public SecuritySystem getSecuritySystem() {
        return securitySystem;
    }

    public String getOwner() {
        return owner;
    }

    public ArrayList<Window> getWindows() {
        return windows;
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", windows=" + windows +
                ", doors=" + doors +
                ", walls=" + walls +
                "}\n";
    }
}
