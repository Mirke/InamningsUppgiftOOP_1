package com.eriksson;

import java.util.ArrayList;

public class SprinklerSystem {
    // TODO: 2022-09-27
    private ArrayList<Sprinkler> sprinklers = new ArrayList<>();

    public ArrayList<Sprinkler> getSprinklers() {
        return sprinklers;
    }

    public void addSprinklers(Sprinkler sprinklers) {
        this.sprinklers.add(sprinklers);
    }

    public Sprinkler installSprinklers(Room atLocation){
        Sprinkler sprinkler = new Sprinkler(atLocation, this);
        this.sprinklers.add(sprinkler);
        return sprinkler;
    }


}
